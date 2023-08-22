package br.com.indicequeimadas.controles;

public class Fila {
	/**
	 * 
	 * VARIAVEL QUE ARMAZENA VALORES DA FILA
	 * 
	 */

	private String[] valores;

	/**
	 * 
	 * POSICAO DO PRIMEIRO VALOR DA FILA
	 * 
	 */

	private int primeiro;

	/**
	 * 
	 * POSICAO DO ULTIMO VALOR DA FILA
	 * 
	 */

	private int ultimo;

	/**
	 * 
	 * POSICAO DO VALOR TOTAL DA FILA
	 * 
	 */

	private int total;

	/*
	 * CONSTRUTOR DA CLASS FILA.
	 *
	 * 
	 * 
	 * @param tamMax - VARIAVEL DO TIPO INT QUE IRA DEFINIR TAMANHO MAXIMO DA FILA.
	 */

	public Fila(int tamMax) {

		valores = new String[tamMax];
		primeiro = 0;
		ultimo = 0;

		total = 0;

	}

	/**
	 * 
	 * PARA INSERIR ELEMENTO NA FILA.
	 *
	 * 
	 * 
	 * @param elemento - VARIAVEL DO TIPO STRING QUE IRA SER INSERIDO A FILA.
	 */

	public void inserir(String elemento) {
		valores[ultimo] = elemento;
		ultimo = (ultimo + 1) % valores.length;
		total++;
	}

	/**
	 * 
	 * RETORNA O PROXIMO ELEMENTO DA FILA E RETIRA ELE DA FILA.
	 *
	 * @return String - RETORNA O PROXIMO ELEMENTO DA FILA.
	 * 
	 */

	public String retirar() {

		String elemento = valores[primeiro];
		primeiro = (primeiro + 1) % valores.length;
		total--;
		return elemento;

	}

	/**
	 * 
	 * PARA RETORNAR SE A FIAL ESTA VAZIA.
	 * 
	 * @return boolean - SE A FILA ESTA VAZIA.
	 * 
	 */

	public boolean isEmpty() {
		return total == 0;
	}

	/**
	 * 
	 * PARA RETORNAR SE A FILA ESTA CHEIA.
	 * 
	 * @return boolean - SE A FILA ESTA CHEIA.
	 * 
	 */

	public boolean isFull() {

		return total == valores.length;

	}
}