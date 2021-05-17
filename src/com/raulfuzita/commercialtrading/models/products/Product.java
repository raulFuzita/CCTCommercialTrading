package com.raulfuzita.commercialtrading.models.products;

/***
 * Product interface is meant to generalize what a product is.
 * You can also use this interface to implement a Decorator Pattern.
 * 
 * @author raul macedo fuzita
 *
 */
public interface Product {
	/***
	 * This method returns a Product cost.
	 * @return long type
	 */
	long getCost();
}
