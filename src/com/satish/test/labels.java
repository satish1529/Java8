package com.satish.test;

public class labels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	private static void test()
	{
		outer : for(int i =0;i<3;i++)
		{
			inner : for(int j = 0;j<3;j++)
			{
				System.out.println(i+" "+j);
				if(i==1)
				{
					continue outer;
				}
					
			}
		}
	}

}
