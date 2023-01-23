package org.pgodoy.radio;

public interface IRadio {
	void turnOnOff();
	void changeAmFm();
	float changeStation(boolean forwardDirection);
	String storeStation(int position);
}
