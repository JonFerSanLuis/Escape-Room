package view.Casa;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import Inicio.Juego;
import config.Config;
import utilidades.Cronometro;
import utilidades.ImagenLoader;

import java.awt.Color;
import java.awt.Cursor;
import java.util.Random;

public class puzzlePapelera extends JPanel {
	
    private JLabel pieza1, pieza2, pieza3, pieza4, pieza5, pieza6, pieza7, pieza8, pieza9, pieza10;
    private Point mouseOffset;
    
    private Image backgroundImage;
    private String backgroundFile;
    JLabel PapeleraLabel;
    
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro
    
    ImagenLoader img = new ImagenLoader();

    public puzzlePapelera(Juego juego) {
        setBounds(200, 100, 950, 600);
        setLayout(null);
        
        backgroundFile = "/img/puzzleFechaAniv.png";
        
        // Botón para mostrar los labels
        JButton btnMostrar = new JButton("");
        btnMostrar.setBounds(406, 432, 116, 129);
        btnMostrar.setBackground(new Color(0, 0, 0, 0));
        btnMostrar.setOpaque(false);
        btnMostrar.setBorderPainted(false);
        btnMostrar.setContentAreaFilled(false);
        btnMostrar.addActionListener(e -> {
            pieza1.setVisible(true);
            pieza2.setVisible(true);
            pieza3.setVisible(true);
            pieza4.setVisible(true);
            pieza5.setVisible(true);
            pieza6.setVisible(true);
            pieza7.setVisible(true);
            pieza8.setVisible(true);
            pieza9.setVisible(true);
            pieza10.setVisible(true);
            btnMostrar.setVisible(false);
        });
        add(btnMostrar);
        btnMostrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        DragListener dragListener = new DragListener();
        
        JButton btnVolver = new JButton(Config.getTexto("btnVolver"));
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("cocina");
        	}
        });
        btnVolver.setBounds(51, 506, 89, 23);
        add(btnVolver);
        
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        
        // Crear y agregar las piezas manualmente
        pieza1 = new JLabel();
        pieza1.setVisible(false);
        
        pieza1.addMouseListener(dragListener);
        pieza1.addMouseMotionListener(dragListener);
        add(pieza1);
        
        pieza1.setIcon(img.scaleImage("/img/piezza1puzzle-removebg-preview.png", 200, 200));

        // Desordenar las posiciones horizontalmente y ponerlas cerca de la parte inferior
        Random rand = new Random();
        int x = 500 - rand.nextInt(200);  // Genera un valor aleatorio para la posición X (ancho de la ventana)
        int y = 400 - rand.nextInt(50);  // Genera un valor aleatorio para la posición Y (parte inferior)
        pieza1.setBounds(x, y, 200, 200);
        
        pieza2 = new JLabel();
        pieza2.setVisible(false);

        pieza2.addMouseListener(dragListener);
        pieza2.addMouseMotionListener(dragListener);
        add(pieza2);
        
        pieza2.setIcon(img.scaleImage("/img/piezza2puzzle-removebg-preview.png", 110, 110));

        int x2 = 500 - rand.nextInt(200);  // Genera un valor aleatorio para la posición X (ancho de la ventana)
        int y2 = 400 - rand.nextInt(50);  // Genera un valor aleatorio para la posición Y (parte inferior)
        pieza2.setBounds(x2, y2, 110, 110);
        
        pieza3 = new JLabel();
        pieza3.setVisible(false);

        pieza3.addMouseListener(dragListener);
        pieza3.addMouseMotionListener(dragListener);
        add(pieza3);
        
        pieza3.setIcon(img.scaleImage("/img/piezza3puzzle-removebg-preview.png", 220, 220));

        int x3 = 500 - rand.nextInt(200);  // Genera un valor aleatorio para la posición X (ancho de la ventana)
        int y3 = 400 - rand.nextInt(50);  // Genera un valor aleatorio para la posición Y (parte inferior)
        pieza3.setBounds(x3, y3, 220, 220);
        
        pieza4 = new JLabel();
        pieza4.setVisible(false);

        pieza4.addMouseListener(dragListener);
        pieza4.addMouseMotionListener(dragListener);
        add(pieza4);
        
        pieza4.setIcon(img.scaleImage("/img/piezza4puzzle-removebg-preview.png", 186, 186));

        int x4 = 500 - rand.nextInt(200);  // Genera un valor aleatorio para la posición X (ancho de la ventana)
        int y4 = 400 - rand.nextInt(50);  // Genera un valor aleatorio para la posición Y (parte inferior)
        pieza4.setBounds(x4, y4, 186, 186);
        
        pieza5 = new JLabel();
        pieza5.setVisible(false);

        pieza5.addMouseListener(dragListener);
        pieza5.addMouseMotionListener(dragListener);
        add(pieza5);
        
        pieza5.setIcon(img.scaleImage("/img/piezza5puzzle-removebg-preview.png", 190, 190));

        int x5 = 500 - rand.nextInt(200);  // Genera un valor aleatorio para la posición X (ancho de la ventana)
        int y5 = 400 - rand.nextInt(50);  // Genera un valor aleatorio para la posición Y (parte inferior)
        pieza5.setBounds(x5, y5, 190, 190);
        
        pieza6 = new JLabel();
        pieza6.setVisible(false);

        pieza6.addMouseListener(dragListener);
        pieza6.addMouseMotionListener(dragListener);
        add(pieza6);
        
        pieza6.setIcon(img.scaleImage("/img/piezza6puzzle-removebg-preview.png", 190, 190));

        int x6 = 500 - rand.nextInt(200);  // Genera un valor aleatorio para la posición X (ancho de la ventana)
        int y6 = 400 - rand.nextInt(50);  // Genera un valor aleatorio para la posición Y (parte inferior)
        pieza6.setBounds(x6, y6, 190, 190);
        
        pieza7 = new JLabel();
        pieza7.setVisible(false);

        pieza7.addMouseListener(dragListener);
        pieza7.addMouseMotionListener(dragListener);
        add(pieza7);
        
        pieza7.setIcon(img.scaleImage("/img/piezza7puzzle-removebg-preview.png", 160, 160));

        int x7 = 500 - rand.nextInt(200);  // Genera un valor aleatorio para la posición X (ancho de la ventana)
        int y7 = 400 - rand.nextInt(50);  // Genera un valor aleatorio para la posición Y (parte inferior)
        pieza7.setBounds(x7, y7, 160, 160);
        
        pieza8 = new JLabel();
        pieza8.setVisible(false);

        pieza8.addMouseListener(dragListener);
        pieza8.addMouseMotionListener(dragListener);
        add(pieza8);
        
        pieza8.setIcon(img.scaleImage("/img/piezza8puzzle-removebg-preview.png", 78, 78));

        int x8 = 500 - rand.nextInt(200);  // Genera un valor aleatorio para la posición X (ancho de la ventana)
        int y8 = 400 - rand.nextInt(50);  // Genera un valor aleatorio para la posición Y (parte inferior)
        pieza8.setBounds(x8, y8, 78, 78);
        
        pieza9 = new JLabel();
        pieza9.setVisible(false);

        pieza9.addMouseListener(dragListener);
        pieza9.addMouseMotionListener(dragListener);
        add(pieza9);
        
        pieza9.setIcon(img.scaleImage("/img/piezza9puzzle-removebg-preview.png", 108, 108));

        int x9 = 500 - rand.nextInt(200);  // Genera un valor aleatorio para la posición X (ancho de la ventana)
        int y9 = 400 - rand.nextInt(50);  // Genera un valor aleatorio para la posición Y (parte inferior)
        pieza9.setBounds(x9, y9, 108, 108);
        
        pieza10 = new JLabel();
        pieza10.setVisible(false);

        pieza10.addMouseListener(dragListener);
        pieza10.addMouseMotionListener(dragListener);
        add(pieza10);
        
        pieza10.setIcon(img.scaleImage("/img/piezza10puzzle-removebg-preview.png", 82, 82));

        int x10 = 500 - rand.nextInt(200);  // Genera un valor aleatorio para la posición X (ancho de la ventana)
        int y10 = 400 - rand.nextInt(50);  // Genera un valor aleatorio para la posición Y (parte inferior)
        pieza10.setBounds(x10, y10, 82, 82);
        
     // Mostrar la imagen de fondo
     		PapeleraLabel = new JLabel();
     		PapeleraLabel.setBounds(0, 0, 950, 600);
     		PapeleraLabel.setIcon(img.scaleImage(backgroundFile, 950, 600)); // Establecer la imagen por defecto
     		add(PapeleraLabel); // Agregar al final para que quede encima del botón
     		
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

    
    private class DragListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            mouseOffset = new Point(e.getPoint());
        }

        public void mouseDragged(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            Point newLocation = label.getLocation();
            newLocation.translate(e.getX() - mouseOffset.x, e.getY() - mouseOffset.y);
            label.setLocation(newLocation);
        }
    }
}


