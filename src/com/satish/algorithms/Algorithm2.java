package com.satish.algorithms;

import java.util.Scanner;

/**
 * Given an n x m matrix, where every row and column is sorted in increasing order, and a number x . The task is to find whether element x is present in the matrix or not.

Expected Time Complexity : O(m + n)

Input:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consists of three lines.
First line of each test case consist of two space separated integers N and M, denoting the number of element in a row and column respectively.
Second line of each test case consists of N*M space separated integers denoting the elements in the matrix in row major order.
Third line of each test case contains a single integer x, the element to be searched.
Output:

Corresponding to each test case, print in a new line, 1 if the element x is present in the matrix, otherwise simply print 0.

Constraints:
1<=T<=200
1<=N,M<=30

Example:

Input:
2
3 3
3 30 38 44 52 54 57 60 69
62
1 6
18 21 27 38 55 67
55

Output:
0
1
 * @author satishkamavaram
 *
 */
public class Algorithm2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfcases = sc.nextInt();
		for(int i =0;i<numberOfcases;i++) 
		{
			int sizeOfn = sc.nextInt();
			int sizeOfm = sc.nextInt();
			
			int [][] arr = new int[sizeOfn][sizeOfm];
			for(int j =0;j<sizeOfn;j++) {
				for(int k =0;k<sizeOfm;k++) {
				  arr[j][k] = sc.nextInt();
				}
			}
			int value = sc.nextInt();
			Algorithm2 a = new Algorithm2();
			System.out.println(a.findValue(arr,sizeOfn,sizeOfm,value));
		}
	}
	
	private int findValue(int [][] arr,int i, int j, int x) {
		int row = i-1;
		int col = j-1;
		
		int max = arr[row][col];
		int min = arr[0][0];
		if(x == min ||  x == max) {
			return 1;
		} else if(x > max || x < min ) {
			return 0;
		} else {
			int n = 0;
			int m = col;
			while(n<=row) {
				int mid = arr[n][m];
				if(mid==x)
					return 1;
				if(mid>x) {
					boolean found = findndex(arr,n,m,x);
					if(found) return 1;
					else return 0;
				}else {
					n++;
				}
			}
			return 0;
		}
	}
	
	private boolean findndex(int [][] arr,int i, int j, int value ){
		int low = 0;
		int high = j;
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[i][mid]==value)
				return true;
			if(arr[i][mid] > value) {
				high = mid - 1;
			}
			else {
				low = mid +1;
			}
		}
		return false;
	}
}
