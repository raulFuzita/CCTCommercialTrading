package com.raulfuzita.commercialtrading.models.trademarket;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.products.Product;

public class TradeFacade {

	public TradeRecord trade(Depot buyer, List<Depot> sellers) {
		int i1 = ThreadLocalRandom.current().nextInt(0, sellers.size());
		Depot seller = sellers.get(i1);
		if (isValidTrade(buyer, seller)) {
			long companyId = seller.getCompanyId();
			int i2 = ThreadLocalRandom.current().nextInt(0, seller.stockSize());
			Product product = seller.peek(i2);
			if (buyer.withdrawCashe(product.getCost())) {
				
				TradeRecord record = new TradeRecord(
						buyer.getId(), 
						seller.getId(), 
						product);
				
				seller.depositCashe(product.getCost());
				buyer.buy(companyId, seller.sell(i2));
				return record;
			}
		}
		return null;
	}
	
	public boolean isValidTrade(Depot buyer, Depot seller) {
		return seller.stockSize() > 14 
				&& seller.stockSize() < 51
				&& buyer.foreignStockSize() < 41;
	}
}
