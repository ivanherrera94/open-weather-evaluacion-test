package mx.com.open.weather.evaluacion.service;

import java.util.List;

import mx.com.open.weather.evaluacion.model.OpenWeatherBitacoraModel;
import mx.com.open.weather.evaluacion.model.OpenWeatherHistorialModel;
import mx.com.open.weather.evaluacion.model.OpenWeatherModel;

public interface OpenWeatherService{
    
	 OpenWeatherModel getCiudad(String ciudad);
	 
	 List<OpenWeatherBitacoraModel> getListCiudad(String ciudad);
	 
	 OpenWeatherHistorialModel getHistorial();
	 
	 OpenWeatherBitacoraModel create(OpenWeatherBitacoraModel bean);
	
}
