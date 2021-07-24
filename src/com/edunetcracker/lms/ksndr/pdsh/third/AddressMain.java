package com.edunetcracker.lms.ksndr.pdsh.third;

import java.util.NoSuchElementException;

public class AddressMain {

	public static void main(String[] args) {
		
		Address ad1 = new Address();
		final String COMMON_VALID_ADDRESS = "Russia, Tulskay obl, Tula, Lenina, 1, 0, 12";
		
		Address ad2 = new Address();
		final String SPECIAL_VALID_ADDRESS = "Russia. Tulskay obl; Tula, Lenina. 1. 0, 12";
		final String SPECIAL_DELIMETERS = ",;.";
		
		try {
			
			System.out.printf("Input: %s\n", COMMON_VALID_ADDRESS);
			ad1.parseAddress(COMMON_VALID_ADDRESS);
			System.out.println(ad1.toString());
			
			System.out.printf("Input: %s\n", SPECIAL_VALID_ADDRESS);
			System.out.printf("With delimeters: '%s'\n", SPECIAL_DELIMETERS);
			ad2.parseAddress(SPECIAL_VALID_ADDRESS, SPECIAL_DELIMETERS);
			System.out.println(ad2.toString());
			
		} catch (NoSuchElementException e) {
			System.err.println("Amount address parts in string not equal to Address fields");
			System.exit(1);
		}
	}

}
