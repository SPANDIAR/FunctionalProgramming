package io.spandiar.fp01;

import java.util.List;

public class PrintListUsingFP {

	public static void main(String[] args) {
		List<Integer> intList = List.of(5, 6, 8, 12, 55, 63, 6, 13);
		printListElementsFunctionally(intList);
	}

	private static void printListElementsFunctionally(List<Integer> intList) {
		intList.stream()
				.forEach(System.out::println);
	}
}
