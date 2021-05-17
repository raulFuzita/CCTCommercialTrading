package com.raulfuzita.commercialtrading.models.factories;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.raulfuzita.commercialtrading.models.company.CCTCompany;
import com.raulfuzita.commercialtrading.models.depot.DepotTrader;
import com.raulfuzita.commercialtrading.models.products.Product;
import com.raulfuzita.commercialtrading.models.trademarket.Market;

public class CCTCompanyDepots50Factory extends AbstractFactory<CCTCompany> {

	private static AtomicInteger code = new AtomicInteger(65);
	
	Market<DepotTrader> market;
	Factory<Product> factory;
	
	public CCTCompanyDepots50Factory(Market<DepotTrader> market, Factory<Product> factory) {
		this.market = market;
		this.factory = factory;
	}

	@Override
	protected CCTCompany create() {
		
		CCTCompany company = new CCTCompany(createName());
		Factory<DepotTrader> traderFactory 
					= new DepotBalance50To100(company.getId(), market, factory);
		List<DepotTrader> traders = traderFactory.makeMany(50);
		company.setDepots(traders);
		return company;
	}
	
	private String createName() {
		char ascii = (char) code.get();
		code.incrementAndGet();
		return String.valueOf(ascii);
	}

}
