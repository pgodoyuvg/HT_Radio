package org.pgodoy.radio;

public interface IRadio {
	void turnOnOff();
	void changeAmFm();
	float changeStation(boolean forwardDirection);
	void storeStation(int position);
}
