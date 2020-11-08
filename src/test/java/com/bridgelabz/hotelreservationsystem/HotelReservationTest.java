package com.bridgelabz.hotelreservationsystem;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

public class HotelReservationTest {
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dMMMyyyy", Locale.ENGLISH);
	LocalDate date;

	@Test
	public void givenHotels_WhenAdded_ShouldReturnSize() {
		HotelReservation hotelReservation = new HotelReservation();
		int entries = hotelReservation.getSize();
		assertEquals(3, entries);
	}

	@Test
	public void givenDates_WhenCheapestRate_ShouldReturnHotelName() {
		HotelReservation hotelReservation = new HotelReservation();
		String date1 = "10Sep2020";
		String date2 = "11Sep2020";
		List<Integer> dates = new ArrayList<>();
		dates.add((LocalDate.parse(date1, formatter)).getDayOfWeek().getValue());
		dates.add((LocalDate.parse(date2, formatter)).getDayOfWeek().getValue());
		int cheapestRate = hotelReservation.getCheapestRate(dates);
		List<String> cheapestHotel = hotelReservation.getCheapestHotel(cheapestRate);
		assertTrue(cheapestHotel.contains("Lakewood"));
		System.out.println(cheapestHotel + ", Total Rate : $" + cheapestRate);
	}

	@Test
	public void givenWeekdaysAndWeekendDays_WhenCheapestRate_ShouldReturnHotelNames() {
		HotelReservation hotelReservation = new HotelReservation();
		String date1 = "11Sep2020";
		String date2 = "12Sep2020";
		List<Integer> dates = new ArrayList<>();
		dates.add((LocalDate.parse(date1, formatter)).getDayOfWeek().getValue());
		dates.add((LocalDate.parse(date2, formatter)).getDayOfWeek().getValue());
		int cheapestRate = hotelReservation.getCheapestRate(dates);
		List<String> cheapestHotel = hotelReservation.getCheapestHotel(cheapestRate);
		assertTrue(cheapestHotel.contains("Lakewood"));
		System.out.println(cheapestHotel + " with Total rates : $" + cheapestRate);
	}

}
