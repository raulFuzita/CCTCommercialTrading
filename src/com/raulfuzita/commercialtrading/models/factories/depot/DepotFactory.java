package com.raulfuzita.commercialtrading.models.factories.depot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.factories.product.NullProductPrice;
import com.raulfuzita.commercialtrading.models.factories.product.ProductFactory;

public abstract class DepotFactory {
	
	private ProductFactory productFactory;
	
	public void setProductFactory(ProductFactory productFactory) {
		this.productFactory = productFactory;
	}

	public List<Depot> makeMany(int units) {
		List<Depot> depots = Collections.synchronizedList(new ArrayList<>());
		Optional<ProductFactory> optional = Optional.ofNullable(productFactory);
		for (int i = 0; i < units; i++)
			depots.add(createDepot(optional.orElse(new NullProductPrice())));
		return depots;
	}
	
	protected abstract Depot createDepot(ProductFactory productFactory);
}
