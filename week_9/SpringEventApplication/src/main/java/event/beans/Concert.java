package event.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "my_events")
public class Concert {
	@Id
	@GeneratedValue
	private long id;
	private String artist;
	private LocalDate date;
	private LocalTime time;

	@Autowired
	private Venue venue;

	/**
	 * Constructor that takes all parameters
	 * @param id
	 * @param artist
	 * @param date
	 * @param time
	 */
	public Concert(long id, String artist, LocalDate date, LocalTime time) {
		setId(id);
		setArtist(artist);
		setDate(date);
		setTime(time);
	}

	/**
	 * Constructor that takes artist, venue, state, city, date, and time as paremters
	 * @param artist
	 * @param date
	 * @param time
	 */
	public Concert(String artist, LocalDate date, LocalTime time) {
		setArtist(artist);
		setDate(date);
		setTime(time);
	}

	@Override
	public String toString() {
		return "Concert [id=" + getId() + ", artist=" + getArtist() + ", date=" + getDate() + ", time=" + getTime()
				+ ", venue=" + getVenue() + "]";
	}

}
