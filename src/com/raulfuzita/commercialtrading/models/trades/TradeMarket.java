package com.raulfuzita.commercialtrading.models.trades;

import java.util.List;

public interface TradeMarket {

	public void register(Trader t);
	public void unregister(Trader t);
	public List<Trader> getTraders();
}
