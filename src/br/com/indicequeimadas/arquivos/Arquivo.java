package br.com.indicequeimadas.arquivos;

import java.io.File;

public class Arquivo {

	/*
	 * @param local String - LOCAL AONDE ESTA O CSV A SER CRIADO.
	 * @param txt   String - OQUE IRA ESCREVER DENTRO.
	 */

	public static void CriarCSV(String local, String txt) {
		Criar.Bloco(local);
		Escrever.Escrita(local, txt);
	}

	/*
	 * @param f String - LOCAL AONDE ESTA O ARQUIVO PARA VERIFICAR SE EXISTE.
	 * 
	 * @return boolean - SE O ARQUIVO EXISTE.
	 */
	public static boolean Existe(File f) {
		return f.exists();
	}

}
