package com.bridgelabz.hotelreservationsystem;

import java.util.HashMap;
import java.util.Map;

public class HotelData {
	Map<Integer, String> hotels;
	Map<Integer, String> hotelName;
	Map<Integer, Integer> hotelRates;

	public Map<Integer, String> getHotels() {
		hotelName = new HashMap<Integer, String>();
		hotelName.put(1, "Lakewood");
		hotelName.put(2, "Bridgewood");
		hotelName.put(3, "Ridgewood");
		return hotelName;
	}

	public String getHotelName(int index) {
		hotels = getHotels();
		return hotelName.get(index);
	}

	public int getHotelWeekdayRates(int index) {
		hotelRates = new HashMap<Integer, Integer>();
		hotelRates.put(1, 110);
		hotelRates.put(2, 150);
		hotelRates.put(3, 220);
		return hotelRates.get(index);
	}

	public int getHotelWeekendRates(int index) {
		hotelRates = new HashMap<Integer, Integer>();
		hotelRates.put(1, 90);
		hotelRates.put(2, 50);
		hotelRates.put(3, 150);
		return hotelRates.get(index);
	}

}
