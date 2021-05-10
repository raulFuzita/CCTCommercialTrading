package com.raulfuzita.commercialtrading.testunit;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.Test;

class TestCodeBase {

	@Test
	void test() {
		
		List<String> names = new CopyOnWriteArrayList<>();
		names.add("John");
		names.add("Peter");
		names.add("Jack");
		
		String name = names.get(0);
		
		System.out.println("Remove a name: " + names.remove(name));
		
		for (String string : names)
			System.out.println(string);
	}

}
