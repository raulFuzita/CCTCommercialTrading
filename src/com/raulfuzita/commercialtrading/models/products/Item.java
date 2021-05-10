package com.raulfuzita.commercialtrading.models.products;

public class Item implements Product {
	
	private double price;
	
	public Item(double price) {
		super();
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Item [price=" + price + "]";
	}
}
