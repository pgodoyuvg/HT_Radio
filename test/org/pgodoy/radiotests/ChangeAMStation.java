package org.pgodoy.radiotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pgodoy.radio.Radio;

class ChangeAMStation {

	private Radio radio;
	@BeforeEach
	void setUp() throws Exception {
		radio = new Radio();
		radio.turnOnOff(); // it will turn the radio on each time a test is run
		assertTrue(radio.isAm()); // it will have the radio on AM at start 
	}

	@Test
	void radioShouldBeAbleToChangeAMStationForward() {
		var startingStation = radio.getCurrentStation();
		var expected = startingStation + 10;
		radio.changeStation(true);
		assertEquals(radio.getCurrentStation(), expected);
	}
	
	@Test
	void radioShouldBeAbleToChangeAMStationBackwards() {
		var startingStation = radio.getCurrentStation();
		radio.changeStation(true);
		radio.changeStation(true); // it will set the station to 2 stations forward
		var expected = startingStation + 10;
		radio.changeStation(false);
		assertEquals(radio.getCurrentStation(), expected);
	}
	
	@Test
	void radioShouldBeAbleToCircleAMStationsFromFirstLastToFirst() {
		var first = 530;
		assertEquals(radio.getCurrentStation(), first);
		var last = 1610;
		radio.changeStation(false);
		assertEquals(radio.getCurrentStation(), last);
		radio.changeStation(true);
		assertEquals(radio.getCurrentStation(), first);
	}
}
