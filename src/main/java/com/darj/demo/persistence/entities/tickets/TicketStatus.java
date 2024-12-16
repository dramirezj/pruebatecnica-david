package com.darj.demo.persistence.entities.tickets;

public enum TicketStatus {

	A("Abierto"), C("Cerrado");

	private String stateValue;

	private TicketStatus(String stateValue) {
		this.stateValue = stateValue;
	}

	public String getStateValue() {
		return stateValue;
	}

	public static TicketStatus getFromString(String value) {
		for(TicketStatus status : TicketStatus.values()) {
			if(status.name().equalsIgnoreCase(value)) { 
				return status;
			}
		}
		return null;
	}
	
}
