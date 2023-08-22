package br.com.indicequeimadas.arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escrever {

	/**
	 * 
	 * @param local   ESCRITO.
	 * @param escrita String - OQUE SERA ESCRITO.
	 * 
	 */

	public static void Escrita(String local, String escrita) {
		try {
			BufferedWriter escrever = new BufferedWriter(new FileWriter(local));
			escrever.write(escrita.trim());
			escrever.flush();
			escrever.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
