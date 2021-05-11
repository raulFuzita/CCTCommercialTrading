package com.raulfuzita.commercialtrading.models.companies;

<<<<<<< HEAD
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
=======
import com.raulfuzita.commercialtrading.util.SerialGenerator;

public abstract class Company {

	private final long id;
	
	public Company() {
		this.id = SerialGenerator.generateSerial();
	}

	public Company(long id) {
		this.id = id;
>>>>>>> ef7341563cede4dba6a7bd3b1b0088ef4d1a29b9
	}

	public long getId() {
		return id;
	}

<<<<<<< HEAD
	public List<Depot> getDepots() {
		if (depots == null)
			return Collections.emptyList();
		return depots;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", depots=" + depots + "]";
=======
	@Override
	public String toString() {
		return "Company [id=" + id + "]";
>>>>>>> ef7341563cede4dba6a7bd3b1b0088ef4d1a29b9
	}
}
