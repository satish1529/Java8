package com.mportal.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
		//testDefault();
	}

	private static void testDefault()
	{
		B b = new B(10,11);
		b.setS("sd");
		b.setSt("sfd");
		B.staticint=11;
		
		/*try(FileOutputStream fos = new FileOutputStream(new File("D://seializeDefault.ser"));
		ObjectOutputStream oos  = new ObjectOutputStream(fos))
		{
		b.writeObject(oos);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try(FileInputStream fis = new FileInputStream(new File("D://seializeDefault.ser"));
				ObjectInputStream ois = new ObjectInputStream(fis)	)
				{
					b.readObject(ois);
				} catch ( IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	private static void test()
	{
		B b = new B(10,11);
		b.setS("sd");
		b.setSt("sfd");
		B.staticint=11;
		System.out.println(b);
		try(FileOutputStream fos = new FileOutputStream(new File("D://seialize.ser"));
				ObjectOutputStream oos  = new ObjectOutputStream(fos))
		{
			oos.writeObject(b);
			
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(FileInputStream fis = new FileInputStream(new File("D://seialize.ser"));
			ObjectInputStream ois = new ObjectInputStream(fis)	)
			{
			      Object o =   ois.readObject();
			      B b1 = (B)o;
			  	System.out.println(b1);
			      System.out.println(b1.getS());
			      System.out.println(b1.getT());
			      System.out.println(b1.getSt());
			      System.out.println(b1.getK());
			      System.out.println(b1.staticint);
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
