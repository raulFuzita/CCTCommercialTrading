package com.raulfuzita.commercialtrading.models.factories.product;

import com.raulfuzita.commercialtrading.models.products.Item;
import com.raulfuzita.commercialtrading.models.products.Product;

public class NullProductPrice extends ProductPrice1To10 {
	
	protected Product createProduct() {
		return new Item(0);
	}
}
