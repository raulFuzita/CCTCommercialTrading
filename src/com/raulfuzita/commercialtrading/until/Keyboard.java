package com.raulfuzita.commercialtrading.until;

import java.util.Scanner;

public class Keyboard {

	public static String inputText(String prompt) {
		System.out.println(prompt);
		Scanner scan = new Scanner(System.in);
		String content = scan.nextLine();
		return content;
	}
	
	public static int inputInt(String prompt) {
		System.out.println(prompt);
		try {
			Scanner scan = new Scanner(System.in);
			return scan.nextInt();
		} catch (Exception e) {
			System.out.println("\nYou must enter a number, please try again.");
			return -1;
		}
	}
}
