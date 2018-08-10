package networkPackage.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interfejs potapanja podmornica.
 * 
 * @author <a href="mailto:lihvarcekmisa@yahoo.com">Lihvarcek Misa</a>
 *
 */

public interface SubmarineNet extends Remote{
   public static final String RMI_NAME = "SubmarineNetServer";
   
   boolean shootSubmarine(int x1,int y1) throws RemoteException;
}
