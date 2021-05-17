package com.raulfuzita.commercialtrading.models.factories;

import java.util.List;

public interface Factory<T> {
	T makeOne();
	List<T> makeMany(int units);
}
