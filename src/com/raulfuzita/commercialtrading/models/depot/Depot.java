package com.raulfuzita.commercialtrading.models.depot;

<<<<<<< HEAD
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongUnaryOperator;

import com.raulfuzita.commercialtrading.models.companies.Company;
=======
>>>>>>> fresh
import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.stocks.Stock;

/***
 * Class Depot extends Warehouse abstract class and has more features
 * than its abstraction.
 * 
 * @author raul macedo fuzita
 *
 */
public class Depot extends Warehouse {
	
<<<<<<< HEAD
	private final Company company;
	private AtomicLong balance;
=======
	private final long companyId;
>>>>>>> fresh

	/***
	 * Inner class.
	 * @author raul macedo fuzita
	 */
	public static class Builder extends Warehouse.Builder<Builder> {
		
<<<<<<< HEAD
		private Company company;
		private AtomicLong balance;
=======
		private final long companyId;
>>>>>>> fresh
		
		/***
		 * This constructor expects a company ID which 
		 * comes from a Company class.
		 * 
		 * @param companyId is a type long.
		 */
		public Builder(long companyId) {
			this.companyId 		= companyId;
		}
		
		public Builder company(Company company) {
			this.company = company;
			return this;
		}

		@Override
		public Depot build() {
			return new Depot(this);
		}

		@Override
		public Builder self() {
			return this;
		}
		
	}
	
<<<<<<< HEAD
	protected Depot(Builder builder) {
		super(builder);
		balance			= builder.balance;
		company			= builder.company;
	}
	
	public Company getCompany() {
		return company;
	}

	public long getBalance() {
		return this.balance.get();
=======
	/***
	 * This constructor requires a builder.
	 * @param builder is a Builder object.
	 */
	protected Depot(Builder builder) {
		super(builder);
		companyId		= builder.companyId;
>>>>>>> fresh
	}
	
	/***
	 * This method returns a company's ID.
	 * @return a company's ID that is type long.
	 */
	public long getCompanyId() {
		return companyId;
	}
	
	/***
	 * This method returns a Product of the Depot.
	 * @param id is a type int
	 * @return a Product interface
	 */
	public Product peek(int id) {
		return this.getStocks().peek(id);
	}
	
	/***
	 * This method requires in index to push a Product from
	 * the native stock to sell it.
	 * @param id is a type int
	 * @return a Product interface
	 */
	public Product sell(int id) {
		return this.getStocks().push(id);
	}
	
	/***
	 * This method will check automatically rather a company stock
	 * is register in the Depot foreign stock. If a foreign stock exist
	 * the product is just added.
	 * 
	 * @param companyId is Long object.
	 * @param product is a Product interface.
	 */
	public void buy(Long companyId, Product product) {
		this.getForeignStocks().putIfAbsent(companyId, new Stock());
		this.getForeignStocks().get(companyId).pull(product);
	}
	
	/***
	 * This method returns the native stock size
	 * @return int
	 */
	public int stockSize() {
		return this.getStocks().size();
	}
	
	/***
	 * This method returns the foreign stock size
	 * @return int
	 */
	public int foreignStockSize() {
		return this.getForeignStocks().size();
	}

	@Override
	public String toString() {
		return "Depot [companyId=" + companyId + ", nativeStock=" + getStocks() 
				+ ", externalStock=" + getForeignStocks() 
				+ ", balance=" + getBalance() + "]";
	}
	
}
