package com.raulfuzita.commercialtrading.models.traders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.observer.MarketSubject;
import com.raulfuzita.commercialtrading.models.observer.Observer;
import com.raulfuzita.commercialtrading.models.observer.TraderObserver;

public class TradersMarket implements MarketSubject {
	
	private List<Observer> observers = Collections.synchronizedList(new ArrayList<>());
	private Map<Long, Depot> traders = Collections.synchronizedMap(new HashMap<>());

	@Override
	public void register(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void unregister(Observer observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			
		}
	}

	@Override
	public void leaveMarket(TraderObserver traderObserver) {
		
	}
	
}
