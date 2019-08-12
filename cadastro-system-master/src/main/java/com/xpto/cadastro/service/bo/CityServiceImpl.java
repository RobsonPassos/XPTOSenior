package com.xpto.cadastro.service.bo;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpto.cadastro.domain.City;
import com.xpto.cadastro.service.repository.CityRepository;
import com.xpto.cadastro.util.UtilXptoCadastro;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired private CityRepository cityRepository;
	private CSVParser parser;
	
	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}
	
	@Override
	public void save(Reader reader) throws IOException {
		parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
		for (CSVRecord record : parser) {
			City city = UtilXptoCadastro.lineCsvOfCity(record);
			save(city);	
		}
	}

	@Override
	public List<Object> searchByColumn(String column, String key,boolean count) {
		return cityRepository.buscar(column, key,count);
	}
	
	@Override
	public int buscaQntColuna(String column, boolean count) {
		return cityRepository.bucarqnt(column, count);
	}
}
