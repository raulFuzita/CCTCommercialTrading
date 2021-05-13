package com.raulfuzita.commercialtrading.models.depot;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import com.raulfuzita.commercialtrading.models.stocks.NullStock;
import com.raulfuzita.commercialtrading.models.stocks.Stock;

public abstract class Warehouse {
	
	private final long id;
	private Stock stocks;
	private Map<Long, Stock> foreignStocks;
	private AtomicLong balance;
	
	public abstract static class Builder<T extends Builder<T>> {
		
		private Stock stocks;
		private Map<Long, Stock> foreignStocks;
		private AtomicLong balance;
		
		public Builder() {
			this.foreignStocks 	= new ConcurrentHashMap<>();
			this.balance 		= new AtomicLong(0);
		}
		
		public T stocks(Stock stocks) {
			this.stocks = stocks;
			return self();
		}
		
		public T balance(long balance) {
			this.balance = new AtomicLong(balance);
			return self();
		}
		
		abstract Warehouse build();
		
		protected abstract T self();
	}

	protected Warehouse(Builder<?> builder) {
		stocks				= builder.stocks;
		foreignStocks		= builder.foreignStocks;
		balance				= builder.balance;
		id					= SerialGenerator.generateSerial();
	}
	
	public long getId() {
		return id;
	}

	public Stock getStocks() {
		Optional<Stock> optional = Optional.ofNullable(stocks);
		return optional.orElse(new NullStock());
	}

	public Map<Long, Stock> getForeignStocks() {
		return foreignStocks;
	}

	public void setForeignStocks(Map<Long, Stock> foreignStocks) {
		this.foreignStocks = new ConcurrentHashMap<>(foreignStocks);
	}
	
	public long getBalance() {
		return this.balance.get();
	}
	
	public void depositCashe(long cashe) {
		balance.getAndAdd(cashe);
	}
	
	public boolean withdrawCashe(long cashe) {
		if (cashe <= balance.get()) {
			balance.getAndUpdate(b -> b - cashe);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Warehouse [stocks=" + stocks + ", foreignStocks=" + foreignStocks 
				+ ", balance=" + balance + "]";
	}
}
