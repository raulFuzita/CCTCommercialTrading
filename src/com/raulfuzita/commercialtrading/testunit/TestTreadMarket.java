package com.raulfuzita.commercialtrading.testunit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

import com.raulfuzita.commercialtrading.models.company.CCTCompany;
import com.raulfuzita.commercialtrading.models.company.CompanyDetailsFacade;
import com.raulfuzita.commercialtrading.models.depot.DepotTrader;
import com.raulfuzita.commercialtrading.models.factories.DepotBalance50To100;
import com.raulfuzita.commercialtrading.models.factories.Factory;
import com.raulfuzita.commercialtrading.models.factories.ProductPrice1To10;
import com.raulfuzita.commercialtrading.models.trademarket.TradeMarket;
import com.raulfuzita.commercialtrading.models.trademarket.records.RecordDataFacade;
import com.raulfuzita.commercialtrading.models.trademarket.records.Recordable;

class TestTreadMarket {

	@Test
	void testMarket() {
		
		TradeMarket<DepotTrader> tk = new TradeMarket<>();
		ProductPrice1To10 pp1To10 = new ProductPrice1To10();
		CCTCompany c1 = new CCTCompany("A");
		
		Factory<DepotTrader> f = new DepotBalance50To100(c1.getId(), tk, pp1To10);
		List<DepotTrader> l1 = f.makeMany(50);
		c1.setDepots(l1);
		
		CCTCompany c2 = new CCTCompany("B");
		f = new DepotBalance50To100(c2.getId(), tk, pp1To10);
		List<DepotTrader> l2 = f.makeMany(50);
		c2.setDepots(l2);
		
		CCTCompany c3 = new CCTCompany("C");
		f = new DepotBalance50To100(c3.getId(), tk, pp1To10);
		List<DepotTrader> l3 = f.makeMany(50);
		c2.setDepots(l3);
		
		int numTransactions = 0;
		LocalDateTime start = LocalDateTime.now();
		try {
			
			List<Future<Recordable>> allRecords = new ArrayList<>();
			
			while(tk.size() > 1) {
				List<Future<Recordable>> records = tk.openMarket();
				allRecords.addAll(records);
//				System.out.println("Records: " + records.size());
				numTransactions += records.size();
//				for (Future<Recordable> record : records) {
//					System.out.println(record.get().getRecord());
//				}
//				System.out.println("Market size (Last): " + tk.size());
			}
			LocalDateTime end = LocalDateTime.now();
			
			System.out.println("Number of transactions: " + numTransactions);
			Duration duration = Duration.between(start, end);
			double timeInSeconds = ((double) duration.toMillis() / 1000);
			System.out.println("Execution time (Seconds): " + timeInSeconds);
			
			System.out.println("\n================= DETAILS =================");
			System.out.println("--------------- All Transactions ------------");
			RecordDataFacade recordData = new RecordDataFacade();
			recordData.allRecords(allRecords);
			System.out.println("\n----------- All Company's Details -----------");
			CompanyDetailsFacade companyDetails = new CompanyDetailsFacade();
			companyDetails.details(c1);
			
			System.out.println("\n--------- All Company's Transaction ---------");
			
			companyDetails.allTransactions(c1, allRecords);
			
		} catch (InterruptedException | ExecutionException e) {
			fail(e.getMessage());
		}
		
	}

}
