package event.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

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
	 * Default constructor with no parameters
	 */
	public Concert() {

	}

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

	/**
	 * Getter for ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * Setter for ID
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter for artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Setter for artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * Getter for date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Setter for date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Getter for time
	 */
	public LocalTime getTime() {
		return time;
	}

	/**
	 * Setter for time
	 */
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	/**
	 * Getter for venue
	 */
	public Venue getVenue() {
		return venue;
	}

	/**
	 * Setter for venue
	 */
	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	@Override
	public String toString() {
		return "Concert [id=" + getId() + ", artist=" + getArtist() + ", date=" + getDate() + ", time=" + getTime()
				+ ", venue=" + getVenue() + "]";
	}

}
