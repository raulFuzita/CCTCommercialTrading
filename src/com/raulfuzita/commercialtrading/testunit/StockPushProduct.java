package com.raulfuzita.commercialtrading.testunit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.raulfuzita.commercialtrading.models.factories.ProductFactory;
import com.raulfuzita.commercialtrading.models.products.Item;
import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.stocks.Stock;

class StockPushProduct {

	@Test
	void pushProductAndReturnIt() {
		List<Product> products = ProductFactory.makeMany(1, 5);
		
		Stock stock = new Stock();
		stock.addListProducts(products);
		
		assertEquals(Item.class.getName(), stock.push(1).getClass().getName());
	}

	
}
