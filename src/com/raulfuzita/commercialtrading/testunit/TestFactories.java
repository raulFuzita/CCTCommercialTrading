package com.raulfuzita.commercialtrading.testunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

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
}
