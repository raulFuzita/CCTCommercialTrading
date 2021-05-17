package com.raulfuzita.commercialtrading.models.depot;

import java.time.LocalDateTime;

import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.trademarket.records.Recordable;

public final class TradeRecord implements Recordable {
	
	private LocalDateTime timestamp = LocalDateTime.now();
	private Depot buyer;
	private Depot seller;
	private Product product;
	
	public void setRecord(Depot buyer, Depot seller, Product product) {
		this.timestamp = LocalDateTime.now();
		this.buyer = buyer;
		this.seller = seller;
		this.product = product;
	}

	@Override
	public String getRecord() {
		return "TradeRecord [buyerId=" + buyer.getId() 
				+ ", sellerId=" + seller.getId() + ", timestamp=" + timestamp 
				+ ", product=" + product + "]";
	}

	@Override
	public long getCompBuyerId() {
		return buyer.getCompanyId();
	}

	@Override
	public long getCompSellerId() {
		return buyer.getCompanyId();
	}
}
