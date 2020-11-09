package com.bridgelabz.hotelreservationsystem;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HotelReservationTest {
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dMMMyyyy", Locale.ENGLISH);
	LocalDate date;
	static HotelReservation hotelReservation;

	@BeforeClass
	public static void createObj() {
		hotelReservation = new HotelReservation();
	}

	@AfterClass
	public static void nullObj() {
		hotelReservation = null;
	}

	@Test
	public void givenHotels_WhenAdded_ShouldReturnSize() {
		int entries = hotelReservation.getSize();
		assertEquals(3, entries);
	}

	@Test
	public void givenDates_WhenCheapestRate_ShouldReturnHotelName() {
		String customerType = "regular";
		List<String> dateRange = Arrays.asList("10Sep2020", "11Sep2020");
		List<Integer> dates = new ArrayList<>();
		for (String eachdate : dateRange)
			dates.add((LocalDate.parse(eachdate, formatter)).getDayOfWeek().getValue());
		int cheapestRate = hotelReservation.getCheapestRate(dates, customerType);
		List<String> cheapestHotel = hotelReservation.getCheapestHotel(cheapestRate);
		assertTrue(cheapestHotel.contains("Lakewood"));
		System.out.println(cheapestHotel + ", Total Rate : $" + cheapestRate);
	}

	@Test
	public void givenWeekdaysAndWeekendDays_WhenCheapestRate_ShouldReturnHotelNames() {
		String customerType = "regular";
		List<String> dateRange = Arrays.asList("11Sep2020", "12Sep2020");
		List<Integer> dates = new ArrayList<>();
		for (String eachdate : dateRange)
			dates.add((LocalDate.parse(eachdate, formatter)).getDayOfWeek().getValue());
		int cheapestRate = hotelReservation.getCheapestRate(dates, customerType);
		List<String> cheapestHotel = hotelReservation.getCheapestHotel(cheapestRate);
		assertTrue(cheapestHotel.contains("Lakewood"));
		System.out.println(cheapestHotel + " with Total rates : $" + cheapestRate);
	}

	@Test
	public void givenWeekdaysAndWeekendDaysForRegularCustomer_WhenCheapestRate_ShouldReturnHotelWithHighestRating() {
		String customerType = "regular";
		List<String> dateRange = Arrays.asList("11Sep2020", "12Sep2020");
		List<Integer> dates = new ArrayList<>();
		for (String eachdate : dateRange)
			dates.add((LocalDate.parse(eachdate, formatter)).getDayOfWeek().getValue());
		int cheapestRate = hotelReservation.getCheapestRate(dates, customerType);
		List<String> cheapestHotel = hotelReservation.getCheapestHotel(cheapestRate);
		String bestRatedCheapestHotel = hotelReservation.getBestRatedCheapestHotel(cheapestHotel);
		int rating = hotelReservation.getHotelRatingBasedOnHotel(bestRatedCheapestHotel);
		assertEquals("Bridgewood", bestRatedCheapestHotel);
		System.out.println(bestRatedCheapestHotel + ", Rating : " + rating + " and Total rate : $" + cheapestRate);
	}

	@Test
	public void givenWeekdaysAndWeekendDays_WhenBestRating_ShouldReturnHotel() {
		String customerType = "regular";
		List<String> dateRange = Arrays.asList("11Sep2020", "12Sep2020");
		List<Integer> dates = new ArrayList<>();
		for (String eachdate : dateRange)
			dates.add((LocalDate.parse(eachdate, formatter)).getDayOfWeek().getValue());
		String bestRatedHotel = hotelReservation.getBestRatedHotel();
		assertEquals("Ridgewood", bestRatedHotel);
		int index = hotelReservation.getHotelIndex(bestRatedHotel);
		System.out.println(bestRatedHotel + ", Total rate : " + hotelReservation.getRate(dates, index, customerType));
	}

	@Test
	public void givenWeekdaysAndWeekendDaysForRewardCustomer_WhenCheapestRate_ShouldReturnHotelWithHighestRating() {
		String customerType = "reward";
		List<String> dateRange = Arrays.asList("11Sep2020", "12Sep2020");
		List<Integer> dates = new ArrayList<>();
		for (String eachdate : dateRange)
			dates.add((LocalDate.parse(eachdate, formatter)).getDayOfWeek().getValue());
		int cheapestRate = hotelReservation.getCheapestRate(dates, customerType);
		List<String> cheapestHotel = hotelReservation.getCheapestHotel(cheapestRate);
		String bestRatedCheapestHotel = hotelReservation.getBestRatedCheapestHotel(cheapestHotel);
		int rating = hotelReservation.getHotelRatingBasedOnHotel(bestRatedCheapestHotel);
		assertEquals("Ridgewood", bestRatedCheapestHotel);
		System.out.println(bestRatedCheapestHotel + ", Rating : " + rating + " and Total rate : $" + cheapestRate);
	}
}
