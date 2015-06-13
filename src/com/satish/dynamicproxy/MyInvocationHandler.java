/**
 * 
 */
package com.satish.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author satish.k
 *
 */
public class MyInvocationHandler implements InvocationHandler {

	 private Object obj;
	MyInvocationHandler(Object obj)
	{
		this.obj = obj;
	}
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("invoke......");
		System.out.println(method.getName()+method.getClass());
	    test();
		return method.invoke(obj, args);
	
	}

	private void test()
	{
		String s = "testing";
		System.out.println(s.toUpperCase());
	}
}
