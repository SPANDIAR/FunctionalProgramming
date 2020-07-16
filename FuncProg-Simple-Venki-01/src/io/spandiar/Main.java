package io.spandiar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;

public class Main {
	
	public static List<Person> createPerson() {
		
		return Arrays.asList(
				new Person("Shankee", 38, Gender.M, "Indian"),
				new Person("Manju", 38, Gender.M, "Indian"),
				new Person("Tannu", 7, Gender.F, "Indian"),
				new Person("Sergey", 48, Gender.M, "Russian"),
				new Person("Obama", 68, Gender.M, "American"),
				new Person("Yuvan", 7, Gender.M, "American"),
				new Person("Steffi", 48, Gender.F, "German"),
				new Person("Karthi", 32, Gender.F, "Indian"),
				new Person("Ravee", 38, Gender.M, "Indian"),
				new Person("Arnold", 78, Gender.M, "American")
				);
	}

	public static void main(String[] args) {
		
		List<Person> person = createPerson();
		
		System.out.println(
		person.parallelStream()
				.filter(p -> p.getGender() == Gender.M)
				.filter(p -> p.getAge() > 40)
				.map(Person::getName)
				.findAny());
		
		// split people by gender
		Map<Boolean, List<Person>> genderBias = person.stream()
		.collect(Collectors.partitioningBy(p -> p.getGender() == Gender.M));
		
		// find Indians less than 40
		Map<String, Person> indians = person.stream()
				.filter(p -> p.getNationality().equalsIgnoreCase("Indian"))
				.filter(p -> p.getAge() < 40)
				.collect(Collectors.toMap(Person::getName, Function.identity()));
		
		// Group people by Country
		Map<String, List<String>> groupByNationalityAndName = person.stream()
				.collect(Collectors.groupingBy(Person::getNationality, Collectors.mapping(Person::getName, Collectors.toList())));
		
		System.out.println(groupByNationalityAndName);
		
		// Find no of people grouped by Nationality
		Map<String, Integer> countsByNationality = person.stream()
				.collect(Collectors.groupingBy(Person::getNationality, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
		
		System.out.println(countsByNationality);
		
		// find the youngest person's name
		
//		Optional<Person> minAge = person.stream()
//			.min(Comparator.comparing(Person::getAge));
		
		String minAge = person.stream()
			.collect(Collectors.collectingAndThen(
							Collectors.minBy(Comparator.comparing(Person::getAge)), 
							p -> p.map(Person::getName).orElse(" ")));
		
		System.out.println(minAge);
		
		
	}
	
	static class Person {
		
		private String name;
		private int age;
		private Gender gender; 
		private String nationality;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			//System.out.println("Age of: " + name);
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public String getNationality() {
			return nationality;
		}
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		public Person(String name, int age, Gender gender, String nationality) {
			super();
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.nationality = nationality;
		}
		public Person() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", nationality=" + nationality
					+ "]";
		}
		
		
		
	}
}
