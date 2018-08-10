package networkPackage.server;

import abstractFigures.Player1_Board;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import networkPackage.remote.SubmarineNet;

/**
 * Implementacija potapanja podmornica
 * 
 * @author <a href="mailto:lihvarcekmisa@yahoo.com">Lihvarcek Misa</a>
 *
 */

public class SubmarineNetImpl extends UnicastRemoteObject implements SubmarineNet{
	private static final long serialVersionUID = 1L;
	
	protected SubmarineNetImpl() throws RemoteException {
	}

	@Override
	public boolean shootSubmarine(int x1, int y1) throws RemoteException {
		Player1_Board p = new Player1_Board();
		return p.shootSubmarine(x1, y1);
	}

}
