package Models;

import java.util.Date;


public class Event {
	private Date date;
	
	private Double lat;
	private Double lng;
	private EventType type;
	
	private int people;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public EventType getEventType() {
		return type;
	}
	public void setEventType(EventType eventType) {
		this.type = eventType;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
}
