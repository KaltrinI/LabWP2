package mk.finki.ukim.wp.organizeme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class OrganizemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizemeApplication.class, args);
	}
}
