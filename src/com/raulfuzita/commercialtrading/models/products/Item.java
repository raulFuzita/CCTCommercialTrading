package com.raulfuzita.commercialtrading.models.products;

public final class Item implements Product {
	
	private final long price;
	private final long delivery;
	
	public Item(long price, long delivery) {
		this.price = price;
		this.delivery = delivery;
	}

	@Override
	public long getCost() {
		return price + delivery;
	}

	@Override
	public String toString() {
		return "Item [price=" + price + ", delivery=" + delivery + "]";
	}
	
}
