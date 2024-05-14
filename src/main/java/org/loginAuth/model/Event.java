package org.loginAuth.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "event", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Event {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "event_Name")
	private String eventName;
	
	@Column(name = "EVENT_DESCRIPTION")
	private String description;
	
	private String startDate;
	
	private String endDate;

	private int pricing;
	
	private String organizerName;
	
	@ManyToMany(mappedBy = "users" ,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_events",
			joinColumns = @JoinColumn(
		            name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "event_id", referencedColumnName = "id"))
	

	public String getEventName() {
		return eventName;
	}


	public Event(String eventName, String description, String startDate, String endDate, int pricing, String organizerName) {
		super();
		this.eventName = eventName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pricing = pricing;
		this.organizerName=organizerName;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	


	


	public int getPricing() {
		return pricing;
	}


	public void setPricing(int pricing) {
		this.pricing = pricing;
	}


	
	
	
	public String getOrganizerName() {
		return organizerName;
	}


	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}


	public Event() {
		
	}
	
	


	

}
