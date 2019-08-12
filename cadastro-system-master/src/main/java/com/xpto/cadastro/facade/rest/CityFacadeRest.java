package com.xpto.cadastro.facade.rest;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.apache.commons.io.input.BOMInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xpto.cadastro.domain.City;
import com.xpto.cadastro.domain.dto.MoreDistantCitiesDTO;
import com.xpto.cadastro.domain.dto.StateAmountCityDTO;
import com.xpto.cadastro.facade.CityFacade;
import com.xpto.cadastro.facade.rest.exception.CadastroApplicationException;
import com.xpto.cadastro.service.bo.CityService;
import com.xpto.cadastro.service.repository.CityRepository;
import com.xpto.cadastro.util.UtilXptoCadastro;

@RestController
public class CityFacadeRest implements CityFacade {

	@Autowired private CityService cityService;
	@Autowired private CityRepository cityRepository;
	
	@GetMapping(path="/teste")
	public ResponseEntity<?> teste() {
		return new ResponseEntity<>(cityRepository.retrieveStateAmountCityAsDTO(), HttpStatus.OK);
	}

	@Override
	@PostMapping(path= "/importa",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> importCsv(@RequestParam("uploadfile") MultipartFile uploadfile) throws CadastroApplicationException {
		
	try {
			final Reader reader = new InputStreamReader(new BOMInputStream(uploadfile.getInputStream()), "UTF-8");
			cityService.save(reader);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CadastroApplicationException(e.getMessage());
		}
	}

	@Override
	@GetMapping(path="/capitais")
	public ResponseEntity<?> capitalCities() {
		City city = new City();
		city.setCapital(Boolean.TRUE);
		return  new ResponseEntity<>(cityRepository.findAll(Example.of(city)), HttpStatus.OK);
	}

	@Override
	@GetMapping(path="/estadocommaiscidades")
	public ResponseEntity<?> estadoComMaisQntCidade() {
		List<StateAmountCityDTO> listStateCount = cityRepository.retrieveStateAmountCityAsDTO();
		Collections.sort(listStateCount, (s1,s2) -> s1.getNumberOfCities().compareTo(s2.getNumberOfCities()));
		return  new ResponseEntity<> (listStateCount.get(listStateCount.size() -1) , HttpStatus.OK);
	}

	@Override
	@GetMapping(path="/estadocommenoscidades")
	public ResponseEntity<?> estadoComMenosQntCidade() {
		List<StateAmountCityDTO> listStateCount = cityRepository.retrieveStateAmountCityAsDTO();
		Collections.sort(listStateCount, (s1,s2) -> s1.getNumberOfCities().compareTo(s2.getNumberOfCities()));
		return  new ResponseEntity<> (listStateCount.get(0) , HttpStatus.OK);
	}
	@Override
	@GetMapping(path="/estadocommaisemenoscidadeesuaqnt")
	public ResponseEntity<?> estadoComMaisEMenosQntCidade() {
		List<StateAmountCityDTO> listStateCount = cityRepository.retrieveStateAmountCityAsDTO();
		Collections.sort(listStateCount, (s1,s2) -> s1.getNumberOfCities().compareTo(s2.getNumberOfCities()));
		List<StateAmountCityDTO> result = new ArrayList<>();
		result.add(listStateCount.get(0));
		result.add(listStateCount.get(listStateCount.size() -1));
		return  new ResponseEntity<> (result , HttpStatus.OK);
	}

	@Override
	@GetMapping(path="/qntcidadesporestado")
	public ResponseEntity<?> qntDeCidadePorEstado() {
		List<StateAmountCityDTO> listStateCount = cityRepository.retrieveStateAmountCityAsDTO();
		Collections.sort(listStateCount, (s1,s2) -> s1.getNumberOfCities().compareTo(s2.getNumberOfCities()));
		return  new ResponseEntity<> (listStateCount, HttpStatus.OK);
	}
	@GetMapping(path="/cidadeporid/{ibge}")
	@Override
	public ResponseEntity<?> cidadeporIdIbge(@PathVariable String ibge) {
		return  new ResponseEntity<> (cityRepository.findByIdIbge(ibge), HttpStatus.OK);
	}
	
	@GetMapping(path="/nomecidadesporestado/{uf}")
	@Override
	public ResponseEntity<?> nomeCidadePorEstado(@PathVariable String uf) {	
		return  new ResponseEntity<> (cityRepository.retrieveNameCitiesByState(uf), HttpStatus.OK);
	}

	@Override
	@PostMapping
	public ResponseEntity<?> addCidade(City city) {
		return new ResponseEntity<> (cityRepository.save(city), HttpStatus.OK);
	}

	@Override
	@DeleteMapping
	public ResponseEntity<?> excluirCidade(String id) {
		System.out.println("idexclusao: " + id);
		cityRepository.delete(id);
		return new ResponseEntity<> (HttpStatus.NO_CONTENT);
	}

	@Override
	@GetMapping("/pesquisacoluna")
	public ResponseEntity<?> pesquisaPorColuna(String column, String key) {
		return new ResponseEntity<> (cityService.searchByColumn(column, key, false), HttpStatus.OK );
	}

	@Override
	@GetMapping("/contarcoluna/{column}")
	public ResponseEntity<?> contarColuna(@PathVariable String column) {
		System.out.println("numeroff:  "+ column);
		int count = cityService.buscaQntColuna(column, true);
		return new ResponseEntity<> ("{ \"count\" : " + count+ " } ", HttpStatus.OK );
	}

	@Override
	@GetMapping("/totalcidades")
	public ResponseEntity<?> totalDeCidades() {
		Long count = cityRepository.count(Example.of(new City()));
		return new ResponseEntity<> (" {  \"count\" : " + count + " } ", HttpStatus.OK);
	}

	@Override
	@GetMapping("/maiordistancia")
	public ResponseEntity<?> cidadesMaisDistantes() {
		List<City> cities = cityRepository.findAll();
		
		City cityALong = new City();
		City cityBLong = new City();
		
		double distanciaMaisLonga = 0;
		
		for(City cityA : cities) {
			for(City cityB : cities) {
				double distanciaMomentania = UtilXptoCadastro.distance(Double.parseDouble(cityA.getlatitude()), Double.parseDouble(cityA.getLongitude()), Double.parseDouble(cityB.getlatitude()), Double.parseDouble(cityB.getLongitude()));
				if (distanciaMaisLonga < distanciaMomentania) {
					distanciaMaisLonga = distanciaMomentania;
					cityALong = cityA;
					cityBLong = cityB;
				}
			}
		}
		return new ResponseEntity<> (new  MoreDistantCitiesDTO(cityALong, cityBLong, distanciaMaisLonga), HttpStatus.OK);
	}
	
}
