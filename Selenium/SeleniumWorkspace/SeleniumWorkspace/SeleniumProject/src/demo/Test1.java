/**
 * Test 1
 * 
 * 1) Go ​to​ ​​google.com
 * 2) Search​ ​for​ ​​wedoqa.com
 * 3) Hit​ ​the​ ​first​ ​result​ ​which​ ​will​ ​navigate​ ​to​ ​​wedoqa.com
 * 4) Click ​through ​the​ ​upper​ ​menu​ ​(Home,​ ​What​ ​we​ ​offer, ​What ​sets​ ​us​ ​apart,​ ​Get​ ​an​ ​offer, Selenium,​ ​Resource,​ ​Who​ ​We​ ​are,​ ​Contact​ ​info)
 * 5) In​ ​the​ ​"Who​ ​we​ ​are​ ​section"​ ​move​ ​the​ ​mouse​ ​cursor​ ​over​ ​somebody​ ​and​ ​read​ ​out​ ​the​ ​popup text​ ​and​ ​print​ ​it​ ​onto​ ​the​ ​console
 * 6) From​ ​the​ ​menu​ ​click​ ​on​ ​"Blog"
 * 7) Create​ ​a​ ​screenshot
 * 8) On​ ​the​ ​Blog​ ​page​ ​search​ ​for​ ​the​ ​word​ ​"test"
 * 9) Read​ ​out​ ​the​ ​date​ ​of​ ​the​ ​last​ ​entry​ ​and​ ​calculate​ ​how​ ​much​ ​days​ ​have​ ​passed​ ​since​ ​then.
 * 
 * @author <a href="lihvarcekmisa@yahoo.com"> Misa Lihvarcek </a>
 */


package demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;

