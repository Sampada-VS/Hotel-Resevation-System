package com.bridgelabz.hotelreservationsystem;

import java.util.HashMap;
import java.util.Map;

public class HotelData {
	Map<String, Integer> hotelRates;

	public Map<String, Integer> getHotels() {
		hotelRates = new HashMap<String, Integer>();
		hotelRates.put("Lakewood", 110);
		hotelRates.put("Bridgewood", 160);
		hotelRates.put("Ridgewood", 220);
		return hotelRates;
	}

}
