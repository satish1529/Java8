package com.satish.PriorityQueue;

import java.util.concurrent.Callable;

public class PriorityBlockingQueueGetThread implements Runnable{

	java.util.concurrent.BlockingQueue<String> bq = null;
	
	PriorityBlockingQueueGetThread(java.util.concurrent.BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	
	@Override
	public void run() {
	
		/*try {
			System.out.println("Getting from queue ");
			String s = bq.take();
			//Thread.sleep(10000);
			s = bq.take();
			System.out.println("got from queue "+s);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
