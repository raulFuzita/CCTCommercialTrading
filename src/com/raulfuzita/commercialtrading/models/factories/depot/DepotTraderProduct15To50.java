package com.raulfuzita.commercialtrading.models.factories.depot;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.raulfuzita.commercialtrading.models.companies.Company;
import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.factories.product.ProductFactory;
import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.stocks.Stock;
import com.raulfuzita.commercialtrading.models.trades.DepotTrader;
import com.raulfuzita.commercialtrading.models.trades.Trader;

public final class DepotTraderProduct15To50 extends DepotFactory {

	private final Company company;
	
	public DepotTraderProduct15To50(Company company) {
		super();
		this.company = company;
	}

	@Override
	protected Trader createDepot(ProductFactory productFactory) {
		List<Product> products = productFactory.makeRange(15, 50);
		long balance = generateBalance();
		return new DepotTrader(new Depot.Builder(balance)
									.company(company)
									.stocks(new Stock(products))
									.self());
	}
	
	protected long generateBalance() {
		return ThreadLocalRandom.current().nextLong(50, 101);
	}
}
