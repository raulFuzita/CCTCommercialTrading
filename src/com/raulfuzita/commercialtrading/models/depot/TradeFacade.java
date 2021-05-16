package com.raulfuzita.commercialtrading.models.depot;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.trademarket.Market;
import com.raulfuzita.commercialtrading.models.trademarket.Recordable;

public class TradeFacade {

	public Recordable trade(Depot buyer, Market<DepotTrader> market) {
		List<DepotTrader> sellers = market.getTraders();
		int i1 = ThreadLocalRandom.current().nextInt(0, sellers.size());
		DepotTrader seller = sellers.get(i1);
		if (isValidTrade(buyer, seller)) {
			long companyId = seller.get().getCompanyId();
			int i2 = ThreadLocalRandom.current().nextInt(0, seller.get().stockSize());
			Product product = seller.get().peek(i2);
			if (buyer.withdrawCashe(product.getCost())) {
				
				Recordable record = new TradeRecord(
						buyer.getId(),
						seller.get().getId(),
						product);
				
				seller.get().depositCashe(product.getCost());
				buyer.buy(companyId, seller.get().sell(i2));
				return record;
			}
		}
		
		return null;
	}
	
	public boolean isValidTrade(Depot buyer, DepotTrader seller) {
		return seller.get().stockSize() > 14 
				&& seller.get().stockSize() < 51
				&& buyer.foreignStockSize() < 41;
	}
}
