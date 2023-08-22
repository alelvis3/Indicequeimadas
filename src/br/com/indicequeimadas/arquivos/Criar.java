package br.com.indicequeimadas.arquivos;

import java.util.Formatter;

public class Criar {
	/*
	 * @param Local String - LOCAL AONDE ESTA O ARQUIVO A SER CRIADO
	 */
	public static void Bloco(String Local) {
		Formatter b;
		try {

			b = new Formatter(Local);
			b.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
