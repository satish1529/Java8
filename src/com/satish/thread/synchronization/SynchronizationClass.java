package com.satish.thread.synchronization;

public class SynchronizationClass {

	public synchronized String testsynchronization()
	{
		System.out.println("before sleep testsynchronization");
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after sleep testsynchronization");
		return "testsynchronization";
	}
	

	public synchronized String testsynchronization1()
	{
		System.out.println("before sleep testsynchronization1");
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after sleep testsynchronization1");
		return "testsynchronization1";
	}
	
	public static synchronized String teststaticsynchronization()
	{
		System.out.println("before sleep teststaticsynchronization");
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after sleep teststaticsynchronization");
		return "teststaticsynchronization";
	}
	

	public static synchronized String teststaticsynchronization1()
	{
		System.out.println("before sleep teststaticsynchronization1");
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after sleep teststaticsynchronization1");
		return "teststaticsynchronization1";
	}
}
