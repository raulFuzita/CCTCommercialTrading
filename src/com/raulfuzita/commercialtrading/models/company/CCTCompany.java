package com.raulfuzita.commercialtrading.models.company;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.raulfuzita.commercialtrading.models.depot.DepotTrader;

/**
 * Class CCTCompany is Thread-safe. This class extends Company class.
 * 
 * @author raul macedo fuzita
 *
 */
public class CCTCompany extends Company {
	
	private List<DepotTrader> depots = new CopyOnWriteArrayList<>();

	/**
	 * @param id is type long
	 * @param name is a String type
	 */
	public CCTCompany(long id, String name) {
		super(id, name);
	}

	/**
	 * This method sets company name
	 * @param name is String type
	 */
	public CCTCompany(String name) {
		super(name);
	}

	/**
	 * This method returns all depots
	 * @return {@code List<DepotTrader>}
	 */
	public List<DepotTrader> getDepots() {
		return depots;
	}
	
	/**
	 * This method sets a whole group of depots
	 * It is thread-safe
	 * @param depots {@code List<DepotTrader>}
	 */
	public void setDepots(List<DepotTrader> depots) {
		this.depots = new CopyOnWriteArrayList<>(depots);
	}
}
