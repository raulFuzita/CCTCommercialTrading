package com.raulfuzita.commercialtrading.models.trades;

import java.util.concurrent.Callable;

import com.raulfuzita.commercialtrading.models.companies.Company;
import com.raulfuzita.commercialtrading.models.products.Product;

public interface Trader extends Callable {

	public void setMarket(TradeMarket tradeMarket);
	public TradeMarket getMarket();
	public boolean isProductAvailable();
	public int nativeStockSize();
	public int externalStockSize();
	public Product peekProduct(int id);
	public Product sellProduct(int id);
	public void buyProduct(Product product, long companyId);
	public Company getCompany();
	public long pay(long price);
	public void recieve(long money);
}
