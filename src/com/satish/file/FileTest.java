package com.satish.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileTest ft = new FileTest();
		try {
			ft.test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private void addTwoNumbers()
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		String c = sc.nextLine();
		System.out.println(a+b);
		System.out.println(c);
	}
	
	
	private void writeToFile() throws IOException
	{
		File f = new File("D:\\temp\\temp.txt");
		FileWriter w = new FileWriter(f,true);
		w.append("test");
		w.close();
	}
	
	private void reverseNumber()
	{
		int i = 153;
		int n = 0;
		while(i!=0)
		{
			n = n*10;
			n = n+i%10;
			i = i/10;
		}
		System.out.println(n);
	}
	
	private void amstrongNumber()
	{
		int i = 153;
		int n = 0;
		int result = 0;
		while(i!=0)
		{
			n = i%10;
			result = result+n*n*n;
			i = i/10;
		}
		System.out.println(result);
	}
	
	
	private void test()
	{
		/*boolean flag = false;
		boolean flag1 = false;
		if(flag|flag1)
			System.out.println("true");*/
		/*int flag = 1;
		int flag1 = 1;
		System.out.println(flag&flag1);*/
		
		/*int i =-10;
		System.out.println(Integer.toBinaryString(i));*/
		
		new Thread(){
			public void run()
			{
				System.out.println("test");
			}
		}.start();
		
	/* Runnable t = () -> {System.out.println("test");
	 };*/
	// Runnable task2 = () -> { System.out.println("Task #2 is running"); };
	}
	
	
	
}
