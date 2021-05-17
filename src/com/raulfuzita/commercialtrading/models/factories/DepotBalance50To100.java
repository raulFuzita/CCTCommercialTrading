package com.raulfuzita.commercialtrading.models.factories;

import java.util.concurrent.ThreadLocalRandom;

import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.depot.DepotTrader;
import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.stocks.Stock;
import com.raulfuzita.commercialtrading.models.trademarket.Market;
import com.raulfuzita.commercialtrading.models.trademarket.TradeMarket;

/**
 * @author raul macedo fuzita
 */
public final class DepotBalance50To100 extends AbstractFactory<DepotTrader> {

	private final long companyId;
	private Market<DepotTrader> market;
	private Factory<Product> factory;
	
	public DepotBalance50To100
	(long companyId, Market<DepotTrader> tradeMarket, Factory<Product> factory) {
		this.companyId = companyId;
		this.market = tradeMarket;
		this.factory = factory;
	}

	@Override
	protected DepotTrader create() {
		Stock stock = new Stock();
		stock.addListProducts(factory.makeMany(50));
		Depot depotTrader = new Depot.Builder(companyId)
				.balance(generateBalance())
				.stocks(stock)
				.build();
		DepotTrader trader = new DepotTrader(depotTrader);
		trader.setMarket(market);
		market.register(trader);
		return trader;
	}

	private long generateBalance() {
		return ThreadLocalRandom.current().nextLong(50, 101);
	}
}
