package idusw.springboot.kjymall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) // Spring - Annotation : java, lombok, spring
//@Configuration
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class KjyMallApplication {

	public static void main(String[] args) {

		SpringApplication.run(KjyMallApplication.class, args);
	}

}
