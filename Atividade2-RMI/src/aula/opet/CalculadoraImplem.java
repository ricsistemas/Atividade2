package aula.opet;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImplem extends UnicastRemoteObject implements Calculadora {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculadoraImplem() throws RemoteException {
		super();
	}

	@Override
	public long add(long x, long y) throws RemoteException {
		return x + y;
	}

	@Override
	public double RealToDolar(double real, double taxa) throws RemoteException {

		if (taxa < 1)
			return 0;
		return real / taxa;
	}

	@Override
	public double RealToEuro(double real, double taxa) throws RemoteException {

		if (taxa < 1)
			return 0;
		return real * taxa;
	}

	@Override
	public int Multiplica(int a, int b) {
		return a * b;

	}

	@Override
	public int Subtrai(int a, int b) {
		return a - b;

	}

	@Override
	public Double Divid(double a, double b) {
		if (b == 0)
			return a;
		return a / b;

	}

}
