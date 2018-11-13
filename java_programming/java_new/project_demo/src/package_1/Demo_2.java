package package_1;

/*This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.*/

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Demo_2 {
 public static int solution(int[] A) {
     // write your code in Java SE 8
     int max = 0;
     
     for(int i=0; i < A.length; i++){
        if(A[i] > max){
           max = A[i]; 
        }
     }
     
     if(max < 1)
        return 1;
      
     int [] B = new int [max];
     for(int k=0; k<B.length; k++)
    	 B[k]=0;
     
     for(int j=1; j<=B.length; j++){
    	for(int i=0; i<A.length; i++){
    	   if(j == A[i]) {
    		  B[j-1] = 1;
    		  break;
    	   }
    	} 
     }
     
     int min = B.length+1;
     
     for(int i=0; i<B.length; i++){
    	if(B[i] == 0) {
           min = i+1;
           break;
    	}
     }
     
     return min;
 }
 
 public static void main(String [] args) {
	int [] a = {1,2,3,6};
	int [] b = {-1,-2,0};
	int [] c = {1,3,6,4,1,2};
	int [] d = {1,2,3};
	
	System.out.println(solution(d));
 }
 
 
}
