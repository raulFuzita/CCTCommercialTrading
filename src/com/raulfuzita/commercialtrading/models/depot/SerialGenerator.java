package com.raulfuzita.commercialtrading.models.depot;

import java.util.concurrent.atomic.AtomicLong;

public enum SerialGenerator {
	INSTANCE;
	private static final AtomicLong nextSerialNum = new AtomicLong(1);
	
	public static long generateSerial() {
		return nextSerialNum.getAndIncrement();
	}
}
