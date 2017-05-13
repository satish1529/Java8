package com.satish.generics;

public class TestGeneric {

	int data;
	
	public void setData(int a){
		System.out.println("super ::::"+a);
		this.data = a;
	}
}

class TestG extends TestGeneric{
	
	public void setData(Integer i){
		super.setData(i);
		System.out.println("sub ::::"+i);
	}
	
	
//	public void setData(Number i){
//		System.out.println("Number ::::"+i);
//	}
	
	public void setData(Float i){
		System.out.println("float ::::"+i);
	}
	
/**	public void setData(char i){
		System.out.println("char ::::"+i);
	}
	
	public void setData(byte i){
		System.out.println("byte ::::"+i);
	}*/
	
//	public void setData(int i){
	//	System.out.println("int ::::"+i);
	//}
	
	public void setData(long i){
		System.out.println("long ::::"+i);
	}
	
	
}
