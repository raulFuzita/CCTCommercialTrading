package com.raulfuzita.commercialtrading.until;

import java.util.Scanner;

public class Keyboard {

	public static String inputText(String prompt) {
		System.out.println(prompt);
		Scanner scan = new Scanner(System.in);
		String content = scan.nextLine();
		scan.close();
		scan = null;
		return content;
	}
}
