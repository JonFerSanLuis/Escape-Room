package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Inicio.Juego;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class CocinaCasa extends JPanel {

	private Image backgroundImage;
    private String backgroundFile;
    JLabel bañoLabel;

	public CocinaCasa(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		backgroundFile = "img/cocinaCasa.jpg";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);       

        ImageIcon flechaOFF = new ImageIcon("img/fechaAbajoOFF.png");
        ImageIcon flechaON = new ImageIcon("img/fechaAbajoON.png");

        Image imgOFF = flechaOFF.getImage().getScaledInstance(89, 83, Image.SCALE_SMOOTH);
        Image imgON = flechaON.getImage().getScaledInstance(89, 83, Image.SCALE_SMOOTH);

        ImageIcon iconOFF = new ImageIcon(imgOFF);
        ImageIcon iconON = new ImageIcon(imgON);
        JLabel lblVolver = new JLabel(iconOFF);
        
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
        		lblVolver.setIcon(iconON);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblVolver.setIcon(iconOFF);
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
        bañoLabel.setIcon(scaledIcon);  // Establecer la imagen por defecto
        add(bañoLabel); // Agregar al final para que quede encima del botón
	}
	
    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
    }
}
