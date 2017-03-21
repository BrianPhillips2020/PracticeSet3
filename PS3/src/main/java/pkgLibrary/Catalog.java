package pkgLibrary;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;
import java.lang.Throwable;
import pkgLibrary.BookException;
import pkgMain.XMLReader;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;

	@XmlElement(name = "book")
	ArrayList<Book> books;

	@XmlAttribute
	double Cost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public double getCost() {
		return Cost;
	}

	public void addBook(Book b) {
		this.books.add(b);
	}
	public static void addBook(Catalog cat, Book b, int id) throws BookException{
		boolean bookexists = false;
		
		for(Book book : cat.getBooks()){
			if(b.getId() == book.getId() ){
				bookexists = true;
				
			}
		}
		if(bookexists == true){
			throw new BookException("Book does not exist");
		}
		else{
			ArrayList<Book> bookarray = cat.getBooks();
			bookarray.add(b);
			cat.setBooks(bookarray);
		}
	}
}
