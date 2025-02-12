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

public class Pasillo2Piso extends JPanel {
    private Image backgroundImage;
    String backgroundFile;
    JLabel lblPasillo2Piso;
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro

    public Pasillo2Piso(Juego juego) {
        setBounds(0, 0, 950, 600);
    	
        backgroundFile = "img/pasillo2dPiso.png";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setLayout(null);
        
        // Flecha pasillo
        ImageIcon flechaPasilloOFF = new ImageIcon("img/flechaArribaOFF.png");
        ImageIcon flechaPasilloON = new ImageIcon("img/flechaArribaON.png");

        Image imgPasilloOFF = flechaPasilloOFF.getImage().getScaledInstance(61, 57, Image.SCALE_SMOOTH);
        Image imgPasilloON = flechaPasilloON.getImage().getScaledInstance(61, 57, Image.SCALE_SMOOTH);

        ImageIcon iconPasilloOFF = new ImageIcon(imgPasilloOFF);
        ImageIcon iconPasilloON = new ImageIcon(imgPasilloON);

        JLabel lblPasillo = new JLabel(iconPasilloOFF);
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
                lblPasillo.setIcon(iconPasilloON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblPasillo.setIcon(iconPasilloOFF);
            }
        });
        btnPasillo.setBounds(464, 319, 47, 47);
        btnPasillo.setBackground(new Color(0, 0, 0, 0));
        btnPasillo.setOpaque(false);
        btnPasillo.setBorderPainted(false);
        btnPasillo.setContentAreaFilled(false);
        add(btnPasillo);
        
     // Flecha pasillo
        ImageIcon flechaHijoOFF = new ImageIcon("img/felchaDerOFF.png");
        ImageIcon flechaHijoON = new ImageIcon("img/felchaDerON.png");

        Image imgHijoOFF = flechaHijoOFF.getImage().getScaledInstance(61, 57, Image.SCALE_SMOOTH);
        Image imgHijoON = flechaHijoON.getImage().getScaledInstance(61, 57, Image.SCALE_SMOOTH);

        ImageIcon iconHijoOFF = new ImageIcon(imgHijoOFF);
        ImageIcon iconHijoON = new ImageIcon(imgHijoON);

        JLabel lblHijo = new JLabel(iconHijoOFF);
        lblHijo.setBounds(458, 377, 61, 57);
        
        // boton pasillo
        JButton btnHijo = new JButton("");
        btnHijo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        btnHijo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblHijo.setIcon(iconHijoON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblHijo.setIcon(iconHijoOFF);
            }
        });
        btnHijo.setBounds(464, 377, 47, 47);
        btnHijo.setBackground(new Color(0, 0, 0, 0));
        btnHijo.setOpaque(false);
        btnHijo.setBorderPainted(false);
        btnHijo.setContentAreaFilled(false);
        add(btnHijo);
        
        
     // Flecha volver escaleras
        ImageIcon flechaEscalerasOFF = new ImageIcon("img/felchaDerOFF.png");
        ImageIcon flechaEscalerasON = new ImageIcon("img/felchaDerON.png");

        Image imgEscalerasOFF = flechaEscalerasOFF.getImage().getScaledInstance(81, 77, Image.SCALE_SMOOTH);
        Image imgEscalerasON = flechaEscalerasON.getImage().getScaledInstance(81, 77, Image.SCALE_SMOOTH);

        ImageIcon iconEscalerasOFF = new ImageIcon(imgEscalerasOFF);
        ImageIcon iconEscalerasON = new ImageIcon(imgEscalerasON);

        JLabel lblFlechaEscaleras = new JLabel(iconEscalerasOFF);
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
            	lblFlechaEscaleras.setIcon(iconEscalerasON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	lblFlechaEscaleras.setIcon(iconEscalerasOFF);
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
        lblPasillo2Piso.setIcon(scaledIcon);  // Establecer la imagen por defecto
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
    
    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
    }
}
