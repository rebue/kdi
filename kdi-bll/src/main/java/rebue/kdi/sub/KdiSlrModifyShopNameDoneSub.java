package rebue.kdi.sub;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import rebue.kdi.svc.KdiCompanySvc;
import rebue.kdi.svc.KdiSenderSvc;
import rebue.sbs.rabbit.RabbitConsumer;
import rebue.slr.co.SlrExchangeCo;
import rebue.slr.msg.SlrModifyShopNameMsg;


@Service
public class KdiSlrModifyShopNameDoneSub implements ApplicationListener<ContextRefreshedEvent> {
    private final static Logger _log                    = LoggerFactory.getLogger(KdiSlrModifyShopNameDoneSub.class);

    /**
     * 处理添加用户完成通知的队列
     */
    private final static String SLR_MODIFY_SHOP_NAME_QUEUE_NAME = "rebue.kdi.slr.modify.shop.name.done.queue";

    @Resource
    private KdiCompanySvc       kdiCompanySvc;
    
    @Resource
    private KdiSenderSvc       kdiSenderSvc;

    @Resource
    private RabbitConsumer      consumer;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        // 防止里面的代码被运行两次
        if (!(event.getApplicationContext() instanceof AnnotationConfigServletWebServerApplicationContext)) {
            return;
        }

        _log.info("订阅修改店铺名字完成的通知: {} - {}", SlrExchangeCo.SLR_MODIFY_SHOP_NAME_DONE_EXCHANGE_NAME, SLR_MODIFY_SHOP_NAME_QUEUE_NAME);
        consumer.bind(SlrExchangeCo.SLR_MODIFY_SHOP_NAME_DONE_EXCHANGE_NAME, SLR_MODIFY_SHOP_NAME_QUEUE_NAME, SlrModifyShopNameMsg.class, (msg) -> {
            try {
                _log.info("接收到修改店铺的消息: {}", msg);
                // 修改快递公司和发件人中的店铺信息
                kdiCompanySvc.updateShopNameByShopId(msg.getId(), msg.getName());
                kdiSenderSvc.updateShopNameByShopId(msg.getId(), msg.getName());
                return true;
            } catch (final DuplicateKeyException e) {
                _log.warn("收到重复的消息: " + msg, e);
                return true;
            } catch (final Exception e) {
                _log.error("修改店铺名称出现异常", e);
                return false;
            }
        });
    }

}
