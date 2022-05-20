package mx.com.open.weather.evaluacion.model;

import java.io.Serializable;
import java.util.List;

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
public class ErrorDetalle implements Serializable {

	private static final long serialVersionUID = 6989643460606424681L;
	private List<ErrorDescripcion> errores;

}
