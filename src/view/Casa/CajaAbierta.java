package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
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
import utilidades.Inventario;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CajaAbierta extends JPanel {
	
    private Image backgroundImage;
    String backgroundFile;
    JLabel Background;

    public CajaAbierta(Juego juego) {
        setBounds(0, 0, 950, 600);
        
        juego.getInventario().setLlaveCajonPadres(new Objeto(true, true, 002, "Llave del Cajón", "La llave del cajón de la comoda de los padres de Mikel", "img/llaveCajon.png"));
    	
        backgroundFile = "img/cajaFuerteOpen.jpeg";
        
        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        JLabel llaveLabel = new JLabel();
		// Cargar la imagen de la bandera inglesa
		ImageIcon llaveCajonImage = new ImageIcon("img/llaveEnCaja.png");
		llaveLabel.setBounds(326, 208, 332, 166); // Ajusta el tamaño del JLabel
		Image imgllaveCajon = llaveCajonImage.getImage().getScaledInstance(llaveLabel.getWidth(),
				llaveLabel.getHeight(), Image.SCALE_SMOOTH);
		
		JButton btnLlaveCajon = new JButton("");
		btnLlaveCajon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.getInventario().agregarObjeto(juego.getInventario().getLlaveCajonPadres());
				llaveLabel.setVisible(false);
				btnLlaveCajon.setVisible(false);
			}
		});
		btnLlaveCajon.setBounds(432, 280, 138, 23);
		btnLlaveCajon.setOpaque(false);
		btnLlaveCajon.setBackground(new Color(0, 0, 0, 0));
		btnLlaveCajon.setBorderPainted(false); // No dibujar el borde
		btnLlaveCajon.setFocusPainted(false);
		btnLlaveCajon.setContentAreaFilled(false);
		add(btnLlaveCajon);
		llaveLabel.setIcon(new ImageIcon(imgllaveCajon));
		add(llaveLabel, Integer.valueOf(2));
        
        setLayout(null);

        JButton btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("cuartoPadres");
        	}
        });
        btnVolver.setBounds(64, 494, 89, 23);
        add(btnVolver);

		// Mostrar la imagen de fondo
		Background = new JLabel();
		Background.setBounds(0, 0, 950, 600);
		Background.setIcon(scaledIcon); // Establecer la imagen por defecto
		add(Background); // Agregar al final para que quede encima del botón
		// Cargar la imagen de la bandera inglesa

	}
    private void upgradeImage() {
		// Cargar la nueva imagen
		ImageIcon originalIcon = new ImageIcon(backgroundFile);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Actualizar el fondo con la nueva imagen
		Background.setIcon(scaledIcon);
		Background.repaint(); // Redibujar para aplicar el cambio
	}
    
    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
    }

}