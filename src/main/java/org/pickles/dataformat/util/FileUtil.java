package org.pickles.dataformat.util;

import java.io.*;

public class FileUtil {

	public static void write(String path, String data){
		try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)))){
			pw.write(data);
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public static String read(String path) {

		StringBuilder sb = new StringBuilder();

		try(BufferedReader br = new BufferedReader(new FileReader(path))){

			String str;
			while((str = br.readLine()) != null){
				sb.append(str);
			}

		}catch(IOException e){
			System.out.println(e);
		}

		return sb.toString();
	}
}
