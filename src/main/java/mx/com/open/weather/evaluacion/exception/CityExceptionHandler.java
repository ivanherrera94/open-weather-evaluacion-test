package mx.com.open.weather.evaluacion.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.Generated;
import mx.com.open.weather.evaluacion.model.ErrorDetalle;
import mx.com.open.weather.evaluacion.util.ResponseEntityGeneric;
import mx.com.open.weather.evaluacion.util.ResponseError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CityExceptionHandler extends ResponseEntityExceptionHandler{

	@Generated
	@ExceptionHandler(Exception.class)
	public final ResponseEntity handleAllExceptions(Exception ex, WebRequest webRequest) {

		ErrorDetalle errorDetalle = ResponseError.create(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ResponseEntityGeneric.MENSAJE_INTERNAL_SERVER_ERROR, ex.getMessage(),
				ResponseEntityGeneric.MENSAJE_INTERNAL_SERVER_ERROR, ResponseEntityGeneric.ERROR_ERROR);
		return new ResponseEntity<>(errorDetalle, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@Generated
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public final ResponseEntity handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex,
			WebRequest webRequest) {
		ErrorDetalle errorDetalle = ResponseError.create(HttpStatus.BAD_REQUEST.value(),
				ResponseEntityGeneric.MENSAJE_BAD_REQUEST,
				ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage(), ex.getMessage(),
				ResponseEntityGeneric.ERROR_WARN);
		return new ResponseEntity<>(errorDetalle, HttpStatus.BAD_REQUEST);
	}

	
	@Generated
	@ExceptionHandler(CityNotFoundException.class)
	public final ResponseEntity handleCityNotFoundException(CityNotFoundException ex, WebRequest webRequest) {
		ErrorDetalle errorDetalle = ResponseError.create(HttpStatus.NOT_FOUND.value(),
				ResponseEntityGeneric.MENSAJE_NOT_FOUND, ex.getMessage(), ResponseEntityGeneric.MENSAJE_NOT_FOUND,
				ResponseEntityGeneric.ERROR_WARN);
		return new ResponseEntity<>(errorDetalle, HttpStatus.NOT_FOUND);

	}
	
	@Generated
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity handleConstraintViolationException(ConstraintViolationException ex,
			WebRequest webRequest) {
		ErrorDetalle errorDetalle = ResponseError.create(HttpStatus.BAD_REQUEST.value(),
				ResponseEntityGeneric.MENSAJE_BAD_REQUEST,
				ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage(), ex.getMessage(),
				ResponseEntityGeneric.ERROR_WARN);
		return new ResponseEntity<>(errorDetalle, HttpStatus.BAD_REQUEST);
	}
	

	@Generated
	@ExceptionHandler(DataIntegrityViolationException.class)
	public final ResponseEntity handleDataIntegrityViolationException(DataIntegrityViolationException ex,
			WebRequest webRequest) {
		ErrorDetalle errorDetalle = ResponseError.create(HttpStatus.BAD_REQUEST.value(),
				ResponseEntityGeneric.MENSAJE_BAD_REQUEST,
				(ex.getCause() != null && ex.getCause().getCause() != null) ? ex.getCause().getCause().getMessage()
						: ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage(),
				ex.getMessage(), ResponseEntityGeneric.ERROR_WARN);
		return new ResponseEntity<>(errorDetalle, HttpStatus.BAD_REQUEST);
	}
	
}
