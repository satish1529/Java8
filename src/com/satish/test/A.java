package com.mportal.test;

public class A {

	  int i = 99;
	    void amethod() throws Exception
	    {
	        System.out.println("Base.amethod()");
	    }
	    
	    public void bmethod(A a)
	    {
	    	
	    }
	    private final void amethod1(int a)
	    {
	        System.out.println("Base.amethod() arg");
	    }
	    
	    public void bmethod()
	    {
	        System.out.println("a.amethod()");
	        try {
				amethod();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	            
	    A ()
	    {
	        try {
				amethod();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    static Number test(int a) throws NullPointerException
	    {
	    	return new Integer(10);
	    }
	    
	   
	   /* private A test(float a) //throws NullPointerException
	    {
	    	return null;
	    	//return new Integer(10);
	    }*/
}
