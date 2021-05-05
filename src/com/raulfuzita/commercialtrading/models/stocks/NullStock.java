package com.raulfuzita.commercialtrading.models.stocks;

public class NullStock extends Stock {

	@Override
	public String toString() {
		return "NullStock [size()=" + size() + ", toString()=" + super.toString() 
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
