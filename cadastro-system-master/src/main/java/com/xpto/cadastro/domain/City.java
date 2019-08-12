package com.xpto.cadastro.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_CITY")
public class City implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6674075437575331978L;

	@Id
	@Column(name="ID_IBGE")
	private String idIbge;
	
	@Column(name="DS_NAME")
	private String name;
	
	@Column(name="BL_CAPITAL")
	private Boolean capital;
	
	@Column(name="DS_ALTERANTIVE_NAME")
	private String alternativeName;
	
	@Column(name="DS_NO_ACCENTS")
	private String noAccents;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DS_NAME_MICROREGION",referencedColumnName="MICRO_ID")
	private Microregion microregion;
	
	@Column(name="DS_LONGITUDE")
	private String longitude;
	@Column(name="DS_LATITUDE")
	private String latitude;
	
	
	public String getIdIbge() {
		return idIbge;
	}
	public void setIdIbge(String id_ibge) {
		this.idIbge = id_ibge;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getCapital() {
		return capital;
	}
	public void setCapital(Boolean capital) {
		this.capital = capital;
	}
	public String getAlternativeName() {
		return alternativeName;
	}
	public void setAlternativeName(String alternativeName) {
		this.alternativeName = alternativeName;
	}

	public Microregion getMicroregion() {
		return microregion;
	}
	public void setMicroregion(Microregion microregion) {
		this.microregion = microregion;
	}

	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getlatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getNoAccents() {
		return noAccents;
	}
	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idIbge == null) ? 0 : idIbge.hashCode());
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
		City other = (City) obj;
		if (idIbge == null) {
			if (other.idIbge != null)
				return false;
		} else if (!idIbge.equals(other.idIbge))
			return false;
		return true;
	}
}
