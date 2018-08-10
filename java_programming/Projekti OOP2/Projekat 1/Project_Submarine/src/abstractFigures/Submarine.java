package abstractFigures;

/**
 * Klasa predstavlja podmornicu sa svim njenim osobinama.
 * 
 * @author <a href="mailto:lihvarcekmisa@yahoo.com"> Lihvarcek Misa </a>
 *
 */

public class Submarine {
   private int id;
   private int length;
   private String orientation;
   private int startX;
   private int startY;
   private int damaged;
   private boolean destroyed;
   
   Submarine(int length, String orientation){
	  this.length = length;
	  this.orientation = orientation;
	  
	  //inicijalno za id stavimo bilo koji broj
	  id = -8;
	  
	  startX = 0; //x koordinata pocetka podmornice
	  startY = 0; //y koordinata pocetka podmornice
	  
	  damaged = 0;
	  destroyed = false;
   }
   
   /**
    * Metod vraca identifikaciju podmornice
    * 
    * @return id
    */
   public int getId(){
	  return id;
   }
   
   
   /**
    * Metod postavlja identifikaciju podmornice
    * 
    * @param ID podmornice
    */
   public void setId(int ID){
	  id = ID;
   }
   
   /**
    * Metod vraca duzinu podmornice.
    * 
    * @return length
    */
   public int getLength(){
	  return length; 
   }
   
   /**
    * Metod vraca orijentaciju podmornice [horizantalno ili vertikalno]
    * 
    * @return orientation
    */
   public String getOrientation(){
	  return orientation;   
   }
   
   /**
    * Metod postavlja orijentaciju podmornice [horizantalno ili vertikalno]
    * 
    * @param newOrientation
    */
   public void setOrientation(String newOrientation){
	  orientation = newOrientation; 
   }
   
   /**
    * Metod vraca stepen ostecenosti podmornice.
    * 
    * @return damaged
    */
   public int getDamageLevel(){
	  return damaged; 
   }
   
   /**
    * Metod ostecuje podmornicu za po 1 segment.
    */
   public void damageSubmarine(){
	  damaged++; 
   }
   
   /**
    * Metod daje povratnu informaciju da li je podmornica unistena.
    * 
    * @return destroyed
    */
   public boolean isDestroyed(){
	  return destroyed; 
   }
   
   /**
    * Metod kojim ostecujemo podmornicu podmornicu kada je pogodjena.
    * 
    */
   public void makeDamage(){
	  damaged += 1;
	  
	  if(damaged >= length)
		 destroyed = true;
   }
   
   /**
    * Metod sluzi za pamcenje startne pozicije podmornice.
    * 
    * @param x - koordinata pocetka podmornice
    * @param y - koordinata pocetka podmornice
    */
   public void setStartPosition(int x,int y){
	  startX = x;
	  startY = y;
   }
   
   /**
    * Metod vraca X koordinatu pocetka podmornice.
    * 
    * @return int startX
    */
   public int getStartX(){
	  return startX; 
   }
   
   /**
    * Metod vraca Y koordinatu pocetka podmornice.
    * 
    * @return int startY
    */
   public int getStartY(){
	  return startY; 
   }
}
