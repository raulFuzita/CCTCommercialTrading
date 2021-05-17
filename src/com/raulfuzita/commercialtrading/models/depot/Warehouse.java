package com.raulfuzita.commercialtrading.models.depot;

<<<<<<< HEAD
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

=======
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
>>>>>>> fresh
import com.raulfuzita.commercialtrading.models.stocks.NullStock;
import com.raulfuzita.commercialtrading.models.stocks.Stock;

/***
 * Class Warehouse cannot be instantiated since it is an abstract class.
 * Warehouse implements a Builder Pattern and is Thread-safe.
 * This class can hold many parameter in the constructor
 * 
 * @author raul macedo fuzita
 *
 */
public abstract class Warehouse {
	
	private final long id;
	private Stock stocks;
<<<<<<< HEAD
	private ConcurrentMap<Long, Stock> foreignStocks;
=======
	private Map<Long, Stock> foreignStocks;
	private AtomicLong balance;
>>>>>>> fresh
	
	/**
	 * Builder is an inner class that sets Warehouse default values for
	 * some attributes.
	 * 
	 * @author raul macedo fuzita
	 *
	 * @param <T> Generic type
	 */
	public abstract static class Builder<T extends Builder<T>> {
		
		private Stock stocks;
		private Map<Long, Stock> foreignStocks;
		private AtomicLong balance;
		
<<<<<<< HEAD
		Stock stocks;
		ConcurrentMap<Long, Stock> foreignStocks;
=======
		public Builder() {
			this.foreignStocks 	= new ConcurrentHashMap<>();
			this.balance 		= new AtomicLong(0);
		}
>>>>>>> fresh
		
		/***
		 * This method is a fluent interface. It sets the 
		 * stock attribute.
		 * 
		 * @param stocks is a Stock object
		 * @return a generic type
		 */
		public T stocks(Stock stocks) {
			this.stocks = stocks;
			return self();
		}
		
		/***
		 * This method is a fluent interface. It sets the 
		 * balance attribute.
		 * 
		 * @param balance is a long type
		 * @return a generic type.
		 */
		public T balance(long balance) {
			this.balance = new AtomicLong(balance);
			return self();
		}
		
		/***
		 * This method builds a concrete object.
		 * @return a Warehouse object
		 */
		abstract Warehouse build();
		
		/***
		 * This method returns the class itself.
		 * @return a generic of Builder.
		 */
		protected abstract T self();
	}

	/***
	 * This is the Warehouse constructor
	 * @param builder is a type of Builder inner class.
	 */
	protected Warehouse(Builder<?> builder) {
		stocks				= builder.stocks;
		foreignStocks		= builder.foreignStocks;
		balance				= builder.balance;
		id					= SerialGenerator.generateSerial();
	}
	
	/***
	 * This method returns the instance ID.
	 * @return an ID type long
	 */
	public long getId() {
		return id;
	}

	/***
	 * This method returns an instance stock. If no stock was set
	 * it will return an empty stock type NullStock object.
	 * This method implements NullObject Pattern.
	 * 
	 * @return a Stock object if exist or a NullStock.
	 */
	public Stock getStocks() {
		Optional<Stock> optional = Optional.ofNullable(stocks);
		return optional.orElse(new NullStock());
	}

	/***
	 * This method returns all foreign stocks
	 * @return a Map<Long, Stock>.
	 */
	public Map<Long, Stock> getForeignStocks() {
<<<<<<< HEAD
		return foreignStocks != null ? foreignStocks : Collections.emptyMap();
	}
	
=======
		return foreignStocks;
	}

	/***
	 * This method sets a whole Map. It has a ConcurrentHashMap internally for
	 * Thread-safe.
	 * @param foreignStocks is a Map<Long, Stock> type.
	 */
>>>>>>> fresh
	public void setForeignStocks(Map<Long, Stock> foreignStocks) {
		this.foreignStocks = new ConcurrentHashMap<>(foreignStocks);
	}
	
<<<<<<< HEAD
	public boolean addForeignStocks(long companyId, Stock stock) {
		Stock result = this.foreignStocks.putIfAbsent(companyId, stock);
		return result == null;
	}
	
	public boolean addForeignStocks(long companyId, Stock stock) {
		Stock result = this.foreignStocks.putIfAbsent(companyId, stock);
		return result == null;
=======
	/***
	 * This method returns the balance of an instance.
	 * @return a balance type long
	 */
	public long getBalance() {
		return this.balance.get();
	}
	
	/***
	 * This method sets a balance and it is Thread-safe.
	 * @param cashe is a type long
	 */
	public void depositCashe(long cash) {
		balance.getAndAdd(cash);
	}
	
	/***
	 * This method withdraw cash and retrn a boolean.
	 * @param cashe is a type long
	 * @return true if cash was withdrawn. Otherwise false.
	 */
	public boolean withdrawCash(long cash) {
		if (cash <= balance.get()) {
			balance.getAndUpdate(b -> b - cash);
			return true;
		}
		return false;
>>>>>>> fresh
	}

	@Override
	public String toString() {
		return "Warehouse [stocks=" + stocks + ", foreignStocks=" + foreignStocks 
				+ ", balance=" + balance + "]";
	}
}
