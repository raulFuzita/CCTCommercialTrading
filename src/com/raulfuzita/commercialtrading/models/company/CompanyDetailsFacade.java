package com.raulfuzita.commercialtrading.models.company;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.raulfuzita.commercialtrading.models.depot.DepotTrader;
import com.raulfuzita.commercialtrading.models.trademarket.records.Recordable;

/**
 * @author raul macedo fuzita
 */
public class CompanyDetailsFacade {

	public void details(CCTCompany company) {
		List<DepotTrader> depots = company.getDepots();
		for (DepotTrader depotTrader : depots) {
			System.out.println(depotTrader.get());
		}
	}
	
	public void 
	allTransactions(CCTCompany company, List<Future<Recordable>> records) 
								throws InterruptedException, ExecutionException {
		for (Future<Recordable> future : records) {
			Recordable record = future.get();
			if (company.getId() == record.getCompBuyerId()) {
				System.out.println(record.getRecord());
			}
		}
	}
}
