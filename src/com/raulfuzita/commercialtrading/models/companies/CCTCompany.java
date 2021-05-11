package com.raulfuzita.commercialtrading.models.companies;

public final class CCTCompany extends Company {

	private String name;

	public CCTCompany() {
		super();
	}

	public CCTCompany(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CCTCompany [name=" + name + ", id()=" + getId() + "]";
	}
}
