package com.satish.test;

import com.sun.scenario.effect.Reflection;

public class Test1 {

	int i ;
	
	private Test1()
	{
		Class c = sun.reflect.Reflection.getCallerClass(2);
		System.out.println(c);
		if(c==Test1.class)
		{
			System.out.println("test1 construct");
		}
		else
		{
			System.out.println("not creating instance");
			throw new SecurityException();
		}
	}
	
	public static Test1 getInstance()
	{
		Test1 t = new Test1();
		return t;
	}
	{
		i=10;
	}
	private Test1(int i)
	{
		System.out.println("test1 construct int");
	}
	
	public int getI()
	{
		/*Class c = sun.reflect.Reflection.getCallerClass(3);
		System.out.println(c);*/
		return i;
	}

}
