package mx.com.open.weather.evaluacion;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import lombok.Generated;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@ComponentScan(basePackages = {"mx.com.open.weather.evaluacion"})
public class OpenWeatherBootApplication {
	
	@Generated
	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherBootApplication.class, args);
		TimeZone.setDefault(TimeZone.getTimeZone("America/Mexico_City"));
	}

}
