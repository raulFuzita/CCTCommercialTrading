package com.raulfuzita.commercialtrading.testunit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.raulfuzita.commercialtrading.models.companies.CCTCompany;
import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.facades.TradeFacade;
import com.raulfuzita.commercialtrading.models.factories.depot.DepotFactory;
import com.raulfuzita.commercialtrading.models.factories.depot.DepotTraderProduct15To50;
import com.raulfuzita.commercialtrading.models.trades.DepotTrader;
import com.raulfuzita.commercialtrading.models.trades.Trader;

class TestTrade {

	@Test
	void test() {
		DepotFactory df = new DepotTraderProduct15To50(new CCTCompany("Company A"));
		List<Trader> compA = df.makeMany(50);
		
		df = new DepotTraderProduct15To50(new CCTCompany("Company B"));
		List<Trader> compB = df.makeMany(50);
		
		TradeFacade tf = new TradeFacade();
		boolean result = tf.trade(compA.get(0), compB.get(1));
		System.out.println("Trade happended successfully: " + result);
	}

}
