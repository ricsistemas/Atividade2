package aula.opet;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {

	public long add(long x, long y) throws RemoteException;

	public double RealToDolar(double real, double taxa) throws RemoteException;

	public double RealToEuro(double real, double taxa) throws RemoteException;

	public int Multiplica(int a, int b) throws RemoteException;

	public Double Divid(double a, double b)throws RemoteException;

	public int Subtrai(int a, int b)throws RemoteException;

}
