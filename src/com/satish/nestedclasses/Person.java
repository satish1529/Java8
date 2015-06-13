package com.mportal.nestedclasses;

public class Person {

	String a;

	Person(String s)
	{
		a = s;
	}
	
	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	public static int compare(Person ap , Person bp)
	{
		return ap.getA().compareTo(bp.getA());
	}
	
	public String toString()
	{
		return a;
	}
}
