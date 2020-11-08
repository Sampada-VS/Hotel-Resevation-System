package com.bridgelabz.hotelreservationsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HotelReservation {
	HotelData hotelData = new HotelData();
	Map<Integer, String> hotel = new HashMap<Integer, String>();
	Map<Integer, Integer> hotelTotalRates = new HashMap<Integer, Integer>();
	List<String> hotelsHavingCheapRate;
	Map<Integer, Integer> cheapestHotelWithRatings = new HashMap<Integer, Integer>();

	public int getSize() {
		hotel = hotelData.getHotels();
		return hotel.size();
	}

	public int getCheapestRate(List<Integer> dates) {
		for (int i = 1; i <= getSize(); i++) {
			int totalRates = 0;
			for (Integer day : dates) {
				if (day >= 1 && day <= 5)
					totalRates = totalRates + hotelData.getHotelWeekdayRates(i);
				else if (day == 6 || day == 7)
					totalRates = totalRates + hotelData.getHotelWeekendRates(i);
			}
			hotelTotalRates.put(i, totalRates);
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
				hotelsHavingCheapRate.add(hotelData.getHotelName(hotelNo));
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
		int hotelNum = 0;
		for (Entry<Integer, Integer> entry : cheapestHotelWithRatings.entrySet()) {
			if (entry.getValue().equals(bestRating)) {
				hotelNum = entry.getKey();
			}
		}
		return hotelData.getHotelName(hotelNum);
	}

	public int getHotelRatingBasedOnHotel(String inputHotel) {
		int hotelNo = 0;
		for (Entry<Integer, String> entry : hotel.entrySet()) {
			if (entry.getValue().equals(inputHotel)) {
				hotelNo = entry.getKey();
			}
		}
		return hotelData.getHotelRatings(hotelNo);

	}

}
