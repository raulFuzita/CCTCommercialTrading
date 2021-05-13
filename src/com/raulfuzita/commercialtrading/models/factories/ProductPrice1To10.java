package com.raulfuzita.commercialtrading.models.factories;

import java.util.concurrent.ThreadLocalRandom;

import com.raulfuzita.commercialtrading.models.products.Item;
import com.raulfuzita.commercialtrading.models.products.Product;

public class ProductPrice1To10 extends AbstractFactory<Product> {

	@Override
	protected Product create() {
		return new Item(generatePrice(), generatePrice());
	}

	private long generatePrice() {
		return ThreadLocalRandom.current().nextLong(1, 11);
	}
}
