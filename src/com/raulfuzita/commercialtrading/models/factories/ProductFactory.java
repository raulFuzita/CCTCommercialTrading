package com.raulfuzita.commercialtrading.models.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.raulfuzita.commercialtrading.models.products.Item;
import com.raulfuzita.commercialtrading.models.products.Product;

public class ProductFactory {

	public static Product makeOne(long compId) {
		return new Item(compId, generatePrice());
	}
	
	public static List<Product> makeMany(long compId, int units) {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < units; i++)
			products.add(new Item(compId, generatePrice()));
		return products;
	}
	
	private static double generatePrice() {
		return ThreadLocalRandom.current().nextInt(1, 11);
	}
}
