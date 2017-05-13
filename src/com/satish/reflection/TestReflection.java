package com.satish.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TestReflection {

	public static void main(String[] args) {
		test();
	}
	
	private static void test()
	{
		B b = new B();
		Class c = b.getClass();
		TypeVariable[] types =c.getTypeParameters();
		for(TypeVariable t : types)
			System.out.println(t.getName());
		System.out.println(Modifier.toString(c.getModifiers()));
		Class [] interfaces = c.getInterfaces();
		for(Class cl : interfaces)
			System.out.println("interfaces : "+cl.getName());
		
		Type [] ginterfaces = c.getGenericInterfaces();
		
		for(Type cl : ginterfaces)
			System.out.println("generic interfaces : "+cl.getClass().getName());
		
		 Field [] dfields = c.getDeclaredFields();
		 for(Field df : dfields)
		 {
			 System.out.println("declared fields : "+df.toGenericString()+", type :  "+df.getType()+", gtype : "+df.getGenericType());
		 }
		 Field [] fields = c.getFields();
		 for(Field f : fields)
		 {
			 System.out.println("fields : "+f.toGenericString()+", type :  "+f.getType()+", gtype : "+f.getGenericType());
		 }
			 
		 
		 try {
			Field field = c.getField("sdf");
			field.setAccessible(true);
			field.setInt(b, 10);
			System.out.println("field : "+field.getName()+", value : "+b.sdf);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 Method [] methods = c.getDeclaredMethods();
		 for(Method method : methods)
		 {
			 try {
				 System.out.println(method);
				 if(method.getName().startsWith("set"))
				 {
					 method.invoke(b, 10);
					 System.out.println(b.t);
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 try {
			Method m = c.getMethod("segting");
			
			System.out.println(m.getName());
			int o = (int)m.invoke(b, null);
			Object o1 = m.invoke(b, new Object[0]);
			System.out.println(o);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
				Method m = c.getMethod("geting",int.class,String.class);
				System.out.println(m.getName());
				m.invoke(b,10,"s");
			} catch (Exception  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 Annotation[] as = c.getAnnotations();
		 for(Annotation a : as)
		 {
			
		 }
		 
		 
		 
	}
}
