import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdasAndMore {

	public static void main(String[] args) {
		
		List<Books> favouriteBooks = List.of(
				new Books("Ponniyin Selvan", "Amarar Kalki", "Tamil", 4.85F, "Classic"),
				new Books("The Godfather", "Mario Puzo", "English", 4.6F, "Crime"),
				new Books("The Street Lawyer", "John Grisham", "English", 3.9F, "Fiction"),
				new Books("1408", "Stephen King", "English", 4.77F, "Horror"),
				new Books("The Prodigal Daughter", "Jeffrey Archer", "English", 3.7F, "Fiction"),
				new Books("Kane & Abel", "Jeffrey Archer", "English", 4.32F, "Classic"),
				new Books("Paarthiban Kanavu", "Amarar Kalki", "Tamil", 4.28F, "Classic"),
				new Books("Kamba Ramayanam", "Kambar", "Tamil", 4.73F, "Classic"),
				new Books("Thirukhural", "Thiruvalluvar", "Tamil", 4.84F, "Literature")
				);
		
		Predicate<Books> ratingGreaterThan4Predicate = book -> book.getRating() > 4.0;
		Predicate<Books> ratingLessThan4Predicate = book -> book.getRating() < 4.0;
		Predicate<Books> foundFrenchBooks = book -> book.getLanguage().contains("French");
		Predicate<Books> foundTamilBooks = book -> book.getLanguage().contains("Tamil");


		
		System.out.println(favouriteBooks.stream().allMatch(ratingGreaterThan4Predicate));
		System.out.println(favouriteBooks.stream().anyMatch(ratingLessThan4Predicate));		
		System.out.println(favouriteBooks.stream().noneMatch(ratingLessThan4Predicate));
		System.out.println(favouriteBooks.stream().anyMatch(foundFrenchBooks));		
		
		// Sorting books
		
		Comparator<Books> compareByRating = Comparator.comparing(Books::getRating);

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Sorting by Rating");
		System.out.println(favouriteBooks.stream()
						.sorted(compareByRating)
						.dropWhile(books -> books.getRating() >= 4.5)
						.collect(Collectors.toList()));	
		
		
		Comparator<Books> compareByBookName = Comparator.comparing(Books::getBookName);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Sorting by BookName");
		System.out.println(favouriteBooks.stream()
						.sorted(compareByBookName)
						.collect(Collectors.toList()));
		
		
		// filter books
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Get all Tamil Books");
		
		System.out.println(favouriteBooks.stream()
						.filter(books -> books.getLanguage().contentEquals("Tamil"))
						//.limit(3)
						.skip(2)
						.collect(Collectors.toList()));
		
		// best rated book
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Best Rated Book");
		System.out.println(favouriteBooks.stream()
			.max(compareByRating));
		
		// books below 4 Star rating
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Less than 4 Star");
		System.out.println(favouriteBooks.stream()
			.filter(ratingLessThan4Predicate)
			.collect(Collectors.toList()));
		
		// Average rating of all books
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Books - Average Ratings");
		
		System.out.println(favouriteBooks.stream().mapToDouble(Books::getRating).average());
	}
}

class Books {
	
	private String bookName;
	private String author;
	private String language;
	private float rating;
	private String category;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Books(String bookName, String author, String language, float rating, String category) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.language = language;
		this.rating = rating;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Books [bookName=" + bookName + ", author=" + author + ", rating=" + rating
				+ "]";
	}
	
}