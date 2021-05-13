package com.raulfuzita.commercialtrading.testunit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.Test;

class TestCodeBase {

	@Test
	void testArrayThreadSafeAndClone() throws CloneNotSupportedException {
		List<TestName> l = new CopyOnWriteArrayList<>();
		l.add(new TestName("John"));
		
		TestName test = (TestName) l.get(0).clone();
		test.name = "Jack";
		
		for (TestName testName : l) {
			System.out.println(testName.name);
		}
		
		assertFalse(test.name.equals(l.get(0).name));
	}
	
	class TestName implements Cloneable {
		String name;
		public TestName(String name) {
			this.name = name;
		}
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}

}