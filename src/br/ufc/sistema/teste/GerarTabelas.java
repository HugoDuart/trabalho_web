package br.ufc.sistema.teste;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelas 
{

	public static void main(String[] args) 
	{
			EntityManagerFactory fabrica = Persistence.
					createEntityManagerFactory("trabalho_final");
			fabrica.close();
	}

}
