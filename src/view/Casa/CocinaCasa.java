package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Inicio.Juego;
import utilidades.Cronometro;
import utilidades.ImagenLoader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class CocinaCasa extends JPanel {

	private Image backgroundImage;
    private String backgroundFile;
    JLabel bañoLabel;
    
	private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro

    
    ImagenLoader img = new ImagenLoader();

	public CocinaCasa(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		backgroundFile = "/img/cocinaCasa.jpg";

        JLabel lblVolver = new JLabel();
        lblVolver.setIcon(img.scaleImage("/img/fechaAbajoOFF.png", 89, 83));
        
        JButton btnCajonCocina = new JButton("");
        btnCajonCocina.setBounds(352, 382, 58, 106);
        btnCajonCocina.setBackground(new Color(0, 0, 0, 0));
        btnCajonCocina.setOpaque(false);
        btnCajonCocina.setBorderPainted(false);
        btnCajonCocina.setContentAreaFilled(false);
        add(btnCajonCocina);
        
        JButton btnNevera = new JButton("");
        btnNevera.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("nevera");
        	}
        });
        btnNevera.setBounds(815, 267, 58, 74);
        btnNevera.setBackground(new Color(0, 0, 0, 0));
        btnNevera.setOpaque(false);
        btnNevera.setBorderPainted(false);
        btnNevera.setContentAreaFilled(false);
        add(btnNevera);
        
        JButton btnVolverRecibidor = new JButton("");
        btnVolverRecibidor.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblVolver.setIcon(img.scaleImage("/img/fechaAbajoON.png", 89, 83));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblVolver.setIcon(img.scaleImage("/img/fechaAbajoOFF.png", 89, 83));
        	}
        });
        btnVolverRecibidor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("recibidor");
        	}
        });
        btnVolverRecibidor.setBackground(new Color(0, 0, 0, 0));
        btnVolverRecibidor.setOpaque(false);
        btnVolverRecibidor.setBorderPainted(false);
        btnVolverRecibidor.setContentAreaFilled(false);
        btnVolverRecibidor.setBounds(449, 495, 58, 66);
        add(btnVolverRecibidor);
        btnVolverRecibidor.setVisible(true);  // Hace el botón no visible
        
        lblVolver.setBounds(435, 488, 89, 83);
        add(lblVolver);
        
        btnVolverRecibidor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNevera.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCajonCocina.setCursor(new Cursor(Cursor.HAND_CURSOR));   
        
        // Mostrar la imagen de fondo
        bañoLabel = new JLabel();
        bañoLabel.setBounds(0, 0, 950, 600);
        bañoLabel.setIcon(img.scaleImage(backgroundFile, 950, 600));  // Establecer la imagen por defecto
        add(bañoLabel); // Agregar al final para que quede encima del botón
        
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
	
    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
    }
}
