package org.pickles.dataformat.csv;

import org.hamcrest.core.StringEndsWith;
import org.junit.Test;
import org.pickles.dataformat.util.FileUtil;

import java.io.StringWriter;
import java.util.List;

import static org.junit.Assert.*;

public class CSVToolsTest {




	@Test
	public void toCSVString() {

		List<Person> people10 = Person.getRandomPersonList(10);

		String csv = CSVTools.toCSVString(people10, Person.class);

		System.out.println(csv);

		FileUtil.write("write_sample.csv", csv);
	}

	@Test
	public void parseFromCSV() {

		String csv = FileUtil.read("read_sample.csv");

		System.out.println(csv);

		List<Person> people = CSVTools.parseFromCSV(csv, Person.class);

		people.forEach(System.out::println);
	}
}