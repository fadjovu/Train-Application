package com.model;

public class Passenger {

	String name;
	int age;
	char gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public Passenger(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Passenger() {
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
}
