package dev.sandeep.EurekaClient;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EurekaClientApplication implements HelloController{

	@Value("${spring.application.name}")
	private String appName;

	@Autowired
	private EurekaClient eurekaClient;


	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@Override
	public String greeting() {
		return String.format(
				"Hello from '%s'!", eurekaClient.getApplication(appName).getName());
	}
}
