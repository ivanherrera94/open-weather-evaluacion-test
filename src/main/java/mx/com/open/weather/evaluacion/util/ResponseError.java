package mx.com.open.weather.evaluacion.util;

import java.util.ArrayList;
import java.util.List;

import mx.com.open.weather.evaluacion.model.ErrorDescripcion;
import mx.com.open.weather.evaluacion.model.ErrorDetalle;

public class ResponseError {

	private ResponseError() {

	}

	public static ErrorDetalle create(Integer codigo, String descripcion, String detalle, String mensaje,
			String nivel) {
		String codigoError = ResponseEntityGeneric.MENSAJE_CODIGO + codigo;
		ErrorDescripcion errorDescripcion = ErrorDescripcion.builder().codigo(codigoError).descripcion(descripcion)
				.detalle(detalle).mensaje(mensaje).nivel(nivel).build();
		List<ErrorDescripcion> errores = new ArrayList<>();
		errores.add(errorDescripcion);
		return ErrorDetalle.builder().errores(errores).build();
	}
}
