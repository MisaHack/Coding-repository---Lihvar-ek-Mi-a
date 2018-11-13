// These are the details that represent an individual ball.
function Ball(x, y, dx, dy, radius){
   this.x=x;
   this.y=y;
   this.dx=dx;
   this.dy=dy;
   this.radius=radius;
   this.strokeColor="black";
   this.fillColor="red";
}

// This is an array that will hold all the balls on the canvas
var balls = [];

var canvas;
var context;

window.onload = function(){
   canvas = document.getElementById("canvas");
   context = canvas.getContext("2d");

   canvas.onmousedown = canvasClick;

   // Redraw every 20 milliseconds
   setTimeout(drawFrame, 20);
}

function addBall(){
   // Get the requested size.
   var radius = parseFloat(document.getElementById("ballSize").value);

   // Create the new ball.
   var ball = new Ball(50,50,1,1,radius);

   // Store it in the ball array.
   balls.push(ball);

   // Play background music, if it's not already playing.
   document.getElementById("backgroundMusic").play();
}

function clearBalls(){
   // Remove all the balls.
   balls = [];

   // Stop background music.
   document.getElementById("backgroundMusic").pause();
   document.getElementById("backgroundMusic").currentTime=0;
}

function drawFrame(){
   // Clear the canvas.
   context.clearRect(0,0,canvas.width,canvas.height);

   // Note that you need to call beginPath() to make sure
   // you don't redraw part of what you were drawing before.
   context.beginPath();

   // Go through all the balls.
   for(var i in balls){
       // Move each ball to its new position.
       var ball = balls[i];
       ball.x += ball.dx;
       ball.y += ball.dy;

       // Add in a "gravity" effect that makes the ball fall faster.
       if((ball.y) < canvas.height)
          ball.dy += 0.22;

       // Add in a "friction" effect that slows down the ball's side-to-side motion.
       ball.dx = ball.dx * 0.998;

       // If the ball has hit the side, bounce it.
       if((ball.x + ball.radius > canvas.width) || (ball.x - ball.radius < 0)){
          boing();
          ball.dx = -ball.dx;
       }

       // If the ball has hit the bottom, bounce it, but slow it down slightly.
       if((ball.y + ball.radius > canvas.height) || (ball.y - ball.radius < 0)){
           boing();
           ball.dy = -ball.dy*0.96;
       }

       // Check if the user wants lines.
       if(!document.getElementById("connectedBalls").checked){
          context.beginPath();
          context.fillStyle = ball.fillColor;
       }
       else{
          context.fillStyle = "white";
       }

       // Draw the ball.
       context.arc(ball.x, ball.y, ball.radius, 0, Math.PI*2);
       context.lineWidth = 1;
       context.fill();
       context.stroke();

   }

   // Draw the next frame in 20 milliseconds.
   setTimeout(drawFrame, 20);
}

   function canvasClick(e){
      // Get the canvas click coordinates.
      var clickX = e.pageX - canvas.offsetLeft;
      var clickY = e.pageY - canvas.offsetTop;

      // Look for the clicked ball.
      for(var i in balls){
         var ball = balls[i];
         if((clickX > (ball.x-ball.radius)) && (clickX < (ball.x+ball.radius))){
            if((clickY > (ball.y-ball.radius)) && (clickY < (ball.y+ball.radius))){
               // Change the clicked ball's speed.
               ball.dx -= 2;
               ball.dy -= 3;
               return;
            }
         }
      }
   }

   var audioElementCount = 3;
   var audioElementIndex = 1;

   function boing(){
      // Rollover to the next <audio> element in the sequence.
      var audioElementName = "audio" + audioElementIndex;
      var audio = document.getElementById(audioElementName);

      audio.currentTime = 0;
      audio.play();

      if(audioElementIndex == audioElementCount){
         audioElementIndex = 1;
      }
      else{
         audioElementIndex += 1;
      }
   }
