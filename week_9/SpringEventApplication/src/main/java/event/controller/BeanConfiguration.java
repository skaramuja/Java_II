package event.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import event.beans.Concert;
import event.beans.Venue;

@Configuration
public class BeanConfiguration {
	@Bean
	public Concert concert() {
		LocalDate date = LocalDate.of(2022, 11, 06);
		LocalTime time = LocalTime.parse("21:00:00", DateTimeFormatter.ISO_TIME);
		Concert concert = new Concert("Matellica", date, time);
		return concert;
	}

	@Bean
	public Venue Venue() {
		Venue venue = new Venue("Hard Rock Live at Seminole Hard Rock Hotel & Casino", "1 Seminole Way", "Hollywood", "Fl");
		return venue;
	}
}
