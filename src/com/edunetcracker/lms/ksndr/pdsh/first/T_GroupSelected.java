package com.edunetcracker.lms.ksndr.pdsh.first;

public class T_GroupSelected {
	
	//fields name for table 
	final static String ID_STUDENT = "id_Student";
	final static String FIRST_NAME = "firstName";
	final static String LAST_NAME = "lastName";
	final static String ID_GROUP = "id_Group";
	
	/**
     * Generate SQL query INSERT T_GroupSelected 
     * FROM SELECT T_student
     * @param groupIdValue - String group identifier for where condition
     * @param dolgCountValue - numbers of debts for where condition
     * @return generated String SQL query with arguments
     */
	public static String insertFromStudentToGroup(String groupIdValue, int dolgCountValue) {
		final String insertPart = String.format("INSERT INTO T_GroupSelected (%s, %s, %s, %s)\n", 
											ID_STUDENT, FIRST_NAME, LAST_NAME, ID_GROUP);
		final String selectPart = String.format("\tSELECT %s, %s, %s, %s \n", 
												ID_STUDENT, FIRST_NAME, LAST_NAME, ID_GROUP);
		final String fromPart = "\tFROM T_Student\n";
		final String wherePart = String.format("\tWHERE %s = '%s' AND %s > %d", 
												ID_GROUP, groupIdValue, T_Student.DOLG_COUNT, dolgCountValue);
		
		return insertPart + selectPart + fromPart + wherePart;
	}
	
	public static void main(String[] args) {
		System.out.println(T_GroupSelected.insertFromStudentToGroup("UIS-311", 10));
	}
}
