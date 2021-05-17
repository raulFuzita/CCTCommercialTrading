package com.raulfuzita.commercialtrading.models.trademarket;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.raulfuzita.commercialtrading.models.depot.DepotTrader;
import com.raulfuzita.commercialtrading.models.trademarket.records.Recordable;

public class TradeMarketFacade {

	public List<Future<Recordable>> bootstrap(TradeMarket<DepotTrader> market) 
								throws InterruptedException, ExecutionException {
		
		List<Future<Recordable>> allRecords = new ArrayList<>();
		int numTransactions = 0;
		LocalDateTime start = LocalDateTime.now();
		
		while(market.size() > 1) {
			List<Future<Recordable>> records = market.openMarket();
			allRecords.addAll(records);
			numTransactions += records.size();
		}
		
		LocalDateTime end = LocalDateTime.now();
		System.out.println("Number of transactions: " + numTransactions);
		Duration duration = Duration.between(start, end);
		double timeInSeconds = ((double) duration.toMillis() / 1000);
		System.out.println("Execution time (Seconds): " + timeInSeconds);
		return allRecords;
	}
}
