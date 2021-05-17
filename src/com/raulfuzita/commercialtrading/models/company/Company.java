package com.raulfuzita.commercialtrading.models.company;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Company {

	private static final AtomicLong nextSerialNum = new AtomicLong(1);
	protected final long id;
	protected final String name;
	
	public Company(String name) {
		this.name = name;
		this.id = nextSerialNum.getAndIncrement();
	}

	public Company(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}
}
