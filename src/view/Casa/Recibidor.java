package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import utilidades.Cronometro;
import utilidades.ImagenLoader;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recibidor extends JPanel {
    private Image backgroundImage;
    String backgroundFile;
    JLabel RecibidorLabel;
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro
    
    ImagenLoader img = new ImagenLoader();

    public Recibidor(Juego juego) {
        setBounds(0, 0, 950, 600);
    	
        backgroundFile = "/img/recibidor.jpeg";

        setLayout(null);
        
        JButton btnEscaleras = new JButton("");
        add(btnEscaleras);
        JButton btnPuerta = new JButton("");
        add(btnPuerta);
        JButton btnCocina = new JButton("");
        add(btnCocina);
        JButton btnBano = new JButton("");
        add(btnBano);

        JLabel lblEscalera = new JLabel();
        lblEscalera.setBounds(797, 247, 81, 77);
        lblEscalera.setIcon(img.scaleImage("/img/flechaEscaleraOFF.png", 81, 77));
        add(lblEscalera);
        
        btnEscaleras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("pasillo2");
        	}
        });
        btnEscaleras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	lblEscalera.setIcon(img.scaleImage("/img/flechaEscaleraON.png", 81, 77));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	lblEscalera.setIcon(img.scaleImage("/img/flechaEscaleraOFF.png", 81, 77));
            }
        });
        btnEscaleras.setBounds(797, 247, 81, 77);
        btnEscaleras.setBackground(new Color(0, 0, 0, 0));
        btnEscaleras.setOpaque(false);
        btnEscaleras.setBorderPainted(false);
        btnEscaleras.setContentAreaFilled(false);

        JLabel lblPuerta = new JLabel();
        lblPuerta.setBounds(250, 390, 212, 137);
        lblPuerta.setIcon(img.scaleImage("/img/FlechaSalonOFF.png", 212, 137));
        add(lblPuerta);
        
        btnPuerta.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		juego.cambiarEscena("salon");
        	}
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblPuerta.setIcon(img.scaleImage("/img/FlechaSalonON.png", 212, 137));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblPuerta.setIcon(img.scaleImage("/img/FlechaSalonOFF.png", 212, 137));        		
        	}
        });
        btnPuerta.setBounds(332, 405, 95, 88);
        btnPuerta.setBackground(new Color(0, 0, 0, 0)); // Hacer el fondo transparente
        btnPuerta.setOpaque(false);
        btnPuerta.setBorderPainted(false);
        btnPuerta.setContentAreaFilled(false);
        
     // Cargar y redimensionar imágenes una sola vez

        JLabel lblCocina = new JLabel();
        lblCocina.setBounds(150, 450, 212, 137);
        lblCocina.setIcon(img.scaleImage("/img/flechaCocinaOFF.png", 212, 137));
        add(lblCocina);
        
        btnCocina.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		juego.cambiarEscena("cocina");
        	}
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblCocina.setIcon(img.scaleImage("/img/flechaCocinaON.png", 212, 137));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblCocina.setIcon(img.scaleImage("/img/flechaCocinaOFF.png", 212, 137));
        		
        	}
        });
        btnCocina.setBounds(183, 471, 147, 88);
        btnCocina.setBackground(new Color(0, 0, 0, 0)); // Hacer el fondo transparente
        btnCocina.setOpaque(false);
        btnCocina.setBorderPainted(false);
        btnCocina.setContentAreaFilled(false);
        
        btnBano.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("bano");
        	}
        });
        btnBano.setBounds(591, 171, 89, 256);
        btnBano.setBackground(new Color(0, 0, 0, 0)); // Hacer el fondo transparente
        btnBano.setOpaque(false);
        btnBano.setBorderPainted(false);
        btnBano.setContentAreaFilled(false);
        
        btnPuerta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEscaleras.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCocina.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBano.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
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

        // Mostrar la imagen de fondo
        RecibidorLabel = new JLabel();
        RecibidorLabel.setBounds(0, 0, 950, 600);
        RecibidorLabel.setIcon(img.scaleImage(backgroundFile, 950, 600));  // Establecer la imagen por defecto
        add(RecibidorLabel); // Agregar al final para que quede encima del botón

        // Actualizar la etiqueta cada segundo (formato HH:MM:SS)
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText(Cronometro.getInstancia().getTiempoFormato()));
        actualizarTimer.start();

    }

}