package com.bridgelabz.hotelreservationsystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void givenHotels_WhenAdded_ShouldReturnSize() {
		HotelReservation hotelReservation = new HotelReservation();
		int entries = hotelReservation.getSize();
		assertEquals(3, entries);
	}

}
