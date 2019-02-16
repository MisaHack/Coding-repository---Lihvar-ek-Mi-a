var squarePosition_y = 0;
var squarePosition_x = 1100;

function drawFrame(){
  var canvas = document.getElementById("animation");
  var context = canvas.getContext("2d");

   //Clean the canvas
   context.clearRect(0,0,canvas.width,canvas.height);

   //Call beginPath() to make sure you don't
   //redraw part of what you were drawing before.
   context.beginPath();

   //Draw a 10x10 square, at the current position.
   context.rect(squarePosition_x,squarePosition_y,50,50);
   context.lineStyle = "black";
   context.lineWidth = 1;
   context.stroke();

   //Make the square down 1 pixel
   //(where it will be drawn in the next frame)
   squarePosition_y += 1;

   //Draw the next frame in 20 milliseconds
   setTimeout(drawFrame,20);

   if(squarePosition_y > canvas.height){
      squarePosition_y = -50;
      context.rect(squarePosition_x,squarePosition_y,50,50);
   }
}
