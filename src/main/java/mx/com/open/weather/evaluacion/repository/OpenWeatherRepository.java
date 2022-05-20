package mx.com.open.weather.evaluacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.open.weather.evaluacion.entity.OpenWeatherEntity;
import mx.com.open.weather.evaluacion.model.OpenWeatherHistorialModel;

@Repository
public interface OpenWeatherRepository extends JpaRepository<OpenWeatherEntity, String> {
	
	 @Query(value = "SELECT name, count(*) as 'veces_consultada' "
	 		+ "FROM bitacora_weather "
	 		+ "GROUP BY name  "
	 		+ "ORDER BY fecha_alta desc limit 10", nativeQuery = true )
	 OpenWeatherHistorialModel getUltimasCiudades();
	 
	 @Query(value = "SELECT * "
	 		+ "FROM bitacora_weather "
	 		+ "WHERE name = :ciudad "
	 		+ "ORDER BY fecha_alta DESC", nativeQuery = true )
		    List<OpenWeatherEntity> getListCiudad(@Param("ciudad") String ciudad);

}
