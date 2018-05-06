package com.ubs.opsit.interviews.converters;

import com.ubs.opsit.interviews.constants.LampStatus;

public class SecondsConverter {
	
	public String convertSeconds(String inputSeconds){
		String result=null;
		int seconds = Integer.parseInt(inputSeconds);
		
		if(seconds<0 || seconds>59){
			throw new RuntimeException("Invalid seconds in input");
		}
		
		if(seconds%2==0){
			result=LampStatus.YELLOW.getState();
		}else{
			result=LampStatus.OFF.getState();
		}
		return result;
	}

}
