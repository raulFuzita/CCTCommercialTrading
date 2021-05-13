package com.raulfuzita.commercialtrading.models.trademarket;

import java.time.LocalDateTime;

import com.raulfuzita.commercialtrading.models.products.Product;

public class TradeRecord {

	private long buyerId;
	private long sellerId;
	private Product product;
	
	public TradeRecord() {}

	public TradeRecord(long buyerId, long sellerId, Product product) {
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.product = product;
	}
	
	@Override
	public String toString() {
		LocalDateTime timestamp = LocalDateTime.now();
		return "TradeRecord [buyerId=" + buyerId + ", sellerId=" + sellerId 
				+ ", timestamp=" + timestamp + ", product=" + product + "]";
	}
	
}
