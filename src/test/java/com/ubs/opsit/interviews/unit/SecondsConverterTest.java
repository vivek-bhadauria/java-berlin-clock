package com.ubs.opsit.interviews.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ubs.opsit.interviews.converters.SecondsConverter;

public class SecondsConverterTest {
	
	SecondsConverter secondsConverter = new SecondsConverter();
	
	public @Rule ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testConvertSeconds(){
		
		assertEquals("O",secondsConverter.convertSeconds("01"));
		assertEquals("O",secondsConverter.convertSeconds("09"));
		assertEquals("Y",secondsConverter.convertSeconds("00"));
		assertEquals("Y",secondsConverter.convertSeconds("02"));
		assertEquals("O",secondsConverter.convertSeconds("33"));
		assertEquals("Y",secondsConverter.convertSeconds("58"));
	}
	
	@Test
	public void testConvertSecondsInvalidInput() {
		
		exception.expect(RuntimeException.class);
		exception.expectMessage("Invalid seconds in input");
		secondsConverter.convertSeconds("60");
		
	}

}