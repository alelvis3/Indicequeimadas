package br.com.indicequeimadas.arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.IOException;

public class Leitura {
	/**
	 *
	 * 
	 * 
	 * @param Local String - LOCAL QUE ESTA O ARQUIVO A SER LIDO.
	 * @return RETORNA OQUE FOI LIDO.
	 * 
	 */

	public static String Ler(String Local) {
		try {
			File Arquivo = new File(Local);

			FileReader ALido = new FileReader(Arquivo);
			BufferedReader Br = new BufferedReader(ALido);
			StringBuffer Ler = new StringBuffer();
			String line;

			while ((line = Br.readLine()) != null) {
				Ler.append(line);
				Ler.append("\n");
			}

			ALido.close();

			return Ler.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}