package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.converters.HoursConverter;
import com.ubs.opsit.interviews.converters.MinutesConverter;
import com.ubs.opsit.interviews.converters.SecondsConverter;

public class TimeConverterImpl implements TimeConverter {
	
	private HoursConverter hoursConverter = new HoursConverter();
	private MinutesConverter minutesConverter = new MinutesConverter();
	private SecondsConverter secondsConverter = new SecondsConverter();

	@Override
	public String convertTime(String aTime) {
		String result="";
		String[] splittedTime =aTime.split(":");
		
		String seconds = splittedTime[2];
		result=result.concat(secondsConverter.convertSeconds(seconds))+"\r\n";
		
		String hours = splittedTime[0];
		result=result.concat(hoursConverter.convertHours(hours))+"\r\n";
		
		String minutes = splittedTime[1];
		result=result.concat(minutesConverter.convertMinutes(minutes));
		
		return result;
		
		}

}
