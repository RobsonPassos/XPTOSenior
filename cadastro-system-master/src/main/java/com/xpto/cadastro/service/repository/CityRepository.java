package com.xpto.cadastro.service.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xpto.cadastro.domain.City;
import com.xpto.cadastro.domain.dto.CityNameDTO;
import com.xpto.cadastro.domain.dto.StateAmountCityDTO;
import com.xpto.cadastro.service.repository.dao.CityRepositoryDAO;

@Repository
public interface CityRepository extends JpaRepository<City, String>, CityRepositoryDAO {
	@Query("Select  new com.xpto.cadastro.domain.dto.StateAmountCityDTO(s, count(c.idIbge) as numberOfCities)  from State s, City c where c.microregion.mesoregion.state = s group by s")
	List<StateAmountCityDTO> retrieveStateAmountCityAsDTO();
	@Query("Select new com.xpto.cadastro.domain.dto.CityNameDTO(c.name ) from State s, City c where c.microregion.mesoregion.state.uf = s.uf and s.uf like :uf")
	List<CityNameDTO> retrieveNameCitiesByState(@Param("uf") String uf);
	City findByIdIbge(String idIbge);
}
