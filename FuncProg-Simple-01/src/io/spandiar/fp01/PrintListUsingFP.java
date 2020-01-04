package io.spandiar.fp01;

import java.util.List;

public class PrintListUsingFP {

	public static void main(String[] args) {
		List<Integer> intList = List.of(5, 6, 8, 12, 7, 11, 6, 15, 24, 29, 22, 12, 3);
		List<String> courseDetails = List.of("Core Java", "JavaEE", "Spring", "Aspect", "Log4J","MVC", "SpringBoot", "JDBC", "Hibernate", "MyBatis", "Java8");
		
		
		/*
		 * System.out.println("Print all integers");
		 * printListElementsFunctionally(intList);
		 * 
		 * System.out.println("Print Even integers"); printEvenNosInList(intList);
		 * 
		 * System.out.println("Print Odd integers"); printOddNosInList(intList);
		 * 
		 * 
		 * System.out.println("Print Square of Odd Numbers");
		 * printOddNosSquareInList(intList);
		 * 
		 * System.out.println("Print Courses");
		 * printListStringsFunctionally(courseDetails);
		 */
		
		
		int sum = sumOfListIntegers(intList);
		System.out.println("Sum of the Integers is: " + sum);
	}
	
	private static int sum(int a, int b) {
		return a+b;
	}

	private static int sumOfListIntegers(List<Integer> intList) {
		return intList.stream()
			.reduce(0, PrintListUsingFP::sum);
	}

	private static void printEvenNosInList(List<Integer> intList) {
		
		intList.stream()
				.distinct()
				.filter(num -> num%2 == 0)
				.forEach(System.out::println);
	}
	
	private static void printOddNosInList(List<Integer> intList) {
		
		intList.stream()
				.distinct()
				.filter(num -> num%2 == 1)
				.forEach(System.out::println);
	}
	
	private static void printOddNosSquareInList(List<Integer> intList) {
		
		intList.stream()
				.distinct()
				.filter(num -> num%2 == 1)
				.map(num -> num * num)
				.forEach(System.out::println);
	}

	private static void printListElementsFunctionally(List<Integer> intList) {
		intList.stream()
				.forEach(System.out::println);
	}
	
	private static void printListStringsFunctionally(List<String> courses) {
		courses.stream()
				//.filter(course -> course.contains("Java"))
				.filter(course -> course.length() >= 5)
				.forEach(System.out::println);
	}
}
