package com.satish.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.Unsafe;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	private static void testEx()
	{
		
		Pattern p =Pattern.compile("^(?!a)[a-z]?$");
		p =Pattern.compile("^\\+12 [12]{4}$");
		p =Pattern.compile("^(x.*)?$");
		p =Pattern.compile("^(xyz){3}$");
		p =Pattern.compile("^[ABD-HJLNP-UW-Z]$");
		p =Pattern.compile("^(.+)@[0-9a-zA-Z]+\\.(com)$");
		p = Pattern.compile("^(?<month>[0-3]?[0-9])/(?<day>[0-3]?[0-9])/(?<year>(?:[0-9]{2})?[0-9]{2})$");
		Matcher m = p.matcher("10/11/2012");
		System.out.println(m.matches());
		
	}
	
	private static void test()
	{
		Unsafe.getUnsafe();
		
	}
}
