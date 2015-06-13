package com.satish.stringbuffer;

import java.net.Socket;

public class TEst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	private static void test()
	{
		StringBuffer s = new StringBuffer();
		s.append("dsd");
		s.insert(1, "bad");
		s.delete(0, 3);
		s.insert(2, 11.2);
		System.out.println(s.indexOf("2", 0));
		System.out.println(s.substring(0, 3));
		s.toString();
		System.out.println(s);
		
	}
	
}
