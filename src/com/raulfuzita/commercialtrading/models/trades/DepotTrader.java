package com.raulfuzita.commercialtrading.models.trades;

import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.products.Product;

public class DepotTrader extends Depot implements Trader {

	private TradeMarket tradeMarket;
	
	public DepotTrader(Builder builder) {
		super(builder);
	}
	
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMarket(TradeMarket tradeMarket) {
		this.tradeMarket = tradeMarket;
	}

	@Override
	public TradeMarket getMarket() {
		return this.tradeMarket;
	}

	@Override
	public boolean isProductAvailable() {
		int size = this.stockSize();
		return size > 14 && size < 51;
	}

	@Override
	public Product sellProduct(int id) {
		return this.sell(id);
	}

	@Override
	public void buyProduct(Product product, long companyId) {
		this.buy(companyId, product);
	}

	@Override
	public long pay(long price) {
		this.withdrawCashe(price);
		return price;
	}

	@Override
	public void recieve(long money) {
		this.depositCashe(money);
	}

	@Override
	public int nativeStockSize() {
		return this.stockSize();
	}

	@Override
	public int externalStockSize() {
		return this.foreignStockSize();
	}

	@Override
	public Product peekProduct(int id) {
		return this.getStocks().peek(id);
	}

}
