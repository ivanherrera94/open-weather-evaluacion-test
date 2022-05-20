package mx.com.open.weather.evaluacion.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class SysModel {

    private String country;
    private Date sunrise;
    private Date sunset;

	
}
