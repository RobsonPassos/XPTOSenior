package com.xpto.cadastro.service.repository.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.xpto.cadastro.util.ColumnArq;


public class CityRepositoryImpl implements CityRepositoryDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> buscar(String column, String key,boolean count) {
		StringBuilder hqlSelect = new StringBuilder(" Select ");
		StringBuilder hqlFrom = new StringBuilder(" From City c ");
		StringBuilder hqlWhere = new StringBuilder(" Where ");
		
		switch (ColumnArq.valueOf(column)) {
		case ibge_id:
			hqlSelect.append("c");
			hqlWhere.append("c.idIbge");
			break;
		case alternative_names:
			hqlSelect.append("c");
			hqlWhere.append("c.alternativeName ");
			break;
		case mesoregion:
			hqlSelect.append("c.microregion.mesoregion");
			hqlWhere.append("c.microregion.mesoregion.name ");
			break;
		case microregion:
			hqlSelect.append("c.microregion");
			hqlWhere.append("c.microregion like ");
			break;
		case no_accents:
			hqlSelect.append("c");
			hqlWhere.append("c.noAccents like");
			break;
		case name:
			hqlSelect.append("c");
			hqlWhere.append("c.name like");
			break;
		case uf:
			hqlSelect.append("c.microregion.mesoregion.state");
			hqlWhere.append("c.microregion.mesoregion.state.uf ");
			break;
		case lat:
			hqlSelect.append("c.latitude");
			hqlWhere.append("c.latitude ");
			break;
		case lon:
			hqlSelect.append("c.longitude");
			hqlWhere.append("c.longitude ");
			break;
		default:
			break;
		}
		if (!count) {
			hqlWhere.append(" like :key");
		}else {
			hqlWhere.append(" is not null");
		}
		hqlSelect.append(hqlFrom);
		hqlSelect.append(hqlWhere);
		
		Query query = entityManager.createQuery(hqlSelect.toString());
		if (!count) {
			query.setParameter("key", "%"+key+"%" );
		}
		return query.getResultList();
	}

	@Override
	public int bucarqnt(String column, boolean count) {
		StringBuilder hqlSelect = new StringBuilder(" Select distinct( ");
		StringBuilder hqlFrom = new StringBuilder(" From City c ");
//		StringBuilder hqlWhere = new StringBuilder(" Where ");
		
		switch (ColumnArq.valueOf(column)) {
		case ibge_id:
			hqlSelect.append("c.idIbge");
			break;
		case alternative_names:
			hqlSelect.append("c.alternativeName ");
			break;
		case mesoregion:
			hqlSelect.append("c.microregion.mesoregion.name ");
			break;
		case microregion:
			hqlSelect.append("c.microregion.name ");
			break;
		case no_accents:
			hqlSelect.append("c.noAccents ");
			break;
		case name:
			hqlSelect.append("c.name ");
			break;
		case uf:
			hqlSelect.append("c.microregion.mesoregion.state.uf ");
			break;
		case lat:
			hqlSelect.append("c.latitude ");
			break;
		case lon:
			hqlSelect.append("c.longitude ");
			break;
		default:
			break;
		}
//		hqlWhere.append(" is not null");
		hqlSelect.append(" ) " + hqlFrom);
//		hqlSelect.append(hqlWhere);
		
		Query query = entityManager.createQuery(hqlSelect.toString());
		
		return query.getResultList().size();
	}
	
}
