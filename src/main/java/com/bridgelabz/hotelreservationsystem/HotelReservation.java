package com.bridgelabz.hotelreservationsystem;

import java.util.HashMap;
import java.util.Map;

public class HotelReservation {
	Map<String, Integer> hotel = new HashMap<String, Integer>();
	HotelData hotelData = new HotelData();

	public int getSize() {
		hotel = hotelData.getHotels();
		return hotel.size();
	}

}
