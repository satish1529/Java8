package com.satish.http;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;

public class TestGC {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	test();
	    int a = 13;
	    System.out.println(a>>>2);
	}

	public static void test()
	{
		List l = new ArrayList();
		for(;;)
		{
			l.add("test");
		}
	}
	
	
}



