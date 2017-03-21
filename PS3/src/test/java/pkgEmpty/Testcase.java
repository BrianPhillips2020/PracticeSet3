package pkgEmpty;

import static org.junit.Assert.*;

import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.text.SimpleDateFormat;
import pkgLibrary.Book;
import pkgLibrary.BookException;
import pkgLibrary.Catalog;
import pkgMain.XMLReader;

import java.io.File;
import java.text.ParseException;
import org.junit.Test;

public class Testcase {

	@Test
	public void test() throws BookException{
		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		String id = "bk101";
		Book b = new Book("bk101", "DGambardella, Matthew", "Hitchhiker's Guide", "space", 42.00, new Date(), "An in-depth look at creating applicationswith XML." , 49.45);
		assertEquals(true, (b.getId() == XMLReader.getBook(cat, id).getId()));
	}
	
	@Test
	public void test2() throws BookException{
		
	
		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		int length = cat.getBooks().size();
		Book b = new Book("bk42", "Douglas Adams", "Hitchhiker's Guide", "space", 42.00, new Date(), "The Meaning of Life",
				33.60);
		Catalog.addBook(cat , b, 0);
		
		assertEquals((cat.getBooks().size()),(length + 1));
		
	
}

}
