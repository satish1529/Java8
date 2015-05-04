package com.mportal.serialization;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class B extends A {

	private static final long serialVersionUID = 7526472295622776147L;
	
	transient int k;
	
	static String  st;
	
	transient int t;
	
	public static int staticint;
	
	
	
	B(int k,int t)
	{
		this.k = k;
		this.t = t;
	}


	/**
	 * @return the k
	 */
	public int getK() {
		return k;
	}


	/**
	 * @param k the k to set
	 */
	public void setK(int k) {
		this.k = k;
	}


	/**
	 * @return the st
	 */
	public static String getSt() {
		return st;
	}


	/**
	 * @param st the st to set
	 */
	public static void setSt(String st) {
		B.st = st;
	}


	/**
	 * @return the t
	 */
	public int getT() {
		return t;
	}


	/**
	 * @param t the t to set
	 */
	public void setT(int t) {
		this.t = t;
	}

	public Object readObject()
	{
		System.out.println("....");
		return null;
	}
	public void readObject(ObjectInputStream oi)
	{
		System.out.println("readOnject");
		try {
			B b = (B)oi.readObject();
			System.out.println("dsfd");
			System.out.println(b.getT());
		/*	System.out.println(oi.readInt());
			System.out.println(oi.readInt());*/
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				oi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private Object readResolve()
	
	{
		System.out.println("readresolve");
		return null;
	}

	public void writeObject(ObjectOutputStream oo)
	{
		System.out.println("writeOnject");
		try {
			oo.writeObject(this);
			oo.writeInt(k);
			oo.writeInt(t);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				oo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
