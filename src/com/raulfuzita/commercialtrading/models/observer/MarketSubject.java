package com.raulfuzita.commercialtrading.models.observer;

public interface MarketSubject extends Subject {
	
	public void leaveMarket(TraderObserver traderObserver);
}
