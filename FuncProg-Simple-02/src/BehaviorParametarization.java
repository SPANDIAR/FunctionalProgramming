/* Using Predicate and passing them as method parameter */

import java.util.List;
import java.util.function.Predicate;

public class BehaviorParametarization {

	public static void main(String[] args) {
		
		List<Integer> intList = List.of(6, 7, 8, 10, 12, 14, 17, 19, 23, 36);
		
		//Predicate<? super Integer> predicate = x -> x%3 == 0;
		
		System.out.println("All Even Numbers");
		someRandomFunction(intList, x -> x%2 == 0);
		
		System.out.println("All Odd Numbers");
		someRandomFunction(intList, x -> x%2 != 0);
		
		System.out.println("All Multiples of 3");
		someRandomFunction(intList, x -> x%3 == 0);

	}

	private static void someRandomFunction(List<Integer> intList, Predicate<? super Integer> predicate) {
		intList.stream()
				.filter(predicate)
				.forEach(System.out::println);
	}
	
}
