package br.com.indicequeimadas.utilidades;

import java.util.ArrayList;

public class Ordenadores {

	/**
	 * 
	 * ORDENADOR DO TIPO RAPIDO
	 *
	 * 
	 * 
	 * @param vet ArrayList<Integer> - QUE SERA ORGANIZADA MAS OBJETIVO DELA SERA
	 *            TRABALHAR JUNTO COM CODIGO PARA ORGANIZAR A arrayOrdenar
	 * 
	 *            ArrayList<Integer>
	 * 
	 * @param esq INTEGER - POSICAO NA ESQUERDA QUE ESTA SENDO USADA PARA PROCESSAR
	 * @param dir INTEGER - POSICAO NA DIREITA QUE ESTA SENDO USADA PARA PROCESSAR
	 * @return ArrayList<Integer> - ORGANIZADA DE FORMA CRESCENTE
	 */

	public ArrayList<Integer> rapida(ArrayList<Integer> vet, int esq, int dir) {
		int pivo = esq, i, ch, j;

		for (i = esq + 1; i <= dir; i++) {
			j = i;
			if (vet.get(j) < vet.get(pivo)) {
				ch = vet.get(j);
				while (j > pivo) {

					vet.set(j, vet.get(j - 1));
					j--;
				}

				vet.set(j, ch);
				pivo++;
			}

		}

		if (pivo - 1 >= esq) {
			rapida(vet, esq, pivo - 1);
		}

		if (pivo + 1 <= dir) {
			rapida(vet, pivo + 1, dir);
		}

		return vet;

	}

	/**
	 *
	 * 
	 * 
	 * @param vet          ArrayList<Integer> - QUE SERA ORGANIZADA MAS OBJETIVO
	 *                     DELA SERA TRABALHAR JUNTO COM CODIGO PARA ORGANIZAR A
	 *                     arrayOrdenar ArrayList<Integer>
	 * 
	 * @param esq          INTEGER - POSICAO NA ESQUERDA QUE ESTA SENDO USADA PARA
	 *                     PROCESSAR
	 * 
	 * @param dir          INTEGER - POSICAO NA DIREITA QUE ESTA SENDO USADA PARA
	 *                     PROCESSAR
	 * 
	 * @param arrayOrdenar ArrayList<Integer> - QUE SERA ORGANIZADA
	 * 
	 * @return ArrayList<Integer> - ORGANIZADA DE FORMA CRESCENTE
	 */

	public ArrayList<String> rapidaOrdenaArray(ArrayList<Integer> vet, int esq, int dir,
			ArrayList<String> arrayOrdenar) {
		int pivo = esq, i, ch, j;
		String chO;
		for (i = esq + 1; i <= dir; i++) {
			j = i;
			if (vet.get(j) < vet.get(pivo)) {
				ch = vet.get(j);
				chO = arrayOrdenar.get(j);
				while (j > pivo) {
					vet.set(j, vet.get(j - 1));

					arrayOrdenar.set(j, arrayOrdenar.get(j - 1));

					j--;

				}

				vet.set(j, ch);
				arrayOrdenar.set(j, chO);
				pivo++;
			}

		}

		if (pivo - 1 >= esq) {

			rapidaOrdenaArray(vet, esq, pivo - 1, arrayOrdenar);

		}

		if (pivo + 1 <= dir) {

			rapidaOrdenaArray(vet, pivo + 1, dir, arrayOrdenar);

		}

		return arrayOrdenar;

	}

	/**
	 *
	 * 
	 * 
	 * @param vet ArrayList<Integer> - QUE SERA ORGANIZADA
	 * 
	 * @return ArrayList<Integer> - RETORNANDO OS NUMEROS ORGANIZADOS DE FORMA
	 *         CRESCENTE
	 * 
	 */

	public ArrayList<Integer> insercao(ArrayList<Integer> vet) {

		for (int i = 0; i < vet.size() - 1; i++) {
			int indiceMinimo = i;
			for (int j = i + 1; j < vet.size() - 1; j++) {
				if (vet.get(j) < vet.get(indiceMinimo)) {
					indiceMinimo = j;

				}

			}

			int tmp = vet.get(indiceMinimo);
			vet.set(indiceMinimo, vet.get(i));
			vet.set(i, tmp);
		}

		return vet;

	}

	/**
	 *
	 * 
	 * 
	 * @param vet          ArrayList<Integer> - QUE SERA ORGANIZADA MAS OBJETIVO
	 *                     DELA SERA TRABALHAR JUNTO COM CODIGO PARA ORGANIZAR A
	 *                     arrayOrdenar ArrayList<Integer>
	 * 
	 * @param arrayOrdenar ArrayList<Integer> - QUE SERA ORGANIZADA
	 * @return ArrayList<Integer> - ORGANIZADA DE FORMA CRESCENTE
	 */

	public ArrayList<String> insercaoOrdenaArray(ArrayList<Integer> vet, ArrayList<String> arrayOrdenar) {

		for (int i = 0; i < vet.size(); i++) {
			int indiceMinimo = i;
			for (int j = i + 1; j < vet.size(); j++) {

				if (vet.get(j) < vet.get(indiceMinimo)) {
					indiceMinimo = j;
				}

			}

			int tmp = vet.get(indiceMinimo);
			vet.set(indiceMinimo, vet.get(i));

			vet.set(i, tmp);
			String tmpOrdenar = arrayOrdenar.get(indiceMinimo);

			arrayOrdenar.set(indiceMinimo, arrayOrdenar.get(i));
			arrayOrdenar.set(i, tmpOrdenar);

		}
		return arrayOrdenar;
	}

}
