package mx.com.open.weather.evaluacion.exception;


public class CityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 9015236738921026713L;

	public CityNotFoundException(String message) {
		super(message);
	}
}

