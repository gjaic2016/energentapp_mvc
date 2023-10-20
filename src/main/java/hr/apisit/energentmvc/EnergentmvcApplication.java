package hr.apisit.energentmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
//import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;

@SpringBootApplication
public class EnergentmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnergentmvcApplication.class, args);
	}

//	@Bean
//	public HttpTraceRepository httpTraceRepository() {
//		return new InMemoryHttpTraceRepository();
//	}

}
