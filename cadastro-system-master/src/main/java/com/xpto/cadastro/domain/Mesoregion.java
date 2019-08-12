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
@Table(name="TB_MESOREGION")
public class Mesoregion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4121588261734421019L;
	

	@Id
	@GeneratedValue
	@Column(name="MESO_ID")
	private String meso_id;

	@Column(name="DS_NAME")
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="UF_ID",referencedColumnName="UF_ID")
	private State state;
	
	@OneToMany(mappedBy="mesoregion", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Microregion> microregions;

	public String getMeso_id() {
		return meso_id;
	}

	public void setMeso_id(String meso_id) {
		this.meso_id = meso_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Microregion> getMicroregions() {
		return microregions;
	}

	public void setMicroregions(List<Microregion> microregions) {
		this.microregions = microregions;
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
		Mesoregion other = (Mesoregion) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
