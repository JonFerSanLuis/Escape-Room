package view.Colegio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inicio.Casa;
import Inicio.Juego;
import config.Config;
import utilidades.ImagenLoader;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ColegioXFuera extends JPanel {

	private JLabel labelFinalCasa;
	String backgroundFile;
	
	ImagenLoader img = new ImagenLoader();

	public ColegioXFuera(Juego juego) {
		setBounds(0, 0, 950, 600);
		backgroundFile = "/img/escuelaIntro.jpeg";
		setLayout(null);
		
		JLabel lblContinuara = new JLabel(Config.getTexto("continuara"));
		lblContinuara.setForeground(new Color(255, 255, 255));
		lblContinuara.setFont(new Font("Lato Light", Font.BOLD | Font.ITALIC, 35));
		lblContinuara.setHorizontalAlignment(SwingConstants.CENTER);
		lblContinuara.setBounds(206, 252, 470, 79);
		add(lblContinuara);
		
		JButton btnJugarOtra = new JButton("HOME");
		btnJugarOtra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Casa casa = new Casa();
				casa.setVisible(true);
				juego.dispose();
			}
		});
		btnJugarOtra.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnJugarOtra.setBounds(822, 527, 89, 23);
		btnJugarOtra.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnJugarOtra);
		
		labelFinalCasa = new JLabel();
		labelFinalCasa.setBounds(0, 0, 950, 600);
		labelFinalCasa.setIcon(img.scaleImage(backgroundFile, 950, 600));
		add(labelFinalCasa);

	}
}
