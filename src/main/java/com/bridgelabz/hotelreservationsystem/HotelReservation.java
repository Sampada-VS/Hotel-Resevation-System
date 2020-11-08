package com.bridgelabz.hotelreservationsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HotelReservation {
	HotelData hotelData = new HotelData();
	Map<Integer, String> hotel = hotelData.getHotels();
	Map<Integer, Integer> hotelTotalRates = new HashMap<Integer, Integer>();
	List<String> hotelsHavingCheapRate;
	Map<Integer, Integer> cheapestHotelWithRatings = new HashMap<Integer, Integer>();
	Map<Integer, Integer> ratings = hotelData.getHotelRatingDetails();

	public int getSize() {
		return hotel.size();
	}

	public String getHotelName(int index) {
		return hotel.get(index);
	}

	public int getRate(List<Integer> dates, int hotelIndex) {
		int totalRates = 0;
		for (Integer day : dates) {
			if (day >= 1 && day <= 5)
				totalRates = totalRates + hotelData.getHotelWeekdayRatesForRegularCustomer(hotelIndex);
			else if (day == 6 || day == 7)
				totalRates = totalRates + hotelData.getHotelWeekendRatesForRegularCustomer(hotelIndex);
		}
		return totalRates;
	}

	public int getCheapestRate(List<Integer> dates) {
		for (int i = 1; i <= getSize(); i++) {
			hotelTotalRates.put(i, getRate(dates, i));
		}
		int cheapestRate = Collections.min(hotelTotalRates.values());
		return cheapestRate;
	}

	public List<String> getCheapestHotel(int rate) {
		hotelsHavingCheapRate = new ArrayList<>();
		int hotelNo = 0;
		for (Entry<Integer, Integer> entry : hotelTotalRates.entrySet()) {
			if (entry.getValue().equals(rate)) {
				hotelNo = entry.getKey();
				hotelsHavingCheapRate.add(getHotelName(hotelNo));
			}
		}
		return hotelsHavingCheapRate;
	}

	public String getBestRatedCheapestHotel(List<String> cheapestHotel) {
		for (int i = 1; i <= cheapestHotel.size(); i++)
			for (String eachCheapestHotel : cheapestHotel) {
				cheapestHotelWithRatings.put(i, getHotelRatingBasedOnHotel(eachCheapestHotel));
			}
		int bestRating = Collections.max(cheapestHotelWithRatings.values());
		return getHotelBasedOnRating(bestRating);
	}

	public String getHotelBasedOnRating(int rating) {
		int hotelNum = 0;
		for (Entry<Integer, Integer> entry : ratings.entrySet()) {
			if (entry.getValue().equals(rating)) {
				hotelNum = entry.getKey();
			}
		}
		return hotel.get(hotelNum);
	}

	public int getHotelRatingBasedOnHotel(String inputHotel) {
		return ratings.get(getHotelIndex(inputHotel));
	}

	public String getBestRatedHotel() {
		int bestRating = Collections.max(ratings.values());
		return getHotelBasedOnRating(bestRating);
	}

	public int getHotelIndex(String inputHotel) {
		int hotelNo = 0;
		for (Entry<Integer, String> entry : hotel.entrySet()) {
			if (entry.getValue().equals(inputHotel)) {
				hotelNo = entry.getKey();
			}
		}
		return hotelNo;
	}

}