public class Test1 {
   public static void main(String [] args) throws InterruptedException{
	   
	  //From "Selenium 3" we need to configure "Gecko driver" for Mozilla Firefox web browser
	  System.setProperty("webdriver.gecko.driver", "C:\\gecko\\geckodriver.exe"); 
	  
	  //"Web Driver" that operates with Mozilla Firefox web browser	  
	  WebDriver driver = new FirefoxDriver();
	  
	  try{
		  
	     //Navigating to web page "google.com"
	     driver.get("https://www.google.com/");
	  
	     //We need to slow the application for some small time to see what is happening on screen when we run application,
	     //in our case for 2000 milliseconds = 2 seconds
	     Thread.sleep(2000);
	  
	     //We want to make Web Browser window maximised
	     driver.manage().window().maximize();	
	  
	     Thread.sleep(2000);
	  
	     //At first I wanted to use FireBug for extracting XPath but I have used Firefox Developers tools instead
	  
	     //We need to find "search" text box on "google.com" and enter character sequence "wedoqa.com"
	     driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("http://wedoqa.com/");
	  
	     //We need to press "Google search" button
	     driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[3]/center/input[1]")).click();
	  
	     //We will click on the first result on the search page
	     driver.findElement(By.xpath("/html/body/div[6]/div[3]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/h3/a")).click();
	  
	     //We click "Home" button
	     driver.findElement(By.xpath("/html/body/div[1]/div/div/div/ul/li[1]/a")).click();

	     //We need to slow the application for some small time to see what is happening on screen when we run application,
	     //in our case for 3000 milliseconds = 3 seconds	  
	     Thread.sleep(3000);
	  
	     //We click "What we offer" button
	     driver.findElement(By.xpath("/html/body/div[1]/div/div/div/ul/li[2]/a")).click();

	     Thread.sleep(3000);
	  
	     //We click "What ​sets​ ​us​ ​apart" button
	     driver.findElement(By.xpath("/html/body/div[1]/div/div/div/ul/li[3]/a")).click();
	  
	     Thread.sleep(3000);
	  
	     //We click "​Get​ ​an​ ​offer" button	  
	     driver.findElement(By.xpath("/html/body/div[1]/div/div/div/ul/li[4]/a")).click();
	  
	     Thread.sleep(3000);

	     //We click "Selenium" button	
	     driver.findElement(By.xpath("/html/body/div[1]/div/div/div/ul/li[5]/a")).click();
	  
	     Thread.sleep(3000);

	     //We click "​Resource" button	  
	     driver.findElement(By.xpath("/html/body/div[1]/div/div/div/ul/li[6]/a")).click();
	  
	     Thread.sleep(3000);

	     //We click "​Who​ ​We​ ​are" button	  
	     driver.findElement(By.xpath("/html/body/div[1]/div/div/div/ul/li[7]/a")).click();
	  
	     Thread.sleep(3000);

	     //We click "​Contact​ ​info" button	  
	     driver.findElement(By.xpath("/html/body/div[1]/div/div/div/ul/li[8]/a")).click();
	  
	     Thread.sleep(3000);
	  
	     //driver.findElement(By.xpath("/html/body/div[2]/section[6]/div[2]/div[4]/img")).click();
	  
	     //Making object from element that we want to point with mouse cursor.
	     WebElement xy = driver.findElement(By.xpath("/html/body/div[2]/section[6]/div[2]/div[6]/img"));
	  
	     //Actions class
	     //The user-facing API for emulating complex user gestures. 
	     //Use this class rather than using the Keyboard or Mouse directly.
	     Actions action = new Actions(driver);
	  
	     //Moves the mouse to the middle of the element "xy". 
	     //The element is scrolled into view and its location is calculated using getBoundingClientRect.
	     action.moveToElement(xy).perform();
	  
	     Thread.sleep(3000);
	  
	     //String name = xy.getAttribute(arg0)
	  
	     //Printing content of popup text from element "xy" into console
	     System.out.println("Popup text: " + xy.getAttribute("data-content"));
	  
	     Thread.sleep(3000);
	  
	     //We click "​Blog" button	  
	     //driver.findElement(By.xpath("/html/body/div[1]/div/div/div/ul/li[10]/a")).click();
	  
	     driver.get("http://blog.wedoqa.com"); //<- I did not click button because it opens new tab and test stop; trying to solve problem
	  
	     //driver.switchTo().window("_blank");
	     //driver.switchTo().window(driver.W)
	  
	     //We take screenshot of "WeDoQA Blog"
	     File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
	     //Now we can do whatever we need to do with it, for example copying screenshot somewhere
	     try {
		  
		    //We will copy screenshot to "tmpScr" folder on "C:\\" disk
		    FileUtils.copyFile(scrFile, new File("C:\\tmpScr\\screenshot.png"));
	     } 
	     catch (IOException e) {
		  
		    //If we fail to copy screenshot to folder we will get error message
		    System.err.println("THERE IS A PROBLEM WITH COPYING A SCREENSHOT!");
	        e.printStackTrace();
	     }
	  
	     Thread.sleep(3000);
	  
	     //driver.switchTo().window("_blank");
	  
	     //We need to find "search" text box on "WeDoQA Blog" and enter character sequence "test"  
	     driver.findElement(By.id("search")).sendKeys("test");
	  
	     Thread.sleep(3000);
	  
	     //Because there is no "Search" button, we must to press "ENTER" key from the keyboard
	     driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
	  
	     Thread.sleep(3000);
	  
	     //We extract the date of last Blog entry
	     WebElement date_1 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div[1]/ul/li[1]"));
	     String lastDate = date_1.getText();
	     System.out.println("Date of the last Blog entry:  " + lastDate);
	  
	     //Current date
	     Date date_2 = new Date();
	     SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
	     String currentDate = formatter.format(date_2);  
	     System.out.println("Date Format with dd MMMM yyyy - current Date : " + currentDate);
	  
	  
	  
	     DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd MMMM yyyy");
	  
	     LocalDateTime startTime = LocalDateTime.parse(currentDate, formater);
	     LocalDateTime endTime = LocalDateTime.parse(lastDate, formater);
	  
	     //Calculating difference between dates
	     Duration difference = Duration.between(startTime, endTime);
	  
	     //Printing time difference, to console, expressed in Days 
	     System.out.println(difference.toDays());
	  
	     driver.quit();
	  
	  } //end try
	  
	  catch(Exception e){
		  
		 e.printStackTrace();
		 
	     //Deleting temporary files after use
	     driver.quit();
	  }
   }
}
