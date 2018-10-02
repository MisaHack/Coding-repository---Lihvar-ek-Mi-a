function startEdit(){
   //Turn on design mode in the <iframe>
   var editor = document.getElementById("pageEditor");
   editor.contentWindow.document.designMode = "on";
}

function stopEdit(){
   //Turn off design mode in the <iframe>
   var editor = document.getElementById("pageEditor");
   editor.contentWindow.document.designMode = "off";

   //Display the edited HTML (just to prove it's there)
   var htmlDisplay = document.getElementById("editedHTML");
   htmlDisplay.textContent = editor.contentWindow.document.body.innerHTML;
}
