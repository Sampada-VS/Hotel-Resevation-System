package com.bridgelabz.hotelreservationsystem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void givenHotels_WhenAdded_ShouldReturnSize() {
		HotelReservation hotelReservation = new HotelReservation();
		int entries = hotelReservation.getSize();
		assertEquals(3, entries);
	}
	@Test
	public void givenDates_WhenCheapestRate_ShouldReturnHotelName() {
		HotelReservation hotelReservation = new HotelReservation();
		List<String> dates=new ArrayList<>();
		dates.add("10sep2020");
		dates.add("11sep2020");
		int totaldays=dates.size();
		int cheapestRate = hotelReservation.getCheapestRate(totaldays);
		String cheapestHotel=hotelReservation.getCheapestHotel(cheapestRate);
		assertEquals("Lakewood", cheapestHotel);
		System.out.println(cheapestHotel+", Total Rate : $"+cheapestRate);

	}

}
