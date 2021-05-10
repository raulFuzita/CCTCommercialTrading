package com.raulfuzita.commercialtrading.models.factories.product;

import java.util.List;

import com.raulfuzita.commercialtrading.models.products.Product;

public interface ProductFactory {
	Product makeOne();
	List<Product> makeMany(int units);
	List<Product> makeRange(int start, int end);
}
