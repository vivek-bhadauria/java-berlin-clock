package com.ubs.opsit.interviews.converters;

import com.ubs.opsit.interviews.constants.LampStatus;

public class MinutesConverter {

	public String convertMinutes(String inputMinutes){
		String result=null;
		String firstRowLamps = "OOOOOOOOOOO";
		String secondRowLamps = "OOOO";
		int minutes = Integer.parseInt(inputMinutes);
		
		if(minutes<0 || minutes>59){
			throw new RuntimeException("Invalid minutes in input");
		}
		
		int firstRowLightedLamps = minutes/5;
		firstRowLamps = updateLamps(firstRowLamps,firstRowLightedLamps);
		
		int secondRowLightedLamps = minutes%5;
		secondRowLamps = updateLamps(secondRowLamps,secondRowLightedLamps);
		
		result = firstRowLamps+"\r\n"+secondRowLamps;
		return result;
	}

	private String updateLamps(String rowLampsStr, int numberOfLampsToLight) {

		StringBuilder rowLamps = new StringBuilder(rowLampsStr);
		for(int i=0; i<numberOfLampsToLight; i++){
			if(rowLampsStr.length()==11 && (i==2 || i==5 || i==8)){
			   rowLamps.setCharAt(i, LampStatus.RED.getState().charAt(0));	
			}else{
			   rowLamps.setCharAt(i, LampStatus.YELLOW.getState().charAt(0));	
			}
		}
		return rowLamps.toString();
	}
}
