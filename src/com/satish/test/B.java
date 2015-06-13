package com.satish.test;

public class B  extends A{

	 int i = -1;
     
	    public static void main(String argv[])
	    {
	        A a = new B();
	        a.bmethod();
	        a.bmethod((B)a);
	        System.out.println(a.i);
	      /*//  b.amethod();
	        a.bmethod();
	        B b = new B();
	        b.amethod1((short)1);*/
	    }
	    
	    public void bmethod(A a)
	    {
	    	System.out.println(a.i+"  ds");
	    }
	    public void bmethod()
	    {
	        System.out.println("b.amethod()");
	        try {
	        	i=100;
				amethod();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    public Integer test(float a) throws NullPointerException
	    {
	    	return new Integer(10);
	    }
	    
	  
	    void amethod() throws Exception
	    {
	        System.out.println("Base.amethod()");
	        return ;
	    }
	    
	  /*  void amethod1(int a)
	    {
	        System.out.println("int "+a);
	    }*/
	   /* void amethod1(byte a)
	    {
	        System.out.println("byte "+a);
	    }*/
	    
	  /*  void amethod1(short a)
	    {
	        System.out.println("short "+a);
	    }*/
	    
	   /* void amethod1(char a)
	    {
	        System.out.println("char "+a);
	    }*/
	    
	   /* void amethod1(long a)
	    {
	        System.out.println("long "+a);
	    }*/
	    
	  /*  void amethod1(float a)
	    {
	        System.out.println("float "+a);
	    }*/
	    
	    void amethod1(double a)
	    {
	        System.out.println("double "+a);
	    }
}
