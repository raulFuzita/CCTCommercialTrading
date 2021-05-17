package com.raulfuzita.commercialtrading.models.trademarket.records;

public class RecordDecorator implements Recordable {

	protected Recordable record;
	
	public RecordDecorator(Recordable record) {
		this.record = record;
	}

	@Override
	public String getRecord() {
		return record.getRecord();
	}

}
