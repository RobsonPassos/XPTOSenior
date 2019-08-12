package com.xpto.cadastro.service.repository.dao;

import java.util.List;

public interface CityRepositoryDAO {
	List<Object> buscar(String column,String key, boolean count);
	int bucarqnt(String column, boolean count);
}
