package projekti.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import projekti.bookstore.domain.Book;
import projekti.bookstore.domain.BookRepository;
import projekti.bookstore.domain.Category;
import projekti.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean 
	public CommandLineRunner demo(BookRepository repository, CategoryRepository cRepository) 
	{return (args) -> { 
		
	Category c1 = new Category("Draama");
	Category c2 = new Category("Komedia");
	Category c3 = new Category("Trilleri");
	cRepository.save(c1);
	cRepository.save(c2);
	cRepository.save(c3);
		
		
	Book book1 = new Book("aku ankka", "jaska jokunen",1958,232423423,c2);
	Book book2 = new Book("Pekka ja Pätkä", "Ressu", 1998 , 78438778, c1);
	repository.save(book1);
	repository.save(book2);
	
	
	
	
	}; 
	
	}

}
