package com.raulfuzita.commercialtrading.models.company;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.raulfuzita.commercialtrading.models.depot.DepotTrader;

public class CCTCompany extends Company {
	
	private List<DepotTrader> depots = new CopyOnWriteArrayList<>();

	public CCTCompany(long id, String name) {
		super(id, name);
	}

	public CCTCompany(String name) {
		super(name);
	}

	public List<DepotTrader> getDepots() {
		return depots;
	}

	public void setDepots(List<DepotTrader> depots) {
		this.depots = new CopyOnWriteArrayList<>(depots);
	}
}
