function saveData(){
   var localData = document.getElementById("localData").value;
   var sessionData = document.getElementById("sessionData").value;

   localStorage.setItem("localData",localData);
   sessionStorage.setItem("sessionData",sessionData);
}

function loadData(){
   var localData = localStorage.getItem("localData",localData);
   var sessionData = sessionStorage.getItem("sessionData",sessionData);

   if(localData != null){
      document.getElementById("localData").value=localData;
   }
   if(sessionData != null){
      document.getElementById("sessionData").value=sessionData;
   }
}
