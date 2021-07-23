package com.edunetcracker.lms.ksndr.pdsh.third;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class AddressTest {
	
	private	static final String[] GOOD_SIMPLE = {
			"Russia, Tulskay obl, Tula, Lenina, 1A, 0, 12",
			"Russia, Moskovskaya obl, Kolomna, Gagarina, 2, 5B, 67",
	};
	
	private static final String[] BAD = {
			"Russia, Tulskay obl: Tula. Lenina% 1, 0; 12",
			"Russia, Moskovskaya obl. Kolomna, 2B, 5. 67",
	};
	
	private Address checkCommonParse(String address) {
		Address ad = new Address();
		ad.parseAddress(address);
		return ad;
	}
	
	@Test
	public void getCountrySimple1() {
		Address ad = checkCommonParse(GOOD_SIMPLE[1]);
		assertEquals("getCountry() failed with parsing address:\n " + GOOD_SIMPLE[1] + "\n",
				     "Russia", ad.getCountry());
	}
	
	@Test
	public void getRoomSimple1() {
		Address ad = checkCommonParse(GOOD_SIMPLE[1]);
		assertEquals("getRoom() failed with parsing address:\n " + GOOD_SIMPLE[1] + "\n",
				     "67", ad.getRoom());
	}
	
	@Test
	public void getCitySimple1() {
		Address ad = checkCommonParse(GOOD_SIMPLE[1]);
		assertEquals("getCity() failed with parsing address:\n " + GOOD_SIMPLE[1] + "\n",
				     "Kolomna", ad.getCity());
	}
	
	@Test
	public void getRegionSimple0() {
		Address ad = checkCommonParse(GOOD_SIMPLE[0]);
		assertEquals("getRegion() failed with parsing address:\n " + GOOD_SIMPLE[0] + "\n",
				     "Tulskay obl", ad.getRegion());
	}

	@Test
	public void getBlockSimple0() {
		Address ad = checkCommonParse(GOOD_SIMPLE[0]);
		assertEquals("getBlock() failed with parsing address:\n " + GOOD_SIMPLE[0] + "\n",
				     "0", ad.getBlock());
	}
	
	@Test
	public void getHouseSimple0() {
		Address ad = checkCommonParse(GOOD_SIMPLE[0]);
		assertEquals("getHouse() failed with parsing address:\n " + GOOD_SIMPLE[0] + "\n",
				     "1A", ad.getHouse());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void parseCommonExceptionBad0(){
		Address ad = checkCommonParse(BAD[0]);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void parseCommonExceptionBad1(){
		Address ad = checkCommonParse(BAD[1]);
	}
	
	private static final String[] GOOD_SPECIAL = {
			"Russia; Tulskay obl, Tula. Lenina, 1, 0; 12",
			"Moskovia, Moskovskaya obl. Kolomna, Gagarina; 2B, 5. 67",
	};
	
	private static final String DELIMETERS = ",.;"; 
	
	private Address checkSpecialParse(String address, String delimeters) {
		Address ad = new Address();
		ad.parseAddress(address, delimeters);
		return ad;
	}
	
	@Test
	public void getCountrySpecial1() {
		Address ad = checkSpecialParse(GOOD_SPECIAL[1], DELIMETERS);
		assertEquals("getCountry() failed with parsing address:\n " + GOOD_SPECIAL[1] + "\n",
				     "Moskovia", ad.getCountry());
	}
	
	@Test
	public void getRegionSpecial1() {
		Address ad = checkSpecialParse(GOOD_SPECIAL[1], DELIMETERS);
		assertEquals("getRegion() failed with parsing address:\n " + GOOD_SPECIAL[1] + "\n",
				     "Moskovskaya obl", ad.getRegion());
	}
	
	@Test
	public void getStreetSpecial1() {
		Address ad = checkSpecialParse(GOOD_SPECIAL[1], DELIMETERS);
		assertEquals("getStreet() failed with parsing address:\n " + GOOD_SPECIAL[1] + "\n",
				     "Gagarina", ad.getStreet());
	}
	
	@Test
	public void getCitySpecial0() {
		Address ad = checkSpecialParse(GOOD_SPECIAL[0], DELIMETERS);
		assertEquals("getCity() failed with parsing address:\n " + GOOD_SPECIAL[0] + "\n",
				     "Tula", ad.getCity());
	}
	
	@Test
	public void getStreetSpecial0() {
		Address ad = checkSpecialParse(GOOD_SPECIAL[0], DELIMETERS);
		assertEquals("getStreet() failed with parsing address:\n " + GOOD_SPECIAL[0] + "\n",
				     "Lenina", ad.getStreet());
	}
	
	@Test
	public void getRoomSpecial0() {
		Address ad = checkSpecialParse(GOOD_SPECIAL[0], DELIMETERS);
		assertEquals("getRoom() failed with parsing address:\n " + GOOD_SPECIAL[0] + "\n",
				     "12", ad.getRoom());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void parseSpecialExceptionBad0() {
		Address ad = checkSpecialParse(BAD[0], DELIMETERS);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void parseSpecialExceptionBad1() {
		Address ad = checkSpecialParse(BAD[1], DELIMETERS);
	}
}
