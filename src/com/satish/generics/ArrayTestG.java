package com.satish.generics;

import java.lang.reflect.Array;

public class ArrayTestG<E> {

	E [] a;
	
	ArrayTestG(Class<E> c)
	{
		a = (E[])Array.newInstance(c, 5);
	}
	
	E[] get()
	{
		return a;
		
	}
	
	public boolean equals(E[] t)
	{
		Object [] current = this.a;
		Object [] input = t;
	
		/*if(current==t)
			return true;
		return current.equals(t);*/
		//return false;
		System.out.println(this.a==t);
		return true;
	}
	
	
	public static void main(String[] args) {
		ArrayTestG<Integer> arrayint = new ArrayTestG<>(Integer.class);
		Integer [] integerArray = arrayint.get();
		for (int i = 0; i < integerArray.length; i++) {
			System.out.println(integerArray[i]);
		}
		
		ArrayTestG<String> arrayint1 = new ArrayTestG<>(String.class);
		
		System.out.println(arrayint.equals(arrayint1.get()));
		
	}
}
