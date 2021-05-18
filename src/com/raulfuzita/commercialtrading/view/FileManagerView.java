package com.raulfuzita.commercialtrading.view;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.raulfuzita.commercialtrading.models.trademarket.records.Recordable;
import com.raulfuzita.commercialtrading.until.FileManager;
import com.raulfuzita.commercialtrading.until.Keyboard;

public class FileManagerView {

	private List<Future<Recordable>> allRecords;
	
	public FileManagerView(List<Future<Recordable>> allRecords) {
		this.allRecords = allRecords;
	}

	public void displayMenu() throws InterruptedException, ExecutionException {
		System.out.println("\n=================== MAIN MENU ===================");
		System.out.println("| (A) Save file									 |");
		System.out.println("---------------------------------------------------");
		String option =  Keyboard.inputText("Enter a valid option: ").toUpperCase();
		
		switch (option) {
			case "A": 
				saveFile();
				break;
		default:
			Keyboard.inputText("\\nThis option doesn't exist. Press any to continue...");
		}
	}
	
	public void saveFile() throws InterruptedException, ExecutionException {
		String filename = getFilename();
		File file = new File(filename);
		
		StringBuilder sb = new StringBuilder();
		for (Future<Recordable> future : allRecords) {
			Recordable record = future.get();
			if (!record.getRecord().isEmpty())
				sb.append(record.getRecord() + "\n");
		}
		
		try {
			FileManager.save(file, sb.toString());
			if (file.exists()) {
				System.out.println("File was created successfully");
				System.out.println("The file is found at: " + file.getPath());
			} else {
				System.out.println("Something happened. File wasn't created.");
				System.out.println("Nothing at: " + file.getPath());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private String getFilename() {
		String filename = Keyboard.inputText("\nEnter file name (transactions):");
		return !filename.isEmpty() ? filename+".txt" : "transactions.txt";
	}
}
