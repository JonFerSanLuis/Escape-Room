package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import utilidades.Cronometro;
import utilidades.ImagenLoader;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BanoCasa extends JPanel {

	private Image backgroundImage;
    private String backgroundFile;
    JLabel ba�oLabel;
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro
    
    ImagenLoader img = new ImagenLoader();
    
	public BanoCasa(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		backgroundFile = "/img/ba�oCasa.jpg";
        
        JButton btnDiario = new JButton("");
        btnDiario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("diario");
        	}
        });
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
		ba�oLabel = new JLabel();
		ba�oLabel.setBounds(0, 0, 950, 600);
		ba�oLabel.setIcon(img.scaleImage(backgroundFile, 950, 600)); // Establecer la imagen por defecto
		add(ba�oLabel); // Agregar al final para que quede encima del bot�n
		
		// Cronometro
        labelTiempo = new JLabel(Cronometro.getInstancia().getTiempoFormato());
        labelTiempo.setFont(new Font("Tahoma", Font.BOLD, 18)); // Fuente m�s grande para mejor visibilidad
        labelTiempo.setForeground(Color.WHITE); // Texto en blanco
        labelTiempo.setBackground(new Color(0, 0, 0)); // Fondo negro semi-transparente
        labelTiempo.setOpaque(true);
        labelTiempo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTiempo.setBounds(10, 10, 102, 30);
        
     // Agregar primero labelTiempo para asegurarnos de que est� al frente
        add(labelTiempo);
        setComponentZOrder(labelTiempo, 0); // Lo pone en la capa superior
        
     // Actualizar la etiqueta cada segundo (formato HH:MM:SS)
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText(Cronometro.getInstancia().getTiempoFormato()));
        actualizarTimer.start();

	}

}
