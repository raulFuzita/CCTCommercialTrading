package com.raulfuzita.commercialtrading.models.products;

/***
 * Class Item implements Product interface. This class is immutable and
 * cannot be extended.
 * 
 * @author raul macedo fuzita
 *
 */
public final class Item implements Product {
	
<<<<<<< HEAD
	private double price;
	
	public Item(double price) {
		super();
=======
	private final long price;
	private final long delivery;
	
	/**
	 * This constructor  takes two parameters to set final attributes
	 * 
	 * @param price is a long type
	 * @param delivery is a long type
	 */
	public Item(long price, long delivery) {
>>>>>>> fresh
		this.price = price;
		this.delivery = delivery;
	}

	/**
	 * Check interface documentation
	 */
	@Override
<<<<<<< HEAD
	public double getPrice() {
		return price;
=======
	public long getCost() {
		return price + delivery;
>>>>>>> fresh
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Item [price=" + price + "]";
=======
		return "Item [price=" + price + ", delivery=" + delivery + "]";
>>>>>>> fresh
	}
	
}
