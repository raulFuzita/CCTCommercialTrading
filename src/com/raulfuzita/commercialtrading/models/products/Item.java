package com.raulfuzita.commercialtrading.models.products;

/***
 * Class Item implements Product interface. This class is immutable and
 * cannot be extended.
 * 
 * @author raul macedo fuzita
 *
 */
public final class Item implements Product {
	
	private final long price;
	private final long delivery;
	
	/**
	 * This constructor  takes two parameters to set final attributes
	 * 
	 * @param price is a long type
	 * @param delivery is a long type
	 */
	public Item(long price, long delivery) {
		this.price = price;
		this.delivery = delivery;
	}

	/**
	 * Check interface documentation
	 */
	@Override
	public long getCost() {
		return price + delivery;
	}

	@Override
	public String toString() {
		return "Item [price=" + price + ", delivery=" + delivery + "]";
	}
	
}
