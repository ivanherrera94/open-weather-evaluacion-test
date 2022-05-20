package mx.com.open.weather.evaluacion.util;

import java.util.Date;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Generated;


public class Logs {
	
	private static final Logger LOG = LoggerFactory.getLogger(Logs.class);

	private Logs() {
		throw new IllegalStateException("Utility class");
	}

	@Generated
	public static void error(String... mensajes) {
		if (LOG.isErrorEnabled()) {
			LOG.error(Arrays.toString(mensajes), new Date().getTime());
		}
	}

	@Generated
	public static void info(String... mensajes) {
		if (LOG.isInfoEnabled()) {
			LOG.info(Arrays.toString(mensajes), new Date().getTime());
		}
	}

	@Generated
	public static void warning(String... mensajes) {
		if (LOG.isWarnEnabled()) {
			LOG.warn(Arrays.toString(mensajes), new Date().getTime());
		}
	}

	@Generated
	public static void debug(String... mensajes) {
		if (LOG.isDebugEnabled()) {
			LOG.debug(Arrays.toString(mensajes), new Date().getTime());
		}
	}
    
}
