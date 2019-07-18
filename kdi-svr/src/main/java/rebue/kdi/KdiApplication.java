package rebue.kdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@ServletComponentScan("rebue")
@EnableFeignClients(basePackages = { "rebue.slr.svr.feign" })
//禁止springboot自动加载持久化bean
@EnableAutoConfiguration(exclude = { JpaRepositoriesAutoConfiguration.class })
public class KdiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KdiApplication.class, args);
    }

}
