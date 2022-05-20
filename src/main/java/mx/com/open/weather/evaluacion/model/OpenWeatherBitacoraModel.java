package mx.com.open.weather.evaluacion.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class OpenWeatherBitacoraModel {

	private Long idBitacora;
	private String name;
    private String country;
    private Integer pressure;
    private Integer humidity;
    private BigDecimal temp;
    private BigDecimal tempMin;
    private BigDecimal tempMax;
    private Date fechaAlta;
	
}
