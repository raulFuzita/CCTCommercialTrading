package com.raulfuzita.commercialtrading.models.stocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.raulfuzita.commercialtrading.models.products.Item;
import com.raulfuzita.commercialtrading.models.products.Product;

public class Stock {

	private List<Product> products = Collections.synchronizedList(new ArrayList<>());
	
	public Stock() {}
	
	public Stock(List<Product> products) {
		this.products = Collections.synchronizedList(new ArrayList<>(products));
	}
	
	public Product peek(int id) {
		return products.get(id);
	}
	
	public Product push(int id) {
		Product product = products.get(id);
		products.remove(id);
		return product;
	}
	
	public void pull(Product product) {
		products.add(product);
	}
	
	public void addListProducts(List<Product> products) {
		this.products = Collections.synchronizedList(new ArrayList<>(products));
	}
	
	public int size() {
		return products.size();
	}

	@Override
	public String toString() {
		return "Stock [products=" + products + "]";
	}
}
