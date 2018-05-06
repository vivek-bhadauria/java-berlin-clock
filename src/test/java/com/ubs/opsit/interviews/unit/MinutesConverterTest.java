package com.ubs.opsit.interviews.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ubs.opsit.interviews.converters.MinutesConverter;

public class MinutesConverterTest {
	
	MinutesConverter minutesConverter = new MinutesConverter();
	
	public @Rule ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testConvertMinutes(){
		assertEquals("YYOOOOOOOOO\r\nYOOO",minutesConverter.convertMinutes("11"));
		assertEquals("YYRYYRYYRYY\r\nYYYY",minutesConverter.convertMinutes("59"));
		assertEquals("OOOOOOOOOOO\r\nOOOO",minutesConverter.convertMinutes("00"));
		assertEquals("YYRYYOOOOOO\r\nYYOO",minutesConverter.convertMinutes("27"));
		assertEquals("OOOOOOOOOOO\r\nYYYY",minutesConverter.convertMinutes("04"));
	}
	
	@Test
	public void testConvertMinutesInvalidInput() {
		
		exception.expect(RuntimeException.class);
		exception.expectMessage("Invalid minutes in input");
		minutesConverter.convertMinutes("60");
		
	}

}
