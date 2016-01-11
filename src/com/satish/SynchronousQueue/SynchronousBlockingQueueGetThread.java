package com.satish.SynchronousQueue;

import java.util.concurrent.Callable;

public class SynchronousBlockingQueueGetThread implements Runnable{

	java.util.concurrent.BlockingQueue<Light> bq = null;
	
	SynchronousBlockingQueueGetThread(java.util.concurrent.BlockingQueue<Light> bq)
	{
		this.bq = bq;
	}
	
	@Override
	public void run() {
	
		try {
			System.out.println("Getting from queue ");
			Light s = bq.take();
			//Thread.sleep(10000);
			System.out.println("got from queue "+s.data);
			s = bq.take();
			System.out.println("got from queue "+s.data);
			s = bq.take();
			System.out.println("got from queue "+s.data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
