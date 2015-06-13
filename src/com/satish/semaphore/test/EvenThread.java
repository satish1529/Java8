package com.satish.semaphore.test;

import java.util.concurrent.Semaphore;

public class EvenThread implements Runnable {

	Semaphore s = null;
	
	EvenThread(Semaphore s)
	{
		this.s = s;
	}
			
	@Override
	public void run() {
		
			try
			{
			for(int i =1;i<10;i++)
			{
				
				if(i%2==0)
					System.out.println(i);
				else
				{
					synchronized (s) {
						s.notify();
						s.wait();
					}
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}

}
