package com.edunetcracker.lms.ksndr.pdsh.fourth;

public class Shirt {
	
	private String id;
	private String description;
	private String color;
	private String size;
	
	public Shirt(String id, String description, String color, String size) {
		this.id = id;
		this.description = description;
		this.color = color;
		this.size = size;
 	}
	
	public String getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getSize() {
		return size;
	}
	
	/**
	 * Collecting info about current Shirt to String
	 * where each line it one field of Shirt class
	 * @return String representation of Shirt instance
	 */
	@Override
	public String toString() {
		String result = String.format("Identifier for current shirt(id): %s\n", id);
		result += String.format("Some words about shirt(description): %s\n", description);
		result += String.format("Shirt color: %s\n", color);
		result += String.format("Shirt size: %s\n", size);
		
		return result;
	}
	
	/**
	 * Convert String array shirts to Shirt array
	 *  
	 * @param shirts - String array, where each element it's 
	 * 					one delimiter separated shirt info
	 * @param delimiter - String 
	 * @return array of Shirt instances
	 */
	
	public static Shirt[] convertFromStringArray(String[] shirts, String delimiter) {
		
		Shirt[] result = new Shirt[shirts.length];
		
		for (int i = 0; i < shirts.length; i++) {
			
			String[] shirtParts = shirts[i].split(delimiter);
			result[i] = new Shirt(shirtParts[0], shirtParts[1], shirtParts[2], shirtParts[3]);
		}
		return result;
	}
	
	/**
	 * Print on screen each instance of Shirt array
	 * using toString() method
	 * @param shirts - Shirt array 
	 */
	public static void printShirtArray(Shirt[] shirts) {
		
		for (int i = 0; i < shirts.length; i++) {
			System.out.println("*** " + (i+1) + " shirt info ***");
			System.out.print(shirts[i].toString()); 
		}
	}

}
