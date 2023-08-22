package br.com.indicequeimadas.controles;

public class Pilha {
	/**
	 * 
	 * VARIAVEL QUE ARMAZENA TODOS OS ELEMENTOS
	 * 
	 */

	private String elementos[];

	/**
	 * 
	 * VARIAVEL QUE ARMAZENA O TOPO DA PILHA
	 * 
	 */

	private int topo;

	/**
	 * 
	 * VARIAVEL QUE ARMAZENA TAMANHO MAXIMO DA PILHA
	 * 
	 */

	private int maxPilha;

	/**
	 *
	 * 
	 * 
	 * @param maximoPilha - VARIAVEL DO TIPO INT QUE IRA DEFINIR TAMANHO MAXIMO DA
	 *                    PILHA.
	 * 
	 */

	public Pilha(int maximoPilha) {
		maxPilha = maximoPilha;
		elementos = new String[maximoPilha];
		topo = -1;
	}

	/**
	 *
	 * 
	 * 
	 * @param elemento - ELEMENTO DO TIPO STRING QUE SERA ADICIONADO NA PILHA.
	 * @throws ArrayStoreException - CASO COLOQUE MAIS ELEMENTO QUE SUPORTA A PILHA.
	 */

	public void push(String elemento) throws ArrayStoreException {

		if (maxPilha < topo)

			new Throwable(new ArrayStoreException());
		topo++;
		elementos[topo] = elemento;

	}

	/**
	 * 
	 * RETORNA O PROXIMO ELEMENTO DA PILHA E RETIRA ELE DA PILHA.
	 *
	 * 
	 * 
	 * @return RETORNA O PROXIMO ELEMENTO DA PILHA.
	 * 
	 * @throws ArrayIndexOutOfBoundsException - CASO TENTE TIRAR ELEMENTOS DA PILHA
	 * 
	 *                                        VAZIA.
	 * 
	 */

	public String pop() throws ArrayIndexOutOfBoundsException {
		if (topo == -1)
			new Throwable(new ArrayIndexOutOfBoundsException());

		String e;
		e = top();
		topo--;
		System.out.println(e);
		return e;
	}

	/**
	 * 
	 * RETORNA SE A PILHA ESTA VAZIA.
	 *
	 * 
	 * 
	 * @return boolean - RETORNA SE A PILHA ESTA VAZIA.
	 * 
	 */

	public boolean isEmpty() {
		return (topo < 0);
	}

	/**
	 * 
	 * RETORNA SE PILHA ESTA CHEIA.
	 *
	 * 
	 * 
	 * @return boolean - RETORNA SE PILHA ESTA CHEIA.
	 * 
	 */

	public boolean isFull() {
		return (topo == maxPilha);
	}

	/**
	 * 
	 * RETORNA O PROXIMO ELEMENTO DA PILHA MAS NAO RETIRA ELE DA PILHA.
	 *
	 * 
	 * 
	 * @return String - RETORNA O ELEMENTO QUE ESTA NO TOPO DA PILHA.
	 * 
	 */

	public String top() {

		return elementos[topo];

	}

}
