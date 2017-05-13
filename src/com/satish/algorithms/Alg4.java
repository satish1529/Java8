package com.satish.algorithms;

public class Alg4 {

	char [] vowels = {'a','e','i','o','u'};
	char [] consonants = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
	public static void main(String[] args) {
		int n = 3;
		
		char [] result = new char[n];
		Solution a = new Solution();
		a.print(a.vowels,a.consonants,result,0,0,0,n,true);
		a.print(a.consonants,a.vowels,result,0,0,0,n,false);
	}
	
	
	private void print(char[] a , char[] b ,char [] result , int aindex, int bindex,int size, int n,boolean flag) {
		if(flag){
			if(aindex>=vowels.length){
				return;
			}
		} else {
			if(aindex>=consonants.length){
				return;
			}
		}
	
		for(int i = 0;i<n;i++) {
			if(i%2==0)
				result[size++] = a[aindex];
			else  
				result[size++] = b[bindex++];
		}
		if(n!=1){
					recurse(result,0,1,result.length);
		} else{
					System.out.println(new String(result));
		}
			
		result = new char[n];
		if(flag) {
			print(a,b,result,++aindex,0,0,n,true);
		} else {
			print(a,b,result,++aindex,0,0,n,false);
		}
	}
	
	private  void recurse(char [] c,int counter,int end,int length)
	{
		while(end<length)
		{
			swap(c,0,end);
			////hgu 
			printWord(c);
			end++;
		}
		counter++;
		if(counter!=length)
			recurse(c,counter,1,length);
	}
	

	
	private  void swap(char [] c , int start,int end)
	{
		char temp = c[start];
		c[start] = c[end];
		c[end] = temp;	
	}
	
	
    
    private  void printWord(char [] c)
    {
    	if(isMatch(c)) {
    		System.out.println(new String(c));
    	}
    }
    
    private boolean isMatch(char[] c){
    	if(c.length==1)
    		return true;
    	else {
    		boolean isVowelIndex0 = false;
    		boolean isVowelIndex1 = false;
    		boolean isConsonantIndex0 = false;
    		boolean isConsonantIndex1 = false;
    		for (int i = 0; i < vowels.length; i++) {
				if(c[0]==vowels[i] ){
					isVowelIndex0 = true;
				} 
				if(c[1]==vowels[i]){
					isVowelIndex1= true;
				}
			}
    		if(isVowelIndex0 && isVowelIndex1)
    			return false;
    		
    		for (int i = 0; i < consonants.length; i++) {
    			if(c[0]==consonants[i] ){
    				isConsonantIndex0 = true;
				} 
				if(c[1]==consonants[i]){
					isConsonantIndex1= true;
				}
			}
    		
    		if(isConsonantIndex0 && isConsonantIndex1)
    			return false;
    		return true;
    	}
    }
    
}
