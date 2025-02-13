package view.Casa;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import utilidades.ImagenLoader;

public class NeveraCalendario extends JPanel {

	private Image backgroundImage;
    private String backgroundFile;
    JLabel bañoLabel;
    
    ImagenLoader img = new ImagenLoader();

	public NeveraCalendario(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		backgroundFile = "/img/NeveraView.png";
        
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("cocina");
        	}
        });
        btnVolver.setBounds(51, 506, 89, 23);
        add(btnVolver);
        
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        
        // Mostrar la imagen de fondo
        bañoLabel = new JLabel();
        bañoLabel.setBounds(0, 0, 950, 600);
        bañoLabel.setIcon(img.scaleImage(backgroundFile, 950, 600));  // Establecer la imagen por defecto
        add(bañoLabel); // Agregar al final para que quede encima del botón
	}

}
