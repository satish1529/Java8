package com.mportal.generic.example;

import java.util.function.Predicate;

public class PredicateImpl<T extends Number> implements Predicate<T>
{
	int count;


	@Override
	public boolean test(T t) {
		if(t.doubleValue() > 10)
			return true;
		return false;
	}

	
	
}
