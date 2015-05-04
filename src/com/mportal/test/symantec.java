package com.mportal.test;

public class symantec {
	
	/*public static void main(String[] args) {
		int [] x = {-8,-3,-7};
		int [] y = {-1,4,5	};
		int k  = 2;
		testing(x,y,k);
	}
	
	private static  void testing(int [] x ,int [] y , int k)
	{
		int maxX = x[0];
		int min = maxX;
		for(int i=1;i<x.length;i++)
		{
			int temp = x[i];
			if(maxX<temp)
				maxX = temp;
			else if(min > temp)
				min = temp;
			
		}
		for(int i=0;i<y.length;i++)
		{
			int temp = y[i];
			if(maxX<temp)
				maxX = temp;
			else if(min > temp)
				min = temp;
			
		}
		System.out.println(maxX);
		System.out.println(min);
		min  = min+1;
		maxX = maxX+1;
		System.out.println((min+maxX)*(min+maxX));
	}*/

	public static void main(String[] args) {
		//int d [] = {12,-5,-1,1,12,3,-2,13,9,-6,-1,8,3,5,2,1,3,7,-1,1,-8,8,0,-7,12,-5,-1,1,12,3,-2,13,9,-6,-1,8,3,5,2,1,3,7,-1,1,-8,8,0,-7,12,-5,-1,1,12,3,-2,13,9,-6,-1,8,3,5,2,1,3,7,-1,1,-8,8,0,-7,12,-5,-1,1,12,3,-2,13,9,-6,-1,8,3,5,2,1,3,7,-1,1,-8,8,0,-7};
		int d [] = {12,-5,-1,1,12,3,-2,13,9,-6,-1,8,3,5,2,1,3};
		int t = 8;
		triplet(t,d);
		System.out.println("===========");
		triplet1(t,d);
	}
	
	private static void triplet(int t ,int[] d)
	{
		long startTime = System.currentTimeMillis();
		int tempTotal = 0;
		int count=0;
		int length = d.length;
		int lengthI = d.length;
		for(int i =0;i<lengthI;i++)
		{
			tempTotal = d[i];
			//if(tempTotal<t)
			{
				for(int j =i+1;j<length;j++)
				{
					tempTotal = tempTotal+d[j];
					if(tempTotal>t)
					{
						tempTotal = d[i];
						continue;
					}
					for(int k = j+1;k<length;k++)
					{
						tempTotal = tempTotal+d[k];
						if(tempTotal>t)
						{
							continue;
						}
						
					    System.out.println(tempTotal +" =  "+d[i]+" "+d[j]+" "+d[k]);
					    count++;
					    tempTotal = d[i]+d[j];
						
					    
					}
					tempTotal = d[i];
				}
			}
		}
		System.out.println(count);
		System.out.println(System.currentTimeMillis()-startTime);
	}
	
	private static void triplet1(int t ,int[] d)
	{
		long startTime = System.currentTimeMillis();
		int tempTotal = 0;
		int count=0;
		int length = d.length;
		int lengthI = d.length-2;
		for(int i =0;i<lengthI;i++)
		{
			tempTotal = d[i];
			int j = i;
			while(j<lengthI)
			{
				if(d[j]+d[j+1]+d[j+2]<=t)
					count++;
				j++;
			}
		}
		System.out.println(count);
		System.out.println(System.currentTimeMillis()-startTime);
	}
}
