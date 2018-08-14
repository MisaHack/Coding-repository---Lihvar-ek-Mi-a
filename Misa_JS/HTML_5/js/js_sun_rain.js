var dayTime = true;

function swapImage(){
   var imgObject = document.getElementById("dayImage");

   if(dayTime === true){
      dayTime = false;
      imgObject.src = "rainy_day.jpg";
   }
   else{
      dayTime = true;
      imgObject.src = "sunny_day.jpg";
   }
}
