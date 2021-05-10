package com.raulfuzita.commercialtrading.testunit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.raulfuzita.commercialtrading.models.factories.product.ProductFactory;
import com.raulfuzita.commercialtrading.models.factories.product.ProductPrice1To10;
import com.raulfuzita.commercialtrading.models.products.Item;
import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.stocks.Stock;

class StockPushProduct {

	@Test
	void pushProductAndReturnIt() {
		ProductFactory productFactory = new ProductPrice1To10();
		List<Product> products = productFactory.makeRange(5, 10);
		
		Stock stock = new Stock();
		stock.addListProducts(products);
		
		assertEquals(Item.class.getName(), stock.push(1).getClass().getName());
	}
	
}
