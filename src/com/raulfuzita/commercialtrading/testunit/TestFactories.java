package com.raulfuzita.commercialtrading.testunit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.raulfuzita.commercialtrading.models.factories.ProductFactory;
import com.raulfuzita.commercialtrading.models.products.Product;

class TestFactories {
	
	@Test
	void requiresTotalUnitsProductFactory() {
		int units = 5;
		List<Product> products = ProductFactory.makeMany(1, units);
		assertTrue(units == products.size());
	}

	@Test
	void testRangePriceProductFactory() {
		Product p = ProductFactory.makeOne(1);
		double price = p.getPrice();
		System.out.println("The price is: " + price);
		assertTrue(price > 0 && price < 11);
	}

}
