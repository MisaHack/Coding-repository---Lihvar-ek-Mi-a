var i = 0;

function play_stop(){
   if(i == 0){
      var obj = document.getElementById("background");
      obj.play();
      i++;
   }
   else{
      var obj = document.getElementById("background");
      obj.pause();
      i--;
   }
}

function play(){
   var video = document.getElementById("customPlayer");
   video.play();
}

function pause(){
   var video = document.getElementById("customPlayer");
   video.pause();
}

function stop(){
   var video = document.getElementById("customPlayer");
   video.pause();
   video.currentTime = 0;
   video.playbackRate = 1;
}

function speedUp(){
   var video = document.getElementById("customPlayer");
   video.play();
   video.playbackRate = 10;
}

function slowDown(){
   var video = document.getElementById("customPlayer");
   video.play();
   video.playbackRate = 0.5;
}

function normal(){
   var video = document.getElementById("customPlayer");
   video.play();
   video.playbackRate = 1;
}

function reverse(){
   var video = document.getElementById("customPlayer");
   video.play();
   video.playbackRate = -1;
}

function progressUpdate(){
   //Resizing the blue positionBar, from 0 to 100%.
   var positionBar = document.getElementById("positionBar");
   var video = document.getElementById("customPlayer");
   positionBar.style.width = (video.currentTime / video.duration * 100) + "%";

   //Display the number of seconds,using two decimal places.
   var displayStatus = document.getElementById("displayStatus");
   displayStatus.innerHTML = (Math.round(video.currentTime * 100) / 100)+ " sec";

   prog();

}

function prog(){
   var posBar = document.getElementById("progress");
   var video = document.getElementById("customPlayer");
   posBar.value = (video.currentTime/video.duration * 100);
}
