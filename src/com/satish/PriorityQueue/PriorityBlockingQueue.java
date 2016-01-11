package com.satish.PriorityQueue;

import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;


public class PriorityBlockingQueue {

	public static void main(String[] args) {
		PriorityBlockingQueue abq = new PriorityBlockingQueue();
		abq.testPutAndGet();
	}
	
	private void test()
	{
		
	}
	
	private void testPutAndGet()
	{
		//PriorityBlocking is an unbounded queue
		// it provided natural ordering by default
		// doesn't allow null
	
		java.util.concurrent.BlockingQueue<String> bq =  new java.util.concurrent.PriorityBlockingQueue<String>(2);
		PriorityBlockingQueuePutThread putThread = new PriorityBlockingQueuePutThread(bq);
		PriorityBlockingQueueGetThread getThread = new PriorityBlockingQueueGetThread(bq);
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
