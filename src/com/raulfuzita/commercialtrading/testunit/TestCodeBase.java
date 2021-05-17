package com.raulfuzita.commercialtrading.testunit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

	
	@Test
	void testDecorator() {
		Recordable p = new PlainRecord();
		p = new Record(p);
		p = new Record(p);
		System.out.println(p.getRecord());
		
	}
	
	interface Recordable {
		String getRecord();
	}
	
	class PlainRecord implements Recordable {
		@Override public String getRecord() {
			return "Plain\n";
		}
	}
	
	class Record implements Recordable {
		private Recordable plain;
		public Record(Recordable plain) {
			this.plain = plain;
		}
		@Override public String getRecord() {
			return "Record\n" + plain.getRecord();
		}
		
	}
}
