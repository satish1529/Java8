package com.satish.algorithms;

public class Algorithm3 {

	public static void main(String[] args) {
		Algorithm3 alg = new Algorithm3();
		alg.printPermutations();
	}
	
	private void printPermutations() {
		String s = "ABCD";
		int length  = s.length()-1;
		for(int i = 0;i<=length;i++){
			char [] c = s.toCharArray();
			if(i!=0)
			{
				swap(c,i,0);
			}
			System.out.println(new String(c));
			/*int n = 1;
			int m = length;
			while(n<length){
				swap(c,n,m);
				m--;
				System.out.println(new String(c));
				if(n>=m) {
					n++;
					m = length;
				}
			}*/
			int n = length-1;
			int m = length;
			while(n<length){
				swap(c,n,m);
				m--;
				System.out.println(new String(c));
				if(n>=m) {
					n--;
					m = length;
				}
			}
			
		}
	}
	
	private void swap(char [] c , int n ,int m) {
		char temp = c[n];
		c[n] = c[m];
		c[m] = temp;
	}
}
