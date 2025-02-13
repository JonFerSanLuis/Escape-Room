package view.Casa;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import utilidades.ImagenLoader;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CuadroPerro extends JPanel {

	private Image backgroundImage;
    private String backgroundFile;
    JLabel ba�oLabel;
    
    ImagenLoader img = new ImagenLoader();

	public CuadroPerro(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		backgroundFile = "/img/cuadroPerro.png";
        
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("salon");
        	}
        });
        btnVolver.setBounds(51, 506, 89, 23);
        add(btnVolver);
        
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        
        // Mostrar la imagen de fondo
        ba�oLabel = new JLabel();
        ba�oLabel.setBounds(0, 0, 950, 600);
        ba�oLabel.setIcon(img.scaleImage(backgroundFile, 950, 600));  // Establecer la imagen por defecto
        add(ba�oLabel); // Agregar al final para que quede encima del bot�n
	}

}
