package com.xpto.cadastro.domain.dto;

import java.io.Serializable;

public class CityNameDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6319382239948008217L;
	private String name;

	
	public CityNameDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
