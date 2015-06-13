package com.mportal.semaphone;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class RunnableImpl implements Runnable{

	int count;
	Semaphore semaphore;
	
	public RunnableImpl(int count,Semaphore s) {
		// TODO Auto-generated constructor stub
		this.count = count;
		this.semaphore = s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("before runnable : "+new Date()+ " : "+Thread.currentThread().getName()+" , "+count);
		try {
			semaphore.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semaphore.release();
		System.out.println("after runnable : "+new Date()+ " : "+Thread.currentThread().getName()+" , "+count);
	}

	
	

}
