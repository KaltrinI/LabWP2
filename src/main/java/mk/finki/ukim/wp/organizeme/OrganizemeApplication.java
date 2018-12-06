package mk.finki.ukim.wp.organizeme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication

public class OrganizemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizemeApplication.class, args);
	}
}
