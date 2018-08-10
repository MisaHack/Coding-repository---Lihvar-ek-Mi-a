package paket1;

/**
 * Program that prints "Div3" if number can be divided with number 3, prints
 * "Div5" if number can be divided with number 5, and prints "Div35" if number
 * can be divided with numbers 3 and 5.
 * 
 * @author <a href="lihvarcekmisa@yahoo.com">Miša Lihvarèek</a>
 *
 */

public class Div35 {
	public static void main(String[] args) {
		
		boolean temp = true;

		// we will print first 50 numbers
		for (int i = 1; i <= 50; i++) {
			//if number can be divided with 3 and 5
			if ((i % 3 == 0) && (i % 5 == 0)) {
				System.out.println("Div35");
				temp = false;
			} else {
				//if number can be divided with 3
				if (i % 3 == 0) {
					System.out.println("Div3");
					temp = false;
				}
				
				//if number can be divided with 5
				if (i % 5 == 0) {
					System.out.println("Div5");
					temp = false;
				}
			}

			if (temp)
				System.out.println(i);

			temp = true;
		}
	}
}
