package io.spandiar;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class Sample {
	
	public static int transform(int e){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("Number: " + e + " - Thread : " + Thread.currentThread().getName());
		return e*2;
	}
	
	
	public static void printInt(Stream<Integer> numbers) {
		
		numbers
				.parallel()
				.map(Sample::transform)
				.forEachOrdered(System.out::println);
		
	}

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
										11, 12, 13, 14, 15, 16, 17, 18, 19, 20
										);
		
//		numbers.parallelStream()
//			.filter(e -> e%2!=0)
//			.map(Sample::transform)
//			.forEach(System.out::println);
		
		printInt(numbers.stream());
		
//		System.out.println("ForkJoinPool " + ForkJoinPool.commonPool());
//		System.out.println("Runtime Processors " + Runtime.getRuntime().availableProcessors());
		
	}

}
