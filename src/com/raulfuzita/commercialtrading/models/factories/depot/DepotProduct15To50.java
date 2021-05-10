package com.raulfuzita.commercialtrading.models.factories.depot;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.factories.product.ProductFactory;
import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.stocks.Stock;

public class DepotProduct15To50 extends DepotFactory {

	@Override
	protected Depot createDepot(ProductFactory productFactory) {
		List<Product> products = productFactory.makeRange(15, 50);
		long balance = generateBalance();
		return new Depot.Builder(balance)
				.stocks(new Stock(products))
				.build();
	}
	
	protected long generateBalance() {
		return ThreadLocalRandom.current().nextLong(50, 101);
	}
}
