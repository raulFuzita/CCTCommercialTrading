package com.raulfuzita.commercialtrading.testunit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.raulfuzita.commercialtrading.models.company.CCTCompany;
import com.raulfuzita.commercialtrading.models.depot.DepotTrader;
import com.raulfuzita.commercialtrading.models.factories.CCTCompanyDepots50Factory;
import com.raulfuzita.commercialtrading.models.factories.DepotBalance50To100;
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
		TradeMarket<DepotTrader> tk = new TradeMarket<>();
		Factory<DepotTrader> pf = new DepotBalance50To100(1, tk, new ProductPrice1To10());
		DepotTrader trader = pf.makeOne();
		List<DepotTrader> traders = pf.makeMany(50);
		
		int s1 = trader.get().stockSize();
		int s2 = traders.get(0).get().stockSize();
		
		assertTrue(s1 == 50 && s2 == 50);
	}
	
	@Test
	void testAmilcarsDepotPriceUpTo20() {
		TradeMarket<DepotTrader> tk = new TradeMarket<>();
		Factory<DepotTrader> pf = new DepotBalance50To100(1, tk, new ProductPrice1To10());
		DepotTrader trader = pf.makeOne();
		List<DepotTrader> traders = pf.makeMany(50);
		
		Product p1 = trader.get().getStocks().peek(0);
		Product p2 = traders.get(0).get().getStocks().peek(0);
		
		assertTrue(p1.getCost() > 0 && p1.getCost() < 21);
		assertTrue(p2.getCost() > 0 && p2.getCost() < 21);
	}
	
	@Test
	void testCCTCompanyDepots50Factory() {
		TradeMarket<DepotTrader> tk = new TradeMarket<>();
		ProductPrice1To10 pp1To10 = new ProductPrice1To10();
		int unit = 30;
		CCTCompanyDepots50Factory factory = new CCTCompanyDepots50Factory(tk, pp1To10);
		List<CCTCompany> companies = factory.makeMany(unit);
		for (CCTCompany company : companies) {
			System.out.println("Company Name: " + company.getName());
		}
		assertTrue(companies.size() == unit);
	}
}
