package com.satish.semaphone;

import java.util.concurrent.Semaphore;

public class TestSemaphore {

	Semaphore s = new Semaphore(2);
	
	public static void main(String[] args) {
		TestSemaphore ts = new TestSemaphore();
		ts.test();
	}
	
	private  void test()
	{
		new Thread(new RunnableImpl(1, s)).start();
		new Thread(new RunnableImpl(2, s)).start();
		new Thread(new RunnableImpl(3, s)).start();
		new Thread(new RunnableImpl(4, s)).start();
	}
}
