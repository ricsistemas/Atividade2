package aula.opet;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PessoaImplem extends UnicastRemoteObject implements Pessoa {

	protected PessoaImplem() throws RemoteException {
		super();

	}

	private static final long serialVersionUID = 1L;

	@Override
	public String getHello() throws RemoteException {
		return "Olá Mundo!";
	}

	@Override
	public String getFaixa(int idade) {
		String faixa = "";
		if (idade < 18)
			faixa = "Jovem";
		else if (idade > 18 && idade < 60)
			faixa = "Adulto";
		else
			faixa = "Idoso";
		return faixa;

	}

}
