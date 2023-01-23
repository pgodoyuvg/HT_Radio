package org.pgodoy.radio.test;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.pgodoy.radio.Radio;
import org.junit.jupiter.api.BeforeEach;

class RadioTurnOnOffTest {

	private Radio radio;
	@BeforeEach
	void setUp() throws Exception {
		radio = new Radio();
	}

	@Test
	void radioIsOffByDefault() {
		assertFalse(radio.isOn());
	}
	
	@Test
	void radioCanBeTurnedOn() {
		radio.turnOnOff();
		assertTrue(radio.isOn());
	}
	
	@Test
	void radioCanBeTurnedOff() {
		radio.turnOnOff();
		assertTrue(radio.isOn());
		radio.turnOnOff();
		assertFalse(radio.isOn());
	}
}
