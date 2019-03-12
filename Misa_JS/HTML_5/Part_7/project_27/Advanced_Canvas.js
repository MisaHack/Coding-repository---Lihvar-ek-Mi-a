function advanced(){
   var canvas = document.getElementById("advancedCanvas");
   var context = canvas.getContext("2d");

   //Create the image object
   context.beginPath();
   var img = new Image();

   //Attach a function to the onload event
   //This tells the browser what to do after the image
   //is loaded.
   img.onload = function(){
      context.drawImage(img,0,0,675,320);
   };

   //Load the image file.
   img.src = "robot.jpg";

   //New Image
   context.beginPath();
   var img_2 = new Image();

   img_2.onload = function(){
      context.drawImage(img_2,0,0,700,350,50,350,350,125);
   };

   img_2.src = "chrome.jpg";

   //Drawing Solid Text
   context.beginPath();
   context.font = "bold 20px Arial";

   context.textBaseline = "top";
   context.fillStyle = "black";
   context.fillText("Demo Text",50,600);

   //Drawing Outlined Text
   context.beginPath();
   context.font = "bold 40px Verdana, sans-serif";
   context.lineWidth = "1";
   context.strokeStyle = "red";
   context.strokeText("Outlined Text",200,580);

   //Draw the shadowed rectangle
   context.beginPath();
   context.rect(50,700,200,100);
   context.fillStyle = "rgb(142, 214, 255)";
   context.shadowColor = "rgb(187, 187, 187)";
   context.shadowBlur = 20;
   context.shadowOffsetX = 15;
   context.shadowOffsetY = 15;
   context.fill();
   context.stroke();

   //Draw the shadowed star
   context.beginPath();
   context.shadowOffsetX = 30;
   context.shadowOffsetY = 30;
   context.shadowBlur = 4;
   var img_3 = new Image();

   img_3.onload = function(){
      context.drawImage(img_3,300,650);
   };

   img_3.src = "star.png";

   //Draw three pieces of shadowed text
   context.beginPath();
   context.textBaseline = "top";
   context.font = "bold 20px Arial";
   context.shadowBlur = 3;
   context.shadowOffsetX = 2;
   context.shadowOffsetY = 2;
   context.fillStyle = "steelblue";
   context.fillText("This is a subtle, slightly old-fashioned shadow.",50,950);

   context.beginPath();
   context.shadowBlur = 5;
   context.shadowOffsetX = 40;
   context.shadowOffsetY = 40;
   context.fillStyle = "green";
   context.fillText("This is a distant shadow...",50,1000);

   context.beginPath();
   context.shadowBlur = 15;
   context.shadowOffsetX = 0;
   context.shadowOffsetY = 0;
   context.shadowColor = "black";
   context.fillStyle = "white";
   context.fillText("This shadow isn't offset. It creates a halo effect.",50,1100);

   //Drawing Image Patterns
   /*
   var img_4 = document.getElementById("wall");

   var pattern = context.createPattern(img_4,"repeat");

   context.fillStyle = pattern;
   context.rect(0,0,canvas.width,canvas.height);
   context.fill();
   */

   //Drawing Linear Gradient with 2 colors
   context.beginPath();
   var gradient = context.createLinearGradient(640,0,760,0);
   gradient.addColorStop(0,"magenta");
   gradient.addColorStop(1,"yellow");

   context.arc(700,1000,60,0,2*Math.PI);

   context.fillStyle = gradient;
   context.fill();
   context.stroke();

   //Drawing Linear Gradient with Multiple colors
   context.beginPath();
   var gradient = context.createLinearGradient(840,0,960,0);
   gradient.addColorStop("0","magenta");
   gradient.addColorStop(".25","blue");
   gradient.addColorStop(".50","green");
   gradient.addColorStop(".75","yellow");
   gradient.addColorStop("1.0","red");

   context.arc(900,1000,60,0,2*Math.PI);

   context.fillStyle = gradient;
   context.fill();
   context.stroke();

   //Drawing Radial Gradient with 2 colors
   context.beginPath();
   var gradient = context.createRadialGradient(1100,1000,10,1100,1000,50);
   gradient.addColorStop(0,"magenta");
   gradient.addColorStop(1,"yellow");

   context.arc(1100,1000,60,0,2*Math.PI);

   context.fillStyle = gradient;
   context.fill();
   context.stroke();

   //Drawing Radial Gradient with Multiple colors
   context.beginPath();
   var gradient = context.createRadialGradient(1300,1000,10,1300,1000,60);
   gradient.addColorStop("0","magenta");
   gradient.addColorStop(".25","blue");
   gradient.addColorStop(".50","green");
   gradient.addColorStop(".75","yellow");
   gradient.addColorStop("1.0","red");

   context.arc(1300,1000,60,0,2*Math.PI);

   context.fillStyle = gradient;
   context.fill();
   context.stroke();

   //Animation in Canvas - Falling square
   drawFrame();
}
