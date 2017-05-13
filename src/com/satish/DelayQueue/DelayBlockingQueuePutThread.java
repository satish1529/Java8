package com.satish.DelayQueue;

import java.util.concurrent.Callable;

public class DelayBlockingQueuePutThread implements Runnable {

	java.util.concurrent.BlockingQueue<Light> bq = null;
	
	DelayBlockingQueuePutThread(java.util.concurrent.BlockingQueue<Light> bq)
	{
		this.bq = bq;
	}
	
	@Override
	public void run()  {
	
		 try {
			 System.out.println("putting to queue");
			Light l = new Light(11,1000);
			bq.put(l);
			bq.put(l);
			System.out.println("put");
			l = new Light(10,3000);
			bq.put(l);
			System.out.println("put");
			l = new Light(30,1);
			bq.put(l);
			System.out.println("put");
			System.out.println(bq);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
