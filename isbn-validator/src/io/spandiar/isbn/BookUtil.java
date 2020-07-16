package io.spandiar.isbn;

import io.spandiar.isbn.connector.BookServiceInterface;
import io.spandiar.isbn.model.Book;

public class BookUtil {
	
	private BookServiceInterface dbService;
	private BookServiceInterface webService;
	
	public void setDBService(BookServiceInterface service) {
		this.dbService = service;
	}
	
	public void setWebService(BookServiceInterface service) {
		this.webService = service;
	}

	public String bookIdentifier(String isbn) {
		
		Book bookDetail;
		
		bookDetail = dbService.getBookDetails(isbn);
		if (bookDetail == null) {
			bookDetail = webService.getBookDetails(isbn);
		}
		
		StringBuilder bookIdentifier = new StringBuilder();
		bookIdentifier.append(isbn.substring(isbn.length()-4));
		bookIdentifier.append(bookDetail.getAuthor().substring(0,1));
		bookIdentifier.append(bookDetail.getTitle().split(" ").length);
		return bookIdentifier.toString();
		
	}

}
