package com.raulfuzita.commercialtrading.view;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.raulfuzita.commercialtrading.models.company.CCTCompany;
import com.raulfuzita.commercialtrading.models.trademarket.records.RecordDataFacade;
import com.raulfuzita.commercialtrading.models.trademarket.records.Recordable;
import com.raulfuzita.commercialtrading.until.Keyboard;

public class MainMenuView {
	
	private RecordDataFacade recordData = new RecordDataFacade();
	private CompanyActionsView companyActions;
	private List<Future<Recordable>> allRecords;
	private List<CCTCompany> companies;
	
	public 
	MainMenuView(List<Future<Recordable>> allRecords, List<CCTCompany> companies) {
		this.allRecords = allRecords;
		this.companies = companies;
		this.companyActions = new CompanyActionsView(allRecords, companies);
	}

	private void displayMenu()  {
		System.out.println("\n=================== MAIN MENU ===================");
		System.out.println("| (A) See all transactions						|");
		System.out.println("| (B) All compay's transactions					|");
		System.out.println("| (C) Company's details							|");
		System.out.println("| (X) Exit										|");
		System.out.println("-------------------------------------------------");
	}
	
	public String selectMenu() throws InterruptedException, ExecutionException {
		displayMenu();
		String option = Keyboard.inputText("Enter one of the options: ").toUpperCase();
		switch (option) {
			case "A": 
				recordData.allRecords(allRecords);
				break;
	
			case "B":
				companyActions.companyTransactions();
				break;
	
			case "C":
				companyActions.companyDetails();
				break;
	
			case "X":
				System.out.println("\n=================================================");
				System.out.println("System is closing...");
				break;
	
			default:
				System.out.println("Sorry, this option doesn't exist\n");
		}
		return option;
	}
	
}
