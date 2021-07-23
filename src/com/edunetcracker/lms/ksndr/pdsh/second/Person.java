package com.edunetcracker.lms.ksndr.pdsh.second;

public class Person {
	
	private String lastName;
	private Character firstCharFirstName;
	private Character firstCharFatherName;
	
	public Person(String lastName) {
		
		this.lastName = lastName;
	}
	
	public Person(String lastName, String firstName) {
		
		this(lastName);
		
		//avoid situation when lastName  
		//want to skip in Person info
		if (isFieldNotEmpty(firstName)) {
			
			this.firstCharFirstName = firstName.charAt(0);
		}
	}
	
	public Person(String lastName, String firstName, String fatherName) {
		
		this(lastName, firstName);
		
		//avoid situation when fatherName  
		//want to skip in Person info
		if (isFieldNotEmpty(fatherName)) {
			
			this.firstCharFatherName = fatherName.charAt(0);
		}
	}
	
	/**
	 * Check some field for not empty.
	 * Empty consider: 
	 *  -empty string (""); 
	 *  -string with whitespace (" ");
	 *  -null value.
	 * @param field - be checked for emptiness
	 * @return true - if field not empty, false - if field empty
	 */
	private boolean isFieldNotEmpty (String field) {
		
		return field != "" && field != " " && field != null;
	}
	
	/**
	 * Get string in special format for Person fields.
	 * Taking into consideration about absence of 
	 * firstName or/and fatherName
	 * @return formated String - "lastName firstCharFirstName.firstCharFatherName."
	 */
	@Override
	public String toString() {
		
		if (firstCharFirstName != null && firstCharFatherName != null) {
			
			return String.format("%s %s.%s.", 
						lastName, firstCharFirstName, firstCharFatherName);
		} 
		
		if (firstCharFirstName != null && firstCharFatherName == null) {
			
			return String.format("%s %s.", lastName, firstCharFirstName);
		}
		
		if (firstCharFirstName == null && firstCharFatherName != null) {
			
			return String.format("%s %s.", lastName, firstCharFatherName);
		}
		
		return lastName;		
	}
	
	
	public static void main(String[] args) {
		Person onlyLast = new Person("Ivanov");
		Person withLastAndFirst = new Person("Petrov", "Ivan");
		Person fullPerson = new Person("Sidorov", "Sidr", "Petrovich");
		Person withLastAndFather = new Person("Kuleshov", null, "Maksimovich");
		
		System.out.println(onlyLast.toString());
		System.out.println(withLastAndFirst.toString());
		System.out.println(fullPerson.toString());
		System.out.println(withLastAndFather.toString());
	}
}
