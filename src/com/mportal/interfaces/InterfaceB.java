package com.mportal.interfaces;

public interface InterfaceB  extends InterfaceA{

	String interfaceA="sfds";
	
	void testAbstract();
	
	default void testDefaultIntefaceA()
	{
		System.out.println("testDefaultIntefaceB");
		
	}
	
	static void testStaticInterfaceA()
	{
		System.out.println("testStaticInterfaceB");
	}
	
	
}
