package tech.omarshabaan.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;

@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

  @Bean
  RouterFunction<ServerResponse> customersRouter(CustomerRepository customerRepository) {
    return route()
        .GET("/customers", _ -> ServerResponse.ok().body(customerRepository.findAll()))
        .build();
  }
}


record Customer(Long id, String name) { }

interface CustomerRepository extends ListCrudRepository<Customer, Long> {}
