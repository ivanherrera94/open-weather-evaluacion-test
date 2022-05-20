package mx.com.open.weather.evaluacion.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Generated
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "bitacora_weather", schema = "bitacora")
public class OpenWeatherEntity implements Serializable {

	private static final long serialVersionUID = -859968159524949531L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBitacora;
	private String name;
    private String country;
    private Long pressure;
    private Long humidity;
    private BigDecimal temp;
    private BigDecimal tempMin;
    private BigDecimal tempMax;
    private Date fechaAlta;
}
