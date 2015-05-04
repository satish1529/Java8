package com.mportal.generic.example1;

import java.util.Comparator;
import java.util.function.Function;

public class FunctionImpl implements Function<Student, Student> {

	@Override
	public Student apply(Student t) {
		return t;
	}

}
