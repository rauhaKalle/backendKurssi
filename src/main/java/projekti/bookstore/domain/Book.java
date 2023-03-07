package projekti.bookstore.domain;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title, author;
	private int publishYear, isbn;
	
	@ManyToOne
	// @JsonIgnoreProperties - one way to avoid infinite loop during JSON serialization/deserialization with bidirectional relationships
    @JsonIgnoreProperties ("books") 
	@JoinColumn(name ="categoryid")
	private Category categoryid;
		
	public Category getCategoryid() {
		return categoryid;
	}
	

	public void setCategoryid(Category categoryid) {
		this.categoryid = categoryid;
	}

	public Book () {}

	public Book(String title, String author, int publishYear, int isbn, Category categoryid) {
		super();
		this.title = title;
		this.author = author;
		this.publishYear = publishYear;
		this.isbn = isbn;
		this.categoryid = categoryid;
	}

	



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publishYear=" + publishYear + ", isbn="
				+ isbn + ", categoryid=" + categoryid + "]";
	}
	
	
	
}
