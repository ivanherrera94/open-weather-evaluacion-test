package mx.com.open.weather.evaluacion.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Generated
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class ErrorDescripcion implements Serializable{

	private static final long serialVersionUID = -7936029204173013839L;
	private String codigo;
	private String descripcion;
	private String detalle;
	private String nivel;
	private String mensaje;

}
