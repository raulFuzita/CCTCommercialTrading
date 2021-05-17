package com.raulfuzita.commercialtrading.models.depot;

import java.util.concurrent.Callable;

import com.raulfuzita.commercialtrading.models.trademarket.Market;
import com.raulfuzita.commercialtrading.models.trademarket.records.EmptyRecord;
import com.raulfuzita.commercialtrading.models.trademarket.records.RecordDecorator;
import com.raulfuzita.commercialtrading.models.trademarket.records.Recordable;

public class DepotTrader implements Callable<Recordable> {
	
	private Market<DepotTrader> market;
	private final Depot trader;
	private Recordable baseRecord = new EmptyRecord();
	
	public DepotTrader(Depot trader) {
		this.trader = trader;
	}

	@Override
	public Recordable call() throws Exception {
		return trade();
	}

	public Depot get() {
		return this.trader;
	}

	public Market<DepotTrader> getMarket() {
		return this.market;
	}

	public void setMarket(Market<DepotTrader> market) {
		this.market = market;
	}
	
	private Recordable trade() {
		
		int c = 0;
		while(market.size() > 1 && c < 40) {
			System.out.println("Records: " + market.size());
			TradeFacade facade = new TradeFacade(baseRecord);
			baseRecord = new RecordDecorator(facade.trade(this, market));
			c++;
		}
		return baseRecord;
	}

}
