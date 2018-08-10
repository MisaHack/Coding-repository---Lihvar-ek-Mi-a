package paket1;

/**
 * Algorithm for searching "Amstrong numbers"
 * 
 * @author <a href="lihvarcekmisa@yahoo.com"> Lihvarèek Miša </a>
 *
 */

public class AmstrongNumbers {
	public static void main(String[] args) {

		
	   int left = 0;
	   int right = 0;
	   
	   int size = 0;
	   int square = 1;
	   
	   int sum = 0;
		
	   //searching in the first 1000 natural numbers
	   for(int i=0; i < 1000; i++){
		   
	      //left part of number
		  left = i;
		   
		  //we are counting how long is number
		  while(left != 0){
			 left = left/10;
			 size++;
		  }
		  
		  
		  left = i;
		  //right = i; <- not necessary any more
		  
		  //we are going trough separate digits (from the right side) and multiply them
		  for(int j=0; j < size; j++){
			  
			 //right side of number 
			 right = left % 10;
			 
			 //multiplication for one digit
			 for(int k=0; k < size; k++){
			    square = square * right;
			 }
			 
			 left = left / 10;
			 
			 //sum of digits of the number
			 sum = sum + square;
			 
			 //resetting square variable
			 square = 1;
			 			 
		  }
		  
		  //if number and sum of its digits are the same then number is "Amstrong number"
		  if(sum == i)
		     System.out.println("Amstrong number: " + sum);
		  
		  //System.out.println(size); <- not necessary any more
		  
		  //System.out.println(square); <- not necessary any more
		  
		  left = 0;
		  right = 0;
		  size = 0;
		  square = 1;
		  sum = 0;
	   }
	}
}
