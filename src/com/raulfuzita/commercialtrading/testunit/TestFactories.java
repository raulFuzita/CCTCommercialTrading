package com.raulfuzita.commercialtrading.testunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.raulfuzita.commercialtrading.models.companies.Company;
import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.factories.company.AmilcarsFactory;
import com.raulfuzita.commercialtrading.models.factories.company.CompanyFactory;
import com.raulfuzita.commercialtrading.models.factories.depot.DepotFactory;
import com.raulfuzita.commercialtrading.models.factories.depot.DepotProduct15To50;
import com.raulfuzita.commercialtrading.models.factories.product.ProductFactory;
import com.raulfuzita.commercialtrading.models.factories.product.ProductPrice1To10;
import com.raulfuzita.commercialtrading.models.products.Item;
import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.stocks.Stock;

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
		DepotFactory depotFactory = new DepotProduct15To50();
		List<Depot> depots = depotFactory.makeMany(2);
		Stock stock = depots.get(1).getStocks();
		assertEquals(Item.class.getName(), stock.push(1).getClass().getName());
	}
	
	@Test
	void testDepotFactoryWithProductPrice1To10() {
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
}
