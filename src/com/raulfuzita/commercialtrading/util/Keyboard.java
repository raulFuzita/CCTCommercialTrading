package com.raulfuzita.commercialtrading.util;

import java.util.Scanner;

public class Keyboard {

	public static String inputText(String prompt) {
		System.out.println(prompt);
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		scan = null;
		return input;
	}
	
	public static int inputInt(String prompt) {
		System.out.println(prompt);
		try(Scanner scan = new Scanner(System.in)){
			return scan.nextInt();
		} catch(Exception e) {
			System.out.println("Only integer numbers are accepted!\n");
			inputInt(prompt);
		}
		return -1;
	}
}
