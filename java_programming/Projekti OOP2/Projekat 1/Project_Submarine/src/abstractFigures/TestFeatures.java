package abstractFigures;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa sluzi za testiranje napisanog koda.
 * 
 * @author <a href="mailto:lihvarcekmisa@yahoo.com"> Lihvarcek Misa </a>
 *
 */

public class TestFeatures {
   public static void main(String [] args){
	   Player1_Board p1 = new Player1_Board();
	   p1.printTable();
	   
	   List<Integer> list = new ArrayList<>();
	   list.add(2);
	   list.add(1);
	   
	   System.out.println(p1.getNumElemInList());
	   
	   System.out.println(list);
	   System.out.println(list.size());
	   
	   Submarine s = new Submarine(2, "horizontal");
	   Submarine s2 = new Submarine(3,"horizontal");
	   Submarine s3 = new Submarine(3,"vertical");
	   
	   p1.putSubmarine(s, 1, 1);
	   p1.putSubmarine(s2, 2, 9);
	   p1.putSubmarine(s3, 4, 0);
	   
	   p1.printTable();
	   
	   p1.shootSubmarine(1, 1);
	   p1.shootSubmarine(1, 1);
	   
	   p1.printTable();
	   
	   p1.changeSubmarinePosition(s2.getId(), 8, 2);
	   p1.changeSubmarinePosition(s3.getId(), 8, 9);
	   
	   p1.printTable();
	   
	   p1.setSubmarinesRandomOnBoard();
	   
	   System.out.println(s.getId());
	   
	   p1.resetTable();
	   
	   p1.printTable();
   }
}
