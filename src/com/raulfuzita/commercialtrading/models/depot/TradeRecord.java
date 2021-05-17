package com.raulfuzita.commercialtrading.models.depot;

import java.time.LocalDateTime;

import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.trademarket.records.RecordDecorator;
import com.raulfuzita.commercialtrading.models.trademarket.records.Recordable;

public final class TradeRecord extends RecordDecorator implements Recordable {
	
	private LocalDateTime timestamp;
	private Depot buyer;
	private Depot seller;
	private Product product;

	public TradeRecord(Recordable record) {
		super(record);
	}
	
	public void setRecord(Depot buyer, Depot seller, Product product) {
		this.timestamp = LocalDateTime.now();
		this.buyer = buyer;
		this.seller = seller;
		this.product = product;
	}

	@Override
	public String getRecord() {
		return record.getRecord() + "\nTradeRecord [buyerId=" + buyer.getId() 
				+ ", sellerId=" + seller.getId() + ", timestamp=" + timestamp 
				+ ", product=" + product + "]";
	}
	
}
