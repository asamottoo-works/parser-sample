package org.pickles.dataformat.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {

	public Person(long id, String name, Date birthday, boolean isStudent, double height, double weight) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.isStudent = isStudent;
		this.height = height;
		this.weight = weight;
	}

	private long id;


	private String name;


	private Date birthday;


	private boolean isStudent;


	private double height;


	private double weight;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public boolean isStudent() {
		return isStudent;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}

	public static long getIncrement() {
		return increment;
	}

	private static long increment = 0;

	public static Person generateRandom(){

		int year = 2018 - ((int) Math.random() * 60);
		int month = (int) Math.random() * 12;
		int day = (int) Math.random() * 28;
		Date birthday = new Date(year, month, day);
		double height = 140 + Math.random() * 60;
		double weight = 30 + Math.random() * 70;

		return new Person(
				++increment,
				"あさもっちゃん" + increment,
				birthday,
				(2018 - year) <= 22,
				height,
				weight
		);
	}

	public static List<Person> getRandomPersonList(int itemNumber){
		final List<Person> people = new ArrayList<>();
		new Times(itemNumber).forEach(() -> people.add(generateRandom()));
		return people;
	}
}
