package abstractFigures;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

/**
 * Tabla na koju drugi igrac stavlja svoje "podmornice",sa praticim metodama.
 * 
 * @author <a href="mailto:lihvarcekmisa@yahoo.com"> Lihvarcek Misa </a>
 *
 */

public class Player2_Board extends AbstractBoard{ 
   //broj podmornica duzine 2,3 i 4 koje se trenutno nalaze na tabli.
   private int No2LengthSubs;
   private int No3LengthSubs;
   private int No4LengthSubs;
   
   //cuvamo spisak svih podmornica, na tabli, u listi
   List<Submarine> submarines;
	
   public Player2_Board(){
	  super();
	  
	  submarines = new ArrayList<>(MAX_SUB_NUM);
	  
	  //inicijalno nam je lista podmornica prazna
	  for(int sub=0;sub < MAX_SUB_NUM; sub++){
		 submarines.add(null); 
	  }
	  
	  No2LengthSubs = 0;
	  No3LengthSubs = 0;
	  No4LengthSubs = 0;
   }
   
   
   /**
    * Metod kojim postavljamo podmornicu na tablu.
    * 
    * @param submarine - podmornica koju zelimo postaviti na tablu
    * @param x1 - x koordinata pocetka podmornice
    * @param y1 - y koordinata pocetka podmornice 
    */
   @Override
   public void putSubmarine(Submarine submarine,int x1,int y1){
	  //uzimamo identifikaciju podmornice koju zelimo postaviti
	  //na tablu
	  //int submarineID = submarine.getId();
	  
	  //uzimamo duzinu podmornice koju zelimo postaviti
	  //na tablu
	  int submarineLength = submarine.getLength();
	  
	  switch(submarineLength){
	     case 2:
	    	//proveravamo da li je broj podmornica na tabli veci
	    	//od dozvoljenog broja date duzine
	    	if(No2LengthSubs < NUM_2LENGTH_SUBS){
	    		
	    	   //ako mozemo staviti jos podmornica onda proveravamo da li
	    	   //podmornica moze da stane na zeljeno mesto na tabli
	    	   //tj. da li neka podmornica vec zauzima to mesto
	    	   
	    	   if(submarine.getOrientation().equals("horizontal")){
	    		  //prvo proveravamo da li ce podmornica preci ivicu table
	    		  if(x1 + submarineLength - 1 < NUM_COLUMNS){
	    			  
	    	         for(int x=x1; x < x1+submarine.getLength(); x++){
	    	    	    //ako je samo jedno od polja na koje smo planirali da postavimo
	    	      	    //podmornicu zauzeto, ne mozemo uopste da postavimo podmornicu
	    	    	    //na taj niz polja
	    		        if(board.get(y1).get(x) != 0){
	    		    	   return; 
	    		        } 
	    	         }
	    	      
	    	         //ako su nam sva polja za postavljanje podmornice dostupna
	    	         //povecavamo broj podmornica duzine 2 i onda postavljamo podmornicu na ta polja
	    	         No2LengthSubs++;
	    	      
	    	         int submarineID = 0;
	    	      
	    	         for(int x=x1; x < x1+submarine.getLength(); x++){
	    	    	    //na polja table cemo postaviti jedinstvenu oznaku za svaku podmornicu pomocu dve cifre
	    	    	    //u obliku: (duzina_podmornice + trenutni_broj_podmornica_te_duzine_na_tabli) = ta_Dva_Broja_Slepljena
	    	    	    //primer: 2 + 1 = 21
	    	    	    submarineID = Integer.parseInt(2 + "" + No2LengthSubs);
                        board.get(y1).set(x, submarineID);
	    	         }
	    	      
                     //dodelimo podmornici isti "id" kao na tabli
                     submarine.setId(submarineID);
                  
                     //dodelimo podmornici njene pocetne koordinate
                     submarine.setStartPosition(x1, y1);
                  
                     //pamtimo koliko podmornica se nalazi na tabli
                     int count = getOccupiedBoardSpace();
                  
                     //brisemo sta god da se nalazi na "count" poziciji liste
                     submarines.remove(count);
                  
                     //na kraju stavimo podmornicu na "count" poziciju u listi svih podmornica na tabli
                     submarines.add(count,submarine);
	    	      
	    		  }
	    		  
	    		  //ako smo prekoracili ivicu table nista necemo postaviti na istu
	    		  return;
	    	   }
	    	   
	    	   
	    	   //ukoliko je orijentacija podmornice vertikalna postupamo veoma slicno
	    	   if(submarine.getOrientation().equals("vertical")){
	    		  //prvo proveravamo da li ce podmornica preci ivicu table 
	    		  if(y1 + submarineLength - 1 < NUM_ROWS){
	    		   
		    	     for(int y=y1; y < y1+submarine.getLength(); y++){
		    	        //ako je samo jedno od polja na koje smo planirali da postavimo
		    	        //podmornicu zauzeto, ne mozemo uopste da postavimo podmornicu
		    	   	    //na taj niz polja
		    	        if(board.get(y).get(x1) != 0){
		    	    	   return; 
		   		        } 
		   	         }
		    	      
		   	         //ako su nam sva polja za postavljanje podmornice dostupna
		   	         //povecavamo broj podmornica duzine 2 i onda postavljamo podmornicu na ta polja
	    	         No2LengthSubs++;
		    	      
	    	         int submarineID = 0;
	    	      
	    	         for(int y=y1; y < y1+submarine.getLength(); y++){		    	    	 
	    	    	    //na polja table cemo postaviti jedinstvenu oznaku za svaku podmornicu pomocu dve cifre
		    	        //u obliku: (duzina_podmornice + trenutni_broj_podmornica_te_duzine_na_tabli) = ta_Dva_Broja_Slepljena
		    	        //primer: 2 + 1 = 21 (tumacenje: duzina 2, prva pojava)
		    	        submarineID = Integer.parseInt(2 + "" + No2LengthSubs);
	                    board.get(y).set(x1, submarineID);
	                     

		             }
	    	      
                     //dodelimo podmornici isti "id" kao na tabli
                     submarine.setId(submarineID);
                  
                     //dodelimo podmornici njene pocetne koordinate
                     submarine.setStartPosition(x1, y1);
                     
                     //pamtimo koliko podmornica se nalazi na tabli
                     int count = getOccupiedBoardSpace();
                  
                     //brisemo sta god da se nalazi na "count" poziciji liste
                     submarines.remove(count);
                  
                     //na kraju stavimo podmornicu na "count" poziciju u listi svih podmornica na tabli
                     submarines.add(count,submarine);
                  
	    		  }
	    	      
		          return;
		       }
	    	   
	    	}
	    	
	    	//ako je prekoracen broj podmornica date duzine vise ne mozemo
	    	//postavljati taj tip podmornica
	    	return;
	     case 3:
	    	//proveravamo da li je broj podmornica na tabli veci
	    	//od dozvoljenog broja date duzine
	    	if(No3LengthSubs < NUM_3LENGTH_SUBS){
	    		
	    	   //ako mozemo staviti jos podmornica onda proveravamo da li
	    	   //podmornica moze da stane na zeljeno mesto na tabli
	    	   //tj. da li neka podmornica vec zauzima to mesto
	    	   
	    	   if(submarine.getOrientation().equals("horizontal")){
		          //prvo proveravamo da li ce podmornica preci ivicu table
		    	  if(x1 + submarineLength - 1 < NUM_COLUMNS){	    		   
	    		   
	    	         for(int x=x1; x < x1+submarine.getLength(); x++){
	    	    	    //ako je samo jedno od polja na koje smo planirali da postavimo
	    	    	    //podmornicu zauzeto, ne mozemo uopste da postavimo podmornicu
	    	    	    //na taj niz polja
	    		        if(board.get(y1).get(x) != 0){
	    		    	   return; 
	    		        } 
	    	         }
	    	      
	    	         //ako su nam sva polja za postavljanje podmornice dostupna
	    	         //povecavamo broj podmornica duzine 3 i onda postavljamo podmornicu na ta polja
	    	         No3LengthSubs++;
	    	      
	    	         int submarineID = 0;
	    	      
	    	         for(int x=x1; x < x1+submarine.getLength(); x++){
	    	    	    //na polja table cemo postaviti jedinstvenu oznaku za svaku podmornicu pomocu dve cifre
	    	    	    //u obliku: (duzina_podmornice + trenutni_broj_podmornica_te_duzine_na_tabli) = ta_Dva_Broja_Slepljena
	    	    	    //primer: 3 + 1 = 31
	    	    	    submarineID = Integer.parseInt(3 + "" + No3LengthSubs);
                        board.get(y1).set(x, submarineID);
                     
	    	         }
	    	      
                     //dodelimo podmornici isti "id" kao na tabli
                     submarine.setId(submarineID);
                  
                     //dodelimo podmornici njene pocetne koordinate
                     submarine.setStartPosition(x1, y1);
                  
                     //pamtimo koliko podmornica se nalazi na tabli
                     int count = getOccupiedBoardSpace();
                  
                     //brisemo sta god da se nalazi na "count" poziciji liste
                     submarines.remove(count);
                  
                     //na kraju stavimo podmornicu na "count" poziciju u listi svih podmornica na tabli
                     submarines.add(count,submarine);	 
                  
		    	  }
	    	      
	    	      return;
	    	   }
	    	   
	    	   
	    	   //ukoliko je orijentacija podmornice vertikalna postupamo veoma slicno
	    	   if(submarine.getOrientation().equals("vertical")){
		    	  //prvo proveravamo da li ce podmornica preci ivicu table 
		   		  if(y1 + submarineLength - 1 < NUM_ROWS){
	    		   
		   		  	 for(int y=y1; y < y1+submarine.getLength(); y++){
		   		   	    //ako je samo jedno od polja na koje smo planirali da postavimo
		    	        //podmornicu zauzeto, ne mozemo uopste da postavimo podmornicu
		   		        //na taj niz polja
		    	        if(board.get(y).get(x1) != 0){
		    	    	   return; 
		   		        } 
		   	         }
		    	      
		   	         //ako su nam sva polja za postavljanje podmornice dostupna
		   	         //povecavamo broj podmornica duzine 3 i onda postavljamo podmornicu na ta polja
	    	         No3LengthSubs++;
	    	      
	    	         int submarineID = 0;
		    	      
	    	         for(int y=y1; y < y1+submarine.getLength(); y++){		    	    	 
	    	    	    //na polja table cemo postaviti jedinstvenu oznaku za svaku podmornicu pomocu dve cifre
		    	        //u obliku: (duzina_podmornice + trenutni_broj_podmornica_te_duzine_na_tabli) = ta_Dva_Broja_Slepljena
		    	        //primer: 3 + 1 = 31 (tumacenje: duzina 3, prva pojava)
		    	        submarineID = Integer.parseInt(3 + "" + No3LengthSubs);
	                    board.get(y).set(x1, submarineID);
	                     
		             }
	    	      
                     //dodelimo podmornici isti "id" kao na tabli
                     submarine.setId(submarineID);
                  
                     //dodelimo podmornici njene pocetne koordinate
                     submarine.setStartPosition(x1, y1);
                     
                     //pamtimo koliko podmornica se nalazi na tabli
                     int count = getOccupiedBoardSpace();
                  
                     //brisemo sta god da se nalazi na "count" poziciji liste
                     submarines.remove(count);
                  
                     //na kraju stavimo podmornicu na "count" poziciju u listi svih podmornica na tabli
                     submarines.add(count,submarine);	    	      
		             
		          }
	    	      
		   		  return;
	    	   }
	    	
	    	   //ako je prekoracen broj podmornica date duzine vise ne mozemo
	    	   //postavljati taj tip podmornica
	    	   return;
	    	}
	     default:
	    	//proveravamo da li je broj podmornica na tabli veci
	    	//od dozvoljenog broja date duzine
	    	if(No4LengthSubs < NUM_4LENGTH_SUBS){
	    		
	    	   //ako mozemo staviti jos podmornica onda proveravamo da li
	    	   //podmornica moze da stane na zeljeno mesto na tabli
	    	   //tj. da li neka podmornica vec zauzima to mesto
	    	   
	    	   if(submarine.getOrientation().equals("horizontal")){
		    	  //prvo proveravamo da li ce podmornica preci ivicu table
		   		  if(x1 + submarineLength - 1 < NUM_COLUMNS){	    		   
	    		   
	    	         for(int x=x1; x < x1+submarine.getLength(); x++){
	    	    	    //ako je samo jedno od polja na koje smo planirali da postavimo
	    	    	    //podmornicu zauzeto, ne mozemo uopste da postavimo podmornicu
	    	    	    //na taj niz polja
	    		        if(board.get(y1).get(x) != 0){
	    		    	   return; 
	    		        } 
	    	         }
	    	      
	    	         //ako su nam sva polja za postavljanje podmornice dostupna
	    	         //povecavamo broj podmornica duzine 2 i onda postavljamo podmornicu na ta polja
	    	         No4LengthSubs++;
	    	      
	    	         int submarineID = 0;
	    	      
	    	         for(int x=x1; x < x1+submarine.getLength(); x++){
	    	    	    //na polja table cemo postaviti jedinstvenu oznaku za svaku podmornicu pomocu dve cifre
	    	    	    //u obliku: (duzina_podmornice + trenutni_broj_podmornica_te_duzine_na_tabli) = ta_Dva_Broja_Slepljena
	    	    	    //primer: 4 + 1 = 41
	    	    	    submarineID = Integer.parseInt(4 + "" + No4LengthSubs);
                        board.get(y1).set(x, submarineID);
                     
	    	         }
	    	      
                     //dodelimo podmornici isti "id" kao na tabli
                     submarine.setId(submarineID);
                  
                     //dodelimo podmornici njene pocetne koordinate
                     submarine.setStartPosition(x1, y1);
                  
                     //pamtimo koliko podmornica se nalazi na tabli
                     int count = getOccupiedBoardSpace();
                  
                     //brisemo sta god da se nalazi na "count" poziciji liste
                     submarines.remove(count);
                  
                     //na kraju stavimo podmornicu na "count" poziciju u listi svih podmornica na tabli
                     submarines.add(count,submarine);	   
                  
		   		  }
	    	      
	    	      return;
	    	   }
	    	   
	    	   
	    	   //ukoliko je orijentacija podmornice vertikalna postupamo veoma slicno
	    	   if(submarine.getOrientation().equals("vertical")){
			   	  //prvo proveravamo da li ce podmornica preci ivicu table 
		   		  if(y1 + submarineLength - 1 < NUM_ROWS){	    		   
	    		   
		    	     for(int y=y1; y < y1+submarine.getLength(); y++){
		    	        //ako je samo jedno od polja na koje smo planirali da postavimo
		    	        //podmornicu zauzeto, ne mozemo uopste da postavimo podmornicu
		    	   	    //na taj niz polja
		    	        if(board.get(y).get(x1) != 0){
		    	    	   return; 
		   		        } 
		   	         }
		    	      
		   	         //ako su nam sva polja za postavljanje podmornice dostupna
		   	         //povecavamo broj podmornica duzine 2 i onda postavljamo podmornicu na ta polja
	    	         No4LengthSubs++;
		    	      
	    	         int submarineID = 0;
	    	      
	    	         for(int y=y1; y < y1+submarine.getLength(); y++){		    	    	 
	    	    	    //na polja table cemo postaviti jedinstvenu oznaku za svaku podmornicu pomocu dve cifre
		    	        //u obliku: (duzina_podmornice + trenutni_broj_podmornica_te_duzine_na_tabli) = ta_Dva_Broja_Slepljena
		    	        //primer: 4 + 1 = 41 (tumacenje: duzina 4, prva pojava)  
		    	        submarineID = Integer.parseInt(4 + "" + No4LengthSubs);
	                    board.get(y).set(x1, submarineID);
	                     	      
		             }
	    	      
                     //dodelimo podmornici isti "id" kao na tabli
                     submarine.setId(submarineID);
                  
                     //dodelimo podmornici njene pocetne koordinate
                     submarine.setStartPosition(x1, y1);
                     
                     //pamtimo koliko podmornica se nalazi na tabli
                     int count = getOccupiedBoardSpace();
                  
                     //brisemo sta god da se nalazi na "count" poziciji liste
                     submarines.remove(count);
                  
                     //na kraju stavimo podmornicu na "count" poziciju u listi svih podmornica na tabli
                     submarines.add(count,submarine);	    	      
	    	      
		   		  }
                  
		          return;
		       }
	    	   
	    	}
	    	
	    	//ako je prekoracen broj podmornica date duzine vise ne mozemo
	    	//postavljati taj tip podmornica
	    	return;
	        
	  }
   }
   
