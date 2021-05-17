package com.raulfuzita.commercialtrading.models.trademarket.records;

public class EmptyRecord implements Recordable {

	@Override
	public String getRecord() {
		return "";
	}

	@Override
	public long getCompBuyerId() {
		return 0;
	}

	@Override
	public long getCompSellerId() {
		return 0;
	}

}
