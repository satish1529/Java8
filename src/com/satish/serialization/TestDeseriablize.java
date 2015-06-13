package com.satish.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestDeseriablize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileInputStream fis = new FileInputStream(new File("E://test.txt"));
				ObjectInputStream ois = new ObjectInputStream(fis)	)
				{
			Test t = (Test)ois.readObject();
			System.out.println(t.getI());
				} catch ( IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
