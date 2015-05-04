/**
 * 
 */
package com.mportal.semaphore.test;

import java.util.concurrent.Semaphore;

/**
 * @author satish.k
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	private static void test()
	{
		Semaphore s = new Semaphore(1);
		EvenThread et = new EvenThread(s);
		OddThread ot = new OddThread(s);
		new Thread(et).start();
		new Thread(ot).start();
	}
}
