package info;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GlavniProgram {
	
	public static void unosOtkupnogMesta(BufferedReader in, List<OtkupnoMesto> otkupna_mesta) throws IOException{
	   	
	}
	
	public static void unosProizvodjaca(BufferedReader input, List<Proizvodjac> proizvodjaci) throws IOException{
	   System.out.println("Unesite ime proizvodjaca: ");
	   String ime = input.readLine();
	   System.out.println();
	   
	   System.out.println("Unesite prezime proizvodjaca: ");
	   String prezime = input.readLine();
	   System.out.println();
	   
	   boolean dalje_1 = false;
	   int jmbg = 0;
	   
	   do{
	      System.out.println("Unesite jmbg proizvodjaca: ");
	   
	      try {
	         jmbg = Integer.parseInt(input.readLine());
	         System.out.println();
	   
	         dalje_1 = false;
	      }
	      catch(NumberFormatException e){
	    	 System.err.println("JMBG mora biti ceo broj!"); 
		     dalje_1=true; 
	      }
	   }
	   while(dalje_1);
	   
	   System.out.println("Unesite broj telefona proizvodjaca: ");
	   String telefon = input.readLine();
	   System.out.println();
	   
	   System.out.println("Unesite poresku izjavu: ");
	   String izjava = input.readLine();
	   System.out.println();
	   
	   System.out.println("Unesite ugovor: ");
	   String ugovor = input.readLine();
	   System.out.println();
	   
	   boolean dalje_2 = false;
	   int povrsina = 0;
	   
	   do{
	      System.out.println("Unesite povrsinu parcele: ");
	   
	      try {
	         povrsina = Integer.parseInt(input.readLine());
	         System.out.println();
	         
	         dalje_2 = false;
	      }
	      catch(NumberFormatException e) {
	    	 System.err.println("Povrsina mora biti ceo broj!");
		     dalje_2 = true; 
	      }
	   }
	   while(dalje_2);
	   
	   System.out.println("Unesite tekuci racun: ");
	   String racun = input.readLine();
	   System.out.println();
	   
	   System.out.println("Unesite naziv otkupnog mesta: ");
	   String mesto = input.readLine();
	   System.out.println();
	   
	   proizvodjaci.add(new Proizvodjac(ime,prezime,jmbg,telefon,izjava,ugovor,povrsina,racun,mesto));
	}
	
	static void unosVoca(BufferedReader input, List<Voce> voce) throws IOException{
	   System.out.println("Unesite ime voca: ");
	   String ime = input.readLine();
	   System.out.println();

	   boolean dalje_1 = false;
	   int prva_klasa = 0;
	   
	   do{
	      System.out.println("Unesite cenu I klase: ");
	   
	      try {
	         prva_klasa = Integer.parseInt(input.readLine());
	         System.out.println();
	         dalje_1 = false;
	      }
	      catch(NumberFormatException e){
		     System.err.println("Cena voca mora biti ceo broj!");
		     dalje_1 = true;
	      }
	   }
	   while(dalje_1);
	   
	   boolean dalje_2 = false;
	   int druga_klasa = 0;
	   
	   do{
	      System.out.println("Unesite cenu II klase: ");
	   
	      try {
	         druga_klasa = Integer.parseInt(input.readLine());
	         System.out.println();
	         dalje_2 = false;
	      }
	      catch(NumberFormatException e){
		     System.err.println("Cena voca mora biti ceo broj!");
		     dalje_2 = true;
	      }
	   }
	   while(dalje_2);
	   
	   boolean dalje_3 = false;
	   int treca_klasa = 0;
	   
	   do{
	      System.out.println("Unesite cenu III klase: ");
	   
	      try {
	         treca_klasa = Integer.parseInt(input.readLine());
	         System.out.println();
	         dalje_3 = false;
	      }
	      catch(NumberFormatException e){
		     System.err.println("Cena voca mora biti ceo broj!");
		     dalje_3 = true;
	      }
	   }
	   while(dalje_3);
	   
	   voce.add(new Voce(ime,prva_klasa,druga_klasa,treca_klasa));
	}
	
	public static void writeFile(String input) throws IOException{
		
	   //FileWriter fileWriter = new FileWriter("c:/temp/samplefile3.txt");
	   //PrintWriter printWriter = new PrintWriter(fileWriter);
	   //printWriter.printf("[][][%s]", input);
	   //printWriter.close();
	   
	   try(FileWriter fw = new FileWriter("c:/temp/log_file.txt", true);
		   BufferedWriter bw = new BufferedWriter(fw);
		   PrintWriter out = new PrintWriter(bw))
		   {
			 out.println("["+ LocalDate.now() + "]" + "[" + LocalTime.now() + "]" + "[" + input + "]");
			   
		   }catch (IOException e) {
		   
		   }
	}

	public static void main(String[] args) throws IOException{
		List<OtkupnoMesto> otkupna_mesta = new ArrayList<>();
		List<Proizvodjac> proizvodjaci = new ArrayList<>();
		List<Voce> voce = new ArrayList<>();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input;

		do{
		   System.out.println("****************** HLADNJACA ********************");
		   System.out.println("Unesite ponudjeni redni broj za sledece funkcije: ");
		   System.out.println("--------------------------------------------------");
		   System.out.println("1 --- Unos novog otkupnog mesta");
		   System.out.println("--------------------------------------------------");
		   System.out.println("2 --- Unos novog proizvodjaca");
		   System.out.println("--------------------------------------------------");
		   System.out.println("3 --- Unos novog voca");
		   System.out.println("--------------------------------------------------");
		   System.out.println("4 --- Unos zaduzenja ambalaze");
		   System.out.println("--------------------------------------------------");
		   System.out.println("5 --- Unos otkupa voca");
		   System.out.println("--------------------------------------------------");
		   System.out.println("6 --- Pregled otkupa");
		   System.out.println("--------------------------------------------------");
		   System.out.println("6 --- Pregled salda za otkupno mesto");
		   System.out.println("--------------------------------------------------");
		   System.out.println("x --- Prekid rada programa");
		   System.out.println("**************************************************");

		   input = in.readLine();

			switch (input) {
			case "1":
				unosOtkupnogMesta(in, otkupna_mesta);
				writeFile("unos otkupnog mesta");
				break;
			case "2":
				unosProizvodjaca(in, proizvodjaci);
				writeFile("unos proizvodjaca");
				break;
			case "3":
				unosVoca(in,voce);
				writeFile("unos voca");
				break;
			case "4":
				
				break;
			case "5":
				
				break;
			case "6":
				
				break;
			}
		} while (!input.equals("x"));
		
		System.err.println("UGASILI STE PROGRAM. PRIJATAN DAN.");
	}
}
