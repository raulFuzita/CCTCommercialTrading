package com.raulfuzita.commercialtrading.models.trades;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class CCTMarket implements TradeMarket {

	private List<Trader> traders;
	
	public CCTMarket() {}

	public CCTMarket(List<Trader> traders) {
		this.traders = new CopyOnWriteArrayList<>(traders);
	}

	@Override
	public List<Trader> getTraders() {
		return traders != null ? traders : Collections.emptyList();
	}

	public void setTraders(List<Trader> traders) {
		this.traders = new CopyOnWriteArrayList<>(traders);
	}

	@Override
	public void register(Trader t) {
		this.traders.add(t);
	}

	@Override
	public void unregister(Trader t) {
		this.traders.remove(t);
	}
	
	
}
