package com.raulfuzita.commercialtrading.models.factories.depot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.factories.product.NullProductPrice;
import com.raulfuzita.commercialtrading.models.factories.product.ProductFactory;
import com.raulfuzita.commercialtrading.models.trades.Trader;

public abstract class DepotFactory {
	
	private ProductFactory productFactory;
	
	public void setProductFactory(ProductFactory productFactory) {
		this.productFactory = productFactory;
	}

	public List<Trader> makeMany(int units) {
		List<Trader> depots = Collections.synchronizedList(new ArrayList<>());
		Optional<ProductFactory> optional = Optional.ofNullable(productFactory);
		for (int i = 0; i < units; i++)
			depots.add(createDepot(optional.orElse(new NullProductPrice())));
		return depots;
	}
	
	protected abstract Trader createDepot(ProductFactory productFactory);
}
