package com.xpto.cadastro.facade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.xpto.cadastro.domain.City;
import com.xpto.cadastro.facade.rest.exception.CadastroApplicationException;

@RequestMapping("/cadastro/api/facade/city")
public interface CityFacade {

	ResponseEntity<?> importCsv(MultipartFile file) throws CadastroApplicationException;
	ResponseEntity<?>  capitalCities();
	ResponseEntity<?>  estadoComMaisQntCidade();
	ResponseEntity<?>  estadoComMenosQntCidade();
	ResponseEntity<?>  estadoComMaisEMenosQntCidade();
	ResponseEntity<?>  qntDeCidadePorEstado();
	ResponseEntity<?>  cidadeporIdIbge(String ibge);
	ResponseEntity<?>  nomeCidadePorEstado(String uf);
	ResponseEntity<?>  addCidade(City city);
	ResponseEntity<?>  excluirCidade(String id);
	ResponseEntity<?>  pesquisaPorColuna(String column, String key);
	ResponseEntity<?>  contarColuna(String column);
	ResponseEntity<?>  totalDeCidades();
	ResponseEntity<?>  cidadesMaisDistantes();
}
