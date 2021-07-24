package com.edunetcracker.lms.ksndr.pdsh.fifth;

import java.util.InputMismatchException;

public class PhoneNumber {
	final private int PHONE_NUMBER_DIGITS = 10;
	final private char RUSSIA_COUNTRY_ID = '8';
	final private char START_PHONE_NUMBER = '+';
	
	private String countryID;
	private String phoneNumber;
	
	public PhoneNumber(String phone) {
		
		if (phone.length() <= PHONE_NUMBER_DIGITS) {
			throw new InputMismatchException();
		}
		
		char firstPhoneSymbol = phone.charAt(0);
		
		if (firstPhoneSymbol != RUSSIA_COUNTRY_ID 
				&& firstPhoneSymbol != START_PHONE_NUMBER) {
			throw new InputMismatchException();
		}
		
		if (firstPhoneSymbol == RUSSIA_COUNTRY_ID) {
			
			countryID = "7";
			phoneNumber = phone.substring(1);
		} else {
			
			//amount of digits equals position for begin of phone number
			final int COUNTRY_ID_DIGITS = phone.length() - PHONE_NUMBER_DIGITS;
			countryID = phone.substring(1, COUNTRY_ID_DIGITS);
			phoneNumber = phone.substring(COUNTRY_ID_DIGITS);
		}	
	}
	
	@Override
	public String toString() {
		
		StringBuilder strBuild = new StringBuilder("+" + countryID);
		strBuild.append(phoneNumber.substring(0, 3)); //first 3 digits
		strBuild.append("-" + phoneNumber.substring(3,6)); //second 3 digits
		strBuild.append("-" + phoneNumber.substring(6)); //last 4 digits
		
		return strBuild.toString();
	}
	
}
