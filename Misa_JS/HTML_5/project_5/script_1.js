var openBox = true;

function open(){
   if(openBox){
      openBox = false;
      var box = document.getElementById("Answer");
      box.style.display = "none";
   }
   else{
      openBox = true;
      var box = document.getElementById("Answer");
      box.style.display = "block";
   }
}
