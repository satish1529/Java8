package com.satish.hashmap;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class Client {

	static Map map = new WeakHashMap<String,String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
	
		System.out.println(map);
		System.gc();
		System.out.println(map);
		//test1();
		
	}

	static void test()
	{	
		WeakReference<String> wr = new WeakReference<String>("test");
		
		map.put(wr, "sfd");
		System.out.println(map);
		System.out.println(map.get(wr));
		
		
	}
	
	static void test1()
	{	
		WeakReference<String> wr = new WeakReference<String>("test");
		
		map.put(wr, "sfd");
		System.out.println(map);
		System.out.println(map.get(wr));
		
		
	}
}
