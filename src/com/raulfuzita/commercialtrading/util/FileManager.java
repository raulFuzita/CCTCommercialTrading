package com.raulfuzita.commercialtrading.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
	
	public static void save(File file, String content) {
		save(file, content, false);
	}

	public static void save(File file, String content, boolean append) {
		try (
			FileWriter fw = new FileWriter(file, append);
			BufferedWriter bw = new BufferedWriter(fw);
		) {
			
			bw.write(content);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
		
	public static String load(File file) {
		StringBuilder sb = new StringBuilder();
		try (
			FileReader fr = new FileReader(file);
			Scanner scan = new Scanner(fr);
		) {
			while(scan.hasNext())
				sb.append(scan.nextLine() + "\n");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return sb.toString();
	}
}
