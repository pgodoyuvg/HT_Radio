package org.pgodoy.radiotests;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.pgodoy.radio.Radio;
import org.junit.jupiter.api.BeforeEach;

class TurnOnOff {

	private Radio radio;
	@BeforeEach
	void setUp() throws Exception {
		radio = new Radio();
	}

	@Test
	void radioShouldBeOffByDefault() {
		assertFalse(radio.isOn());
	}
	
	@Test
	void radioShouldBeAbleToBeTurnedOn() {
		radio.turnOnOff();
		assertTrue(radio.isOn());
	}
	
	@Test
	void radioShouldBeAbleToBeTurnedOff() {
		radio.turnOnOff();
		assertTrue(radio.isOn());
		radio.turnOnOff();
		assertFalse(radio.isOn());
	}
}
