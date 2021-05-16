package com.raulfuzita.commercialtrading.models.trademarket;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TradeMarket<E extends Callable<Recordable>> implements Market<E> {

	private List<E> traders = new CopyOnWriteArrayList<>();

	public List<Future<Recordable>> openMarket() throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newSingleThreadExecutor();
		List<Future<Recordable>> record = es.invokeAll(traders);
		es.shutdown();
		System.out.println("Records: " + record.size());
		for (Future<Recordable> future : record) {
			System.out.println(future.get().getRecord());
		}
		es = null;
		return record;
	}

	@Override
	public List<E> getTraders() {
		return this.traders;
	}

	@Override
	public void setTraders(List<E> traders) {
		this.traders = new CopyOnWriteArrayList<>();
	}

	@Override
	public void register(E trader) {
		this.traders.add(trader);
	}

	@Override
	public void unregister(E trader) {
		this.traders.remove(trader);
	}

}
