package com.raulfuzita.commercialtrading.testunit;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
=======
import static org.junit.jupiter.api.Assertions.*;
>>>>>>> fresh

import java.util.List;

import org.junit.jupiter.api.Test;

<<<<<<< HEAD
<<<<<<< HEAD
import com.raulfuzita.commercialtrading.models.companies.Company;
import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.factories.company.AmilcarsFactory;
import com.raulfuzita.commercialtrading.models.factories.company.CompanyFactory;
import com.raulfuzita.commercialtrading.models.factories.depot.DepotFactory;
import com.raulfuzita.commercialtrading.models.factories.depot.DepotProduct15To50;
=======
import com.raulfuzita.commercialtrading.models.companies.CCTCompany;
import com.raulfuzita.commercialtrading.models.factories.depot.DepotFactory;
import com.raulfuzita.commercialtrading.models.factories.depot.DepotTraderProduct15To50;
>>>>>>> ef7341563cede4dba6a7bd3b1b0088ef4d1a29b9
import com.raulfuzita.commercialtrading.models.factories.product.ProductFactory;
import com.raulfuzita.commercialtrading.models.factories.product.ProductPrice1To10;
import com.raulfuzita.commercialtrading.models.products.Item;
import com.raulfuzita.commercialtrading.models.products.Product;
<<<<<<< HEAD
import com.raulfuzita.commercialtrading.models.stocks.Stock;
=======
import com.raulfuzita.commercialtrading.models.trades.Trader;
>>>>>>> ef7341563cede4dba6a7bd3b1b0088ef4d1a29b9
=======
import com.raulfuzita.commercialtrading.models.company.CCTCompany;
import com.raulfuzita.commercialtrading.models.depot.DepotTrader;
import com.raulfuzita.commercialtrading.models.factories.CCTCompanyDepots50Factory;
import com.raulfuzita.commercialtrading.models.factories.DepotBalance50To100;
import com.raulfuzita.commercialtrading.models.factories.Factory;
import com.raulfuzita.commercialtrading.models.factories.ProductPrice1To10;
import com.raulfuzita.commercialtrading.models.products.Item;
import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.trademarket.TradeMarket;

>>>>>>> fresh

class TestFactories {
	
	@Test
<<<<<<< HEAD
	void requiresTotalUnitsProductFactory() {
		int units = 5;
		ProductFactory productFactory = new ProductPrice1To10();
		List<Product> products = productFactory.makeMany(units);
		assertTrue(units == products.size());
=======
	void testProductFactory15To50() {
		Factory<Product> pf = new ProductPrice1To10();
		Product product = pf.makeOne();
		List<Product> products = pf.makeMany(50);
		assertEquals(Item.class, product.getClass());
		assertEquals(Item.class, products.get(0).getClass());
>>>>>>> fresh
	}

	
	@Test
<<<<<<< HEAD
	void testRangePriceProductFactory() {
		ProductFactory productFactory = new ProductPrice1To10();
		Product p = productFactory.makeOne();
		double price = p.getPrice();
		System.out.println("The price is: " + price);
		assertTrue(price > 0 && price < 11);
	}
	
	@Test
	void testDepotFactoryWithDefaultProductFactory() {
<<<<<<< HEAD
		DepotFactory depotFactory = new DepotProduct15To50();
		List<Depot> depots = depotFactory.makeMany(2);
		Stock stock = depots.get(1).getStocks();
		assertEquals(Item.class.getName(), stock.push(1).getClass().getName());
=======
		DepotFactory depotFactory = new DepotTraderProduct15To50(new CCTCompany());
		List<Trader> depots = depotFactory.makeMany(2);
		Trader trader = depots.get(1);
		assertEquals(Item.class.getName(), trader.sellProduct(1).getClass().getName());
>>>>>>> ef7341563cede4dba6a7bd3b1b0088ef4d1a29b9
	}
	
	@Test
	void testDepotFactoryWithProductPrice1To10() {
<<<<<<< HEAD
		DepotFactory depotFactory = new DepotProduct15To50();
		ProductFactory productFactory = new ProductPrice1To10();
		depotFactory.setProductFactory(productFactory);
		List<Depot> depots = depotFactory.makeMany(5);
		Stock stock = depots.get(1).getStocks();
		assertEquals(Item.class.getName(), stock.push(1).getClass().getName());
	}

	@Test
	void testAmilcarsFactory() {
		CompanyFactory companyFactory = new AmilcarsFactory();
		Company company = companyFactory.make();
		long id = company.getId();
		System.out.println("Company ID: " + id);
		assertTrue(id == (long)id);
	}
=======
		DepotFactory depotFactory = new DepotTraderProduct15To50(new CCTCompany());
		ProductFactory productFactory = new ProductPrice1To10();
		depotFactory.setProductFactory(productFactory);
		List<Trader> depots = depotFactory.makeMany(5);
		Trader trader = depots.get(1);
		assertEquals(Item.class.getName(), trader.sellProduct(1).getClass().getName());
	}

	
>>>>>>> ef7341563cede4dba6a7bd3b1b0088ef4d1a29b9
=======
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
>>>>>>> fresh
}
