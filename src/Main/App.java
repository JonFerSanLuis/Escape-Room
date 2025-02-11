package Main;

import utilidades.Inventario;

import java.awt.EventQueue;

import Inicio.Casa;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Casa casa = new Casa();
					casa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
