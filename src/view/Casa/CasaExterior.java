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

		// Imagen pequeña 1
		String smallImagePath1 = "img/PistaIcono.png";
		ImageIcon smallScaledIcon1 = new ImageIcon(
				new ImageIcon(smallImagePath1).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

		// Imagen pequeña 2
		String smallImagePath2 = "img/MochilaIcono.png";
		ImageIcon smallScaledIcon2 = new ImageIcon(
				new ImageIcon(smallImagePath2).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

		// Imagen de fondo
		String imagePath = "img/CasaExteriorImg.jpeg";
		ImageIcon scaledIcon = new ImageIcon(
				new ImageIcon(imagePath).getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH));


		// Botón (btnPuertaCasa)
		JButton btnPuertaCasa = new JButton();
		btnPuertaCasa.setBounds(467, 268, 67, 106);
		btnPuertaCasa.setOpaque(false);
		getContentPane().add(btnPuertaCasa);

		JLabel lblReaccionPuertaCasa = new JLabel();
		lblReaccionPuertaCasa.setForeground(Color.WHITE);
		lblReaccionPuertaCasa.setBounds(272, 404, 510, 50);

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
		
		getContentPane().add(lblReaccionPuertaCasa);
		btnPuertaCasa.setVisible(false);


		// Imagen pequeña 2
		JLabel lblMochila = new JLabel(new ImageIcon("img/IconoMochilaEX.png"));
		lblMochila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMochila.setIcon(new ImageIcon("img/IconoMochilaENT.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMochila.setIcon(new ImageIcon("img/IconoMochilaEX.png"));
			}
		});

		lblMochila.setBounds(835, 11, 65, 60); // Posición adicional a la derecha del JFrame
		getContentPane().add(lblMochila);

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
		JLabel lblCasa = new JLabel(scaledIcon);
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
