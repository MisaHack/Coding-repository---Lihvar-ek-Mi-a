var canvas;
var context;
var rad=(2*Math.PI)/60;

window.onload = function(){
  canvas = document.getElementById("clock");
  context = canvas.getContext("2d");
  context.translate(250,250);

  draw();
}

function draw(){

  context.clearRect(-250,-250,canvas.width,canvas.height);

  context.lineWidth = 3;

  context.beginPath();
  context.arc(0,0,150,0,2*Math.PI);
  context.fillStyle = "rgba(66, 206, 244,0.5)";
  context.fill();
  context.stroke();

  context.beginPath();
  var gradient = context.createLinearGradient(-150,0,150,0);
  gradient.addColorStop("0","magenta");
  gradient.addColorStop(".25","blue");
  gradient.addColorStop(".50","green");
  gradient.addColorStop(".75","yellow");
  gradient.addColorStop("1.0","red");
  context.arc(0,0,150,0,2*Math.PI);
  context.fillStyle = gradient;
  context.fill();
  context.stroke();

  //Broj podeoka na satu
  var copies = 60;

  //Zaboravio sam beginPath() pre crtanja linije!!
  //Zato se pojavila dupla linija, to nije bilo dobro
  context.beginPath();
  for(var i=1; i <= copies; i++){
     context.rotate(rad);
     context.moveTo(0,140);
     context.lineTo(0,150);
  }
  context.stroke();

  /*
  var copies_big = 4;
  context.beginPath();
  context.lineWidth = 5;
  for(var i=1; i<= copies_big; i++){
     context.rotate(2*Math.PI/4);
     context.moveTo(0,135);
     context.lineTo(0,150);
  }
  context.stroke();
  */



  context.beginPath();
  //context.save();

  context.moveTo(0,0);
  context.lineTo(0,130);
  context.rotate(rad);

  context.stroke();
  //context.restore();

  setTimeout(draw, 1000);


}
