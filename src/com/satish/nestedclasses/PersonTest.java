package com.satish.nestedclasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		personTest();
	}
	
	private static void personTest()
	{
		//Reference by static method
		Person [] personArray = {new Person("satish"),new Person("atish"),new Person("tish")};
		Arrays.sort(personArray,Person::compare);
		System.out.println(personArray[0]+" "+personArray[1]+" "+personArray[2]);
		
		//Using lamda expression by comparator interface
		Person [] personArray1 = {new Person("satish"),new Person("atish"),new Person("tish")};
		Arrays.sort(personArray1, ( a ,  b) -> {
			return a.getA().compareTo(b.getA());
			}
		); 
		System.out.println(personArray1[0]+" "+personArray1[1]+" "+personArray1[2]);
		
		//reference by instance method of particular object
		Person [] personArray2 = {new Person("satish"),new Person("atish"),new Person("tish")};
		PersonComparision pc = new PersonComparision();
		Arrays.sort(personArray2,pc::compareByName);
		System.out.println(personArray2[0]+" "+personArray2[1]+" "+personArray2[2]);
		
		//Reference to an Instance Method of an Arbitrary Object of a Particular Type
		String[] stringArray = { "Barbara", "James", "Mary", "John",
			    "Patricia", "Robert", "Michael", "Linda" };
		Arrays.sort(stringArray, String::compareToIgnoreCase);
		for(String s : stringArray)
			System.out.print(s+" ");
	}

}
