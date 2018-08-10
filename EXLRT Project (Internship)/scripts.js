//function for changing image at some point of time - every 10 seconds

function changeImage(){
   // Object Date
   var time = new Date();
      
   //document.getElementById("parag").innerHTML = " " + time.getHours() + " " + time.getMinutes();
   var interval = time.getSeconds();
   
   switch(interval % 40){
	  case 0:
         document.getElementById("JSImg").setAttribute("src", "wheat.jpg");
         break;
      case 9:
         document.getElementById("JSImg").setAttribute("src", "exlrt.png");
         break;
      case 19:
         document.getElementById("JSImg").setAttribute("src", "book.png");
         break;
      case 29:
         document.getElementById("JSImg").setAttribute("src", "phone.jpg");
         break;		 
   }
   
   document.getElementById("parag").innerHTML = time.getSeconds() % 40 + "";

   //document.getElementById("JSImg").setAttribute("src", "Article.jpg"); 
   //= document.createElement("article.jpg").setAttribute("src", "article.jpg");;
   
   // setTimeout() call function again after 0,5 seconds
   var temp = setTimeout(changeImage,500);      
}