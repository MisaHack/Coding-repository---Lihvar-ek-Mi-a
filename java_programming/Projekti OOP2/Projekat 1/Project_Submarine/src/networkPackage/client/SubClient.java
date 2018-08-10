package networkPackage.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import networkPackage.remote.SubmarineNet;

public class SubClient {
   public static void main(String [] args) throws RemoteException, NotBoundException{
	  //pribavi referencu na udaljeni objekat pod imenom u konstanti
	  //RMI_NAME
			   
	   Registry reg = LocateRegistry.getRegistry(40);
 	   SubmarineNet remote = (SubmarineNet)reg.lookup(SubmarineNet.RMI_NAME);
			  
	   boolean z = remote.shootSubmarine(1, 1); // metod se izvrsava na serveru
			  
  	   System.out.println("The result is: " + z);
   }
}
