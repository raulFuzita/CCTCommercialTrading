package com.raulfuzita.commercialtrading.models.facades;

import java.util.concurrent.ThreadLocalRandom;

import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.trades.Trader;

public class TradeFacade {

	public boolean trade(Trader buyer, Trader trader) {
		if (isValidTrade(buyer, trader)) {
			
			int size = trader.nativeStockSize();
			int id = ThreadLocalRandom.current().nextInt(0, size);
			
			long companyId = trader.getCompany().getId();
			Product product = trader.sellProduct(id);
			long price = (long) product.getPrice();
			
			trader.recieve(buyer.pay(price));
			buyer.buyProduct(product, companyId);
			return true;
		}
		return false;
	}
	
	protected boolean isValidTrade(Trader buyer, Trader trader) {
		return buyer.getCompany() != trader.getCompany() && trader.isProductAvailable();
	}
}
