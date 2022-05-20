package mx.com.open.weather.evaluacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.open.weather.evaluacion.entity.OpenWeatherEntity;
import mx.com.open.weather.evaluacion.exception.CityNotFoundException;
import mx.com.open.weather.evaluacion.model.MainModel;
import mx.com.open.weather.evaluacion.model.OpenWeatherBitacoraModel;
import mx.com.open.weather.evaluacion.model.OpenWeatherHistorialModel;
import mx.com.open.weather.evaluacion.model.OpenWeatherModel;
import mx.com.open.weather.evaluacion.model.SysModel;
import mx.com.open.weather.evaluacion.repository.OpenWeatherRepository;
import mx.com.open.weather.evaluacion.util.ResponseEntityGeneric;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

@Service
public class OpenWeatherServiceImpl implements OpenWeatherService {

	@Autowired
	private OpenWeatherRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RestClient rest;

	@Override
	public OpenWeatherModel getCiudad(String ciudad) {
		
		OpenWeatherModel regCiudad = rest.consultaCiudad(ciudad);
		MainModel main = regCiudad.getMain();
		SysModel sys = regCiudad.getSys();
		OpenWeatherBitacoraModel regBitacora = new OpenWeatherBitacoraModel();

		if (Objects.isNull(regCiudad)) {
			throw new CityNotFoundException(ResponseEntityGeneric.MENSAJE_NOT_FOUND);
		}
		
		regBitacora.setCountry(sys.getCountry());
		regBitacora.setHumidity(main.getHumidity());
		regBitacora.setName(regCiudad.getName());
		regBitacora.setTemp(main.getTemp());
		regBitacora.setTempMin(main.getTemp_min());
		regBitacora.setTempMax(main.getTemp_max());
		regBitacora.setPressure(main.getPressure());
		regBitacora.setHumidity(main.getHumidity());
		regBitacora.setFechaAlta(new Date());
		
		create(regBitacora);
		return regCiudad;
	}
	
	@Override
	public OpenWeatherHistorialModel getHistorial() {
		
		OpenWeatherHistorialModel reg = repository.getUltimasCiudades();
		if (Objects.isNull(reg)) {
			throw new CityNotFoundException(ResponseEntityGeneric.MENSAJE_NOT_FOUND);
		}
		OpenWeatherHistorialModel bean = modelMapper.map(reg, new TypeToken<OpenWeatherHistorialModel>(){}.getType());

		return bean;
	}
	
	@Override
	public List<OpenWeatherBitacoraModel> getListCiudad(String ciudad) {
		
		List<OpenWeatherEntity> regs = repository.getListCiudad(ciudad);
		if (regs.isEmpty()) {
			throw new CityNotFoundException(ResponseEntityGeneric.MENSAJE_NOT_FOUND);
		}
		List<OpenWeatherBitacoraModel> lista = modelMapper.map(regs, new TypeToken<List<OpenWeatherBitacoraModel>>(){}.getType());
		
		return lista;
	}
	
	@Override
	public OpenWeatherBitacoraModel create(OpenWeatherBitacoraModel bean) {
		return modelMapper.map(repository.save(modelMapper.map(bean, OpenWeatherEntity.class)), OpenWeatherBitacoraModel.class);
	}
}
