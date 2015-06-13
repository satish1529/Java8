package com.satish.thread.synchronization;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestSynchronizaiton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			test();
		} catch (InterruptedException | ExecutionException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void test() throws InterruptedException, ExecutionException
	{
		SynchronizationClass sc = new SynchronizationClass();
		
		Runnable r = ()->{SynchronizationClass.teststaticsynchronization();};
		System.out.println("running main");
		Thread t = new Thread(r);
		Runnable r1 = ()->{SynchronizationClass.teststaticsynchronization1();};
		Thread t1 = new Thread(r1);
		ExecutorService es = Executors.newFixedThreadPool(2);
		//es.execute(t);
		//es.execute(t1);
	    Future f = es.submit(t);
	   System.out.println(f.get());
	    Future f1 = es.submit(t1);
	    System.out.println(f1.get());
		System.out.println("still running");
	}

}
