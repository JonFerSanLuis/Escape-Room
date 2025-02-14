package view.Casa;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import config.Config;
import utilidades.ImagenLoader;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelefonoDesbloq extends JPanel {
	
	ImagenLoader img = new ImagenLoader();
	
	JLabel lblMovil = new JLabel("");
	
	String background;

	public TelefonoDesbloq(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		background = "/img/telefono.png";

		JButton btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("cuartoHijo");
        	}
        });
        btnVolver.setBounds(51, 506, 89, 23);
        add(btnVolver);
        
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		
        lblMovil.setIcon(img.scaleImage(background, 950, 600));
		lblMovil.setBounds(0, 0, 950, 600);
		add(lblMovil);
	}

}
