package com.satish.algorithms;

import java.util.Arrays;
import java.util.Scanner;
/***
 * Given a sorted array having no duplicates, arr[] and a value, x, find floor of x in given array. Floor of x is the largest element in arr[] such that the element is smaller than or equal to x. If floor exists, then return index of it, else return -1.

Examples:

Input : arr[] = {1, 2, 8, 10, 11, 12, 19}, x = 5
Output : 1 
1 is index of 2. 2 is the largest element in arr[]
smaller than 5.

Input : arr[] = {1, 2, 8, 10, 11, 12, 19}, x = 20
Output : 6
19 is the largest element in arr[] smaller than 20.

Input : arr[] = {1, 2, 8, 10, 11, 12, 19}, x = 0
Output : -1
Since floor doesn't exist, output is -1.
Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N and x, N is the size of array.
The second line of each test case contains N array elements.

Output:

Print index of floor of x if it exists, else print -1

Constraints:

1 ≤ T ≤ 500
1 ≤ N ≤ 1000
0 ≤ X ≤ 1000 
1 ≤ arr[i] ≤ 10000

Example:

Input:
3
7 0
1 2 8 10 11 12 19
7 5
1 2 8 10 11 12 19
7 10
1 2 8 10 11 12 19

Output:
-1
1
3
 * @author satishkamavaram
 *
 */
public class Algorithm1 {

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfcases = sc.nextInt();
		for(int i =0;i<numberOfcases;i++) 
		{
			int sizeOfArray = sc.nextInt();
			int value = sc.nextInt();
			int [] arr = new int[sizeOfArray];
			for(int j =0;j<sizeOfArray;j++) {
				arr[j] = sc.nextInt();
			}
			System.out.println("=======");
			Algorithm1 a = new Algorithm1();
			System.out.println(a.findndex(arr,value));
		
		}
	}
	
	
	public static void main2(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
          Scanner sc = new Scanner(System.in);
          String s =  sc.nextLine();
          if(s!=null && s.length() >0) {
              char  [] c  = s.toCharArray();
              int length = s.length();
              int i  = 0;
               while(i <= length-2){
                   if(c[i] == c[i+1]) {
                       c[i] = c[i+1] =' ';
                       if(i!=0) {
                           if(c[i-1] == c[i+2])
                                c[i-1] = c[i+2] =' ';
                       }
                       i = i + 2;
                   } else    {
                       i++;
                   }  
               }
             System.out.println(Arrays.toString(c));
        }      
       }  
	
	public static void main3(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
          Scanner sc = new Scanner(System.in);
          String s =  sc.nextLine();
          if(s!=null && s.length() >0) {
              char  [] c  = s.toCharArray();
              int length = s.length()-1;
              int i  = 1;
               while(i <= length) {
                   if(c[i] == c[i-1]) {
                	   c[i] = c[i-1] = ' ';
                	   int n  = i+1;
                	   int m  = i-2;
                	   while( n <= length && m >=0 && c[n]  == c[m]) {
                		   c[n]  = c[m] = ' ';
                		   n = n+1;
                		   m = m-1;
                		   i++;
                	   }
                	   //move chars
                	   n = n-1;
                	   while(m>=0 && c[m] != ' ') {
                		   c[n] = c[m];
                		   c[m] = ' ';
                		   n--;
                		   m--;
                	   }
                	   i++;
                   }
                   i++;
               }
               String result   = new String(c);
               result = result.trim();
               if(result.length() == 0 )
            	   result  = "Empty String";
             System.out.println(result);
        }      
       }  
	
	// aabcdeffedhaa
	// aabcdeffeehaa
	private int findndex(int [] arr,int value ){
		int index = -1;
		int size = arr.length;
		int low = 0;
		int high = size-1;
		if(value<arr[low])
			return index;
		if(value>arr[high])
			return high;
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[mid]==value)
				return mid;
			if(arr[mid] > value) {
				index = high-1;
				high = mid - 1;
			}
			else {
				index = low+1;
				low = mid +1;
			}
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		int n = 1;
		if(n<2)
			return;
		String s3 = "int";
		String s = "min("+s3+", "+ s3+")";
		
		int count =2;
		StringBuffer sb = new StringBuffer();
		if(n == 2) {
			System.out.println(sb.append(s));
			return;
		}
		 sb.append(s);
		 int start = 0;
		while(count<n) {
			start = sb.lastIndexOf(s3);
			sb.replace(start, start+3, s);
			count++;
		}
		System.out.println(sb.toString());
	}
	
	
}
