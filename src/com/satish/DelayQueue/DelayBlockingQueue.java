package com.satish.DelayQueue;

import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;


public class DelayBlockingQueue {

	public static void main(String[] args) {
		DelayBlockingQueue abq = new DelayBlockingQueue();
		abq.testPutAndGet();
	}
	
	private void test()
	{
		
	}
	
	private void testPutAndGet()
	{
		//DelayQueue is an unbounded queue
		// it provided natural ordering by default
		// doesn't allow null
		java.util.concurrent.BlockingQueue<Light> bq =  new java.util.concurrent.DelayQueue<Light>();
		DelayBlockingQueuePutThread putThread = new DelayBlockingQueuePutThread(bq);
		DelayBlockingQueueGetThread getThread = new DelayBlockingQueueGetThread(bq);
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
