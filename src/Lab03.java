//Import Statements
import java.util.Random; 

public class Lab03 {

	public static void main(String[] args) {
		//int arraySize = 1000000; 
		int arraySize = 100; 
		int[] A = new int[arraySize]; 
		
		//Initialize Array
		initialize(A, arraySize); 
		//printArray(A, arraySize); 
		
		//Shuffle Array Randomly 
		FisherYatesShuffle(A, arraySize);
		//printArray(A, arraySize); 
		
		quicksort(A, 0, arraySize-1); 
		printArray(A, arraySize); 
		
	}
	
	//Task #1
	private static void initialize(int[] A, int n) {
		for(int i=0; i<n; i++){
			A[i] = i; 
		}
	}
	
	private static void FisherYatesShuffle(int[] A, int n) {
		Random random = new Random(); 
		int j; 
		
		for(int i=0; i<n-1; i++) {
			j = random.nextInt(n-i)+i; //get the random number j such that i<=j<n
			int temp = A[i]; 
			A[i] = A[j]; 
			A[j] = temp; 
		}
	}
	
	private static void printArray(int[] A, int n) {
		System.out.print("{");
		for(int i=0; i<n; i++) {
			int valueToPrint = A[i]; 
			System.out.print(valueToPrint + ", ");
		}
		System.out.println("}");
	}
	
	//Task #2
	private static void quicksort(int[] A, int left, int right) {
		Random random = new Random(); 
		int m = left;
		
		if(left>=right) {
			return; 
		}
		
		//pivot is a random element in A[l]...A[u]
		swap(A, left, random.nextInt(right-left+1)+left); 
					
		for(int i=left+1; i<=right; i++) {
			if(A[i]<A[left]) {
				swap(A, ++m, i);
			}
		}
		
		swap(A, left, m); 
		quicksort(A, left, m-1); 
		quicksort(A, m+1, right); 	
	}
	
	private static void swap(int A[], int i, int j) {
		int temp = A[j]; 
		A[j] = A[i]; 
		A[i] = temp; 
	}
	
	private static void insertionSort(int[] A, int n) {
		int key; 
		int j; 
		
		for(int i=1; i<n; i++) {
			key = A[i]; 
			
		}
	}
}
