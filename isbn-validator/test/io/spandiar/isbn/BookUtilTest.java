package io.spandiar.isbn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.internal.verification.Times;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.verification.VerificationMode;

import io.spandiar.isbn.connector.BookServiceInterface;
import io.spandiar.isbn.model.Book;

class BookUtilTest {
	
	static BookServiceInterface testWebService;
	static BookServiceInterface testDbService;
	static BookUtil bookUtil;
	
	
	@BeforeAll
	static void initialize() {
		
		testWebService = Mockito.mock(BookServiceInterface.class);
		testDbService = Mockito.mock(BookServiceInterface.class);
		bookUtil = new BookUtil();
	}

	@Test
	void testBookIdentifier() {
		
		BookServiceInterface testWebService = new BookServiceInterface() {
			@Override
			public Book getBookDetails(String isbn) {
				return new Book("1501165429", "Megan Miranda", "The Girl From Widow Hills");
			};
		};
		
		BookServiceInterface testDbService = new BookServiceInterface() {
			@Override
			public Book getBookDetails(String isbn) {
				return null;
			};
		};
		
		BookUtil bookUtil = new BookUtil();
		bookUtil.setWebService(testWebService);
		bookUtil.setDBService(testDbService);
		assertEquals("5429M5", bookUtil.bookIdentifier("1501165429"));
	}
	
	@Test
	void testBookUtilIsbnWithMockito() {
		
		Mockito.when(testDbService.getBookDetails("0743477111")).thenReturn(null);
		Mockito.when(testWebService.getBookDetails("0743477111")).thenReturn(new Book("0743477111", "William Shakespeare", "Romeo and Juliet"));

		bookUtil.setWebService(testWebService);
		bookUtil.setDBService(testDbService);
		assertEquals("7111W3", bookUtil.bookIdentifier("0743477111"), "Assert for 0743477111 - Romeo & Juliet");
		
	}
	
	@Test
	void testBookUtilIsbnWithMockitoServiceCalls() {
		
		Mockito.when(testDbService.getBookDetails("0743477111")).thenReturn(new Book("0743477111", "William Shakespeare", "Romeo and Juliet"));
		Mockito.when(testWebService.getBookDetails("0743477111")).thenReturn(new Book("0743477111", "William Shakespeare", "Romeo and Juliet"));

		bookUtil.setWebService(testWebService);
		bookUtil.setDBService(testDbService);
		assertEquals("7111W3", bookUtil.bookIdentifier("0743477111"), "Assert for 0743477111 - Romeo & Juliet");
		
		Mockito.verify(testDbService, Mockito.times(1)).getBookDetails("0743477111");
		Mockito.verifyNoInteractions(testWebService);
		
	}

}
