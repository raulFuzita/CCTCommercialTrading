package com.raulfuzita.commercialtrading.models.trademarket.records;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class RecordDataFacade {

	public void allRecords(List<Future<Recordable>> records) 
								throws InterruptedException, ExecutionException {
		for (Future<Recordable> future : records) {
			Recordable record = future.get();
			if (!record.getRecord().isEmpty()) {
				System.out.println(record.getRecord());
			}
		}
	}
}
