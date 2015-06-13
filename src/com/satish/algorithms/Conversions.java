package com.mportal.algorithms;

public class Conversions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convertDecimalToBinary();
		convertDecimalToHexDecimal();
		convertDecimalToOctal();
		convertBinaryToDecimal();
		convertHexToDecimal();
		convertOctalToDecimal();
	}

	private static void convertDecimalToBinary()
	{
		int i =30;
		int temp = i;
		int[] rem = new int[8];
		int count = rem.length-1; 
		while(i>0)
		{
			rem[count] = i%2;
			i = i/2;
			count--;
		}
		
		System.out.print("converting Decimal "+temp+" to Binary : ");
		for(int j =0;j<rem.length;j++)
		{
			System.out.print(rem[j]);
		}
		System.out.println();
	}
	
	private static void convertDecimalToHexDecimal()
	{
		int i  = 30;
		int temp = i;
		StringBuffer sb = new StringBuffer();
		int j ;
		while(i>0)
		{
			j = i%16;
			switch(j)
			{
				case 10 :
					sb.append('A');
					break;
				case 11 :
				    sb.append('B');
				    break;
				case 12 :
				    sb.append('C');
				    break;
				case 13 :
				    sb.append('D');
				    break;
				case 14 :
				    sb.append('E');
				    break;
				case 15 :
				    sb.append('F');
				    break;
				default :
					sb.append(j);
					break;
			}
			i = i/16;
		}
		System.out.print("converting Decimal "+temp+" to Hex : ");
		System.out.print(sb.reverse().toString());
		System.out.println();
	}
	
	private static void convertDecimalToOctal()
	{
		int i  = 30;
		int temp = i;
		StringBuffer sb = new StringBuffer();
		int j ;
		while(i>0)
		{
			j = i%8;
			sb.append(j);
			i = i/8;
		}
		System.out.print("converting Decimal "+temp+" to Octal : ");
		System.out.print(sb.reverse().toString());
		System.out.println();
	}
	
	private static void convertBinaryToDecimal()
	{
		int i = 11111111;
		int temp =i;
		int sum = 0;
		int j ;
		int count=0;
		while(i>0)
		{
			j = i%10;
			sum = (int) (sum +Math.pow(2, count)*j);
			i = i/10;
			count++;
		}
		System.out.print("converting Binary "+temp+" to Decimal : ");
		System.out.print(sum);
		System.out.println();
	}
	
	private static void convertOctalToDecimal()
	{
		int i = 36;
		int temp =i;
		int sum = 0;
		int j ;
		int count=0;
		while(i>0)
		{
			j = i%10;
			sum = (int) (sum +Math.pow(8, count)*j);
			i = i/10;
			count++;
		}
		System.out.print("converting Octal "+temp+" to Decimal : ");
		System.out.print(sum);
		System.out.println();
	}
	
	private static void convertHexToDecimal()
	{
		String s = "11AB";
		String temp =s;
		int sum = 0;
		int count=0;
		for(int i =s.length()-1;i>=0;i--)
		{
			char stemp = s.charAt(i);
			switch(stemp)
			{
				case 'A' :
					sum = (int) (sum +Math.pow(16, count)*10);
					break;
				case 'B' :
					sum = (int) (sum +Math.pow(16, count)*11);
				    break;
				case 'C' :
					sum = (int) (sum +Math.pow(16, count)*12);
				    break;
				case 'D' :
					sum = (int) (sum +Math.pow(16, count)*13);
				    break;
				case 'E' :
					sum = (int) (sum +Math.pow(16, count)*14);
				    break;
				case 'F' :
					sum = (int) (sum +Math.pow(16, count)*15);
				    break;
				default :
					sum = (int) (sum +Math.pow(16, count)*Integer.valueOf(s.substring(i, i+1)));
					break;
			}
			count++;
		}
		System.out.print("converting Hex "+temp+" to Decimal : ");
		System.out.print(sum);
		System.out.println();
	}
	
}
