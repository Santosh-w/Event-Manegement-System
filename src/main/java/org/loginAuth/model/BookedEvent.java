package org.loginAuth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "bookedEvent", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class BookedEvent {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "event_Name")
	private String eventName;
	

	@Column(name = "organizer_Name")
	private String organizerName;
	
	

	public String getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}

	@Column(name = "client_Name")
	private String clientName;
	
	@Column(name = "booked_Date")
	private String bookedDate;

	public BookedEvent(String organizerName,String eventName,  String clientName, String bookedDate) {
		
		this.eventName = eventName;
		
		this.organizerName = organizerName;
		this.clientName=clientName;
		this.bookedDate=bookedDate;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public BookedEvent() {
	
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}
	
	

	
	

}
