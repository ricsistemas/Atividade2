package aula.opet;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

	private static final int PORT = 1097;
	private static Registry registry;

	public static void startRegistry() throws RemoteException {
		// Create server registry
		registry = LocateRegistry.createRegistry(PORT);
	}

	public static void registerObject(String name, Remote remoteObj) throws RemoteException, AlreadyBoundException {

		registry.rebind(name, remoteObj);

		System.out.println("Registado: " + name + " -> " + remoteObj.getClass().getName() + "[" + remoteObj + "]");
	}

	static void shutdown() throws RemoteException {

	};

	public static void main(String args[]) throws Exception {

		System.out.println("Inicio do Servidor...");
		try {
			startRegistry();
			registerObject(Pessoa.class.getSimpleName(), new PessoaImplem());
			registerObject(Calculadora.class.getSimpleName(), new CalculadoraImplem());

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		// Server was the start, and was listening to the request from the client.
		System.out.println("Servidor iniciado!");
	}
}
