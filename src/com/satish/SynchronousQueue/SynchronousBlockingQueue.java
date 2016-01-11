package com.satish.SynchronousQueue;

import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;


public class SynchronousBlockingQueue {

	public static void main(String[] args) {
		SynchronousBlockingQueue abq = new SynchronousBlockingQueue();
		abq.testPutAndGet();
	}
	
	private void test()
	{
		
	}
	
	private void testPutAndGet()
	{
		//Synchronous Queue is an 0 capacity queue
		// put will wait till other thread is ready to recieve it and vice versa.
		// doesn't allow null
	
		java.util.concurrent.BlockingQueue<Light> bq =  new java.util.concurrent.SynchronousQueue<Light>();
		SynchronousBlockingQueuePutThread putThread = new SynchronousBlockingQueuePutThread(bq);
		SynchronousBlockingQueueGetThread getThread = new SynchronousBlockingQueueGetThread(bq);
		Thread putT = new Thread(putThread);
		Thread putG = new Thread(getThread);
		try {
			putG.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			putT.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
