package com.raulfuzita.commercialtrading.models.depot;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongUnaryOperator;

import com.raulfuzita.commercialtrading.models.products.Product;

public class Depot extends Warehouse {
	
	private AtomicLong balance;

	public static class Builder extends Warehouse.Builder<Builder> {
		
		private AtomicLong balance;
		
		public Builder(long balance) {
			this.balance = new AtomicLong(balance);
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
	
	private Depot(Builder builder) {
		super(builder);
		balance			= builder.balance;
	}
	
	public long getBalance() {
		return this.balance.get();
	}
	
	public void withdrawCashe(long cashe) {
		LongUnaryOperator luo = b -> b - cashe;
		balance.getAndUpdate(luo);
	}
	
	public void depositCashe(long cashe) {
		balance.getAndAdd(cashe);
	}
	
	public synchronized Product sell(int id) {
		return this.getStocks().push(id);
	}
	
	public void buy(Long companyId, Product product) {
		this.getForeignStocks().get(companyId).pull(product);
	}
	
	public int stockSize() {
		return this.getStocks().size();
	}
	
	public int foreignStockSize() {
		return this.getForeignStocks().size();
	}

	@Override
	public String toString() {
		return "Depot [balance=" + balance + ", getStocks()=" + getStocks() 
				+ ", getForeignStocks()=" + getForeignStocks() + "]";
	}
}