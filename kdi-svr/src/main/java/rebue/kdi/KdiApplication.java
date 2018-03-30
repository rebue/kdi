package rebue.kdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
@ServletComponentScan("rebue")
public class KdiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KdiApplication.class, args);
    }

}
