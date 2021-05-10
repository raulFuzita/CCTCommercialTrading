package com.raulfuzita.commercialtrading.models.companies;

import com.raulfuzita.commercialtrading.util.SerialGenerator;

public abstract class Company {

	private final long id;
	
	public Company() {
		this.id = SerialGenerator.generateSerial();
	}

	public Company(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + "]";
	}
}
