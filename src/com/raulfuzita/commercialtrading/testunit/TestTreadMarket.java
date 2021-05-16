package com.raulfuzita.commercialtrading.testunit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.raulfuzita.commercialtrading.models.company.CCTCompany;
import com.raulfuzita.commercialtrading.models.depot.DepotTrader;
import com.raulfuzita.commercialtrading.models.factories.DepotBalance50To100;
import com.raulfuzita.commercialtrading.models.factories.Factory;
import com.raulfuzita.commercialtrading.models.factories.ProductPrice1To10;
import com.raulfuzita.commercialtrading.models.trademarket.TradeMarket;

class TestTreadMarket {

	@Test
	void test() {
		
		TradeMarket<DepotTrader> tk = new TradeMarket<>();
		ProductPrice1To10 pp1To10 = new ProductPrice1To10();
		CCTCompany c1 = new CCTCompany("A");
		
		Factory<DepotTrader> f = new DepotBalance50To100(c1.getId(), tk, pp1To10);
		List<DepotTrader> l1 = f.makeMany(50);
		c1.setDepots(l1);
		
		CCTCompany c2 = new CCTCompany("B");
		f = new DepotBalance50To100(c2.getId(), tk, pp1To10);
		List<DepotTrader> l2 = f.makeMany(50);
		c2.setDepots(l2);
		
		CCTCompany c3 = new CCTCompany("C");
		f = new DepotBalance50To100(c3.getId(), tk, pp1To10);
		List<DepotTrader> l3 = f.makeMany(50);
		c2.setDepots(l3);
		
		try {
			tk.openMarket();
		} catch (InterruptedException | ExecutionException e) {
			fail(e.getMessage());
		}
		
	}

}
