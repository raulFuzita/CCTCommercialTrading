package com.raulfuzita.commercialtrading.testunit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.raulfuzita.commercialtrading.models.depot.Depot;

class TestDepot {

	@Test
	void balanceOperationsNoThread() {
		Depot d = new Depot.Builder(100).build();
		System.out.println("Depot balance: " + d.getBalance());
		d.withdrawCashe(50);
		d.depositCashe(30);
		long balance = d.getBalance();
		assertTrue("Balance is not as expected: " + balance, 80 == balance);
	}
	
	@Test
	void balanceOperationsWithThread() throws InterruptedException, ExecutionException {
		
		long initBalance = 200;
		int stopAt = 200;
		
		Depot d = new Depot.Builder(initBalance).build();
		
		ExecutorService es = Executors.newFixedThreadPool(5);
		Set<Callable<Integer>> callables = new HashSet<>();
		
		callables.add(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int i = 0;
				while (i < stopAt) {
					d.depositCashe(1);
					i++;
				} return i;
			}
		});
		
		callables.add(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int i = 0;
				while (i < stopAt) {
					d.depositCashe(1);
					i++;
				} return i;
			}
		});
		
		callables.add(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int i = 0;
				while (i < stopAt) {
					d.withdrawCashe(1);
					i++;
				} return -i;
			}
		});
		
		List<Future<Integer>> results = es.invokeAll(callables);
		
		es.shutdown();
		System.out.println("Thread has finished: " + es.isShutdown());
		es = null;
		
		long balance = d.getBalance();
		long totalLoop = initBalance;
		
		for (Future<Integer> future : results) {
			System.out.println("Theread: " + future.get());
			totalLoop += future.get();
		}
		
		System.out.format("Initial Balance: %d%nTotal Balance: %d%nBalance: %d%n", 
				initBalance, totalLoop, balance);
		
		assertTrue(balance == totalLoop);
	}

}
