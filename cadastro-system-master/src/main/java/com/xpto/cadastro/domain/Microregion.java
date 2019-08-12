package com.xpto.cadastro.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_MICROREGION")
public class Microregion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -992258664791237384L;
	
	@Id
	@GeneratedValue
	@Column(name="MICRO_ID")
	private String micro_id;
	
	@Column(name="DS_NAME")
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DS_NAME_MESOREGION",referencedColumnName="MESO_ID")
	private Mesoregion mesoregion;
	
	@OneToMany(mappedBy="microregion", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<City> cities;

	public String getMicro_id() {
		return micro_id;
	}

	public void setMicro_id(String micro_id) {
		this.micro_id = micro_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mesoregion getMesoregion() {
		return mesoregion;
	}

	public void setMesoregion(Mesoregion mesoregion) {
		this.mesoregion = mesoregion;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Microregion other = (Microregion) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}
