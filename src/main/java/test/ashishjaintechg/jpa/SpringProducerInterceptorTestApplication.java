package test.ashishjaintechg.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringProducerInterceptorTestApplication {

	@Autowired
	KafkaTemplate<String, String> template;
	
	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name) {
		template.send("test","hi" +name);
		return "Data published";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringProducerInterceptorTestApplication.class, args);
	}

}
