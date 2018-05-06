package com.ubs.opsit.interviews.unit;

import com.ubs.opsit.interviews.converters.HoursConverter;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HoursConverterTest {

	HoursConverter hoursConverter = new HoursConverter();
	
	public @Rule ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testConvertHours(){
		
		assertEquals("OOOO\r\nROOO", hoursConverter.convertHours("01"));
		assertEquals("OOOO\r\nOOOO", hoursConverter.convertHours("00"));
		assertEquals("ROOO\r\nOOOO", hoursConverter.convertHours("05"));
		assertEquals("ROOO\r\nRRRR", hoursConverter.convertHours("09"));
		assertEquals("RRRO\r\nROOO", hoursConverter.convertHours("16"));
		assertEquals("RRRR\r\nRRRO", hoursConverter.convertHours("23"));
	}
	
	@Test
	public void testConvertHoursInvalidInput() {
		
		exception.expect(RuntimeException.class);
		exception.expectMessage("Invalid hours in input");
		hoursConverter.convertHours("25");
		
	}
}
