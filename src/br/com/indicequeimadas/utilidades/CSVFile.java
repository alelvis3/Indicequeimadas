package br.com.indicequeimadas.utilidades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFile {
	/**
	 *
	 * @param csvLocation STRING - LOCAL DO CSV.
	 * @param csvDiv      STRING - CASO A CSV ESTEJA DIVIDO POR "," OU ";" OU
	 *                    QUALQUER OUTRA COISA PRECISA SER INFORMADO NESTE PARAMETRO
	 *                    PARA RETORNAR SEPARADOS.
	 * @return ArrayList<String[]> - RETORNA A LEITURA DO ARQUIVO CSV SEM CABECARIO
	 *         COMO UMA ARRAYLIST DE STRING[], EXEMPLO ARRAYLIST A0{String[] S0{"0",
	 *         "FERNANDO", "TESTE"}, String[] S1{"1", "VITOR", "TESTE"}}
	 */

	public ArrayList<String[]> readToList(String csvLocation, String csvDiv) {
		BufferedReader br = null;
		String line = "";
		ArrayList<String[]> returnReadArray = new ArrayList<String[]>();
		boolean topTags = true;
		try {

			br = new BufferedReader(new FileReader(csvLocation));
			do {

				if (topTags) {// PARA EXCLUIR CABECARIO

					line = br.readLine();// IRA PULAR A LINHA

					topTags = false;// DESATIVAR CHECAGEM

				}

				String[] data = line.split(csvDiv);// DIVIDIR PELO PARAMETRO QUE FOI INFORMADO
				for (int i = 0; i < data.length; i++) {// PERCORRER ENTRE STRING[] QUE NASCERAM COM DIVISAO
					data[i].replaceAll("'", "''");// TROCAR TODOS "'" POR "''"
					if (data[i].isEmpty())// SE NAO CONTIVER NADA ESCREVER "NULL"
						data[i] = "NULL";

				}

				returnReadArray.add(data);// ADICIONAR NOVA LINHA QUE FOI LIDA NA ARRAY QUE IRA RETORNAR
			} while ((line = br.readLine()) != null);
		} catch (FileNotFoundException e) {// ERRO CASO NAO ENCONTRE O ARQUIVO
			e.printStackTrace();

		} catch (IOException e) {// ERRO NA LEITURA e.printStackTrace();
		} finally {// SEMPRE IRA FECHAR ARQUIVO APOS LER MESMO QUE TENHA UM ERRO
			if (br != null) {
				try {
					br.close();

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

		return returnReadArray;// ArrayList<String[]> QUE IRA RETORNAR

	}

}
