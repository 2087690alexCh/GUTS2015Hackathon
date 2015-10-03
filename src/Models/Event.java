package Models;

import java.util.Date;


public class Event {
	private Date date;
	
	private Double lat;
	private Double lng;
	private String eventName;
	private String dangerousLvl;
	
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
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDangerousLvl() {
		return dangerousLvl;
	}
	public void setDangerousLvl(String dangerousLvl) {
		this.dangerousLvl = dangerousLvl;
	}
}