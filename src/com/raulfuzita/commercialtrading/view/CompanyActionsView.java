package com.raulfuzita.commercialtrading.view;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.raulfuzita.commercialtrading.models.company.CCTCompany;
import com.raulfuzita.commercialtrading.models.company.CompanyDetailsFacade;
import com.raulfuzita.commercialtrading.models.trademarket.records.Recordable;
import com.raulfuzita.commercialtrading.until.Keyboard;

public class CompanyActionsView {

	private CompanyDetailsFacade companyDetails = new CompanyDetailsFacade();
	private List<Future<Recordable>> allRecords;
	private List<CCTCompany> companies;
	
	public 
	CompanyActionsView(List<Future<Recordable>> allRecords, List<CCTCompany> companies) {
		this.allRecords = allRecords;
		this.companies = companies;
	}
	
	private int displayMenu() {
		System.out.println("\n============== COMPANY'S REQUIRES ================");
		System.out.println(" ID   Name");
		for (CCTCompany company : companies)
			System.out.println(" ("+company.getId()+")  " + company.getName());
		System.out.println("-------------------------------------------------");
		return Keyboard.inputInt("Enter a company ID: ");
	}
	
	public void companyDetails() {
		int id = displayMenu()-1;
		if (id > -1 && id < companies.size()) {
			companyDetails.details(companies.get(id));
			return;
		}
		Keyboard.inputText("\nID doesn't exit. Press any key to continue...");
	}
	
	public void companyTransactions() throws InterruptedException, ExecutionException {
		int id = displayMenu()-1;
		if (id > -1 && id < companies.size()) {
			companyDetails.allTransactions(companies.get(id), allRecords);
			return;
		}
		Keyboard.inputText("\nID doesn't exit. Press any key to continue...");
	}
}
