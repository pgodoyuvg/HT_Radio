package org.pgodoy.radiotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pgodoy.radio.Radio;

class StoreStation {

	private Radio radio;
	@BeforeEach
	void setUp() throws Exception {
		radio = new Radio();
	}

	@Test
	void radioShouldBeAbleToStoreAMStation() {
		assertTrue(radio.isAm());
		radio.changeStation(false);
		var position = 3;
		var current = radio.getCurrentStation();
		var result = radio.storeStation(position);
		assertEquals(result, "Successfully stored station (" + current + ") in position " + position);
	}

	@Test
	void radioShouldBeAbleToStoreFMStation() {
		radio.changeAmFm();
		assertFalse(radio.isAm());
		radio.changeStation(true);
		var position = 2;
		var current = radio.getCurrentStation();
		var result = radio.storeStation(position);
		assertEquals(result, "Successfully stored station (" + current + ") in position " + position);
	}
	
	@Test
	void radioShouldNotBeAbleToStoreStationOutOfBounds() {
		var position = 10;
		var result = radio.storeStation(position);
		assertEquals(result, "Unable to store in position " + position);
	}
}
