package com.mportal.test;

import java.util.Arrays;
import java.util.Comparator;

public class Primes2 {
public static void main(String[] args) {
Integer[] primes = {2, 7, 5, 3};
MySort ms = new MySort();
Arrays.sort(primes, ms);
for(Integer p2: primes)
System.out.print(p2 + " ");
	
}
static class MySort implements Comparator<Integer> {

	public int compare(Integer x, Integer y) {
return y.compareTo(x);
}

}
}