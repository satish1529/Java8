package com.satish.nestedclasses;

public class A {

	int i = 0;
	private static int j = 0;
	
	private void testA()
	{
		
	}
	
	Runnable r = () -> System.out.println("test");
	
	
	
	interface AI{
		
	}
	 class A1{
		//final static int j=1;
		int k = 0;
		private  void test(int a , int b)
		{
			final int ji = 0;
			
			class B{
				
				final static int m = 0;
				
				private  void testing()
				{
					System.out.println(a);
				}
				
			}
			
			Thread t =new Thread(new Runnable(){

				int m =0;
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(m);
				}
				
			});
			
		}
		
	}
}
