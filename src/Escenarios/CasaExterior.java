package Escenarios;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CasaExterior extends JFrame {
	private JTextField textField;

	public CasaExterior() {
		// Configuración básica del JFrame
		setTitle("CasaExImagen");
		setSize(1000, 533);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		// Imagen pequeña 1
		String smallImagePath1 = "D:/Josué/Reto2/ImagenesESR/PistaIcono.png";
		ImageIcon smallScaledIcon1 = new ImageIcon(
				new ImageIcon(smallImagePath1).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

		// Imagen pequeña 2
		String smallImagePath2 = "D:/Josué/Reto2/ImagenesESR/MochilaIcono.png";
		ImageIcon smallScaledIcon2 = new ImageIcon(
				new ImageIcon(smallImagePath2).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

		// Imagen de fondo
		String imagePath = "D:/Josué/Reto2/ImagenesESR/CasaXFuera.jpg";
		ImageIcon scaledIcon = new ImageIcon(
				new ImageIcon(imagePath).getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH));
						
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\pngimg.com_-_sticky_note_PNG18899-removebg-preview (1).png"));
		lblNewLabel.setBounds(281, 311, 46, 50);
		getContentPane().add(lblNewLabel);
		;
						lblNewLabel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\PostitClick.png"));

							}
							
							
							@Override
							public void mouseExited(MouseEvent e) {
								lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\PostitEntrada.png"));
							}
							
						});
						
				
						// Imagen pequeña 2
						JLabel smallImageLabel2 = new JLabel(smallScaledIcon2);
						smallImageLabel2.setBounds(849, 11, 50, 50); // Posición adicional a la derecha del JFrame
						getContentPane().add(smallImageLabel2);
		
				// Imagen pequeña 1
				JLabel smallImageLabel1 = new JLabel(smallScaledIcon1);
				smallImageLabel1.setBounds(924, 11, 50, 50); // Posición en la parte derecha del JFrame
				getContentPane().add(smallImageLabel1);

		JLabel lblReaccionPuertaCasa = new JLabel("");
		lblReaccionPuertaCasa.setForeground(Color.WHITE);
		lblReaccionPuertaCasa.setBounds(272, 404, 510, 50);
		getContentPane().add(lblReaccionPuertaCasa);

		// Añadir la imagen de fondo primero
		JLabel escCasa = new JLabel(scaledIcon);
		escCasa.setBounds(0, -52, 984, 602);
		escCasa.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(escCasa);

		// Botón (btnPuertaCasa)
		JButton btnPuertaCasa = new JButton("New button");
		btnPuertaCasa.setBounds(467, 268, 67, 106);
		btnPuertaCasa.setOpaque(false);
		getContentPane().add(btnPuertaCasa);

		btnPuertaCasa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Acción al presionar el botón
				try {
					Font optionsFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/BonaNovaSC-Bold.ttf"));
					optionsFont = optionsFont.deriveFont(30f);
					lblReaccionPuertaCasa.setFont(optionsFont);
					lblReaccionPuertaCasa.setText("Solo se puede acceder con código");
				} catch (FontFormatException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			CasaExterior frame = new CasaExterior();
			frame.setVisible(true);
		});
	}
}
