package view.Casa;

import java.awt.Color;
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
        
        // Flecha
        ImageIcon flechaPasilloOFF = new ImageIcon("img/flechaArribaOFF.png");
        ImageIcon flechaPasilloON = new ImageIcon("img/flechaArribaON.png");

        Image imgPasilloOFF = flechaPasilloOFF.getImage().getScaledInstance(81, 77, Image.SCALE_SMOOTH);
        Image imgPasilloON = flechaPasilloON.getImage().getScaledInstance(81, 77, Image.SCALE_SMOOTH);

        ImageIcon iconPasilloOFF = new ImageIcon(imgPasilloOFF);
        ImageIcon iconPasilloON = new ImageIcon(imgPasilloON);

        JLabel lblPasillo = new JLabel(iconPasilloOFF);
        lblPasillo.setBounds(445, 336, 81, 77);
        add(lblPasillo);
        
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
        btnPasillo.setBounds(445, 346, 65, 67);
        btnPasillo.setBackground(new Color(0, 0, 0, 0));
        btnPasillo.setOpaque(false);
        btnPasillo.setBorderPainted(false);
        btnPasillo.setContentAreaFilled(false);
        add(btnPasillo);
        // --------------
        
        // Mostrar la imagen redimensionada
        lblPasillo2Piso = new JLabel();
        lblPasillo2Piso.setBounds(0, 0, 934, 561);
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
		setComponentZOrder(labelTiempo, 0); // Lo pone en la capa superior

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
