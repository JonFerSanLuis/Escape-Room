 package view.Casa;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Inicio.Juego;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Objetos.Objeto;
import config.Config;
import utilidades.Cronometro;
import utilidades.ImagenLoader;
import utilidades.Inventario;

public class CasaExteriorFinal extends JPanel {
	
	private JTextField textField;

	int txtPuerta;

	int txtPre;

	String CasaExterior;

	JLabel lblCasa;
	
	private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro
	
    Inventario inventario = new Inventario();
	
	ImagenLoader img = new ImagenLoader();

	public CasaExteriorFinal(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		juego.getInventario().setLlavePuerta(new Objeto(true, true, 001, "Llave", "La llave de la puerta delantera de la casa de Mikel", "/img/llaveCasa.png"));

		CasaExterior = "/img/CasaExteriorTexto.jpeg";

		lblCasa = new JLabel();
		lblCasa.setBackground(Color.BLACK);
		lblCasa.setIcon(img.scaleImage(CasaExterior, 950, 600)); // Establecer la imagen por defecto
		add(lblCasa);
		
		upgradeImage();

		// Añadir la imagen de fondo primero
		lblCasa.setBounds(0, 0, 950, 600);
		lblCasa.setHorizontalAlignment(SwingConstants.CENTER);

		ArrayList<JLabel> TxtIntroCasa = new ArrayList<>();

		JLabel TxtOutroCasa1 = new JLabel(Config.getTexto("iCantBelieve"));
		TxtOutroCasa1.setHorizontalAlignment(SwingConstants.CENTER);
		TxtOutroCasa1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtOutroCasa1.setForeground(Color.WHITE);
		TxtOutroCasa1.setBounds(50, 495, 875, 50);
		add(TxtOutroCasa1);
		TxtOutroCasa1.setVisible(true);

		JLabel TxtIntroCasa2 = new JLabel(Config.getTexto("iMustRush"));
		TxtIntroCasa2.setHorizontalAlignment(SwingConstants.CENTER);
		TxtIntroCasa2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtIntroCasa2.setForeground(Color.WHITE);
		TxtIntroCasa2.setBounds(50, 495, 875, 50);
		add(TxtIntroCasa2);
		TxtIntroCasa2.setVisible(false);

		TxtIntroCasa.add(TxtOutroCasa1);
		TxtIntroCasa.add(TxtIntroCasa2);

		txtPre = 0;

			JButton btnContinue = new JButton(Config.getTexto("btnContinuar"));
			btnContinue.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnContinue.setBounds(819, 468, 115, 23);
			btnContinue.setBackground(new Color(0, 0, 0, 0));
			btnContinue.setOpaque(false);
			btnContinue.setBorderPainted(false);
			btnContinue.setContentAreaFilled(false);
			btnContinue.setForeground(Color.GRAY);

			btnContinue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (txtPre == TxtIntroCasa.size() - 1) {
						juego.cambiarEscena("colegioIntro");
						txtPre = 0;
					} else {
						TxtIntroCasa.get(txtPre).setVisible(false);
						TxtIntroCasa.get(++txtPre).setVisible(true);
					}
				}
			});

			btnContinue.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnContinue.setForeground(Color.white);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnContinue.setForeground(Color.GRAY);
				}
			});

			btnContinue.setOpaque(false);
			btnContinue.setBorderPainted(false);
			btnContinue.setContentAreaFilled(false);

			add(btnContinue);

		add(lblCasa);
		
		labelTiempo = new JLabel(Cronometro.getInstancia().getTiempoFormato());
		labelTiempo.setFont(new Font("Tahoma", Font.BOLD, 18)); // Fuente más grande para mejor visibilidad
		labelTiempo.setForeground(Color.WHITE); // Texto en blanco
		labelTiempo.setBackground(new Color(0, 0, 0)); // Fondo negro semi-transparente
		labelTiempo.setOpaque(true);
		labelTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTiempo.setBounds(10, 10, 102, 30); 
		
		// Agregar primero labelTiempo para asegurarnos de que está al frente
		add(labelTiempo);
		setComponentZOrder(labelTiempo, 0); // Lo pone en la capa superior

        // Actualizar la etiqueta cada segundo con el formato HH:MM:SS
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText(Cronometro.getInstancia().getTiempoFormato()));
        actualizarTimer.start();

	}

	private void upgradeImage() {
		// Actualizar el fondo con la nueva imagen
		lblCasa.setIcon(img.scaleImage(CasaExterior, 950, 600));
		lblCasa.repaint(); // Redibujar para aplicar el cambio
	}

}
