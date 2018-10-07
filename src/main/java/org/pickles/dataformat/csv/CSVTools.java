package org.pickles.dataformat.csv;

import com.github.mygreen.supercsv.io.CsvAnnotationBeanReader;
import com.github.mygreen.supercsv.io.CsvAnnotationBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVTools {

	public static <T> String toCSVString(List<T> beans, Class<T> type){

		StringWriter writer = new StringWriter();

		try(CsvAnnotationBeanWriter<T> csvWriter = new CsvAnnotationBeanWriter<>(
				type, writer, CsvPreference.STANDARD_PREFERENCE)){

			csvWriter.writeHeader();

			beans.forEach(item -> {
				try {
					csvWriter.write(item);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		return writer.toString();
	}

	public static <T> List<T> parseFromCSV(String csv, Class<T> type) {

		List<T> list = new ArrayList<>();

		try(CsvAnnotationBeanReader<T> csvReader = new CsvAnnotationBeanReader<>(
				type, new BufferedReader(new StringReader(csv)), CsvPreference.STANDARD_PREFERENCE)) {

			csvReader.getHeader(true);

			T record = null;
			while((record = csvReader.read()) != null) {
				list.add(record);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}



}
