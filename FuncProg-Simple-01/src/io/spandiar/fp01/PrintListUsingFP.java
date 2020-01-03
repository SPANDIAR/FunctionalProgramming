package io.spandiar.fp01;

import java.util.List;

public class PrintListUsingFP {

	public static void main(String[] args) {
		List<Integer> intList = List.of(5, 6, 8, 12, 55, 63, 6, 13, 24);
		//printListElementsFunctionally(intList);
		printEvenNosInList(intList);
	}

	private static void printEvenNosInList(List<Integer> intList) {
		
		intList.stream()
				.distinct()
				.filter(PrintListUsingFP::isEven)
				.forEach(System.out::println);
				
	}
	
	private static boolean isEven(int number){
		return (number %2 ==0);
	}

	private static void printListElementsFunctionally(List<Integer> intList) {
		intList.stream()
				.forEach(System.out::println);
	}
}
