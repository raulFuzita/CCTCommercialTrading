package com.raulfuzita.commercialtrading.models.stocks;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.raulfuzita.commercialtrading.models.products.Product;

public class Stock {

	protected List<Product> products = new CopyOnWriteArrayList<>();
	
	public Product push(int id) {
		Product product = products.get(id);
		products.remove(id);
		return product;
	}
	
	public Product peek(int id) {
		return products.get(id);
	}
	
	public synchronized void pull(Product product) {
		products.add(product);
	}
	
	public void addListProducts(List<Product> products) {
		this.products = new CopyOnWriteArrayList<>(products);
	}
	
	public int size() {
		return products.size();
	}

	@Override
	public String toString() {
		return "Stock [products=" + products + "]";
	}
}
