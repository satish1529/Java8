package com.satish.generic.example1;

public class Student implements Comparable<Student>{

	String name;
	
	int age;
	
	int marks;

	Student(String name,int age,int marks)
	{
		this.name = name;
		this.age = age;
		this.marks =marks;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the marks
	 */
	public int getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public int compareTo(Student o) {
		if(o.age>this.age)
			return 1;
		else if(o.age<this.age)
			return -1;
		return 0;
	}
	
	
}
