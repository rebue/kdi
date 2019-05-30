package rebue.kdi.ro;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;


@JsonInclude(Include.NON_NULL)
@Data
public class CompanyRo {
	
    /**
     *    快递公司信息ID
     *
     */
    private Long id;

    /**
     *    快递公司字典ID
     */
    private Long companyDicId;

    /**
     *    快递公司账号
     *
     */
    private String companyAccount;

    /**
     *    快递公司密码
     */
    private String companyPwd;

    /**
     *    支付类型
     *                运费支付方式:
     *                1-现付
     *                2-到付
     *                3-月结
     *                4-第三方付
     *
     */
    private Byte payType;

    /**
     *    录入时间
     *
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date entryTime;

    /**
     *    组织ID
     */
    private Long orgId;

    /**
     *    是否为默认公司（true：默认  false：不是默认）
     */
    private Boolean isDefault;

    /**
     *    月结账号
     */
    private String monthCode;

    /**
     *    网点
     */
    private String sendSite;
    
    /**
     * 快递公司名字
     */
    private String companyName;
    
    /*
     * 快递公司编号
    */
    private String companyCode;
    
    /**
     * 模板id
     */
    private  long templateId ;
    
    /**
     * 模板名字
     */
    private String templateName;
    
    /**
     * 模板图片路径
     */
   private String templateImgPath;
   
   /**
    * 模板字典id
    */
   private Long templateDicId;
   
   /**
    * 店铺id
    */
   private Long shopId;
   
   /**
    * 快递公司别名
    */
   private String anotherName;
   
   private String shopName;

}
