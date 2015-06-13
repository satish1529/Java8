package com.satish.size;

import java.lang.instrument.Instrumentation;

public class MyAgent {
	
	 private static volatile Instrumentation instrumenter;
	
	public static void premain(String args, Instrumentation inst) {
		instrumenter = inst;
	  }
	
	 public static long getObjectSize(Object o) {
	        return instrumenter.getObjectSize(o);
	    }

}
	