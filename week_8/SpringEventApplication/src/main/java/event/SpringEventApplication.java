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
public class SpringEventApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringEventApplication.class, args);
	}

	@Autowired
	EventRepository repo;

	@Override
	public void run(String... args) throws Exception {

		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);

		Concert concert = appContext.getBean("concert", Concert.class);
		repo.save(concert);

		LocalDate date = LocalDate.of(2022, 11, 17);
		LocalTime time = LocalTime.parse("20:00:00", DateTimeFormatter.ISO_TIME);
		Concert concert2 = new Concert("Eagles", date, time);

		Venue venue = new Venue("Wells Fargo Arena", "233 Center St", "Des Moines", "IA");
		concert2.setVenue(venue);
		repo.save(concert2);

		List<Concert> allMyConcerts = repo.findAll();

		for (Concert event : allMyConcerts) {
			System.out.println(event.toString());
		}
		((AbstractApplicationContext) appContext).close();
	}
}
