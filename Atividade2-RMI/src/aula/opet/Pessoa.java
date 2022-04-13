package aula.opet;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Pessoa extends Remote {

	String getHello() throws RemoteException;

	String getFaixa(int idade) throws RemoteException;

}
