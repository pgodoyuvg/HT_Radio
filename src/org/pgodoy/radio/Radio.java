package org.pgodoy.radio;

public class Radio implements IRadio {
	boolean on;
	boolean am;
	float currentStation;
	
	public boolean isOn() {
		return on;
	}

	public boolean isAm() {
		return am;
	}

	public float getCurrentStation() {
		return currentStation;
	}
	
	public void turnOnOff() {
		on = !on;
	}
	
	public void changeAmFm() {
		am = !am;
	}
	
	public float changeStation(boolean forwardDirection) {
		float changeAmount = am ? 10 : 0.2f;
		changeAmount = forwardDirection ? changeAmount : -changeAmount;

		
		return 0;
	}

	public void storeStation(int position) {
		// TODO Auto-generated method stub
		
	}

}
