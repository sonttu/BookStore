package Haagahelia.BookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Haagahelia.Book.domain.Book;
import Haagahelia.Book.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Kirja1", "Kirjailija1", 2000, "ISBN2039420", 20.99));
			repository.save(new Book("Kirja2", "Kirjailija2", 2000, "ISBN2039421", 20.99));	
			
			log.info("fetch all students");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	
	}
}



