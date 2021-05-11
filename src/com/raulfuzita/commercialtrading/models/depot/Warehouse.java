package com.raulfuzita.commercialtrading.models.depot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.raulfuzita.commercialtrading.models.stocks.NullStock;
import com.raulfuzita.commercialtrading.models.stocks.Stock;

public abstract class Warehouse {
	
	private Stock stocks;
	private ConcurrentMap<Long, Stock> foreignStocks;
	
	abstract static class Builder<T extends Builder<T>> {
		
		Stock stocks;
		ConcurrentMap<Long, Stock> foreignStocks;
		
		public T stocks(Stock stocks) {
			this.stocks = stocks;
			return self();
		}
		
		public abstract Warehouse build();
		
		protected abstract T self();
	}

	protected Warehouse(Builder<?> builder) {
		stocks				= builder.stocks;
		foreignStocks		= builder.foreignStocks;
	}

	public Stock getStocks() {
		Optional<Stock> optional = Optional.ofNullable(stocks);
		return optional.orElse(new NullStock());
	}

	public Map<Long, Stock> getForeignStocks() {
		return foreignStocks != null ? foreignStocks : Collections.emptyMap();
	}
	
	public void setForeignStocks(Map<Long, Stock> foreignStocks) {
		this.foreignStocks = new ConcurrentHashMap<>(foreignStocks);
	}
	
	public boolean addForeignStocks(long companyId, Stock stock) {
		Stock result = this.foreignStocks.putIfAbsent(companyId, stock);
		return result == null;
	}
	
	public boolean addForeignStocks(long companyId, Stock stock) {
		Stock result = this.foreignStocks.putIfAbsent(companyId, stock);
		return result == null;
	}

	@Override
	public String toString() {
		return "Warehouse [stocks=" + stocks + ", foreignStocks=" + foreignStocks + "]";
	}

}
