package com.process.jpademo;

import com.process.jpademo.entity.Product;
import com.process.jpademo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null, "Dell Inspiron PC", 850, 4));
		productRepository.save(new Product(null, "MacBook", 2850, 2));
		productRepository.save(new Product(null, "HP laptop PC", 750, 10));
		productRepository.save(new Product(null, "Surface Pro PC", 1850, 5));

		//List<Product> products = productRepository.findAll();
		//List<Product> products1 = productRepository.findByNameContainsIgnoreCase("PC");
		List<Product> products2 = productRepository.search("PC", 800);
		products2.forEach(p -> {
			System.out.println(p.getName());
			System.out.println(p.getPrice());
			System.out.println(p.getQuantity());
			System.out.println("******************************");
		});
	}
}
