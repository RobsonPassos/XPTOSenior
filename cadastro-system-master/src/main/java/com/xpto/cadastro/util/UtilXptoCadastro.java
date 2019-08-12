package com.xpto.cadastro.util;

import org.apache.commons.csv.CSVRecord;

import com.xpto.cadastro.domain.City;
import com.xpto.cadastro.domain.Mesoregion;
import com.xpto.cadastro.domain.Microregion;
import com.xpto.cadastro.domain.State;

public class UtilXptoCadastro {
	
	private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM

    public static double distance(double startLat, double startLong,
                                  double endLat, double endLong) {

        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // <-- d
    }

    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
	public static City lineCsvOfCity(CSVRecord record) {
		State state = new State();
		state.setUf(record.get(ColumnArq.uf));				
		
		Mesoregion mesoregion = new Mesoregion();
		mesoregion.setName(record.get(ColumnArq.mesoregion));
		mesoregion.setState(state);
		
		Microregion microregion = new Microregion();
		microregion.setName(record.get(ColumnArq.microregion));
		microregion.setMesoregion(mesoregion);
		
		
		
		City city = new City();
		
		city.setMicroregion(microregion);
		
		city.setIdIbge(record.get(ColumnArq.ibge_id));
		city.setCapital(Boolean.parseBoolean(record.get(ColumnArq.capital)));
		city.setLatitude(record.get(ColumnArq.lat));
		city.setLongitude(record.get(ColumnArq.lon));
		city.setName(record.get(ColumnArq.name));
		city.setAlternativeName(record.get(ColumnArq.alternative_names));
		return city;
	}
	
	
	public static void classOfColumn(String column) {
	
		switch (ColumnArq.valueOf(column)) {
		
			case ibge_id:
				break;
			case alternative_names:
				break;
			case mesoregion:
				break;
			case microregion:
				break;
			case no_accents:
				break;
			case name:
				break;
			case uf:
				break;
			case lat:
				break;
			case lon:
				break;
			default:
				break;
		}
	}
	
	
	
}
