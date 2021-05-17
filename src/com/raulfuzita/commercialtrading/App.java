package com.raulfuzita.commercialtrading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.raulfuzita.commercialtrading.models.company.CCTCompany;
import com.raulfuzita.commercialtrading.models.depot.DepotTrader;
import com.raulfuzita.commercialtrading.models.factories.CCTCompanyDepots50Factory;
import com.raulfuzita.commercialtrading.models.factories.ProductPrice1To10;
import com.raulfuzita.commercialtrading.models.trademarket.TradeMarket;
import com.raulfuzita.commercialtrading.models.trademarket.TradeMarketFacade;
import com.raulfuzita.commercialtrading.models.trademarket.records.Recordable;
import com.raulfuzita.commercialtrading.view.MainMenuView;

/**
 * @author raul macedo fuzita
 */
public class App {
	
	public App() {
		
		System.out.println("************************ CCT CA2 THIRD YEAR **************************");
		System.out.println("Author: Raul Macedo Fuzita					 ");
		System.out.println("Github: https://github.com/raulFuzita/CCTCommercialTrading/tree/master");
		System.out.println("Date: 17-05-21");
		System.out.println("\nRunning app...");
		
		TradeMarket<DepotTrader> tk = new TradeMarket<>();
		ProductPrice1To10 pp1To10 = new ProductPrice1To10();
		CCTCompanyDepots50Factory factory = new CCTCompanyDepots50Factory(tk, pp1To10);
		List<CCTCompany> companies = factory.makeMany(3);
		
		TradeMarketFacade marketFacade = new TradeMarketFacade();
		
		try {
			List<Future<Recordable>> allRecords = marketFacade.bootstrap(tk);
			MainMenuView mainMenu = new MainMenuView(allRecords, companies);
			while(true) {
				if (mainMenu.selectMenu().equalsIgnoreCase("X"))
					break;
			}
			System.out.println("\nBye bye :D");
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new App();
	}
}
