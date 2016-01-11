package com.satish.ArrayBlockingQueue;

import java.util.concurrent.Callable;

public class ArrayBlockingQueuePutThread implements Runnable {

	java.util.concurrent.BlockingQueue<String> bq = null;
	
	ArrayBlockingQueuePutThread(java.util.concurrent.BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	
	@Override
	public void run()  {
	
		 try {
			 System.out.println("putting to queue");
			 String s = "test";
			bq.put(s);
			bq.put("test1");
			bq.put("test2");
			bq.put(null);
			bq.put(null);
			System.out.println(bq);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
