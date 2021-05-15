package com.raulfuzita.commercialtrading.models.trademarket;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.raulfuzita.commercialtrading.models.depot.Depot;

public class TradeMarket {
	
	private List<Depot> observers = new CopyOnWriteArrayList<>();

	public List<Depot> getObservers() {
		return observers;
	}

	public void setObservers(List<Depot> observers) {
		this.observers = new CopyOnWriteArrayList<>(observers);
	}
	
	public void register(Depot e) {
		this.observers.add(e);
	}
	
	public void unregister(Depot e) {
		this.observers.remove(e);
	}

	public List<Future<TradeRecord>> openMarket() throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newSingleThreadExecutor();
		List<Future<TradeRecord>> record = es.invokeAll(observers);
		es.shutdown();
		System.out.println("Records: " + record.size());
		for (Future<TradeRecord> future : record) {
			System.out.println(future.get());
		}
		es = null;
		return record;
	}
}
