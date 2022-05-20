package mx.com.open.weather.evaluacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.open.weather.evaluacion.exception.CityNotFoundException;
import mx.com.open.weather.evaluacion.model.OpenWeatherModel;
import mx.com.open.weather.evaluacion.util.Logs;
import mx.com.open.weather.evaluacion.util.ResponseEntityGeneric;



@Service
public class RestClient {
	
	
	@Value("${open.weather.service.url}")
    private String openWeatherServiceUrl;
    
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
    ObjectMapper objectMapper;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	 
	 public OpenWeatherModel consultaCiudad(String ciudad) {
		 
		 	Logs.info("Consultando Ciudad >>  {}", ciudad);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(headers);

			try {
				ResponseEntity<OpenWeatherModel> response = restTemplate.exchange(openWeatherServiceUrl + "/weather?q=" + ciudad + "&appid=bda24560bbeedffea6a151be95b4fe78&units=metric", HttpMethod.GET, entity, new ParameterizedTypeReference<OpenWeatherModel>() {});
				if(response.getBody() != null && response.getStatusCodeValue() == 200) {
					Logs.info("Response >> ", response.getBody().toString());
					return response.getBody();			
				}
				else
					return null;	    
				}
			catch(HttpClientErrorException e) {
				if(e.getRawStatusCode() == 404) { 
					Logs.info("Datos no encontrados");
					throw new CityNotFoundException("Ciudad no encontrada: " + ResponseEntityGeneric.MENSAJE_NOT_FOUND);
				}
				else {
					Logs.info("Exception al obtener Ciudad {} ", e.toString());
					throw new CityNotFoundException("Ocurrio un error con el servicio Open Weather: " + ResponseEntityGeneric.MENSAJE_INTERNAL_SERVER_ERROR);
				}
			}
			catch(Exception e) {
				throw new CityNotFoundException(ResponseEntityGeneric.MENSAJE_INTERNAL_SERVER_ERROR);
			}
	 }
	
}
