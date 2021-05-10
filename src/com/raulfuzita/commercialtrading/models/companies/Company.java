package com.raulfuzita.commercialtrading.models.companies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.raulfuzita.commercialtrading.models.depot.Depot;
import com.raulfuzita.commercialtrading.util.SerialGenerator;

public final class Company {

	private final long id;
	private final List<Depot> depots;
	
	public static class Builder {
		
		private long id;
		private List<Depot> depots;
		
		public Builder() {
			id = SerialGenerator.generateSerial();
		}
		
		public Builder id(long id) {
			this.id = id;
			return this;
		}
		
		public Builder depots(List<Depot> depots) {
			this.depots = Collections.synchronizedList(new ArrayList<>(depots));
			return this;
		}
		
		public Company build() {
			return new Company(this);
		}
	}
	
	private Company(Builder builder) {
		id 			= builder.id;
		depots		= builder.depots;
	}

	public long getId() {
		return id;
	}

	public List<Depot> getDepots() {
		if (depots == null)
			return Collections.emptyList();
		return depots;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", depots=" + depots + "]";
	}
}
