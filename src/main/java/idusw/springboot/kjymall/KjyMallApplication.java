package idusw.springboot.kjymall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication // Spring - Annotation : java, lombok, spring
//@Configuration
//@EnableAutoConfiguration
public class KjyMallApplication {

	public static void main(String[] args) {

		SpringApplication.run(KjyMallApplication.class, args);
	}

}
