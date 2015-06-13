package com.satish.test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Test {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Test().test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void test() throws Exception
	{
		boolean t = false;
		if(t==true)
			System.out.println("true");
		Boolean b = new Boolean("sd");
		System.out.println(b.booleanValue());
	}*/
	
	static int x[] =new int[]{0,0,0}	;
	public static  void main(String [] args) 
    {
		/*Map<A,String> m= new WeakHashMap<>();
		A a = new A();
		
		m.put(a, "sds");
		
System.gc();
		
		for(Object o : m.keySet())
		{
			System.out.println(((A)o).i);
		}
	
		
	    a= null;
	    
System.gc();
		
		for(Object o : m.keySet())
		{
			System.out.println(((A)o).i);
		}
	*/
		StringBuffer sb = new StringBuffer("java language");
		test(sb);
		System.out.println(sb.toString());
		System.out.println(bit(0X00000000));
    }
	
	static int bit(int n)
	{
	return (n + (n|~n));
	}
	
	private static void test(StringBuffer sb)
	{
		sb.append("sdf");
		sb = null;
	}

}
