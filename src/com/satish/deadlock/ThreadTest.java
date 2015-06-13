package com.satish.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest implements Runnable {

	ReentrantLock obj1 = null;
	ReentrantLock obj2 = null;
	
	public ThreadTest(ReentrantLock obj1,ReentrantLock obj2) {
		// TODO Auto-generated constructor stub
		this.obj1 = obj1;
		this.obj2 = obj2;
	}		
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//deadlock();
		lockTimeout();
	}
	
	private void deadlock()
	{
		System.out.println("Thread name : "+Thread.currentThread().getName());
		synchronized (obj1) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread name inside obj1 : "+Thread.currentThread().getName());
			synchronized (obj2) {
				System.out.println("Thread name inside obj2 : "+Thread.currentThread().getName());
			}
		}
	}
	
	private void lockTimeout()
	{
		try
		{
			System.out.println("Thread name : "+Thread.currentThread().getName());
			if(obj1.tryLock(5, TimeUnit.SECONDS))
			{
				System.out.println("Thread name inside obj1 : "+Thread.currentThread().getName());
				if(obj2.tryLock(3, TimeUnit.SECONDS))
				{
					System.out.println("Thread name inside obj2 : "+Thread.currentThread().getName());
				}
				else
				{
					System.out.println("Not able to get lock on obj2 : "+Thread.currentThread().getName());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		finally
		{
			System.out.println("Lock status obj1 :"+Thread.currentThread().getName()+" "+obj1.isLocked()+ " "+ obj1.isHeldByCurrentThread());
			System.out.println("Lock status obj2 :"+Thread.currentThread().getName()+" "+obj2.isLocked()+ " "+ obj2.isHeldByCurrentThread());
			
			if(obj1.isHeldByCurrentThread())
				obj1.unlock();
			if(obj2.isHeldByCurrentThread())
				obj2.unlock();
		}
		
	}

}
