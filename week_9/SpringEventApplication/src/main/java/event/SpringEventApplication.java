/**
 * @author $skramuja - Sabina Johnson
 * CIS175 - Fall 2022
 * 10/18/2022
 */

package event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import event.beans.Concert;
import event.beans.Venue;
import event.controller.BeanConfiguration;
import event.repository.EventRepository;

@SpringBootApplication
public class SpringEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEventApplication.class, args);
	}

	@Autowired
	EventRepository repo;

}
