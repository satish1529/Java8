package com.satish.thread.ScheduleExecutorService;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectionExecutionHandlerImpl implements RejectedExecutionHandler {

	String name ;
	
	RejectionExecutionHandlerImpl(String name)
	{
		this.name = name;
	}
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
		System.out.println("inside rejection"+r.toString());
		new Thread(new ThreadGroup(name),r).start();
	}

}
