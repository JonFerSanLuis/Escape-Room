package Main;

import utilidades.Inventario;

import java.awt.EventQueue;

import Inicio.Home;
import Inicio.Juego;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
