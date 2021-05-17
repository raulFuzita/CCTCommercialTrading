package com.raulfuzita.commercialtrading.models.depot;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.trademarket.Market;
import com.raulfuzita.commercialtrading.models.trademarket.records.Recordable;

public class TradeFacade {
	
	protected Recordable record;
	
	public TradeFacade(Recordable record) {
		this.record = record;
	}

	public Recordable trade(DepotTrader trader, Market<DepotTrader> market) {
		Depot buyer = trader.get();
		List<DepotTrader> sellers = market.getTraders();
		int i1 = ThreadLocalRandom.current().nextInt(0, sellers.size());
		DepotTrader seller = sellers.get(i1);
		
		if (!sellerHasProduct(seller)) {
			market.unregister(seller);
			return this.record;
		}
		
		if (buyerHasSpace(buyer)) {
			long companyId = seller.get().getCompanyId();
			int i2 = ThreadLocalRandom.current().nextInt(0, seller.get().stockSize());
			Product product = seller.get().peek(i2);
			if (buyer.withdrawCashe(product.getCost())) {
				
				TradeRecord newRecord = new TradeRecord(record);
				newRecord.setRecord(buyer,seller.get(),product);
				
				seller.get().depositCashe(product.getCost());
				buyer.buy(companyId, seller.get().sell(i2));
				return newRecord;
			}
		}
		
		market.unregister(trader);
		return this.record;
	}
	
	public boolean sellerHasProduct(DepotTrader seller) {
		return seller.get().stockSize() > 14 
				&& seller.get().stockSize() < 51;
	}
	
	public boolean buyerHasSpace(Depot buyer) {
		return buyer.foreignStockSize() < 40;
	}
}
