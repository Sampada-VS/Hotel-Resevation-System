package com.bridgelabz.hotelreservationsystem;

import java.util.HashMap;
import java.util.Map;

public class HotelData {
	Map<Integer, String> hotelName;
	Map<Integer, Integer> hotelRates;
	Map<Integer, Integer> hotelRatings;

	public Map<Integer, String> getHotels() {
		hotelName = new HashMap<Integer, String>();
		hotelName.put(1, "Lakewood");
		hotelName.put(2, "Bridgewood");
		hotelName.put(3, "Ridgewood");
		return hotelName;
	}

	public int getHotelWeekdayRatesForRegularCustomer(int index) {
		hotelRates = new HashMap<Integer, Integer>();
		hotelRates.put(1, 110);
		hotelRates.put(2, 150);
		hotelRates.put(3, 220);
		return hotelRates.get(index);
	}

	public int getHotelWeekendRatesForRegularCustomer(int index) {
		hotelRates = new HashMap<Integer, Integer>();
		hotelRates.put(1, 90);
		hotelRates.put(2, 50);
		hotelRates.put(3, 150);
		return hotelRates.get(index);
	}
	public int getHotelWeekdayRatesForRewardCustomer(int index) {
		hotelRates = new HashMap<Integer, Integer>();
		hotelRates.put(1, 80);
		hotelRates.put(2, 110);
		hotelRates.put(3, 100);
		return hotelRates.get(index);
	}

	public int getHotelWeekendRatesForRewardCustomer(int index) {
		hotelRates = new HashMap<Integer, Integer>();
		hotelRates.put(1, 80);
		hotelRates.put(2, 50);
		hotelRates.put(3, 40);
		return hotelRates.get(index);
	}

	public Map<Integer, Integer> getHotelRatingDetails() {
		hotelRatings = new HashMap<Integer, Integer>();
		hotelRatings.put(1, 3);
		hotelRatings.put(2, 4);
		hotelRatings.put(3, 5);
		return hotelRatings;
	}

}
