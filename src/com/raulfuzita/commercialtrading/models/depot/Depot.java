package com.raulfuzita.commercialtrading.models.depot;

import java.util.List;
import java.util.concurrent.Callable;

import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.stocks.Stock;
import com.raulfuzita.commercialtrading.models.trademarket.TradeFacade;
import com.raulfuzita.commercialtrading.models.trademarket.TradeMarket;
import com.raulfuzita.commercialtrading.models.trademarket.TradeRecord;

public class Depot extends Warehouse implements Callable<TradeRecord> {
	
	private final long companyId;
	private TradeMarket tradeMarket;

	public static class Builder extends Warehouse.Builder<Builder> {
		
		private final long companyId;
		private TradeMarket tradeMarket;
		
		public Builder(long companyId) {
			this.companyId 		= companyId;
		}
		
		public Builder tradeMarket(TradeMarket tradeMarket) {
			this.tradeMarket = tradeMarket;
			return self();
		}

		@Override
		public Depot build() {
			return new Depot(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
		
	}
	
	protected Depot(Builder builder) {
		super(builder);
		companyId		= builder.companyId;
		tradeMarket		= builder.tradeMarket;
	}
	
	public long getCompanyId() {
		return companyId;
	}
	
	public Product peek(int id) {
		return this.getStocks().peek(id);
	}
	
	public Product sell(int id) {
		return this.getStocks().push(id);
	}
	
	public void buy(Long companyId, Product product) {
		// this.getForeignStocks().get(companyId).pull(product);
		this.getForeignStocks().putIfAbsent(companyId, new Stock());
		this.getForeignStocks().get(companyId).pull(product);
	}
	
	public int stockSize() {
		return this.getStocks().size();
	}
	
	public int foreignStockSize() {
		return this.getForeignStocks().size();
	}
	
	@Override
	public TradeRecord call() throws Exception {
		return trade();
	}
	
	private TradeRecord trade() {
		List<Depot> depots = tradeMarket.getObservers();
		TradeFacade facade = new TradeFacade();
		return facade.trade(this, depots);
	}

	@Override
	public String toString() {
		return "Depot [companyId=" + companyId + ", getStocks()=" + getStocks() 
				+ ", getForeignStocks()=" + getForeignStocks() 
				+ ", getBalance()=" + getBalance() + "]";
	}
	
}
