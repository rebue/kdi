package rebue.kdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringCloudApplication
@ServletComponentScan("rebue")
@EnableFeignClients(basePackages = { "rebue.slr.svr.feign"})
public class KdiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KdiApplication.class, args);
    }

}
	