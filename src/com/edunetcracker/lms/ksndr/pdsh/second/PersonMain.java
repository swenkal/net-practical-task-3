package com.edunetcracker.lms.ksndr.pdsh.second;

public class PersonMain {

	public static void main(String[] args) {
		Person onlyLast = new Person("Ivanov");
		Person withLastAndFirst = new Person("Petrov", "Ivan");
		Person fullPerson = new Person("Sidorov", "Sidr", "Petrovich");
		Person withLastAndFather = new Person("Kuleshov", " ", "Maksimovich");
		
		System.out.println(onlyLast.toString());
		System.out.println(withLastAndFirst.toString());
		System.out.println(fullPerson.toString());
		System.out.println(withLastAndFather.toString());
	}

}
