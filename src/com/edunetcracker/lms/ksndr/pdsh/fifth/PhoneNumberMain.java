package com.edunetcracker.lms.ksndr.pdsh.fifth;

public class PhoneNumberMain {

	public static void main(String[] args) {
		
		final String RUSSIA_PHONE_NUMBER = "89101684044";
		System.out.printf("Input: %s\n", RUSSIA_PHONE_NUMBER);
		PhoneNumber pn = new PhoneNumber(RUSSIA_PHONE_NUMBER);
		System.out.printf("Output: %s\n", pn.toString());
		
		final String UNKNOW_PHONE_NUMBER = "+1829101684044";
		PhoneNumber pn2 = new PhoneNumber(UNKNOW_PHONE_NUMBER);
		System.out.printf("Input: %s\n", UNKNOW_PHONE_NUMBER);
		System.out.printf("Output: %s\n", pn2.toString());
	}
}
