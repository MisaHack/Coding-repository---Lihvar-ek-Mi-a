package bean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.CommentG3;
import entity.TweetG3;
import entity.UserG3;


/**
 * Klasa sluzi za popunjavanje baze podataka sa unapred definisanim
 * podacima kako bi aplikacija bila spremna za upotrebu po startovanju.
 * 
 * @author <a href="mailto:lihvarcekmisa@yahoo.com">Lihvarcek Misa</a>
 *
 */

//treba nam samo jedna instanca klase iz koje cemo
//izvlaciti podatke pa zato @Singleton
//lokalni bean
//podaci ce biti inject-ovani odmah po startovanju u bazu
@Singleton
@Startup
public class FillDatabaseG3 {
   //logger nam sluzi za ispis poruka o gresci u konzoli
   private static final Logger logger = Logger.getLogger(FillDatabaseG3.class.getName());
   //objekat pomocu koga se izvrsavaju operacije nad bazom.
   //vrednost polja "name" je naziv persistence-unit-a u fajlu
   //persistence.xml
   @PersistenceContext(name="TwitterServerProjectG3")
   private EntityManager em;
   
   //EJB komponente bi trebalo inicijalizovati u metodi oznacenoj sa
   //@PostConstruct(npr. polje "em" je jos uvek null u konstruktoru)
   
   //metod moze da ima proizvoljan naziv
   @PostConstruct
   public void postConstructG3(){
	  //prvo vrsimo proveru da li su podaci vec uneti ranije
		/**
		 * @author Nenad Barugdzic
		 */
	  List<UserG3> users = em.createNamedQuery("UserG3.findAll", UserG3.class).getResultList();
	  if(users != null && !users.isEmpty()){
		 logger.info("Podaci su vec uneti u bazu podataka.");
		 return;
	  }
	  
	  //ako podaci nisu uneti onda unosimo par User-a,Twitt-ova
	  //i Comment-a
	  
	  //prvi User
	  UserG3 user1 = createNewUser("@Misa", "Misa", "Lihvarcek", "lihvarcekmisa@yahoo.com",
			                        "Misa.png", "Programmer1", "000", "9.3.1990.");
	  
	  //drugi User
	  UserG3 user2 = createNewUser("@Nenad", "Nenad", "Barugdzic", 
			                        "bnenad@gmail.com", "Nenad.png", 
			                        "Programmer2", "111", "Unknown");
	  
	  //treci user
	  UserG3 user3 = createNewUser("@Nemanja", "Nemanja", "Dragin", 
                                   "dnemanja@gmail.com", "Nemanja.png", 
                                   "Programmer3", "222", "Unknown");
	  
	  
	  
	  //prvi twitt
	  TweetG3 twitt1 = createNewTwitt("Hello World",user1);
	  //drugi twitt
	  TweetG3 twitt2 = createNewTwitt("Zdravo svete",user2);
	  
	  
	  //prvi komentar 
	  CommentG3 comment1 = createNewComment(1, "Firste Comment");
	  //drugi komentar
	  CommentG3 comment2 = createNewComment(2, "Second Comment");
	  
	  
	  //ubacimo sve kreirane podatke u bazu podataka
	  em.persist(user1);
	  em.persist(user2);
	  em.persist(user3);
	  
	  em.persist(twitt1);
	  em.persist(twitt2);
	  
	  
//	  em.persist(comment1);
//	  em.persist(comment2);
   }
   
   /**
    * Pomocni metod kojim pravimo novog korisnika,
    * sa svim njegovim podacima.
    * 
    * @param tweetname - jedinstveno ime User-a na twitter-u
    * @param name - pravo ime korisnika
    * @param surname - prezime korisnika
    * @param email - email adresa korisnika
    * @param avatar - profilna slika korisnika
    * @param about  - kratak opis korisnika (hobiji itd.)
    * @param password - sifra za loggin korisnika
    * @param birthdate - datum rodjenja korisnika
    * 
    * @return new User
    */
   public UserG3 createNewUser(String tweetname,String name,String surname,
		                    String email,String avatar,String about,
		                    String password,String birthdate){
	  
	  UserG3 user = new UserG3();
	  user.setTweetname(tweetname);
	  user.setName(name);
	  user.setSurname(surname);
	  user.setEmail(email);
	  user.setAvatar(avatar);
	  user.setAbout(about);
	  user.setPassword(password);
	  user.setBirtdate(birthdate);
	  
	  return user;
   }
   
   /**
    * Pomocni metod kojim pravimo novi Tweet sa
    * svim informacijama koje sadrzi.
    * 
    * @param twitt_id - jedinstveni broj twitt-a
    * @param twittText - sadrzaj poruke koju nosi twitt
    * @param createDate - datum kreiranja twitt-a
    * 
    * @return new Twitt
    */
   public TweetG3 createNewTwitt(String twittText,UserG3 user){
	   
	   TweetG3 twitt = new TweetG3();
	   twitt.setTweetText(twittText);
	   Date newDate = new Date();
	   twitt.setCreateDate(new Timestamp(newDate.getTime()));
	   twitt.setUsers(user);
	   
	   return twitt;
   }
   
   
   /**
    * Pomocni metod kojim pravimo novi komentar sa pratecom porukom.
    * 
    * @param comment_id - jedinstvena identifikacija komentara
    * @param commentText - tekst komentara
    * 
    * @return new Comment
    */
   public CommentG3 createNewComment(int comment_id,String commentText){
	  CommentG3 comment = new CommentG3();
	  comment.setComment_id(comment_id);
	  comment.setCommentText(commentText);
	  
	  return comment;
   }

}
