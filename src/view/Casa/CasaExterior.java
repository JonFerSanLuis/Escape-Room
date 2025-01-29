package view.Casa;

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
		setTitle("Casa");
		setSize(1000, 533);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblPostit = new JLabel();
		lblPostit.setIcon(new ImageIcon("img/PostitEntrada.png"));
		lblPostit.setBounds(281, 311, 46, 50);
		getContentPane().add(lblPostit);
		
		JButton btnPosit = new JButton("");

		btnPosit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPostit.setIcon(new ImageIcon("img/PostitClick.png"));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblPostit.setIcon(new ImageIcon("img/PostitEntrada.png"));
			}

		});

		btnPosit.setBounds(281, 311, 46, 50);
		btnPosit.setOpaque(false);
		btnPosit.setBackground(new Color(0, 0, 0, 0));
		btnPosit.setBorderPainted(false); // No dibujar el borde
		btnPosit.setFocusPainted(false);
		btnPosit.setContentAreaFilled(false);
		getContentPane().add(btnPosit);
		btnPosit.setVisible(false);

		// Imagen pequeña 1
		String smallImagePath1 = "img/PistaIcono.png";
		ImageIcon smallScaledIcon1 = new ImageIcon(
				new ImageIcon(smallImagePath1).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

		// Imagen pequeña 2
		String smallImagePath2 = "img/MochilaIcono.png";
		ImageIcon smallScaledIcon2 = new ImageIcon(
				new ImageIcon(smallImagePath2).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

		// Imagen de fondo
		String imagePath = "img/CasaExteriorTexto.jpeg";
		ImageIcon scaledIcon = new ImageIcon(
				new ImageIcon(imagePath).getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH));
		
		JLabel lblCasa = new JLabel(scaledIcon);

		// Botón (btnPuertaCasa)
		JButton btnPuertaCasa = new JButton();
		btnPuertaCasa.setBounds(467, 268, 67, 106);
		btnPuertaCasa.setOpaque(false);
		btnPuertaCasa.setBackground(new Color(0, 0, 0, 0));
		btnPuertaCasa.setBorderPainted(false); // No dibujar el borde
		btnPuertaCasa.setFocusPainted(false);
		btnPuertaCasa.setContentAreaFilled(false);
		getContentPane().add(btnPuertaCasa);

		JLabel lblReaccionPuertaCasa = new JLabel();
		lblReaccionPuertaCasa.setForeground(Color.WHITE);
		lblReaccionPuertaCasa.setBounds(271, 429, 510, 50);

		btnPuertaCasa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Acción al presionar el botón
				try {
					Font optionsFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/BonaNovaSC-Bold.ttf"));
					optionsFont = optionsFont.deriveFont(20f);
					lblReaccionPuertaCasa.setFont(optionsFont);
					lblCasa.setIcon(new ImageIcon("img/CasaExteriorTexto.jpeg"));
					lblReaccionPuertaCasa.setText("Parece que la puerta esta cerrada.");
					try {
						Thread.sleep(2500); // Espera
					} catch (InterruptedException e3) {
						System.out.println("Hilo interrumpido");
					}
					lblReaccionPuertaCasa.setText("Debo encontrar la forma de entrar.");
					try {
						Thread.sleep(2500); // Espera
					} catch (InterruptedException e3) {
						System.out.println("Hilo interrumpido");
					}
					lblCasa.setIcon(new ImageIcon("img/CasaExteriorImg.jpeg"));
				} catch (FontFormatException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		getContentPane().add(lblReaccionPuertaCasa);
		btnPuertaCasa.setVisible(true);

		// Imagen pequeña 2
		JLabel lblMochila = new JLabel(new ImageIcon("img/IconoMochilaEX.png"));
		
		JButton btnMochila = new JButton("");
		
		btnMochila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMochila.setIcon(new ImageIcon("img/IconoMochilaENT.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMochila.setIcon(new ImageIcon("img/IconoMochilaEX.png"));
			}
		});
		
		btnMochila.setBounds(835, 11, 65, 60);
		btnMochila.setOpaque(false);
		btnMochila.setBackground(new Color(0, 0, 0, 0));
		btnMochila.setBorderPainted(false); // No dibujar el borde
		btnMochila.setFocusPainted(false);
		btnMochila.setContentAreaFilled(false);
		
		lblMochila.setBounds(835, 11, 65, 60); // Posición adicional a la derecha del JFrame
		getContentPane().add(lblMochila);
		getContentPane().add(btnMochila);
		btnMochila.setVisible(false);

		// Imagen pequeña 1
		JLabel lblPista = new JLabel(new ImageIcon("img/IconoPistaEX.png"));
		lblPista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPista.setIcon(new ImageIcon("img/IconoPistaENT.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblPista.setIcon(new ImageIcon("img/IconoPistaEX.png"));
			}
		});
		lblPista.setBounds(910, 11, 64, 60); // Posición en la parte derecha del JFrame
		getContentPane().add(lblPista);


		// Añadir la imagen de fondo primero
		
		lblCasa.setBounds(0, -52, 984, 602);
		lblCasa.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCasa);

	}
        


	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			CasaExterior frame = new CasaExterior();
			frame.setVisible(true);
		});
	}
}
