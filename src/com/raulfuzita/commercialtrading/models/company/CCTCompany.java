package com.raulfuzita.commercialtrading.models.company;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.raulfuzita.commercialtrading.models.depot.Depot;

public class CCTCompany extends Company {
	
	private List<Depot> depots = new CopyOnWriteArrayList<>();

	public CCTCompany(long id, String name) {
		super(id, name);
	}

	public CCTCompany(String name) {
		super(name);
	}

	public List<Depot> getDepots() {
		return depots;
	}

	public void setDepots(List<Depot> depots) {
		this.depots = new CopyOnWriteArrayList<>(depots);
	}
}
