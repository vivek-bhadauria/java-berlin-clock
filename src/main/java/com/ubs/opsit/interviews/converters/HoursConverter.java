package com.ubs.opsit.interviews.converters;

import com.ubs.opsit.interviews.constants.LampStatus;

public class HoursConverter {
	
	public String convertHours(String inputHours){
		String result = null;
		String firstRowLamps = null;
		String secondRowLamps = null;
		int hours = Integer.parseInt(inputHours);
		
		if(hours<0 || hours>24){
			throw new RuntimeException("Invalid hours in input");
		}
		
		int firstRowLightedLamps = hours/5;
		firstRowLamps = updateLamps(firstRowLightedLamps);
		
		int secondRowLightedLamps = hours%5;
		secondRowLamps = updateLamps(secondRowLightedLamps);
		
		result = firstRowLamps+"\r\n"+secondRowLamps;
		return result;
	}

	private String updateLamps(int numberOfLampsToLight) {
		
		StringBuilder rowLamps = new StringBuilder("OOOO");
		for(int i=0; i<numberOfLampsToLight; i++){
			rowLamps.setCharAt(i, LampStatus.RED.getState().charAt(0));
		}
		return rowLamps.toString();
	}

}
