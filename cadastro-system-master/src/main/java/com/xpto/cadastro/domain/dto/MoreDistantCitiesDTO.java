package com.xpto.cadastro.domain.dto;

import java.io.Serializable;

import com.xpto.cadastro.domain.City;

public class MoreDistantCitiesDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7857461886224717753L;
	private City cityA;
	private City cityB;
	private double distant;
	public City getCityA() {
		return cityA;
	}
	public void setCityA(City cityA) {
		this.cityA = cityA;
	}
	public City getCityB() {
		return cityB;
	}
	public void setCityB(City cityB) {
		this.cityB = cityB;
	}
	public double getDistant() {
		return distant;
	}
	public void setDistant(double distant) {
		this.distant = distant;
	}
	public MoreDistantCitiesDTO(City cityA, City cityB, double distant) {
		super();
		this.cityA = cityA;
		this.cityB = cityB;
		this.distant = distant;
	}
	
	
}
