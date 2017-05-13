package com.satish.generics;

public class Test1 {

	public static void main(String[] args) {
		
		TestG t = new TestG();
		TestGeneric t1 = new TestGeneric();
		//t1.setData("sd");
		int b = 1;
		t.setData('c');
	//	t.setData(1.1);
		//t.setData(1);
		Integer i = t.data;
		System.out.println(t instanceof TestGeneric);
		System.out.println(t1.getClass().isAssignableFrom(TestG.class));
		System.out.println(t1.getClass().isAssignableFrom(TestGeneric.class));
		
		System.out.println(t.getClass().isAssignableFrom(TestG.class));
		System.out.println(t.getClass().isAssignableFrom(TestGeneric.class));
	}
}
