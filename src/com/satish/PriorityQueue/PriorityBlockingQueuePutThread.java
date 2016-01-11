package com.satish.PriorityQueue;

import java.util.concurrent.Callable;

public class PriorityBlockingQueuePutThread implements Runnable {

	java.util.concurrent.BlockingQueue<String> bq = null;
	
	PriorityBlockingQueuePutThread(java.util.concurrent.BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	
	@Override
	public void run()  {
	
		 try {
			 System.out.println("putting to queue");
			 String s = "test";
			bq.put(s);
			bq.put("atest1");
			bq.put("dtest2");
			bq.put("ctest3");
			bq.put("atest4");
			System.out.println(bq);
			System.out.println(bq.remainingCapacity());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
