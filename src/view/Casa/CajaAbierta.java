package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import Objetos.Objeto;
import config.Config;
import utilidades.Cronometro;
import utilidades.ImagenLoader;
import utilidades.Inventario;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;

public class CajaAbierta extends JPanel {
	
    private Image backgroundImage;
    String backgroundFile;
    JLabel Background;
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro
    
    ImagenLoader img = new ImagenLoader();
    
    Inventario inventario = new Inventario();

    public CajaAbierta(Juego juego) {
        setBounds(0, 0, 950, 600);
        
        juego.getInventario().setLlaveCajonPadres(new Objeto(true, true, 002, "Llave del Cajón", "La llave del cajón de la comoda de los padres de Mikel", "/img/llaveCajon.png"));
    	
        backgroundFile = "/img/cajaFuerteOpen.jpeg";
        
        JLabel llaveLabel = new JLabel();
		llaveLabel.setBounds(326, 225, 332, 166); // Ajusta el tamaño del JLabel
		
		JButton btnLlaveCajon = new JButton("");
		btnLlaveCajon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLlaveCajon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.getInventario().agregarObjeto(juego.getInventario().getLlaveCajonPadres());
				llaveLabel.setVisible(false);
				btnLlaveCajon.setVisible(false);
			}
		});
		btnLlaveCajon.setBounds(432, 288, 138, 23);
		btnLlaveCajon.setOpaque(false);
		btnLlaveCajon.setBackground(new Color(0, 0, 0, 0));
		btnLlaveCajon.setBorderPainted(false); // No dibujar el borde
		btnLlaveCajon.setFocusPainted(false);
		btnLlaveCajon.setContentAreaFilled(false);
		add(btnLlaveCajon);
		llaveLabel.setIcon(img.scaleImage("/img/llaveEnCaja.png", 332, 166));
		
        
        setLayout(null);

        JButton btnVolver = new JButton(Config.getTexto("btnVolver"));
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("cuartoPadres");
        	}
        });
        btnVolver.setBounds(64, 494, 89, 23);
        add(btnVolver);
        add(llaveLabel, Integer.valueOf(2));

		// Mostrar la imagen de fondo
		Background = new JLabel();
		Background.setBounds(0, 0, 950, 600);
		Background.setIcon(img.scaleImage(backgroundFile, 950, 600)); // Establecer la imagen por defecto
		add(Background); // Agregar al final para que quede encima del botón
		// Cargar la imagen de la bandera inglesa
		
		 // Cronometro
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
        
     // Actualizar la etiqueta cada segundo (formato HH:MM:SS)
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText(Cronometro.getInstancia().getTiempoFormato()));
        actualizarTimer.start();


	}
    private void upgradeImage() {
		Background.setIcon(img.scaleImage(backgroundFile, 950, 600));
		Background.repaint(); // Redibujar para aplicar el cambio
	}

}