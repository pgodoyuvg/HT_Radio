package org.pgodoy.radiotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pgodoy.radio.Radio;

class ChangeFMStation {

	private Radio radio;
	@BeforeEach
	void setUp() throws Exception {
		radio = new Radio();
		radio.turnOnOff(); // it will turn the radio on each time a test is run
		radio.changeAmFm(); // it will change the radio to FM each time a test is run
	}

	@Test
	void radioShouldBeAbleToChangeFMStationForward() {
		var startingStation = radio.getCurrentStation();
		var expected = startingStation + 0.2f;
		radio.changeStation(true);
		assertEquals(radio.getCurrentStation(), expected);
	}
	
	@Test
	void radioShouldBeAbleToChangeFMStationBackwards() {
		var startingStation = radio.getCurrentStation();
		radio.changeStation(true);
		radio.changeStation(true); // it will set the station to 2 stations forward
		var expected = startingStation + 0.2f;
		radio.changeStation(false);
		assertEquals(radio.getCurrentStation(), expected);
	}
	
	@Test
	void radioShouldBeAbleToCircleFMStationsFromFirstLastToFirst() {
		var first = 87.9f;
		assertEquals(radio.getCurrentStation(), first);
		var last = 107.9f;
		radio.changeStation(false);
		assertEquals(radio.getCurrentStation(), last);
		radio.changeStation(true);
		assertEquals(radio.getCurrentStation(), first);
	}
}
