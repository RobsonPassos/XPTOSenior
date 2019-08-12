package com.xpto.cadastro.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_STATE")
public class State implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 305230953398234394L;
	
	@Id
	@GeneratedValue
	@Column(name="UF_ID")
	private String uf_id;

	@Column(name="DS_UF")
	private String uf;
	@Column(name="DS_NAME")
	private String name;
	
	@OneToMany(mappedBy="state", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Mesoregion> mesoregions;

	
	
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	public String getUf_id() {
		return uf_id;
	}
	public void setUf_id(String uf_id) {
		this.uf_id = uf_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Mesoregion> getMesoregions() {
		return mesoregions;
	}
	public void setMesoregions(List<Mesoregion> mesoregions) {
		this.mesoregions = mesoregions;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		State other = (State) obj;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
	
	
	
	
}
