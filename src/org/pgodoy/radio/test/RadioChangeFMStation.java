package org.pgodoy.radio.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pgodoy.radio.Radio;

class RadioChangeFMStation {

	private Radio radio;
	@BeforeEach
	void setUp() throws Exception {
		radio = new Radio();
		radio.turnOnOff(); // it will turn the radio on each time a test is run
		radio.changeAmFm(); // it will change the radio to FM each time a test is run
	}

	@Test
	void radioCanChangeFMStationForward() {
		
	}

}
