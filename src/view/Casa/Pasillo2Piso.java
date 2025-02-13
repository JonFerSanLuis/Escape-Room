package view.Casa;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import utilidades.Cronometro;
import utilidades.ImagenLoader;

public class Pasillo2Piso extends JPanel {
    private Image backgroundImage;
    String backgroundFile;
    JLabel lblPasillo2Piso;
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro
    
    ImagenLoader img = new ImagenLoader();

    public Pasillo2Piso(Juego juego) {
        setBounds(0, 0, 950, 600);
    	
        backgroundFile = "/img/pasillo2dPiso.png";

        setLayout(null);

        JLabel lblPasillo = new JLabel();
        lblPasillo.setIcon(img.scaleImage("/img/flechaArribaOFF.png", 61, 57));
        lblPasillo.setBounds(458, 319, 61, 57);
        
        // boton pasillo
        JButton btnPasillo = new JButton("");
        btnPasillo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("cuartoPadres");
        	}
        });
        btnPasillo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	lblPasillo.setIcon(img.scaleImage("/img/flechaArribaON.png", 61, 57));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	lblPasillo.setIcon(img.scaleImage("/img/flechaArribaOFF.png", 61, 57));
            }
        });
        btnPasillo.setBounds(464, 319, 47, 47);
        btnPasillo.setBackground(new Color(0, 0, 0, 0));
        btnPasillo.setOpaque(false);
        btnPasillo.setBorderPainted(false);
        btnPasillo.setContentAreaFilled(false);
        add(btnPasillo);

        JLabel lblHijo = new JLabel();
        lblHijo.setIcon(img.scaleImage("/img/felchaDerOFF.png", 61, 57));
        lblHijo.setBounds(458, 377, 61, 57);
        
        // boton pasillo
        JButton btnHijo = new JButton("");
        btnHijo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("puertaMikel");
        	}
        });
        btnHijo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	lblHijo.setIcon(img.scaleImage("/img/felchaDerON.png", 61, 57));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	lblHijo.setIcon(img.scaleImage("/img/felchaDerOFF.png", 61, 57));
            }
        });
        btnHijo.setBounds(464, 377, 47, 47);
        btnHijo.setBackground(new Color(0, 0, 0, 0));
        btnHijo.setOpaque(false);
        btnHijo.setBorderPainted(false);
        btnHijo.setContentAreaFilled(false);
        add(btnHijo);
        
        JLabel lblFlechaEscaleras = new JLabel();
        lblFlechaEscaleras.setIcon(img.scaleImage("/img/felchaDerOFF.png", 81, 77));
        lblFlechaEscaleras.setBounds(445, 484, 81, 77);
        
        // boton volver escaleras
        JButton btnVolverRecibidor = new JButton("");
		btnVolverRecibidor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				juego.cambiarEscena("recibidor");
			}
		});
		btnVolverRecibidor.setBounds(434, 492, 113, 59);
		add(btnVolverRecibidor);
		
		btnVolverRecibidor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	lblFlechaEscaleras.setIcon(img.scaleImage("/img/felchaDerON.png", 81, 77));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	lblFlechaEscaleras.setIcon(img.scaleImage("/img/felchaDerOFF.png", 81, 77));
            }
        });
		
		btnVolverRecibidor.setBackground(new Color(0, 0, 0, 0));
		btnVolverRecibidor.setOpaque(false);
		btnVolverRecibidor.setBorderPainted(false);
		btnVolverRecibidor.setContentAreaFilled(false);
		
		btnHijo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPasillo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVolverRecibidor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
        add(lblFlechaEscaleras);
        add(lblPasillo);
        add(lblHijo);
        
        // Mostrar la imagen redimensionada
        lblPasillo2Piso = new JLabel();
        lblPasillo2Piso.setBounds(0, 0, 950, 600);
        lblPasillo2Piso.setIcon(img.scaleImage(backgroundFile, 950, 600));  // Establecer la imagen por defecto
        add(lblPasillo2Piso);
        
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
		setComponentZOrder(labelTiempo, 0);

        // Actualizar la etiqueta cada segundo (formato HH:MM:SS)
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText(Cronometro.getInstancia().getTiempoFormato()));
        actualizarTimer.start();
    }

}
