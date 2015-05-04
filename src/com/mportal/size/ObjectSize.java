package com.mportal.size;

import java.lang.instrument.Instrumentation;

public class ObjectSize {

    private int i; // 4 bytes
    private char j; // 2 bytes

   
    
    public static void main(String[] args) {
                    getObjectSize();
    }

    
    
    private static void getObjectSize()
    {
    	 	  System.out.println("size of object :"+MyAgent.getObjectSize(new ObjectSize()));
    }
}

