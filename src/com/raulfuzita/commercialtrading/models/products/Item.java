package com.raulfuzita.commercialtrading.models.products;

public class Item implements Product {
	
	private long compId;
	private double price;
	
	public Item(long compId, double price) {
		super();
		this.compId = compId;
		this.price = price;
	}

	@Override
	public double getCompanyId() {
		return compId;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Item [compId=" + compId + ", price=" + price + "]";
	}
}
