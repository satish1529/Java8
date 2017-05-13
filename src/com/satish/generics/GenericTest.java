package com.satish.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericTest gt = new GenericTest();
		gt.testGenericUnknownType();
		gt.testGenericExtends();
		gt.testGenericSuper();
		gt.testUnkownIteration();
	}

	
	private void testGenericUnknownType()
	{
		List<String> list = new ArrayList<String>();
		list.add("test");
		
		List<?> listG = list;
		listG.add(null);
		
		
		for(Object o : listG)
		{
			System.out.println(o);
		}
		
	}
	
	private void testGenericExtends()
	{
		List<Object> listo = new ArrayList<Object>();
		listo.add(10);
		listo.add("sdf");
		
		List<A> list = new ArrayList<A>();
		list.add(new B());
		list.add(new C());
		
		List<? extends A> listG = list;
	
			
		for(A a : listG)
		{
			System.out.println(a);
		}
		System.out.println("================");
		
		List<B> listb = new ArrayList<B>();
		listb.add(new B());
		
	    listG = listb;
		
		for(A a : listG)
		{
			System.out.println(a);
		}
		System.out.println("================");
	}
	
	{
		int i =100000;
	}
	
	static
	{
		int i = 29;
	}
	
	private void testGenericSuper()
	{
		List<A> list = new ArrayList<A>();
		list.add(new B());
		list.add(new C());
		
		List<? super A> listG = new ArrayList<A>();;
		listG.add(new B());
		listG.add(new C());
		
		Integer i = new Integer(10);
		int ints  = 	10;
		
		if(i==ints)
			System.out.println("true.,...");
		
		
		List<? super Number> listb = new ArrayList<Number>();
		listb.add(10);
		listb.add(10.1);
		listb.add(new Long(100));
		
		
	
		
		for(Object o : listb)
		{
			System.out.println(o);
		}
	}
	
	private void testUnkownIteration()
	{
		//why ? is used instead of Object . Because List<Integer>, List<String>, List<Double>, are not subtypes of List<Object>
		List<String> list = new ArrayList<String>();
		list.add("test");
		//iterateObject(list);
		iterateUnknownObject(list);
		iterateTypeObject(list);
		//why ? extends Number instead of Number
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		//iterateRestrictedObject(list1);
		iterateExtendsObject(list1);
		
		List<String> lists = new ArrayList<String>();
		List<Integer> listi = new ArrayList<Integer>();
		List<?> listu = lists;
		listu = listi;
		
		List<Object> objects = new ArrayList<Object>();
		objects.add("ds");
		objects.add(1);
		
		List<Number> listn = new ArrayList<Number>();
		listn.add(1.1);
		iterateSuperObject1(listn);
	
		//iterateSuperObject(listi);
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

	
	private static <TEE> void iterateTypeObject(List<TEE> objects)
	{
		objects.add(null);
		for(TEE obj: objects)
			System.out.println("unknown : "+obj);
	}
	
	private static <T extends Integer> void iterateExtendsObjectInt(List<T> objects)
	{
		//objects.add(1);
		for(Number obj: objects)
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
		objects.add(1.1);
		for(Number obj: objects)
			System.out.println("unknown : "+obj);
	}
	
	private static void iterateSuperObject(List<? super Number> objects)
	{
		objects.add(10.1);
		objects.add(10);
		objects.add(null);
	}
	
	private static void iterateSuperObject1(List<? super Integer> objects)
	{
		objects.add(10);
		objects.add(new Integer(1));
		for(Object obj: objects)
			System.out.println("sdf : "+obj);
	}
	
	private static void iterateSuperObject2(List<? super Number> objects)
	{

		objects.add(10);
		objects.add(new Integer(1));
		for(Object obj: objects)
			System.out.println("unknown : "+obj);
	}
}
