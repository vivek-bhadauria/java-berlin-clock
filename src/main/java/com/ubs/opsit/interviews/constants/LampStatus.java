package com.ubs.opsit.interviews.constants;

public enum LampStatus {

	YELLOW("Y"),
	RED("R"),
	OFF("O");
	
	private String state; 
	
	LampStatus(String val) {
		state = val;
	}

	public String getState() {
	    return state;
	}
}
