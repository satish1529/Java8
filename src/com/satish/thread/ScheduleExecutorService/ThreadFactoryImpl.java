package com.mportal.thread.ScheduleExecutorService;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;

public class ThreadFactoryImpl implements ThreadFactory {

String name ;
	
ThreadFactoryImpl(String name)
	{
		this.name = name;
	}
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(new ThreadGroup(name),r);
		t.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("exception : "+t.getName()+ " name :"+e.getClass());
			}
		});
		return t;
	}

}
