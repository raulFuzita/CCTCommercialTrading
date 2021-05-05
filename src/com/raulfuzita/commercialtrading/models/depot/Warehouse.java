package com.raulfuzita.commercialtrading.models.depot;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.raulfuzita.commercialtrading.models.stocks.NullStock;
import com.raulfuzita.commercialtrading.models.stocks.Stock;

public abstract class Warehouse {
	
	private Stock stocks;
	private Map<Long, Stock> foreignStocks;
	
	abstract static class Builder<T extends Builder<T>> {
		
		Stock stocks;
		Map<Long, Stock> foreignStocks;
		
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
		if (foreignStocks == null)
			return Collections.emptyMap();
		return foreignStocks;
	}

	public void setForeignStocks(Map<Long, Stock> foreignStocks) {
		this.foreignStocks = Collections.synchronizedMap(new HashMap<>(foreignStocks));
	}

	@Override
	public String toString() {
		return "Warehouse [stocks=" + stocks + ", foreignStocks=" + foreignStocks + "]";
	}

}
