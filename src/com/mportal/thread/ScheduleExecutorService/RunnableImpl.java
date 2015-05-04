package com.mportal.thread.ScheduleExecutorService;

import java.util.*;
import java.util.concurrent.Callable;

public class RunnableImpl implements Runnable{

	int count;
	
	public RunnableImpl(int count) {
		// TODO Auto-generated constructor stub
		this.count = count;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("before runnable : "+new Date()+ " : "+Thread.currentThread().getName()+" , "+count);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count==1)
			throw new ArrayIndexOutOfBoundsException();
		System.out.println("after runnable : "+new Date()+ " : "+Thread.currentThread().getName()+" , "+count);
	}

	
	

}
