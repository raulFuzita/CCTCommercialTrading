package com.raulfuzita.commercialtrading.models.depot;

import java.time.LocalDateTime;

import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.trademarket.Recordable;

public final class TradeRecord implements Recordable {
	
	private LocalDateTime timestamp;
	private long buyerId;
	private long sellerId;
	private Product product;

	public TradeRecord(long buyerId, long sellerId, Product product) {
		this.timestamp = LocalDateTime.now();
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.product = product;
	}

	@Override
	public String getRecord() {
		return "TradeRecord [buyerId=" + buyerId + ", sellerId=" + sellerId 
				+ ", timestamp=" + timestamp + ", product=" + product + "]";
	}
	
}
