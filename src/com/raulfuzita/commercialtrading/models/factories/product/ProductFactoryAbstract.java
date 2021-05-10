package com.raulfuzita.commercialtrading.models.factories.product;

import java.util.concurrent.ThreadLocalRandom;

public class ProductFactoryAbstract {
	
	protected final double generatePrice(int start, int end) {
		return ThreadLocalRandom.current().nextInt(start, end);
	}
}
