package Inicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JButton;

public class Intro extends JFrame {

	private JPanel contentPane;

	String IntroBackground;

	JLabel IntroLabel;

	Integer txt;

	public Intro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 950, 600);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		IntroBackground = "sources/Generate_a_scene_of_two_young__(2)_Nero_AI_Anime_Face_(1)_(1)-transformed (1).png";

		ImageIcon originalIcon = new ImageIcon(IntroBackground);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		ArrayList<JTextPane> TxtIntro = new ArrayList<>();
		txt = 0;

		JTextPane HistoriIntro = new JTextPane();
		HistoriIntro.setForeground(Color.WHITE);
		HistoriIntro.setOpaque(false);
		HistoriIntro.setBackground(new Color(0, 0, 0, 0));
		HistoriIntro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HistoriIntro.setEditable(false);
		HistoriIntro.setText("Me llamo Yuri, soy una estudiante de secundaria y mi mejor amigo sufre BULLING.");
		HistoriIntro.setBounds(48, 502, 855, 58);
		contentPane.add(HistoriIntro);

		JTextPane HistoriIntro2 = new JTextPane();
		HistoriIntro2.setForeground(Color.WHITE);
		HistoriIntro2.setOpaque(false);
		HistoriIntro2.setBackground(new Color(0, 0, 0, 0));
		HistoriIntro2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HistoriIntro2.setEditable(false);
		HistoriIntro2.setText(
				"Me di cuenta mientras charlabamos en el parque. Me confesó que dentro de poco se iba a mudar bastante lejos y se puso sentimental.");
		HistoriIntro2.setBounds(48, 490, 855, 58);
		contentPane.add(HistoriIntro2);
		HistoriIntro2.setVisible(false);

		JTextPane HistoriIntro3 = new JTextPane();
		HistoriIntro3.setForeground(Color.WHITE);
		HistoriIntro3.setOpaque(false);
		HistoriIntro3.setBackground(new Color(0, 0, 0, 0));
		HistoriIntro3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HistoriIntro3.setEditable(false);
		HistoriIntro3.setText(
				"Entonces comentó que al menos esperaba no tener que lidiar con 'gente así' en su futuro hogar.");
		HistoriIntro3.setBounds(48, 490, 855, 58);
		contentPane.add(HistoriIntro3);
		HistoriIntro3.setVisible(false);

		JTextPane HistoriIntro4 = new JTextPane();
		HistoriIntro4.setForeground(Color.WHITE);
		HistoriIntro4.setOpaque(false);
		HistoriIntro4.setBackground(new Color(0, 0, 0, 0));
		HistoriIntro4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HistoriIntro4.setEditable(false);
		HistoriIntro4.setText("Agregarle a eso que no era la primera vez que lo veía con moratones.");
		HistoriIntro4.setBounds(48, 502, 855, 58);
		contentPane.add(HistoriIntro4);
		HistoriIntro4.setVisible(false);

		JTextPane HistoriIntro5 = new JTextPane();
		HistoriIntro5.setForeground(Color.WHITE);
		HistoriIntro5.setOpaque(false);
		HistoriIntro5.setBackground(new Color(0, 0, 0, 0));
		HistoriIntro5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HistoriIntro5.setEditable(false);
		HistoriIntro5.setText("Tanto silencio me hizo pensar y darme cuenta de lo despistada que fuí.");
		HistoriIntro5.setBounds(48, 502, 855, 58);
		contentPane.add(HistoriIntro5);
		HistoriIntro5.setVisible(false);

		JTextPane HistoriIntro6 = new JTextPane();
		HistoriIntro6.setForeground(Color.WHITE);
		HistoriIntro6.setOpaque(false);
		HistoriIntro6.setBackground(new Color(0, 0, 0, 0));
		HistoriIntro6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HistoriIntro6.setEditable(false);
		HistoriIntro6.setText("La sorpresa me hizo enfadarme sin razón y comenzar a levantar la voz.");
		HistoriIntro6.setBounds(48, 502, 855, 58);
		contentPane.add(HistoriIntro6);
		HistoriIntro6.setVisible(false);

		JTextPane HistoriIntro7 = new JTextPane();
		HistoriIntro7.setForeground(Color.WHITE);
		HistoriIntro7.setOpaque(false);
		HistoriIntro7.setBackground(new Color(0, 0, 0, 0));
		HistoriIntro7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HistoriIntro7.setEditable(false);
		HistoriIntro7.setText("'¡Por qué no me dijiste nada!' Le grité, cegada por la impotencia");
		HistoriIntro7.setBounds(48, 502, 855, 58);
		contentPane.add(HistoriIntro7);
		HistoriIntro7.setVisible(false);

		JTextPane HistoriIntro8 = new JTextPane();
		HistoriIntro8.setForeground(Color.WHITE);
		HistoriIntro8.setOpaque(false);
		HistoriIntro8.setBackground(new Color(0, 0, 0, 0));
		HistoriIntro8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HistoriIntro8.setEditable(false);
		HistoriIntro8.setText(
				"Tuvimos una fuerte discusión por culpa de mi falta de tacto. Y por alguna razón no dejaba de echarle la culpa a él.");
		HistoriIntro8.setBounds(48, 490, 855, 58);
		contentPane.add(HistoriIntro8);
		HistoriIntro8.setVisible(false);

		JTextPane HistoriIntro9 = new JTextPane();
		HistoriIntro9.setForeground(Color.WHITE);
		HistoriIntro9.setOpaque(false);
		HistoriIntro9.setBackground(new Color(0, 0, 0, 0));
		HistoriIntro9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HistoriIntro9.setEditable(false);
		HistoriIntro9.setText("Si tan solo hubiera sido un poco más considerada y atenta...");
		HistoriIntro9.setBounds(48, 502, 855, 58);
		contentPane.add(HistoriIntro9);
		HistoriIntro9.setVisible(false);

		JTextPane HistoriIntro10 = new JTextPane();
		HistoriIntro10.setForeground(Color.WHITE);
		HistoriIntro10.setOpaque(false);
		HistoriIntro10.setBackground(new Color(0, 0, 0, 0));
		HistoriIntro10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HistoriIntro10.setEditable(false);
		HistoriIntro10.setText("Hace unos días, Mikel se escapó de casa.");
		HistoriIntro10.setBounds(48, 502, 855, 58);
		contentPane.add(HistoriIntro10);
		HistoriIntro10.setVisible(false);

		JTextPane HistoriIntro11 = new JTextPane();
		HistoriIntro11.setForeground(Color.WHITE);
		HistoriIntro11.setOpaque(false);
		HistoriIntro11.setBackground(new Color(0, 0, 0, 0));
		HistoriIntro11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HistoriIntro11.setEditable(false);
		HistoriIntro11.setText("No soporto pensar que tengo parte de culpa.");
		HistoriIntro11.setBounds(48, 502, 855, 58);
		contentPane.add(HistoriIntro11);
		HistoriIntro11.setVisible(false);

		JTextPane HistoriIntro12 = new JTextPane();
		HistoriIntro12.setForeground(Color.WHITE);
		HistoriIntro12.setOpaque(false);
		HistoriIntro12.setBackground(new Color(0, 0, 0, 0));
		HistoriIntro12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HistoriIntro12.setEditable(false);
		HistoriIntro12.setText("TENGO QUE ENCONTRARLE");
		HistoriIntro12.setBounds(48, 502, 855, 58);
		contentPane.add(HistoriIntro12);
		HistoriIntro12.setVisible(false);

		TxtIntro.add(HistoriIntro);
		TxtIntro.add(HistoriIntro2);
		TxtIntro.add(HistoriIntro3);
		TxtIntro.add(HistoriIntro4);
		TxtIntro.add(HistoriIntro5);
		TxtIntro.add(HistoriIntro6);
		TxtIntro.add(HistoriIntro7);
		TxtIntro.add(HistoriIntro8);
		TxtIntro.add(HistoriIntro9);
		TxtIntro.add(HistoriIntro10);
		TxtIntro.add(HistoriIntro11);
		TxtIntro.add(HistoriIntro12);

		

		try {
			Font optionsFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/BeechlandsDemoRegular.ttf"));
			optionsFont = optionsFont.deriveFont(10f);
			contentPane.setLayout(null);
			JButton btnContinue = new JButton("CONTINUAR");
			btnContinue.setBounds(819, 468, 115, 23);
			btnContinue.setBackground(new Color(0, 0, 0, 0));
			btnContinue.setOpaque(false);
			btnContinue.setBorderPainted(false);
			btnContinue.setContentAreaFilled(false);
			btnContinue.setForeground(Color.GRAY);

			btnContinue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (txt == 11) {
						dispose();
					} else if (txt < TxtIntro.size()) {
						TxtIntro.get(txt).setVisible(false);
						TxtIntro.get(txt + 1).setVisible(true);
						txt = txt + 1;
					}
					if (txt == 1) {
						IntroBackground = "sources/confesion.jpg";
						upgradeImage();
					}
					if (txt == 6) {
						IntroBackground = "sources/Por qué.png";
						upgradeImage();
					}
				}
			});
			btnContinue.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnContinue.setForeground(Color.white);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnContinue.setForeground(Color.GRAY);
				}
			});

			btnContinue.setOpaque(false);
			btnContinue.setBorderPainted(false);
			btnContinue.setContentAreaFilled(false);

			contentPane.add(btnContinue);

		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
		IntroLabel = new JLabel();
		IntroLabel.setBackground(new Color(240, 240, 240));
		IntroLabel.setBounds(0, 0, 934, 561);
		IntroLabel.setIcon(scaledIcon); // Establecer la imagen por defecto
		contentPane.add(IntroLabel);

	}

	private void upgradeImage() {
	    // Cargar la nueva imagen
	    ImageIcon originalIcon = new ImageIcon(IntroBackground);
	    Image originalImage = originalIcon.getImage();
	    Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon scaledIcon = new ImageIcon(scaledImage);
	    
	    // Actualizar el fondo con la nueva imagen
	    IntroLabel.setIcon(scaledIcon);
	    IntroLabel.repaint(); // Redibujar para aplicar el cambio
	}

	private ImageIcon loadImage(String filePath) {
		ImageIcon icon = new ImageIcon(filePath);
		Image image = icon.getImage();
		return new ImageIcon(
				image.getScaledInstance(contentPane.getWidth(), contentPane.getHeight(), Image.SCALE_SMOOTH));
	}
}
