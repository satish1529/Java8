package com.satish.heap;

import java.util.Arrays;

public class MaxHeap {
	
	int [] arr  =  { 5,8,3,1,5,6,9,11,23,56,78,93,88,4,2,100};
		
	int [] emptyArr  =  new int[20];
	int size   =   0;
	public static void main(String[] args) {
		MaxHeap maxHeap  =   new MaxHeap();
	//	maxHeap.convertToMaxHeap();
		maxHeap.heapify();
		maxHeap.addToMaxHeap(5);
		maxHeap.addToMaxHeap(8);
		maxHeap.addToMaxHeap(3);
		maxHeap.addToMaxHeap(1);
		maxHeap.addToMaxHeap(5);
		maxHeap.addToMaxHeap(6);
		maxHeap.addToMaxHeap(9);
		maxHeap.addToMaxHeap(11);
		maxHeap.addToMaxHeap(23);
		maxHeap.addToMaxHeap(56);
		maxHeap.addToMaxHeap(78);
		maxHeap.addToMaxHeap(93);
		maxHeap.addToMaxHeap(88);
		maxHeap.addToMaxHeap(4);
		maxHeap.addToMaxHeap(2);
		maxHeap.addToMaxHeap(100);
		maxHeap.printEmptyArrayAfterAddition();
		int max = maxHeap.getValueFromMaxHeap();
		System.out.println(max);
		maxHeap.printEmptyArrayAfterAddition();
	}
	
	private void printEmptyArrayAfterAddition(){
		System.out.println(Arrays.toString(emptyArr));
	}
	
	
	private void convertToMaxHeap() {
		if(arr == null)
			return;
		int i = 0;
		int leftChild  = 0;
		int rightChild   = 0;
		int size = arr.length;
		boolean swap  =  false;
		while(i<=size) {
			if(i+1 == size && swap) {
				i  = 0;
				swap  =  false;
			}
			leftChild  = 2*i+1;
			rightChild   = 2*i+2;
			if(leftChild<size && arr[i] < arr[leftChild]) {
				swap(i,leftChild);
				swap   = true;
			}
				
			if(rightChild<size && arr[i] < arr[rightChild]) {
				swap(i,rightChild);
				swap   = true;
			}
			
			i++;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private void heapify() {
		if(arr == null)
			return;
		int size  = arr.length;
		int mid  = (int) Math.floor(size/2)-1;
		for(int i = mid; i>=0;i--){
			
		
				int largeChildIndex  = i*2+1;
				int rightChild   = 2*i+2;
				int largeChildValue  = arr[largeChildIndex];
				if(rightChild<size && arr[largeChildIndex]< arr[rightChild]) {
					largeChildValue  = arr[rightChild];
					largeChildIndex  = rightChild;
				}
				if(arr[i] < largeChildValue) {
					swap(i,largeChildIndex);
				}
			
		
		}
			
		System.out.println(Arrays.toString(arr));
	}
	
	private void swap(int i,int j){
		int  temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	private void addToMaxHeap(int i) {
		if(i == 0)
			return;
		if(size == 0) {
			emptyArr[size] = i;
			size++;
			return;
		}
		emptyArr[size]  = i;
 		int parentIndex  = (size>>1);
		int	tempPosition   = size;
		while(parentIndex>=0) {
			if(emptyArr[tempPosition] > emptyArr[parentIndex])	{
				int  temp = emptyArr[parentIndex];
				emptyArr[parentIndex] = emptyArr[tempPosition];
				emptyArr[tempPosition] = temp;
				tempPosition = parentIndex;
			    parentIndex  = parentIndex >> 1;
			} else {
				break;
			}	
		}
		size++;
	}
	
	
	private int getValueFromMaxHeap() {
		if(size == 0) {
			return 0;
		}
		int result  = emptyArr[0];
		emptyArr[0]  =  emptyArr[size--]; 
		
		int i = 0;
		while(i < size) {
			int largeChildIndex  = i*2+1;
			int rightChild   = 2*i+2;
			if(largeChildIndex>size) 
				break;
			int largeChildValue  = emptyArr[largeChildIndex];
			if(rightChild<size && emptyArr[largeChildIndex]< emptyArr[rightChild]) {
				largeChildValue  = emptyArr[rightChild];
				largeChildIndex  = rightChild;
			}
			if(emptyArr[i] < largeChildValue) {
				int  temp = emptyArr[largeChildIndex];
				emptyArr[largeChildIndex] = emptyArr[i];
				emptyArr[i] = temp;
				i  = largeChildIndex;
			} else  {
				break;
			}
		}
		return result;
	}

}
