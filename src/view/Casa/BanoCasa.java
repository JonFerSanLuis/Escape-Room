package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import utilidades.ImagenLoader;

import javax.swing.JButton;

public class BanoCasa extends JPanel {

	private Image backgroundImage;
    private String backgroundFile;
    JLabel bañoLabel;
    
    ImagenLoader img = new ImagenLoader();
    
	public BanoCasa(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		backgroundFile = "/img/bañoCasa.jpg";
        
        JButton btnDiario = new JButton("");
        btnDiario.setBounds(0, 381, 89, 44);
        btnDiario.setOpaque(false);
        btnDiario.setBackground(new Color(0, 0, 0, 0));
        btnDiario.setBorderPainted(false); // No dibujar el borde
        btnDiario.setFocusPainted(false);
        btnDiario.setContentAreaFilled(false);
        btnDiario.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnDiario);

		JLabel lblFlechaPasillo = new JLabel("");
		lblFlechaPasillo.setBounds(443, 435, 209, 115);
		
		lblFlechaPasillo.setIcon(img.scaleImage("/img/FlechaVolverSalonOFF.png", lblFlechaPasillo.getWidth(), lblFlechaPasillo.getHeight()));
		
		JButton btnVolverPasillo = new JButton("");
		btnVolverPasillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				juego.cambiarEscena("recibidor");
			}
		});
		btnVolverPasillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFlechaPasillo.setIcon(img.scaleImage("/img/FlechaVolverSalonON.png", lblFlechaPasillo.getWidth(), lblFlechaPasillo.getHeight()));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFlechaPasillo.setIcon(img.scaleImage("/img/FlechaVolverSalonOFF.png", lblFlechaPasillo.getWidth(), lblFlechaPasillo.getHeight()));
			}
		});
		
		btnVolverPasillo.setBounds(475, 449, 133, 81);
		btnVolverPasillo.setBackground(new Color(0, 0, 0, 0));
		btnVolverPasillo.setOpaque(false);
		btnVolverPasillo.setBorderPainted(false);
		btnVolverPasillo.setContentAreaFilled(false);
		
		btnDiario.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVolverPasillo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		add(btnVolverPasillo);
		add(lblFlechaPasillo);
		
		// Mostrar la imagen de fondo
		bañoLabel = new JLabel();
		bañoLabel.setBounds(0, 0, 950, 600);
		bañoLabel.setIcon(img.scaleImage(backgroundFile, 950, 600)); // Establecer la imagen por defecto
		add(bañoLabel); // Agregar al final para que quede encima del botón
	}

}
