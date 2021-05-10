package com.raulfuzita.commercialtrading.models.factories.company;

import com.raulfuzita.commercialtrading.models.companies.Company;

public abstract class CompanyFactory {

	public Company make() {
		return createCompany();
	}

	protected abstract Company createCompany();
}
