package com.raulfuzita.commercialtrading.testunit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.factories.AmilcarsDepotBalance50To100;
import com.raulfuzita.commercialtrading.models.factories.Factory;
import com.raulfuzita.commercialtrading.models.factories.ProductPrice1To10;
import com.raulfuzita.commercialtrading.models.products.Item;
import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.trademarket.TradeMarket;


class TestFactories {
	
	@Test
	void testProductFactory15To50() {
		Factory<Product> pf = new ProductPrice1To10();
		Product product = pf.makeOne();
		List<Product> products = pf.makeMany(50);
		assertEquals(Item.class, product.getClass());
		assertEquals(Item.class, products.get(0).getClass());
	}

	
	@Test
	void testAmilcarsDepotFactoryBalance1To10() {
		TradeMarket tk = new TradeMarket();
		Factory<Depot> pf = new AmilcarsDepotBalance50To100(1, tk, new ProductPrice1To10());
		Depot depot = pf.makeOne();
		List<Depot> depots = pf.makeMany(50);
		
		int s1 = depot.stockSize();
		int s2 = depots.get(0).stockSize();
		
		assertTrue(s1 == 50 && s2 == 50);
	}
	
	@Test
	void testAmilcarsDepotPriceUpTo20() {
		TradeMarket tk = new TradeMarket();
		Factory<Depot> pf = new AmilcarsDepotBalance50To100(1, tk, new ProductPrice1To10());
		Depot depot = pf.makeOne();
		List<Depot> depots = pf.makeMany(50);
		
		Product p1 = depot.getStocks().peek(0);
		Product p2 = depots.get(0).getStocks().peek(0);
		
		assertTrue(p1.getCost() > 0 && p1.getCost() < 21);
		assertTrue(p2.getCost() > 0 && p2.getCost() < 21);
	}
}
