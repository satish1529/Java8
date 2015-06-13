package com.satish.dynamicproxy;

import java.lang.reflect.Proxy;

public class MyProxy {

	public static Object newInstance(Object obj)
	{
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class<?> []{InterfaceA.class}, new MyInvocationHandler(obj));
	}
}
