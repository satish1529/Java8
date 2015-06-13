package com.satish.generic.example1;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		
		Student s = new Student("satish",32,90);
		Student s1 = new Student("aatish",31,80);
		Student s2 = new Student("datish",30,20);
		Student s3 = new Student("zatish",22,98);
		Student s4 = new Student("matish",29,95);
		
		List<Student> list = new ArrayList<>();
		list.add(s);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		
		
		list.stream().sorted(new MarkComparator().thenComparing(new FunctionImpl())).sorted().forEach(p->System.out.println(p.getName()));
		System.out.println("=======");
		list.stream().sorted(new MarkComparator().thenComparing(new AgeComparator())).sorted().forEach(p->System.out.println(p.getName()));
	}

}
