package com.raulfuzita.commercialtrading.testunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.raulfuzita.commercialtrading.models.companies.CCTCompany;
import com.raulfuzita.commercialtrading.models.factories.depot.DepotFactory;
import com.raulfuzita.commercialtrading.models.factories.depot.DepotTraderProduct15To50;
import com.raulfuzita.commercialtrading.models.factories.product.ProductFactory;
import com.raulfuzita.commercialtrading.models.factories.product.ProductPrice1To10;
import com.raulfuzita.commercialtrading.models.products.Item;
import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.trades.Trader;

class TestFactories {
	
	@Test
	void requiresTotalUnitsProductFactory() {
		int units = 5;
		ProductFactory productFactory = new ProductPrice1To10();
		List<Product> products = productFactory.makeMany(units);
		assertTrue(units == products.size());
	}

	@Test
	void testRangePriceProductFactory() {
		ProductFactory productFactory = new ProductPrice1To10();
		Product p = productFactory.makeOne();
		double price = p.getPrice();
		System.out.println("The price is: " + price);
		assertTrue(price > 0 && price < 11);
	}
	
	@Test
	void testDepotFactoryWithDefaultProductFactory() {
		DepotFactory depotFactory = new DepotTraderProduct15To50(new CCTCompany());
		List<Trader> depots = depotFactory.makeMany(2);
		Trader trader = depots.get(1);
		assertEquals(Item.class.getName(), trader.sellProduct(1).getClass().getName());
	}
	
	@Test
	void testDepotFactoryWithProductPrice1To10() {
		DepotFactory depotFactory = new DepotTraderProduct15To50(new CCTCompany());
		ProductFactory productFactory = new ProductPrice1To10();
		depotFactory.setProductFactory(productFactory);
		List<Trader> depots = depotFactory.makeMany(5);
		Trader trader = depots.get(1);
		assertEquals(Item.class.getName(), trader.sellProduct(1).getClass().getName());
	}

	
}
