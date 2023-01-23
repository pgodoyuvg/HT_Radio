package org.pgodoy.radio;

public class Radio implements IRadio {
	boolean on;
	boolean am;
	float currentStation;
	float previousStationAM;
	float previousStationFM;
	float[] storedStationsAM;
	float[] storedStationsFM;
	
	private static int MIN_AM = 530;
	private static int MAX_AM = 1610;
	private static int STATION_DIFF_AM = 10; 
	private static float MIN_FM = 87.9f;
	private static float MAX_FM = 107.9f;
	private static float STATION_DIFF_FM = 0.2f;
	
	
	public Radio() {
		on = false;
		am = true;
		currentStation = MIN_AM;
		previousStationAM = MIN_AM;
		previousStationFM = MIN_FM;
		storedStationsAM = new float[5];
		storedStationsFM = new float[5];
	}
	
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
		if (am) {
			previousStationAM = currentStation;
			currentStation = previousStationFM;
		} else {
			previousStationFM = currentStation;
			currentStation = previousStationAM;
		}
		am = !am;
	}
	
	public float changeStation(boolean forwardDirection) {
		float changeAmount = am ? STATION_DIFF_AM : STATION_DIFF_FM;
		changeAmount = forwardDirection ? changeAmount : -changeAmount;
		currentStation += changeAmount;
		
		if (forwardDirection) {
			if (am && currentStation > MAX_AM) {
				currentStation = MIN_AM;
				return currentStation;
			}
			
			if (!am && currentStation > MAX_FM) {
				currentStation = MIN_FM;
				return currentStation;
			}
			
			return currentStation;
		}
		
		if (am && currentStation < MIN_AM) {
			currentStation = MAX_AM;
			return currentStation;
		}
		
		if (!am && currentStation < MIN_FM) {
			currentStation = MAX_FM;
			return currentStation;
		}
		
		return currentStation;
	}

	public String storeStation(int position) {
		if (position > 5) {
			return "Unable to store in position " + position;
		}
		if (am) {
			storedStationsAM[position] = currentStation;
		} else {
			storedStationsFM[position] = currentStation;
		}
		
		return "Successfully stored station (" + currentStation + ") in position " + position;
	}

}
