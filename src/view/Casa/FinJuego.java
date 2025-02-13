package view.Casa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inicio.Casa;
import Inicio.Juego;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinJuego extends JPanel {
	
	public FinJuego(Juego juego) {
		setBounds(100, 100, 950, 600);

		setLayout(null);
		
		setBackground(Color.black);
		
		JLabel lblTexto = new JLabel("Te has quedado sin tiempo...");
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblTexto.setForeground(new Color(255, 255, 255));
		lblTexto.setBounds(211, 184, 530, 71);
		add(lblTexto);
		
		JButton btnVolverHome = new JButton("HOME");
		btnVolverHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Casa c = new Casa();
				c.setVisible(true);
				juego.dispose();
			}
		});
		btnVolverHome.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnVolverHome.setBounds(345, 300, 264, 49);
		add(btnVolverHome);
	}
}
