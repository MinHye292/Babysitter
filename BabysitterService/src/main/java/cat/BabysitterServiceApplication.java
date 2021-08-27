package cat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BabysitterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabysitterServiceApplication.class, args);
	}
}