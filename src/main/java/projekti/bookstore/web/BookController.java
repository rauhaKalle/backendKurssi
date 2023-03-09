package projekti.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import projekti.bookstore.domain.Book;
import projekti.bookstore.domain.BookRepository;
import projekti.bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository cRepository;
	
	
	@RequestMapping(value="/books/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
	    	return repository.findById(bookId);
	    }
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>) repository.findAll();
	}
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String bookList(Model model) {
		
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable ("id") Long bookId, Model model) {

		repository.deleteById(bookId);
		return "redirect:../booklist";
	}

	@RequestMapping(value ="/add")
	public String addBook(Model model){
		model.addAttribute("book", new Book());
		model.addAttribute("categories", cRepository.findAll());
		return "addbook";
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	@RequestMapping(value ="/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		return "editbook";
	}
	
	

}
