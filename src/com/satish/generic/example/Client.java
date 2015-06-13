package com.satish.generic.example;

import java.util.List;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		
		PredicateImpl<Integer> p = new PredicateImpl<>();
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(5);
		list.add(20);
		list.add(1);
		list.stream().filter(p).forEach(c->System.out.println(c.intValue()));;

	}

}
