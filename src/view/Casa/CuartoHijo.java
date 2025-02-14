package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import utilidades.ImagenLoader;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CuartoHijo extends JPanel {
	
	private JLabel lblPasillo2Piso;
	private JButton btnTV;
	private JLabel lblDestello;
	
	ImagenLoader img = new ImagenLoader();

	public CuartoHijo(Juego juego) {
	    setBounds(0, 0, 950, 600);
	    setLayout(null);

	    String backgroundFile = "/img/CuartoHijo.jpg";

	    // Crear la imagen de fondo
	    lblPasillo2Piso = new JLabel();
	    lblPasillo2Piso.setBounds(0, 0, 950, 600);
	    lblPasillo2Piso.setIcon(img.scaleImage(backgroundFile, 950, 600));

	    btnTV = new JButton("");
	    btnTV.setBounds(20, 230, 78, 102);
	    btnTV.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		juego.cambiarEscena("verPantalla");
	    	}
	    });
	    
	    btnTV.setContentAreaFilled(false);
	    btnTV.setBorderPainted(false);
	    btnTV.setFocusPainted(false);
	    btnTV.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JLabel lblFlechaPasillo = new JLabel("");
		lblFlechaPasillo.setBounds(175, 410, 309, 190);

		lblFlechaPasillo.setIcon(img.scaleImage("/img/FlechaVolverPasilloPadresOFF.png", 309, 190));
		// Boton pasillo
		JButton btnVolverPasillo = new JButton("");
		btnVolverPasillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				juego.cambiarEscena("pasillo2");
			}
		});
		btnVolverPasillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFlechaPasillo.setIcon(img.scaleImage("/img/FlechaVolverPasilloPadresON.png", 309, 190));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblFlechaPasillo.setIcon(img.scaleImage("/img/FlechaVolverPasilloPadresOFF.png", 309, 190));
			}
		});
		
		JButton btnPhone = new JButton("");
		btnPhone.setBounds(579, 373, 70, 22);
		btnPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(juego.getCoverPadreFin()==false) {
					juego.cambiarEscena("telefono");
				}else {
					juego.cambiarEscena("telDesbloq");	
				}
			}
		});
		
		btnPhone.setBackground(new Color(0, 0, 0, 0));
		btnPhone.setOpaque(false);
		btnPhone.setBorderPainted(false);
		btnPhone.setContentAreaFilled(false);
		btnPhone.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnPhone);

		btnVolverPasillo.setBounds(260, 456, 155, 106);
		btnVolverPasillo.setBackground(new Color(0, 0, 0, 0));
		btnVolverPasillo.setOpaque(false);
		btnVolverPasillo.setBorderPainted(false);
		btnVolverPasillo.setContentAreaFilled(false);
		btnVolverPasillo.setCursor(new Cursor(Cursor.HAND_CURSOR));

		add(btnVolverPasillo);
		add(lblFlechaPasillo);

	    add(btnTV);
	    add(lblPasillo2Piso);
	    
	}
}
