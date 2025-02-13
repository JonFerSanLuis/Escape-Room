package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Inicio.Juego;
import utilidades.ImagenLoader;

import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TvCuartoHijo extends JPanel {
	
	private JLabel lblTv;
	private JTextField textField;
	private JButton btnSubmit;
	private int attemptCount = 0;  // Contador de intentos
	
	ImagenLoader img = new ImagenLoader();

	// La contraseña correcta
	private final String correctPassword = "gladiator2010";
	
	// Pistas
	private final String[] clues = {
		"La contraseña tiene 13 caracteres.",
		"La contraseña esta en ingles",
		"Contiene numero y letras",
		"Es quizá la nota se refiere a su padre biologico"
	};

	public TvCuartoHijo(Juego juego) {
	    setBounds(0, 0, 950, 600);
	    setLayout(null);

		String backgroundFile = "/img/Fototelevision.png";

		btnSubmit = new JButton("");
		btnSubmit.setBounds(420, 331, 98, 33);
		add(btnSubmit);
		btnSubmit.setOpaque(false);
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBorderPainted(false);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = textField.getText().trim().toLowerCase();

				if (userInput.equals(correctPassword)) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							juego.cambiarEscena("conversacionesPc");
						}
					});
				} else {
					attemptCount++;
					if (attemptCount < clues.length) {
						JOptionPane.showMessageDialog(null, "¡Contraseña incorrecta! Pista: " + clues[attemptCount]);
					} else {
						JOptionPane.showMessageDialog(null, "¡Contraseña incorrecta! Ya no hay más pistas.");
					}
				}
			}
		});

		JLabel btnenter = new JLabel("");
		btnenter.setIcon(img.scaleImage("/img/botonenter.png", 160, 88));

		btnenter.setBounds(390, 311, 160, 88); // Establecer el mismo tamaño que el botón
		add(btnenter);

		Color backgroundColor = new Color(209, 238, 253);

		textField = new JTextField();
		textField.setBounds(359, 276, 208, 33);
		add(textField);
		textField.setColumns(10);
		textField.setBackground(backgroundColor);
		textField.setForeground(Color.BLACK);
	    textField.setBorder(new LineBorder(backgroundColor, 2)); 
	    
	    JLabel lblPosit = new JLabel("");
	    lblPosit.setIcon(img.scaleImage("/img/postitTvIng.png", 430, 217));
	    lblPosit.setBounds(-67, 21, 430, 217);
	    add(lblPosit);
	    
	    JButton btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("curtoHijo");
        	}
        });
        btnVolver.setBounds(51, 506, 89, 23);
        add(btnVolver);
        
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
	    
	    lblTv = new JLabel();
	    lblTv.setBounds(0, 0, 950, 600);
	    lblTv.setIcon(img.scaleImage(backgroundFile, 950, 600));
	    add(lblTv);
        
	}
}
