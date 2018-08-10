package paket1;

/**
 * Making sum of first 1000 prime numbers
 * 
 * @author <a href="lihvarcekmisa@yahoo.com"> Miša Lihvarèek </a>
 *
 */

public class PrimeNumbersSum {
   public static void main(String [] args){
	  
	  //number of natural numbers in which
	  //we are searching prime numbers
	  final int max = 1000;
	  
	  
	  int temp = 0;
	  
	  int sum = 0; 
	  
	  //number that we are looking at the moment (number "i")
	  for(int i=1; i <= max ; i++){
		  
		 //"j" all other numbers before mentioned number "i"
		 //example: i=4, then "j" will be 1,2,3,4
		 for(int j=1; j <= i ; j++){
			 
            //"temp" is number of numbers that "i" can be divided with
			if(i%j == 0){
			   temp++;	
			} 
		 }
		 
		 //if there is only two numbers that can be divided with "i"
		 //(1 and number "i") then the number "i" is prime number		 
		 if(temp == 2){
		    sum = sum + i;
		    System.out.println("Prime number: " + i);
		 }
		 
		 temp = 0;
	  }
	  
	  System.out.println(sum);
   }
}
