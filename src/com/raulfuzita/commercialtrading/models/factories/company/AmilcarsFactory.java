package com.raulfuzita.commercialtrading.models.factories.company;

import java.util.List;

import com.raulfuzita.commercialtrading.models.companies.Company;
import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.models.factories.depot.DepotFactory;
import com.raulfuzita.commercialtrading.models.factories.depot.DepotProduct15To50;
import com.raulfuzita.commercialtrading.models.factories.product.ProductFactory;
import com.raulfuzita.commercialtrading.models.factories.product.ProductPrice1To10;

public class AmilcarsFactory extends CompanyFactory {

	@Override
	protected Company createCompany() {
		DepotFactory depotFactory = new DepotProduct15To50();
		ProductFactory productFactory = new ProductPrice1To10();
		depotFactory.setProductFactory(productFactory);
		List<Depot> depots = depotFactory.makeMany(50);
		return new Company.Builder().depots(depots).build();
	}

}
