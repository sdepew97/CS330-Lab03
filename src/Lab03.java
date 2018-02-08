//Import Statements
import java.util.Random; 

public class Lab03 {

	public static void main(String[] args) {
		//int arraySize = 1000000; 
		int arraySize = 100; 
		int[] A = new int[arraySize]; 
		
		//Initialize Array
		initialize(A, arraySize); 
		printArray(A, arraySize); 
		
		//Shuffle Array Randomly 
		FisherYatesShuffle(A, arraySize);
		printArray(A, arraySize); 
	}
	
	private static void initialize(int[] A, int n) {
		for(int i=0; i<n; i++){
			A[i] = i; 
		}
	}
	
	private static void FisherYatesShuffle(int[] A, int n) {
		Random random = new Random(); 
		int j; 
		
		for(int i=0; i<n-1; i++) {
			j = random.nextInt(n-i+1)+i; //get the random number j such that i<=j<n
			int temp = A[i]; 
			A[i] = A[j]; 
			A[j] = temp; 
		}
	}
	
	private static void printArray(int[] A, int n) {
		for(int i=0; i<n; i++) {
			int valueToPrint = A[i]; 
			System.out.println(valueToPrint);
		}
	}
}
