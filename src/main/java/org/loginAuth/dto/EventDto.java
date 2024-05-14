package org.loginAuth.dto;

public class EventDto {


	private String eventName;
	
	private String description;
	
	private String startDate;
	private String endDate;

	private int pricing;
	
	private String organizerName;

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public String getEventName() {
		return eventName;
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

	public int getPricing() {
		return pricing;
	}

	public void setPricing(int pricing) {
		this.pricing = pricing;
	}

	public EventDto(String eventName, String description, String startDate,String endDate, int pricing, String organizerName) {
		super();
		this.eventName = eventName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pricing = pricing;
		this.organizerName=organizerName;
	}

	public EventDto() {
		
	}

	

	
	


}
