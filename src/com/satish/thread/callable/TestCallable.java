package com.satish.thread.callable;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test("Sd");
	}

	private static void test() throws Exception
	{
		Callable c = new CallableImpl();
		ExecutorService es = Executors.newCachedThreadPool();
		Future<List> f = es.submit(c);
		Future<List> f1 = es.submit(c);
		try
		{
		List s = f.get();
		List s1 = f1.get();
		}catch(Exception e)
		{
			System.out.println("exception");
		}
		/*System.out.println(s);
		System.out.println(s1);*/
	}
	
	/*private static void test(String s)
	{
		System.out.println("string : " +s);
	}*/
	
	private static void test(Object s)
	{
		System.out.println(" object : "+s);
	}
}
