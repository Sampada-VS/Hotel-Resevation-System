package com.bridgelabz.hotelreservationsystem;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HotelReservation {
	Map<Integer, String> hotel = new HashMap<Integer, String>();
	Map<Integer, Integer> hotelTotalRates = new HashMap<Integer, Integer>();
	HotelData hotelData = new HotelData();

	public int getSize() {
		hotel = hotelData.getHotels();
		return hotel.size();
	}

	public int getCheapestRate(int numberOfDays) {
		for (int i = 1; i <= getSize(); i++)
			hotelTotalRates.put(i, numberOfDays * hotelData.getHotelRates(i));
		int cheapestRate = Collections.min(hotelTotalRates.values());
		return cheapestRate;
	}

	public String getCheapestHotel(int rate) {
		int hotelNo = 0;
		for (Entry<Integer, Integer> entry : hotelTotalRates.entrySet()) {
			if (entry.getValue().equals(rate)) {
				hotelNo = entry.getKey();
			}
		}
		return hotelData.getHotelName(hotelNo);
	}

}
