package mx.com.open.weather.evaluacion.util;

public class ResponseEntityGeneric {

	public static final String MENSAJE_CONSULTA_EXITOSA = "Consulta exitosa";
	public static final String MENSAJE_CONSULTA_SIN_DATOS = "Consulta sin datos";
	public static final String MENSAJE_CREATED = "Recurso creado correctamente";
	public static final String MENSAJE_DELETED = "Recurso eliminado correctamente";
	public static final String MENSAJE_NOT_FOUND = "Recurso no encontrado";
	public static final String MENSAJE_BAD_REQUEST = "El servidor no puede interpretar la solicitud, revisar request";
	public static final String MENSAJE_INTERNAL_SERVER_ERROR = "Error interno";
	public static final String MENSAJE_MODIFICADO = "Recurso modificado correctamente";
	public static final String MENSAJE_CODIGO = "open-weather ";
	public static final String ERROR_INFO = "INFO";
	public static final String ERROR_WARN= "WARNING";
	public static final String ERROR_ERROR= "ERROR";
	
	private ResponseEntityGeneric() {
		throw new IllegalStateException("Utility class");
    }



}