   /**
    * Pomocni metod koji nam vraca koliko se zaista podmornica
    * nalazi na tabli.
    * 
    * @return broj podmornica na tabli
    */
   public int getOccupiedBoardSpace(){
	  //zauzeto mesta
	  int occupied = 0;
	  
	  //trcimo kroz listu podmornica i povecavamo broj podmornica
	  //za svako ne-prazno mesto
	  for(Submarine submarine: submarines){
		 if(submarine == null)
			return occupied;
		 occupied++;
	  }
	  
	  //vratimo broj podmornica
	  return occupied; 
   }
   
   /**
    * Metod kojim gadjamo podmornice na tabli i otkrivamo skrivena polja.
    * 
    * @param x1 - x koordinata polja table koje gadjamo
    * @param y1 - y koordinata polja table koje gadjamo
    * 
    * @return povratna vrednost kazuje da li je podmornica pogodjena ili ne
    */
   @Override
   public boolean shootSubmarine(int x1,int y1){
	  //ne smemo dozvoliti da se dva puta gadja jedno te isto mesto
	  //pa proveravamo da li je polje otkriveno 
	  if(board.get(y1).get(x1) != -1 && board.get(y1).get(x1) != -2){
	     //vrsimo proveru da li smo pogodili prazno mesto
	     if(board.get(y1).get(x1) == 0){
		  
		    //ako jesmo onda to mesto oznacimo sa "-2" sto ima znacenje
		    //"pogodjeno prazno mesto"
		    board.get(y1).set(x1, -2);
		 
		    //saljemo obavestenje da ni�ta nije pogo�eno
		    return false;
	     }
	  
	     //ako nismo pogodili prazno mesto onda smo sigurno pogodili
	     //podmornicu, pa ispitujemo koja podmornica je u pitanju
	     int submarineID = board.get(y1).get(x1);
	  
	     //"trcimo" kroz listu svih podmornica na tabli
	     //i trazimo one ciji "id"-ovi se poklapaju
	     for(Submarine submarine:submarines){
	    	//ako naidjemo na null vrednost preskacemo ta polja liste
	    	if(submarine != null){
		       if(submarineID == submarine.getId()){
			 
			      //kada smo pronasli podmornicu koju smo pogodili
			      //povecavamo joj ostecenost za 1
			      submarine.damageSubmarine();
			
			      //na mestu gde smo pogodili podmornicu postavljamo
			      //oznaku "-1" koja ima znacenje "pogodjen je deo podmornice"
			      board.get(y1).set(x1, -1);
		       }
	    	}
	     }
	  
	     //saljemo obavestenje da je podmornica pogodjena
	     return true;
      }
	  
	  //nista ne menjamo ako je otvoreno polje pa samo vratimo false
	  return false;
   }
   
   
   /**
    * Metod sluzi za pomeranje podmornice na novu poziciju na tabli.
    * 
    * @param id - identifikacioni broj podmornice koju pomeramo
    * @param newX1 - x koordinata polja na koje zelimo premestiti podmornicu
    * @param newY1 - y koordinata polja na koje zelimo premestiti podmornicu
    * @return
    */
   @Override
   public boolean changeSubmarinePosition(int id,int newX1,int newY1){
	  //prvo proverimo da li podmornica sa datim id-om
	  //postoji na tabli
	  for(Submarine submarine:submarines){
		 //ako nema podmornica na tabli onda ne mozemo ni da pomerimo nista
		 if(submarine == null){
			out.println("Na tabli nema podmornica ili trazena podmornica ne postoji!");
			return false; 
		 } 
		 
		 //ako podmornica sa datim id-om postoji
		 //onda uzimamo njenu poziciju
		 if(submarine.getId() == id){
			//trenutne x i y koordinate pocetog dela podmornice
			int currentX = submarine.getStartX();
			int currentY = submarine.getStartY();
			
			//pribavimo i orijentaciju podmornice
			String orientation = submarine.getOrientation();
			
			//imamo dva scenarija kada je podmornica
			//postavljena horizontalno ili vertikalno
			switch(orientation){
			   case "horizontal":
				  //najvaznije je da na pocetku proverimo da li prelazimo ivicu
				  //table, ako prelazimo odmah prekidamo bilo kakvo pomeranje
				  //jer ne smemo preci ivicu table
				  if(newX1 + submarine.getLength() - 1 < NUM_COLUMNS){
				   
				     //trcimo po x osi tabele a y nam je fiksirana
				     //i proveramo niz polja na koja zelimo da postavimo
				     //podmornicu, polje po polje
				     for(int x=newX1; x < newX1 + submarine.getLength(); x++){
					    //ako je bar jedno polje u tom nizu polja
					    //zauzeto, odustajemo od pomeranja
					    if(board.get(newY1).get(x) != 0){
						   //ako je polje koje smo pronasli polje
						   //podmornice koju pomeramo, ponasamo
						   //se kao da je to prazno mesto 
						   //(posto znamo da ga niko drugi ne zauzima)
						   if(board.get(newY1).get(x) != submarine.getId()){
							  return false; 
						   } 
					    } 
				     }
				  
				     //ako su sva polja slobodna,
				     //oslobadjamo polja koja podmornica trenutno zauzima
				     //postavljajuci nule
				     for(int x=currentX; x < currentX + submarine.getLength(); x++){
					    board.get(currentY).remove(x);
					    board.get(currentY).add(x, 0);
				     }
				  
				     //zatim mozemo da stavimo podmornicu na zeljenu poziciju
				     for(int x=newX1; x < newX1 + submarine.getLength(); x++){
					    board.get(newY1).remove(x);
					    board.get(newY1).add(x, submarine.getId()); 
				     }
				  
				     return true;
				  
				  }
				  
				  //prekoracena je ivica table pa nista ne pomeramo
				  return false;
				  
			   case "vertical":
			      //najvaznije je da na pocetku proverimo da li prelazimo ivicu
				  //table, ako prelazimo odmah prekidamo bilo kakvo pomeranje
				  //jer ne smemo preci ivicu table
				  if(newY1 + submarine.getLength() - 1 < NUM_ROWS){
					   
				     //trcimo po y osi tabele a x nam je fiksirana
				     //i proveramo niz polja na koja zelimo da postavimo
				     //podmornicu, polje po polje
				     for(int y=newY1; y < newY1 + submarine.getLength(); y++){
					    //ako je bar jedno polje u tom nizu polja
					    //zauzeto, odustajemo od pomeranja
					    if(board.get(y).get(newX1) != 0){
						   //ako je polje koje smo pronasli polje
						   //podmornice koju pomeramo, ponasamo
						   //se kao da je to prazno mesto 
						   //(posto znamo da ga niko drugi ne zauzima)
						   if(board.get(y).get(newX1) != submarine.getId()){
							  return false; 
						   } 
					    } 
				     }
					  
				     //ako su sva polja slobodna,
				     //oslobadjamo polja koja podmornica trenutno zauzima
				     //postavljajuci nule
				     for(int y=currentY; y < currentY + submarine.getLength(); y++){
					    board.get(y).remove(currentX);
					    board.get(y).add(currentX, 0);
				     }
					  
				     //zatim mozemo da stavimo podmornicu na zeljenu poziciju
				     for(int y=newY1; y < newY1 + submarine.getLength(); y++){
					    board.get(y).remove(newX1);
					    board.get(y).add(newX1, submarine.getId()); 
				     }
				  
				     return true;
					  
				  }  
					  
				  //prekoracena je ivica table pa nista ne pomeramo
				  return false;  
			}
		 }  
	  }
	  
	  return true;
   }
   
   
   /**
    * Metod vraca listu sa id-ovima podmornica koje su potopljene.
    * 
    * @return lista id-ova potopljenih podmornica
    * 
    */
   public List<Integer> getSunkenList(){
	  List<Integer> sunkenList = new ArrayList<>();
	  sunkenList.clear();
	   
	  for(Submarine submarine: submarines){
		 if(submarine.isDestroyed()){
			sunkenList.add(submarine.getId()); 
		 } 
	  }
	  
	  return sunkenList;
   }
   
