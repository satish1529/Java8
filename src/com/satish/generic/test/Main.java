package com.satish.generic.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.satish.thread.ScheduleExecutorService.RunnableImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric<Connection> tg = new TestGeneric<Connection>();
		Connection c = new HTTPConnection();
		tg.execute(c);
		
		List<Connection> list  = new ArrayList<>();
		tg.test(list);
		
		list.parallelStream().map(Connection::get);
		
		list.parallelStream().map(Connection::get);
		try {
			test();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void test() throws InterruptedException
	{
		BlockingQueue<String> bq = new LinkedBlockingQueue<String>();
		
		bq.put("test");
		
		System.out.println(bq.poll(10, TimeUnit.SECONDS));
		
		//System.out.println(bq.poll(10, TimeUnit.SECONDS));
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					System.out.println(bq.poll(10, TimeUnit.SECONDS));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		bq.clear();
		
		bq.put("test1");
		System.out.println(bq);
	}

}
