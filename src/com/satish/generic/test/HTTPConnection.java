package com.satish.generic.test;

public class HTTPConnection implements Connection{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("HTTPConnection::::::::");
	}

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return "HTTPConnection";
	}

	@Override
	public String get(String s) {
		// TODO Auto-generated method stub
		return "HTTPConnection String";
	}

	@Override
	public void getConsumer(String s) {
		// TODO Auto-generated method stub
		System.out.println("s");
	}

}
