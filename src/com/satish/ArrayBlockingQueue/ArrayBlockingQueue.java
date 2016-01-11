	package com.satish.ArrayBlockingQueue;

import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;


public class ArrayBlockingQueue {

	public static void main(String[] args) {
		ArrayBlockingQueue abq = new ArrayBlockingQueue();
		abq.testPutAndGet();
	}
	
	private void test()
	{
		java.util.concurrent.BlockingQueue<String> bq =  new java.util.concurrent.ArrayBlockingQueue<String>(2);
		bq.offer("test");
		bq.offer("test1");
		bq.offer("test2");
		try {
			bq.put("test3");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void testPutAndGet()
	{
		//Arrayblocking is fixed size
		//internally it stores as array
		//fairness policy if set to true , then order of FIFO is gauranteed
		//While calling put , if queue is full , it will wait till space is available
		//while calling get , if queue is empty , it will wait till some element gets added.
		//does not allow null values
		//is threadsafe because it uses internal locks 
		
		//LinkedBlockingQueue is optionally bounded Queue by default it is Integer.MAX_VALUE ( 2 power 31 -1)
		//internally stores as linked nodes
		java.util.concurrent.BlockingQueue<String> bq =  new java.util.concurrent.ArrayBlockingQueue<String>(2);
		ArrayBlockingQueuePutThread putThread = new ArrayBlockingQueuePutThread(bq);
		ArrayBlockingQueueGetThread getThread = new ArrayBlockingQueueGetThread(bq);
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
