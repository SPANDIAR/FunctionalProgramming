package io.spandiar.isbn.connector;

import io.spandiar.isbn.model.Book;

public interface BookServiceInterface {
	
	public Book getBookDetails(String isbn);

}
