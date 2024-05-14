package org.loginAuth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "acceptedEvent", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class AcceptedEvent {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "event_Name")
	private String eventName;
	

	@Column(name = "organizer_Name")
	private String organizerName;
	
	@Column(name = "client_Name")
	private String clientName;
	
	@Column(name = "accepted_Date")
	private String acceptedDate;

	public AcceptedEvent(String organizerName,String eventName,  String clientName, String acceptedDate) {
		
		this.eventName = eventName;
		
		this.organizerName = organizerName;
		this.clientName=clientName;
		this.acceptedDate=acceptedDate;
	}

	public String getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(String acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public AcceptedEvent() {
	
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
