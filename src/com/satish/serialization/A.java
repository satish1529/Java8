package com.satish.serialization;

import java.io.Serializable;

public class A implements Serializable {

	String s ;
	
	int i;

	A()
	{
		
	}
	A(int i, String s)
	{
		this.i =i;
		this.s = s;
	}
	
	/**
	 * @return the s
	 */
	public String getS() {
		Integer [] i ={1,2};
		return s;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(String s) {
		this.s = s;
	}

	/**
	 * @return the i
	 */
	public int getI() {
		return i;
	}

	/**
	 * @param i the i to set
	 */
	public void setI(int i) {
		this.i = i;
	}
	
	
}
