package com.satish.generic.test;

public class WSConnection implements Connection {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("WSConnection::::::::");
	}
	
	@Override
	public String get() {
		// TODO Auto-generated method stub
		return "WSConnection";
	}

	@Override
	public String get(String s) {
		// TODO Auto-generated method stub
		return "WSConnection String";
	}

	@Override
	public void getConsumer(String s) {
		// TODO Auto-generated method stub
		System.out.println(s);
	}

}
