package io.spandiar.isbn;

public class IsbnValidator {
	
	private static final String ISBNSTDTEXT = "^\\d{9,13}[\\d|X]$"; 
	private static final int ISBN10MOD = 11;

	public static void main(String[] args) {
	
		String input = args[0];
		System.out.println(input + " is a valid ISBN:  " + validateIsbn(input));
	}
	
	public static boolean validateIsbn(String inputIsbn) {
		
		if(!inputIsbn.isBlank() && (inputIsbn.length() == 10 || inputIsbn.length() == 13) && inputIsbn.matches(ISBNSTDTEXT)) {
			return isbnValidator10(inputIsbn);
		}
		throw new NumberFormatException("Invalid length of ISBN");
	}
	
	private static boolean isbnValidator10(String inputIsbn) {
		int total = 0;
		
		for(int i=0; i<10;i++) {
			if(inputIsbn.charAt(i) == 'X') {
				total += 10;
			} else {
				total += Character.getNumericValue(inputIsbn.charAt(i)) * (10 - i);
			}
		}
		return (total%(ISBN10MOD) == 0);
	}

}
