package com.xpto.cadastro.service.bo;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.xpto.cadastro.domain.City;

public interface CityService {
	City save(City city);
	void save(Reader reader) throws IOException;
	List<Object> searchByColumn(String column, String key, boolean count);
	int buscaQntColuna(String column, boolean count);
}
