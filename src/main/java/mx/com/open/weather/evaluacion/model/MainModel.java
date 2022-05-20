package mx.com.open.weather.evaluacion.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MainModel {

	private BigDecimal temp;
	private Integer feels_like;
	private BigDecimal temp_min;
	private BigDecimal temp_max;
	private Integer pressure;
	private Integer humidity;
	
}
