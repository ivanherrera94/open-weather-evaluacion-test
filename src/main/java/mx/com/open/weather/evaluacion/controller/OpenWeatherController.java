package mx.com.open.weather.evaluacion.controller;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.open.weather.evaluacion.exception.Exception;
import mx.com.open.weather.evaluacion.model.OpenWeatherBitacoraModel;
import mx.com.open.weather.evaluacion.model.OpenWeatherHistorialModel;
import mx.com.open.weather.evaluacion.model.OpenWeatherModel;
import mx.com.open.weather.evaluacion.service.OpenWeatherService;
import mx.com.open.weather.evaluacion.util.Logs;
import mx.com.open.weather.evaluacion.util.ResponseEntityGeneric;
import mx.com.open.weather.evaluacion.util.Version;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT,
        RequestMethod.PATCH, RequestMethod.OPTIONS})
public class OpenWeatherController{

	@Value("${version.nombre}")
    private String nombre;
    
    @Value("${version.version}")
    private String version;
    
    @Value("${version.correos}")
    private String correos;
	
    @Autowired
    private OpenWeatherService service;
    
	private Version v;
    
    private OpenWeatherController() {
		this.v = new Version();
    }
	
	@GetMapping(path = "${context.name}" + "/version", produces = MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Version", notes = "Muestra la version y responsable del ws")
	public ResponseEntity version(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
		this.v.setNombre(nombre);
		this.v.setVersionService(version);

		this.v.setCorreos(correos);
		this.v.setFecha(new Date());

		return new ResponseEntity<>(this.v, HttpStatus.OK);
	}
	
	@GetMapping(value = "${context.name}/consultar/{ciudad}", produces = MediaType.APPLICATION_JSON)
	@ApiOperation(value = "OpenWeather", notes = "Obtiene los datos de una ciudad")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = ResponseEntityGeneric.MENSAJE_CONSULTA_EXITOSA, response = OpenWeatherModel.class),
		@ApiResponse(code = 204, message = ResponseEntityGeneric.MENSAJE_CONSULTA_SIN_DATOS),
		@ApiResponse(code = 503, message = ResponseEntityGeneric.MENSAJE_NOT_FOUND) })
	public ResponseEntity<OpenWeatherModel> getCiudad(
			@PathVariable("ciudad") String ciudad) {
		
        OpenWeatherModel serviceResponse = service.getCiudad(ciudad);	
        Logs.info(ResponseEntityGeneric.MENSAJE_CONSULTA_EXITOSA);
        
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "${context.name}/consultarList/{ciudad}", produces = MediaType.APPLICATION_JSON)
	@ApiOperation(value = "OpenWeather", notes = "Obtiene una lista de datos openWeather de una ciudad registrados en bitacora")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = ResponseEntityGeneric.MENSAJE_CONSULTA_EXITOSA, response = OpenWeatherModel.class),
		@ApiResponse(code = 204, message = ResponseEntityGeneric.MENSAJE_CONSULTA_SIN_DATOS),
		@ApiResponse(code = 503, message = ResponseEntityGeneric.MENSAJE_NOT_FOUND) })
	public ResponseEntity<List<OpenWeatherBitacoraModel>> getListCiudad(
			@PathVariable("ciudad") String ciudad) {
		
        List<OpenWeatherBitacoraModel> serviceResponse = service.getListCiudad(ciudad);	
        Logs.info(ResponseEntityGeneric.MENSAJE_CONSULTA_EXITOSA);
        
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "${context.name}/consultarHistorial", produces = MediaType.APPLICATION_JSON)
	@ApiOperation(value = "OpenWeather", notes = "Obtiene una lista de datos openWeather de una ciudad registrados en bitacora")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = ResponseEntityGeneric.MENSAJE_CONSULTA_EXITOSA, response = OpenWeatherModel.class),
		@ApiResponse(code = 204, message = ResponseEntityGeneric.MENSAJE_CONSULTA_SIN_DATOS),
		@ApiResponse(code = 503, message = ResponseEntityGeneric.MENSAJE_NOT_FOUND) })
	public ResponseEntity<OpenWeatherHistorialModel> getHistorial(
			@PathVariable("ciudad") String ciudad) {
		
		OpenWeatherHistorialModel serviceResponse = service.getHistorial();	
        Logs.info(ResponseEntityGeneric.MENSAJE_CONSULTA_EXITOSA);
        
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		
	}
}
