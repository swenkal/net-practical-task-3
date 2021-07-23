package com.edunetcracker.lms.ksndr.pdsh.third;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Address {

	private String country;
	private String region;
	private String city;
	private String street;
	private String house;
	private String block;
	private String room;
	
	public Address() {
		super();
	};
	
	/**
	 * Parsing address from String representation
	 * with common delimiter - comma (",").
	 * ASSUMPTION: in string all parts of address should be exist.
	 * @param address - full address with comma delimiter
	 * @throws NoSuchElementException - when amount of class arguments 
	 * 									don't equal to splited parts
	 */
	public void parseAddress(String address) 
			throws NoSuchElementException {
		
		String[] addressParts = address.split(",");
		int classArgsCount = getClass().getDeclaredFields().length;
		
		if (addressParts.length != classArgsCount) {
			throw new NoSuchElementException();
		}
		setAllAddressFields(addressParts);	
	}
	
	/**
	 * Overloading parseAddress(String address)
	 * Parsing address from String representation 
	 * with special delimiters 
	 * ASSUMPTION: in string all parts of address should be exist.
	 * @param address - full address with special delimiters
	 * @param delimeters - sequence of char's which can be delimiter for string
	 * @throws NoSuchElementException
	 */
	public void parseAddress(String address, String delimeters) 
			throws NoSuchElementException {
		
		StringTokenizer st = new StringTokenizer(address, delimeters);
		int classArgsCount = getClass().getDeclaredFields().length;
		
		if (st.countTokens() != classArgsCount) {
			throw new NoSuchElementException();
		}
		
		String[] addressParts = new String[st.countTokens()];
		int i = 0;
		
		while (st.hasMoreTokens()) {
			addressParts[i] = st.nextToken();
			i++;
		}
		setAllAddressFields(addressParts);
	}
	
	private void setAllAddressFields(String[] addressParts) {
		
		this.country = addressParts[0].trim();
		this.region = addressParts[1].trim();
		this.city = addressParts[2].trim();
		this.street = addressParts[3].trim();
		this.house = addressParts[4].trim();
		this.block = addressParts[5].trim();
		this.room = addressParts[6].trim();
	}
	
	@Override
	public String toString() {
		
		return String.format("<Address: %s, %s, %s, %s, %s, %s, %s>", 
					country, region, city, street, house, block, room);
	}
	
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

	public String getCountry() {
		return country;
	}

	public String getRegion() {
		return region;
	}

	public String getCity() {
		return city;
	}

	public String getHouse() {
		return house;
	}

	public String getStreet() {
		return street;
	}

	public String getBlock() {
		return block;
	}

	public String getRoom() {
		return room;
	}

}
