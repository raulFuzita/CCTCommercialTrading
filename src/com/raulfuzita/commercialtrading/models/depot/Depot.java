package com.raulfuzita.commercialtrading.models.depot;

import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.stocks.Stock;

public class Depot extends Warehouse {
	
	private final long companyId;

	public static class Builder extends Warehouse.Builder<Builder> {
		
		private final long companyId;
		
		public Builder(long companyId) {
			this.companyId 		= companyId;
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
	public String toString() {
		return "Depot [companyId=" + companyId + ", getStocks()=" + getStocks() 
				+ ", getForeignStocks()=" + getForeignStocks() 
				+ ", getBalance()=" + getBalance() + "]";
	}
	
}
