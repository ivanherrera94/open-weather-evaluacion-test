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
public class OpenWeatherModel {

    private MainModel main;
    private SysModel sys;
    private Long id;
    private String name;
	
}
