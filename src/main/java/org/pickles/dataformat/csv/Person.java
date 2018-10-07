package org.pickles.dataformat.csv;

import com.github.mygreen.supercsv.annotation.CsvBean;
import com.github.mygreen.supercsv.annotation.CsvColumn;
import com.github.mygreen.supercsv.annotation.format.CsvBooleanFormat;
import com.github.mygreen.supercsv.annotation.format.CsvDateTimeFormat;
import com.github.mygreen.supercsv.annotation.format.CsvNumberFormat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CsvBean
public class Person {

	private static final SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

	public Person(){}

	public Person(long id, String name, Date birthday, boolean student, BigDecimal height, BigDecimal weight) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.student = student;
		this.height = height;
		this.weight = weight;
	}

	@CsvColumn(number=1, label="ID")
	private long id;

	@CsvColumn(number=2, label="名前")
	private String name;

	@CsvColumn(number=3, label="誕生日")
	@CsvDateTimeFormat(pattern="yyyy/MM/dd")
	private Date birthday;

	@CsvColumn(number=4, label="学生")
	@CsvBooleanFormat(
			readForTrue={"○", "true", "yes"},
			readForFalse={"×", "false", "no", ""},
			writeAsTrue="○",
			writeAsFalse="")
	private boolean student;

	@CsvColumn(number=5, label="身長")
	@CsvNumberFormat(precision=4, rounding= RoundingMode.HALF_UP)
	private BigDecimal height;

	@CsvColumn(number=6, label="体重")
	@CsvNumberFormat(precision=5, rounding= RoundingMode.HALF_UP)
	private BigDecimal weight;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isStudent() {
		return student;
	}

	public void setStudent(boolean student) {
		student = student;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", birthday=" + DEFAULT_FORMAT.format(birthday) +
				", isStudent=" + student +
				", height=" + height +
				", weight=" + weight +
				'}';
	}

	private static long increment = 0;

	public static Person generateRandom(){

		int year = 2018 - (int) ( Math.random() * 60);
		int month = (int) (Math.random() * 12) + 1;
		int day = (int) (Math.random() * 28) + 1;
		Date birthday = null;
		try {
			birthday = DEFAULT_FORMAT.parse(year + "/" + month + "/" + day);
		} catch (ParseException e) {
			e.printStackTrace();
			birthday = new Date();
		}
		double height = 140 + Math.random() * 60;
		double weight = 30 + Math.random() * 70;

		return new Person(
				++increment,
				"あさもっちゃん" + increment,
				birthday,
				(2018 - year) <= 22,
				BigDecimal.valueOf(height),
				BigDecimal.valueOf(weight)
		);
	}

	public static List<Person> getRandomPersonList(int itemNumber){
		final List<Person> people = new ArrayList<>();
		new Times(itemNumber).forEach(() -> people.add(generateRandom()));
		return people;
	}
}
