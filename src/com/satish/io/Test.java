package com.satish.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		takeinput();
	}

	private static void takeinput()
	{
		Scanner s = new Scanner(System.in);
		/*while(s.hasNext())
		{
			System.out.println(s.next());
		}*/
		
		/*int i = s.nextInt()+s.nextInt();
		System.out.println(i);*/
		
		
		/*try(DataOutputStream dos  = new DataOutputStream(System.out);) {
			dos.writeUTF("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*A a  = new A();
		a.setI(10);
		a.setS("sd");
		B b = new B();
		b.setJ(11);
		a.setA(b);
		try(ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("E://test.txt")))))
		{
			os.writeObject(a);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		Path p = Paths.get("E://test.txt");
		/*System.out.println(p.toUri());
		System.err.println("est");
		*/
		File f = new File("D://MyTWCWorkspace");
		
		Path p1 = Paths.get("E://test1.txt");
		/*try {
			System.out.println(Files.isSameFile(p,p1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			List<String> list = Files.readAllLines(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			//Files.createLink(p1, p);
			Files.createSymbolicLink(p1,p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

