package com.raulfuzita.commercialtrading.models.trademarket;

import java.util.List;

public interface Market<E> {

	List<E> getTraders();
	void setTraders(List<E> traders);
	void register(E trader);
	void unregister(E trader);
}