   /**
    * Metod vraca logicku vrednost da li su sve podmornice potopljene.
    * 
    * @return <b>true</b> - sve podmornice su potopljene i igra je gotova,
    *         <b>false</b> - nisu sve podmornice potopljene i igra se nastavlja
    */
   public boolean isItGameOver(){
	  if(getSunkenList().size() == MAX_SUB_NUM){
		 return true; 
	  }
	  return false;
   }
   
   /**
    * Metod vraca tablu u stanje pre pocetka igre.
    */
   @Override
   public void resetTable(){
	  //brisemo sve elemente sa table
	  for(int row=0; row < board.size(); row++){
		 board.get(row).clear();
	  }
	  
	  //nakon toga postavljamo sva polja na 0
	  for(int row=0;row < NUM_ROWS; row++){
		 for(int column=0; column < NUM_COLUMNS; column++){
		    board.get(row).add(0);
		 }
	  }
   }
   
   /**
    * Metod postavlja podmornice nasumice na tablu.
    */
   @Override
   public void setSubmarinesRandomOnBoard(){
	  List<String> orientations = new ArrayList<>();
	  orientations.add("horizontal");
	  orientations.add("vertical");
	   
	  //pravimo potreban broj podmornica i redjamo na tablu
	  for(int subSerial=0;subSerial < MAX_SUB_NUM ;subSerial++){
		 //odaberemo nasumicnu duzinu podmornice
		 int randomLength = (int)(Math.random() * 2) + 2;
		 
		 //odaberemo nasumicnu orijentaciju podmornice
		 String randomOrientation = orientations.get(Math.random() < 0.5 ? 0 : 1);
		 
		 out.print(randomOrientation + "-");
		 out.print(randomLength);
		 out.println();
	  } 
   }
   
   /**
    * Metod za testiranje vraca trenutan broj elemenata u listi( mogu biti i samo null vrednosti).
    * 
    * @return broj elemenata u listi
    */
   public int getNumElemInList(){
	  return submarines.size(); 
   }
   
}
