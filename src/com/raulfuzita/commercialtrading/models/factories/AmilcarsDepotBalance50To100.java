package com.raulfuzita.commercialtrading.models.factories;

import java.util.concurrent.ThreadLocalRandom;

import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.stocks.Stock;
import com.raulfuzita.commercialtrading.models.trademarket.TradeMarket;

public final class AmilcarsDepotBalance50To100 extends AbstractFactory<Depot> {

	private final long companyId;
	private TradeMarket tradeMarket;
	private Factory<Product> factory;
	
	public AmilcarsDepotBalance50To100
	(long companyId, TradeMarket tradeMarket, Factory<Product> factory) {
		this.companyId = companyId;
		this.tradeMarket = tradeMarket;
		this.factory = factory;
	}

	@Override
	protected Depot create() {
		Stock stock = new Stock();
		stock.addListProducts(factory.makeMany(50));
		Depot depotTrader = new Depot.Builder(companyId)
				.balance(generateBalance())
				.stocks(stock)
				.tradeMarket(tradeMarket)
				.build();
		tradeMarket.add(depotTrader);
		return depotTrader;
	}

	private long generateBalance() {
		return ThreadLocalRandom.current().nextLong(50, 101);
	}
}
