package io.spandiar.isbn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsbnValidatorTest {

	@Test
	void validateValidIsbn() {
		Assert.assertTrue("Assert for ISBN: 0399103422", IsbnValidator.validateIsbn("0399103422"));
	}
	
	@Test
	void validateValidIsbnWithChar() {
		Assert.assertTrue("Assert for ISBN: 012000030X", IsbnValidator.validateIsbn("012000030X"));
	}
	
	@Test
	void validateInvalidIsbn() {
		Assert.assertFalse("Assert for ISBN: 0399103522", IsbnValidator.validateIsbn("0399103522"));
	}
	
	@Test
	void validateInvalidIsbn9Digits() {
		Assertions.assertThrows(NumberFormatException.class, () -> {IsbnValidator.validateIsbn("039910351");});
	}

}
