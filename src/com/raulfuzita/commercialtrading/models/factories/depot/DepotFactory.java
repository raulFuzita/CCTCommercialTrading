package com.raulfuzita.commercialtrading.models.factories.depot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.factories.product.NullProductPrice;
import com.raulfuzita.commercialtrading.models.factories.product.ProductFactory;
<<<<<<< HEAD
=======
import com.raulfuzita.commercialtrading.models.trades.Trader;
>>>>>>> ef7341563cede4dba6a7bd3b1b0088ef4d1a29b9

public abstract class DepotFactory {
	
	private ProductFactory productFactory;
	
	public void setProductFactory(ProductFactory productFactory) {
		this.productFactory = productFactory;
	}

<<<<<<< HEAD
	public List<Depot> makeMany(int units) {
		List<Depot> depots = Collections.synchronizedList(new ArrayList<>());
=======
	public List<Trader> makeMany(int units) {
		List<Trader> depots = Collections.synchronizedList(new ArrayList<>());
>>>>>>> ef7341563cede4dba6a7bd3b1b0088ef4d1a29b9
		Optional<ProductFactory> optional = Optional.ofNullable(productFactory);
		for (int i = 0; i < units; i++)
			depots.add(createDepot(optional.orElse(new NullProductPrice())));
		return depots;
	}
	
<<<<<<< HEAD
	protected abstract Depot createDepot(ProductFactory productFactory);
=======
	protected abstract Trader createDepot(ProductFactory productFactory);
>>>>>>> ef7341563cede4dba6a7bd3b1b0088ef4d1a29b9
}
