import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnonymousOperations {

	public static void main(String[] args) {
		
		System.out.println("");
		System.out.println("Sum of n numbers");
		System.out.println(IntStream.range(0, 10).sum());
		
		System.out.println("");
		System.out.println("Sum of n numbers");
		System.out.println(IntStream.rangeClosed(0, 10).sum());
		
		System.out.println("");
		System.out.println("Even Numbers");
		System.out.println(IntStream.iterate(0, a -> a+2).peek(System.out::println).limit(5).sum());
		
		System.out.println("");
		System.out.println("Multiples of 3 in a list");
		System.out.println(IntStream.iterate(0, a->a+3).limit(10).boxed().collect(Collectors.toList()));
	}
}
