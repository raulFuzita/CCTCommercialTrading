package com.raulfuzita.commercialtrading.models.factories.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.raulfuzita.commercialtrading.models.products.Item;
import com.raulfuzita.commercialtrading.models.products.Product;

public class ProductPrice1To10 extends ProductFactoryAbstract implements ProductFactory {

	@Override
	public Product makeOne() {
		return createProduct();
	}

	@Override
	public List<Product> makeMany(int units) {
		return makeRange(0, units);
	}
	
	@Override
	public List<Product> makeRange(int start, int end) {
		List<Product> products = Collections.synchronizedList(new ArrayList<>());
		for (int i = start; i < end; i++)
			products.add(createProduct());
		return products;
	}
	
	protected Product createProduct() {
		double price = generatePrice(1, 10);
		return new Item(price);
	}

}
