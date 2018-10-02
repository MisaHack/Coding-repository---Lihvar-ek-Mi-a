function startEdit(){
   //Make the element editable.
   var element = document.getElementById("editableElement");
   element.contentEditable = true;
}

function stopEdit(){
   //Return the element to normal.
   var element = document.getElementById("editableElement");
   element.contentEditable = false;

   //Show the markup in a message box.
   alert("Your edited content: " + element.innerHTML);
}
