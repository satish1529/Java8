package com.mportal.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import sun.misc.Unsafe;

public class unsafe {

	public static void main(String[] args) {
		test();
		//System.out.println(Check("5083598160453421"));
		
	}
	
	private static void test()
	{
		try {
			
			Field field =	Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			Unsafe unsafe = (Unsafe) field.get(null);
			
			Test1 t = (Test1)unsafe.allocateInstance(Test1.class);
		System.out.println(t.getI()+"----");
		Test1.getInstance();
		
			Constructor[] cs  = Test1.class.getDeclaredConstructors();
			for(Constructor c : cs)
			{
				c.setAccessible(true);
				if(c.getParameterCount()==0)
					c.newInstance(null);
				else
					c.newInstance(1);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void test1()
	{
		List<String> params = new ArrayList<String>() {
            {
                add("param one");
                add("param two");
                add("param three");
                add("param four");
            }
        };
        
        if("2.01".equals("2.01"))
        {
        	System.out.println("sdfsdsdsssss");
        	
        }
        else{
        System.out.println("Sdfsd");
        }
        System.out.println("Sdfsd");
	}
	
	public static boolean Check(String ccNumber)
    {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}
