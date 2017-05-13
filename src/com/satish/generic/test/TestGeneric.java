package com.satish.generic.test;

import java.util.List;

public class TestGeneric<T> {

	T t;
	
	public void execute(T t)
	{
		
	}
	
	public void test(List<? super Connection> list)
	{
		list.add(new HTTPConnection());
		list.add(new WSConnection());
	}
}
