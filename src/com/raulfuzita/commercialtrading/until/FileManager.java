package com.raulfuzita.commercialtrading.until;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

	public static void 
	save(File file, String content, boolean append) throws IOException {
		createFile(file, content, append);
	}
	
	public static void 
	save(File file, String content) throws IOException {
		createFile(file, content, false);
	}
	
	private static void 
	createFile(File file, String content, boolean append) throws IOException {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, append));
		writer.write(content);
		writer.close();
		writer = null;
	}
	
	public static String load(File file) throws FileNotFoundException {
		
		Scanner reader = new Scanner(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		while(reader.hasNext())
			sb.append(reader.nextLine());
		reader.close();
		reader = null;
		
		return sb.toString();
	}
}
