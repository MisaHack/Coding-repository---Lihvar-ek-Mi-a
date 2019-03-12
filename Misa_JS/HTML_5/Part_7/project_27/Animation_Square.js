var squarePosition_y = 0;
var squarePosition_x = 1100;
var posY = -50;
var triger = false;
var go_now = true;

var rad = 0;

var canvas;
var context;

function drawFrame(){
  canvas = document.getElementById("animation");
  context = canvas.getContext("2d");

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

   if(squarePosition_y+50 > canvas.height){
      triger = true;

      if(go_now == false){
         go_now = true;
         posY = -50;
      }
   }

   if(triger){
     context.rect(squarePosition_x,posY,50,50);
     context.lineStyle = "black";
     context.lineWidth = 1;
     context.stroke();
     posY++;
   }

   if(posY+50 > canvas.height && go_now == true){
      squarePosition_y = -50;
      go_now = false;
   }

   //Ovaj deo koda sam ubacio da probam menjanje sadrzaja pagagrafa
   //u realnom vremenu, morao sam ovde da ubacim zato sto se petlja
   //beskoncno vrti pa ce vrednosti biti ispisivane redovno po 1 sekund
   var today = new Date();
   document.getElementById("p").innerHTML = today.getSeconds();

   //Draw the next frame in 20 milliseconds
   setTimeout(drawFrame,20);
}
