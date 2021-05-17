package com.raulfuzita.commercialtrading.models.factories;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raul macedo fuzita
 */
public abstract class AbstractFactory<T> implements Factory<T> {

	@Override
	public T makeOne() {
		return create();
	}

	@Override
	public List<T> makeMany(int units) {
		List<T> list = new ArrayList<>();
		for (int i = 0; i < units; i++)
			list.add(create());
		return list;
	}

	protected abstract T create();
}
