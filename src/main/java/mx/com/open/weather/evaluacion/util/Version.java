package mx.com.open.weather.evaluacion.util;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Version {
	
	private String nombre;
	private String versionService;
	private String correos;
	private Date fecha;
	
}
