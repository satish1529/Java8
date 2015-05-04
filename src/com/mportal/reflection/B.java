package com.mportal.reflection;

import java.util.List;

public class B<T> extends A  implements InterfaceA,InterfaceB<T>{

	T t;
	public List<? extends Comparable> l;
	public final String s ="test";
	
	public int sdf =1;
	private String j;
	
	String m;
	
	protected String p;

	/**
	 * @return the t
	 */
	public T getT() {
		return t;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(T t) {
		this.t = t;
	}
	
	public int segting() {
	return 1;
	}
	
	
	public int getI() {
		return i;
	}

	
	public int geting(int i ,String s) {
		return 1;
		}
}
