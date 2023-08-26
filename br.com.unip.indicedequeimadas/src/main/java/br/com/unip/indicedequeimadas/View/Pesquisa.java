package br.com.unip.indicedequeimadas.View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Pesquisa extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesquisa frame = new Pesquisa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pesquisa() {
		setBounds(100, 100, 450, 300);

	}

}
