package rebue.kdi.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringCloudApplication
@EnableScheduling
@EnableFeignClients(basePackages = { "rebue.kdi.svr.feign" })
public class KdiSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KdiSchedulerApplication.class, args);
    }

}
