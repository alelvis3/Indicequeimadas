package br.com.indicequeimadas.inicio;

import java.awt.EventQueue;



import br.com.indicequeimadas.telas.Visualizar;


public class Principal {
	/**

	* VARIAVEL AONDE FICA A TELA

	*/

	private static Visualizar frame;
	/**

	* INICIO DO PROGRAMA, AONDE INSTANCIA A TELA E TORNA VISIVEL.
	*/
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { try {
			frame = new Visualizar(); frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});	
		/*
		 * 	PARA PEGAR A VARIAVEL VISUALIZAR.
		 * 	@return Visualizar - RETORNA A CLASSE VISUALIZAR DO TIPO JFRAME QUE ESTA
		 *  INSTANCIADA.
		 */
		


		
	}
	public static Object getVisualizar() {
		// TODO Auto-generated method stub
		return null;
	}

}



