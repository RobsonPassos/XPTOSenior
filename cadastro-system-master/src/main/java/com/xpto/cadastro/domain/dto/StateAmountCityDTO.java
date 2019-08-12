package com.xpto.cadastro.domain.dto;

import java.io.Serializable;

import com.xpto.cadastro.domain.State;

public class StateAmountCityDTO implements Serializable {
	
	
	private static final long serialVersionUID = 5349040089967525167L;
	private State state;
	private Long numberOfCities;

	public StateAmountCityDTO(State state, Long numberOfCities) {
		super();
		this.state = state;
		this.numberOfCities = numberOfCities;
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	
	
	public Long getNumberOfCities() {
		return numberOfCities;
	}

	public void setNumberOfCities(Long numberOfCities) {
		this.numberOfCities = numberOfCities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numberOfCities == null) ? 0 : numberOfCities.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateAmountCityDTO other = (StateAmountCityDTO) obj;
		if (numberOfCities == null) {
			if (other.numberOfCities != null)
				return false;
		} else if (!numberOfCities.equals(other.numberOfCities))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	
	
}
