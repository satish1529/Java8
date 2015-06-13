package com.mportal.serialization;

import java.io.Serializable;


public class Test  implements Serializable{

	Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	String s;
	
	int i;

	/**
	 * @return the s
	 */
	public String getS() {
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
