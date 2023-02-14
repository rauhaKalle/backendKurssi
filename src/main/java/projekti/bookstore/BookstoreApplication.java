package projekti.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import projekti.bookstore.domain.Book;
import projekti.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean 
	public CommandLineRunner demo(BookRepository repository) 
	{return (args) -> { 
	Book book1 = new Book("aku ankka", "jaska jokunen",1958,232423423);
	Book book2 = new Book("Pekka ja Pätkä", "Ressu", 1998 , 78438778);
	repository.save(book1);
	repository.save(book2);
	}; 
	}

}
