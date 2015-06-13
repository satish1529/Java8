package com.mportal.thread.ScheduleExecutorService;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestScheduleExecutorService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			test();
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void test() throws InterruptedException, ExecutionException, TimeoutException
	{
		/*ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
		Callable c = new CallableImpl();
		ScheduledFuture<List> sf = ses.schedule(c, 5, TimeUnit.SECONDS);
		System.out.println("scheduled");
		//List list = sf.get();
		//System.out.println(list);
		
		ScheduledFuture sf1 =ses.scheduleAtFixedRate(new RunnableImpl(), 1, 5, TimeUnit.SECONDS);
		//ses.scheduleWithFixedDelay(new RunnableImpl(), 4, 5, TimeUnit.SECONDS);
		System.out.println(sf1.get()+"  done");*/
		ExecutorService ex = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1),new ThreadFactoryImpl("satish"),new RejectionExecutionHandlerImpl("satish"));
		
		ex.execute(new RunnableImpl(1));
		ex.execute(new RunnableImpl(2));
		ex.execute(new RunnableImpl(3));
		ex.execute(new RunnableImpl(4));
		
	}
}
