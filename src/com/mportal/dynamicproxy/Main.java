package com.mportal.dynamicproxy;

import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	private static void test()
	{
		InterfaceA i = (InterfaceA)MyProxy.newInstance(new InterfaceAImpl());
		System.out.println("proxy  created "+i);
		i.test("satish", 100);
	}
}
