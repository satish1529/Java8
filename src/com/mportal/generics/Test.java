package com.mportal.generics;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<?> listNumber = new ArrayList<>();
		iterateTypeObject(listNumber);
		List<?> [] llist = new ArrayList<?>[3];
		Object [] o = llist;
		try {
			Class.forName("double");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testNumber()
	{
		List<Number> l = new ArrayList<>();
		l.add(10);
		l.add(10.1);
		l.add(new Integer(10));
		
		List<Integer> integer = new ArrayList<>();
		//l  = integer; //compiler error		
		
		List<? extends Number> listExtends = new ArrayList<>();
		listExtends= integer;
	}
	
	private static void iterateObject(List<Object> objects)
	{
		objects.add("s");
		for(Object obj: objects)
			System.out.println("object : " +obj);
	}
	
	private static void iterateUnknownObject(List<?> objects)
	{
		objects.add(null);
		for(Object obj: objects)
			System.out.println("unknown : "+obj);
	}
	
	private static <T> void iterateTypeObject(List<T> objects,T x)
	{
		objects.add(null);
		objects.add(x);
		for(T obj: objects)
			System.out.println("unknown : "+obj);
	}
	
	private static <T extends Number> void iterateTypeExtendsObject(List<T> objects)
	{
		objects.add(null);
	//	objects.add(x);
		for(T obj: objects)
			System.out.println("unknown : "+obj);
	}
	
	private static <T> void iterateTypeObject(List<T> objects)
	{
		objects.add(null);
	//	objects.add(x);
		for(T obj: objects)
			System.out.println("unknown : "+obj);
	}
	
	
	
	private static void iterateExtendsObject(List<? extends Number> objects)
	{
		objects.add(null);
		for(Number obj: objects)
			System.out.println("unknown : "+obj);
	}
	
	private static void iterateRestrictedObject(List<Number> objects)
	{
		objects.add(10.1);
		for(Number obj: objects)
			System.out.println("unknown : "+obj);
	}
	
	private static void iterateSuperObject(List<? super Number> objects)
	{
		objects.add(10.1);
		objects.add(10);
		for(Object obj: objects)
			System.out.println("unknown : "+obj);
	}
}
