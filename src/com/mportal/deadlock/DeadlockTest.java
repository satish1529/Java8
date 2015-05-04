package com.mportal.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockTest {

	public static void main(String[] args) {
		ReentrantLock obj1 = new ReentrantLock();
		ReentrantLock obj2 = new ReentrantLock();
		Thread t1 = new Thread(new ThreadTest(obj1, obj2));
		Thread t2 = new Thread(new ThreadTest(obj2, obj1));
		t1.start();
		t2.start();
	}
}
