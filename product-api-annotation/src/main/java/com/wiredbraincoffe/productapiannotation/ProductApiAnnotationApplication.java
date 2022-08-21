package com.wiredbraincoffe.productapiannotation;

import com.wiredbraincoffe.productapiannotation.model.Product;
import com.wiredbraincoffe.productapiannotation.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ProductApiAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiAnnotationApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductRepository repository) {
		return args -> {
			Flux<Product> productFlux = Flux.just(
					new Product(null, "Big Latte", 2.99),
					new Product(null, "Big Decaf", 2.49),
					new Product(null, "Green Tea", 1.99),
					new Product(null, "Strong Coffee", 2.59),
					new Product(null, "Cold Coffee", 1.49))
					.flatMap(repository::save)
					.thenMany(repository.findAll());

			productFlux
					.subscribe(System.out::println);
		};
	}

}
