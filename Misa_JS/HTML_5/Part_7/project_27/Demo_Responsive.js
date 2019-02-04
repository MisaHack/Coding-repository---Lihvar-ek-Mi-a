window.onload = function canv(){
   var canvas = document.getElementById("drawingCanvas");
   var context = canvas.getContext("2d");

   context.moveTo(10,10);
   context.lineTo(400,30);
   //line thickness
   context.lineWidth = 10;
   //line color
   context.strokeStyle = "rgb(96, 219, 217)";
   context.stroke();

   //Set line width and color (for all the lines)
   context.lineWidth = 20;
   context.strokeStyle = "rgb(205,40,40)";

   //Draw the first line, with the standard butt ending
   context.beginPath();
   context.moveTo(10,50);
   context.lineTo(400,50);
   context.lineCap = "butt";
   context.stroke();

   //Draw the second line, with a round cap
   context.beginPath();
   context.moveTo(10,120);
   context.lineTo(400,120);
   context.lineCap = "round";
   context.stroke();

   //Draw the third line, with a square cap
   context.beginPath();
   context.moveTo(10,190);
   context.lineTo(400,190);
   context.lineCap = "square";
   context.stroke();

   //Dividing end line
   context.lineWidth = 3;
   context.strokeStyle = "rgb(0,0,0)";

   context.beginPath();
   context.moveTo(400,40);
   context.lineTo(400,200);
   context.stroke();

   //Drawing triangle
   context.beginPath();
   context.moveTo(650,50);
   context.lineTo(450,250);
   context.lineTo(850,250);
   context.lineTo(650,30);

   context.lineWidth = 10;
   context.strokeStyle = "red";

   context.closePath();
   context.fillStyle = "blue";
   context.fill();

   context.stroke();

   //Drawing triangle - better way
   context.beginPath();
   context.moveTo(1100,50);
   context.lineTo(900,250);
   context.lineTo(1300,250);
   context.closePath();

   context.lineJoin = "bevel";

   context.fillStyle = "green";
   context.fill();

   context.lineWidth = 10;
   context.strokeStyle = "red";
   context.stroke();

   //Drawing rectangle
   context.beginPath();
   context.fillStyle = "orange";
   context.fillRect(50,300,100,200);

   context.lineWidth = 5;
   context.strokeStyle = "purple";
   context.strokeRect(50,300,100,200);

   //Drawing ARC
   context.beginPath();
   var centerX = 300;
   var centerY = 400;
   var radius = 100;
   var startingAngle = 0 * Math.PI;
   var endingAngle = 1 * Math.PI;

   context.arc(centerX, centerY, radius, startingAngle, endingAngle);

   context.closePath();

   context.stroke();

   //Drawing CIRCLE
   context.beginPath();
   var centerX = 550;
   var centerY = 400;
   var radius = 100;
   var startingAngle = 0;
   var endingAngle = 2 * Math.PI;

   context.arc(centerX, centerY, radius, startingAngle, endingAngle);

   context.strokeStyle = "rgb(50, 85, 104)";

   context.stroke();

   //Drawing Bezier curve - Left Hearth
   context.beginPath();
   context.moveTo(854,456);

   var control1_x = 834;
   var control1_y = 260;
   var control2_x = 634;
   var control2_y = 404;

   var endPointX = 854;
   var endPointY = 550;

   context.bezierCurveTo(control1_x, control1_y, control2_x, control2_y, endPointX, endPointY);

   context.fillStyle = "red";
   context.fill();

   context.stroke();

   //Drawing Bezier curve - Right Hearth
   context.beginPath();
   context.moveTo(854,456);

   var control1_x = 874;
   var control1_y = 260;
   var control2_x = 1074;
   var control2_y = 404;

   var endPointX = 854;
   var endPointY = 550;

   context.bezierCurveTo(control1_x, control1_y, control2_x, control2_y, endPointX, endPointY);

   context.fillStyle = "red";
   context.fill();

   context.stroke();

   //Drawing 3 rectangles
   context.beginPath();
   context.rect(50,600,30,30);
   context.rect(90,600,30,30);
   context.rect(130,600,30,30);
   context.stroke();

   //Drawing 3 rectangles - with TRANSLATE
   context.beginPath();
   context.strokeStyle = "red";
   context.rect(200,600,30,30);

   context.translate(40,0);
   context.rect(200,600,30,30);

   context.translate(40,0);
   context.rect(200,600,30,30);

   context.stroke();

   //Drawing - Spirograph
   context.beginPath();
   context.save(); //saves the current state of coordinate system
   context.translate(380,600); //coordinate begining is here now

   var copies = 10;

   for(var i=1; i < copies; i++){
      context.rotate(2 * Math.PI * 1/(copies-1));
      context.rect(0,0,60,60);
   }

   context.stroke();

   context.restore();// returns previous state of coordinate system

   //Drawing tranparent shapes - BEGINING OF COORDINATE SYSTEM IS NOT CORRECT
   //I have solved the problem with save() and restore()
   context.beginPath();

   context.fillStyle = "rgb(100,150,185)";
   context.lineWidth = 10;
   context.strokeStyle = "red";
   context.arc(600,600,100,0,2 * Math.PI);
   context.fill();
   context.stroke();

   context.beginPath();
   context.fillStyle = "rgba(100,150,185,0.5)";
   context.moveTo(650,600);
   context.lineTo(450,800);
   context.lineTo(750,800);
   context.closePath();
   context.fill();
   context.stroke();

   //Drawing with Composite Operations - source-atop
   context.beginPath();

   //context.moveTo(800,600);
   context.fillStyle = "blue";
   context.fillRect(800,600,70,70);
   context.stroke();

   context.globalCompositeOperation = "source-atop";

   context.beginPath();
   context.fillStyle = "red";
   context.arc(800,600,35,0, 2*Math.PI, true);
   context.fill();
   context.stroke();



}
