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
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Objetos.Objeto;
import utilidades.Inventario;

public class CasaExterior extends JFrame {
	
	private JTextField textField;

	int txtPuerta;

	int txtPre;

	String CasaExterior;

	JLabel lblCasa;

	public CasaExterior() {
		// Configuración básica del JFrame
		setTitle("Casa");
		setBounds(200, 100, 950, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		Inventario inventario = new Inventario();
		
		Objeto LlavePuerta = new Objeto(true, true, 114, "Llave", "La llave de la puerta delantera de la casa de Mikel");

		JLabel txtLlaveEncontrada = new JLabel("-Mueves la maceta cuidadosamente y encuentras la llave de la casa-");
		txtLlaveEncontrada.setHorizontalAlignment(SwingConstants.CENTER);
		txtLlaveEncontrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLlaveEncontrada.setForeground(Color.WHITE);
		txtLlaveEncontrada.setBounds(50, 495, 875, 50);
		getContentPane().add(txtLlaveEncontrada);
		txtLlaveEncontrada.setVisible(false);
		
		JLabel txtLlaveNOEncontrada = new JLabel("-Mueves la maceta, pero no hay nada debajo-");
		txtLlaveNOEncontrada.setHorizontalAlignment(SwingConstants.CENTER);
		txtLlaveNOEncontrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLlaveNOEncontrada.setForeground(Color.WHITE);
		txtLlaveNOEncontrada.setBounds(50, 495, 875, 50);
		getContentPane().add(txtLlaveNOEncontrada);
		txtLlaveNOEncontrada.setVisible(false);

		JButton btnContinueMaceta = new JButton("CONTINUAR");
		JButton btnMaceta = new JButton("");
		JButton btnPuertaCasa = new JButton("");
		JButton btnMochila = new JButton("");
		btnMochila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton btnPista = new JButton("");
		JButton btnPosit = new JButton("");
		JButton btnMacetaIncorrect = new JButton("");
		
		btnMaceta.setBounds(512, 422, 17, 17);
		btnMaceta.setOpaque(false);
		btnMaceta.setBackground(new Color(0, 0, 0, 0));
		btnMaceta.setBorderPainted(false); // No dibujar el borde
		btnMaceta.setFocusPainted(false);
		btnMaceta.setContentAreaFilled(false);
		btnMaceta.setVisible(false);
		btnMaceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CasaExterior = "img/CasaExteriorTexto.jpeg";
				upgradeImage();
				btnPuertaCasa.setVisible(false);
				btnPista.setVisible(false);
				btnMochila.setVisible(false);
				btnPosit.setVisible(false);
				btnMaceta.setVisible(false);
				btnMacetaIncorrect.setVisible(false);
				txtLlaveEncontrada.setVisible(true);
				btnContinueMaceta.setVisible(true);
				inventario.agregarObjeto(LlavePuerta);
			}
		});
		
		btnMacetaIncorrect.setBounds(422, 409, 23, 23);
		btnMacetaIncorrect.setOpaque(false);
		btnMacetaIncorrect.setBackground(new Color(0, 0, 0, 0));
		btnMacetaIncorrect.setBorderPainted(false); // No dibujar el borde
		btnMacetaIncorrect.setFocusPainted(false);
		btnMacetaIncorrect.setContentAreaFilled(false);
		btnMacetaIncorrect.setVisible(false);
		btnMacetaIncorrect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CasaExterior = "img/CasaExteriorTexto.jpeg";
				upgradeImage();
				btnPuertaCasa.setVisible(false);
				btnPista.setVisible(false);
				btnMochila.setVisible(false);
				btnPosit.setVisible(false);
				btnMaceta.setVisible(false);
				btnMacetaIncorrect.setVisible(false);
				btnContinueMaceta.setVisible(true);
				txtLlaveNOEncontrada.setVisible(true);
			}
		});
		
		getContentPane().add(btnMacetaIncorrect);

		ImageIcon PositImagen = new ImageIcon("img/postitGrande (2).png");
		JLabel lblPositGrande = new JLabel();
		lblPositGrande.setBounds(223, 67, 478, 429); // Ajusta el tamaño del JLabel
		// Redimensionar la imagen para que se ajuste al tamaño del JLabel
		Image imgPositG = PositImagen.getImage().getScaledInstance(lblPositGrande.getWidth(),
				lblPositGrande.getHeight(), Image.SCALE_SMOOTH);

		try {
			Font optionsFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/BeechlandsDemoRegular.ttf"));
			optionsFont = optionsFont.deriveFont(10f);
			btnContinueMaceta.setBounds(819, 468, 115, 23);
			btnContinueMaceta.setBackground(new Color(0, 0, 0, 0));
			btnContinueMaceta.setOpaque(false);
			btnContinueMaceta.setBorderPainted(false);
			btnContinueMaceta.setContentAreaFilled(false);
			btnContinueMaceta.setForeground(Color.GRAY);
			btnContinueMaceta.setContentAreaFilled(false);
			btnContinueMaceta.setVisible(false);
			btnContinueMaceta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnPuertaCasa.setVisible(true);
					btnPista.setVisible(true);
					btnMochila.setVisible(true);
					btnPosit.setVisible(true);
					txtLlaveEncontrada.setVisible(false);
					btnContinueMaceta.setVisible(false);
					btnMacetaIncorrect.setVisible(true);
					btnMaceta.setVisible(true);
					txtLlaveNOEncontrada.setVisible(false);
					CasaExterior = "img/CasaExteriorImg.jpeg";
					upgradeImage();
				}
				
			});
			btnContinueMaceta.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnContinueMaceta.setForeground(Color.white);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnContinueMaceta.setForeground(Color.GRAY);
				}
			});
			
			
			getContentPane().add(btnContinueMaceta);

		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}

		getContentPane().add(btnMaceta);

		lblPositGrande.setIcon(new ImageIcon(imgPositG));
		getContentPane().add(lblPositGrande);
		lblPositGrande.setVisible(false);

		JLabel TxtPuerta1 = new JLabel("Parece que no hay nadie en casa.");
		TxtPuerta1.setHorizontalAlignment(SwingConstants.CENTER);
		TxtPuerta1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtPuerta1.setForeground(Color.WHITE);
		TxtPuerta1.setBounds(50, 495, 875, 50);
		getContentPane().add(TxtPuerta1);
		TxtPuerta1.setVisible(false);

		JLabel TxtPuerta2 = new JLabel("Pero la puerta esta cerrada.");
		TxtPuerta2.setHorizontalAlignment(SwingConstants.CENTER);
		TxtPuerta2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtPuerta2.setForeground(Color.WHITE);
		TxtPuerta2.setBounds(50, 495, 875, 50);
		getContentPane().add(TxtPuerta2);
		TxtPuerta2.setVisible(false);

		JLabel TxtPuerta3 = new JLabel("Debo encontrar la forma de entrar");
		TxtPuerta3.setHorizontalAlignment(SwingConstants.CENTER);
		TxtPuerta3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtPuerta3.setForeground(Color.WHITE);
		TxtPuerta3.setBounds(50, 495, 875, 50);
		getContentPane().add(TxtPuerta3);
		TxtPuerta3.setVisible(false);

		ArrayList<JLabel> ReaccionPuerta = new ArrayList<>();

		ReaccionPuerta.add(TxtPuerta1);
		ReaccionPuerta.add(TxtPuerta2);
		ReaccionPuerta.add(TxtPuerta3);

		txtPuerta = 0;

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPuertaCasa.setVisible(true);
				btnPista.setVisible(true);
				btnMochila.setVisible(true);
				btnPosit.setVisible(true);
				btnVolver.setVisible(false);
				btnMaceta.setVisible(true);
				lblPositGrande.setVisible(false);
			}
		});
		btnVolver.setBounds(37, 511, 89, 23);
		getContentPane().add(btnVolver);
		btnVolver.setVisible(false);

		JLabel lblPostit = new JLabel();
		lblPostit.setIcon(new ImageIcon("img/PostitEntrada.png"));
		lblPostit.setBounds(259, 350, 46, 50);
		getContentPane().add(lblPostit);

		btnPosit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPuertaCasa.setVisible(false);
				btnPista.setVisible(false);
				btnMochila.setVisible(false);
				btnPosit.setVisible(false);
				btnVolver.setVisible(true);
				btnMaceta.setVisible(false);
				lblPositGrande.setVisible(true);
			}
		});

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

		btnPosit.setBounds(259, 350, 46, 50);
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

		CasaExterior = "img/CasaExteriorTexto.jpeg";

		ImageIcon originalIcon = new ImageIcon(CasaExterior);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		lblCasa = new JLabel();
		lblCasa.setBackground(new Color(240, 240, 240));
		lblCasa.setBounds(0, 0, 934, 561);
		lblCasa.setIcon(scaledIcon); // Establecer la imagen por defecto
		getContentPane().add(lblCasa);

		// Botón (btnPuertaCasa)

		btnPuertaCasa.setBounds(445, 296, 57, 130);
		btnPuertaCasa.setOpaque(false);
		btnPuertaCasa.setBackground(new Color(0, 0, 0, 0));
		btnPuertaCasa.setBorderPainted(false); // No dibujar el borde
		btnPuertaCasa.setFocusPainted(false);
		btnPuertaCasa.setContentAreaFilled(false);
		getContentPane().add(btnPuertaCasa);

		JButton btnContinuePuerta = new JButton("CONTINUAR");

		try {
			Font optionsFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/BeechlandsDemoRegular.ttf"));
			optionsFont = optionsFont.deriveFont(10f);
			btnContinuePuerta.setBounds(819, 468, 115, 23);
			btnContinuePuerta.setBackground(new Color(0, 0, 0, 0));
			btnContinuePuerta.setOpaque(false);
			btnContinuePuerta.setBorderPainted(false);
			btnContinuePuerta.setContentAreaFilled(false);
			btnContinuePuerta.setForeground(Color.GRAY);
			btnContinuePuerta.setContentAreaFilled(false);
			btnContinuePuerta.setVisible(false);

			btnContinuePuerta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (txtPuerta == 2) {
						btnPuertaCasa.setVisible(true);
						btnPista.setVisible(true);
						btnMochila.setVisible(true);
						btnPosit.setVisible(true);
						btnMaceta.setVisible(true);
						btnContinuePuerta.setVisible(false);
						CasaExterior = "img/CasaExteriorImg.jpeg";
						upgradeImage();
						TxtPuerta3.setVisible(false);
						txtPuerta = 0;
					} else if (txtPuerta < ReaccionPuerta.size()) {
						ReaccionPuerta.get(txtPuerta).setVisible(false);
						ReaccionPuerta.get(txtPuerta + 1).setVisible(true);
						txtPuerta = txtPuerta + 1;
					}
				}
			});

			btnContinuePuerta.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnContinuePuerta.setForeground(Color.white);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnContinuePuerta.setForeground(Color.GRAY);
				}
			});

			getContentPane().add(btnContinuePuerta);

		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}

		btnPuertaCasa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(inventario.contieneObjeto(LlavePuerta)){
					Recibidor recibidor = new Recibidor();
					recibidor.setVisible(true);
					dispose();
				}else {
					btnContinuePuerta.setVisible(true);
				btnPuertaCasa.setVisible(false);
				btnPista.setVisible(false);
				btnPuertaCasa.setVisible(false);
				btnMochila.setVisible(false);
				btnMaceta.setVisible(false);
				btnPosit.setVisible(false);
				CasaExterior = "img/CasaExteriorTexto.jpeg";
				upgradeImage();
				TxtPuerta1.setVisible(true);
				}
			}
		});

		// Imagen pequeña 2
		JLabel lblMochila = new JLabel(new ImageIcon("img/IconoMochilaEX.png"));

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

		btnMochila.setBounds(785, 11, 65, 60);
		btnMochila.setOpaque(false);
		btnMochila.setBackground(new Color(0, 0, 0, 0));
		btnMochila.setBorderPainted(false); // No dibujar el borde
		btnMochila.setFocusPainted(false);
		btnMochila.setContentAreaFilled(false);

		lblMochila.setBounds(785, 11, 65, 60); // Posición adicional a la derecha del JFrame
		getContentPane().add(lblMochila);
		getContentPane().add(btnMochila);
		btnMochila.setVisible(false);
		lblMochila.setVisible(false);

		// Imagen pequeña 1
		JLabel lblPista = new JLabel(new ImageIcon("img/IconoPistaEX.png"));

		btnPista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPista.setIcon(new ImageIcon("img/IconoPistaENT.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblPista.setIcon(new ImageIcon("img/IconoPistaEX.png"));
			}
		});

		btnPista.setBounds(860, 11, 64, 60);
		btnPista.setOpaque(false);
		btnPista.setBackground(new Color(0, 0, 0, 0));
		btnPista.setBorderPainted(false); // No dibujar el borde
		btnPista.setFocusPainted(false);
		btnPista.setContentAreaFilled(false);

		lblPista.setBounds(860, 11, 64, 60);
		getContentPane().add(btnPista);// Posición en la parte derecha del JFrame
		getContentPane().add(lblPista);
		btnPista.setVisible(false);
		lblPista.setVisible(false);

		// Añadir la imagen de fondo primero
		lblCasa.setBounds(0, 0, 934, 561);
		lblCasa.setHorizontalAlignment(SwingConstants.CENTER);

		ArrayList<JLabel> TxtIntroCasa = new ArrayList<>();

		JLabel TxtIntroCasa1 = new JLabel("Esta es la casa de Mikel.");
		TxtIntroCasa1.setHorizontalAlignment(SwingConstants.CENTER);
		TxtIntroCasa1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtIntroCasa1.setForeground(Color.WHITE);
		TxtIntroCasa1.setBounds(50, 495, 875, 50);
		getContentPane().add(TxtIntroCasa1);
		TxtIntroCasa1.setVisible(true);

		JLabel TxtIntroCasa2 = new JLabel("Debería ver a sus padres por si me pueden dar algo de información");
		TxtIntroCasa2.setHorizontalAlignment(SwingConstants.CENTER);
		TxtIntroCasa2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtIntroCasa2.setForeground(Color.WHITE);
		TxtIntroCasa2.setBounds(50, 495, 875, 50);
		getContentPane().add(TxtIntroCasa2);
		TxtIntroCasa2.setVisible(false);

		TxtIntroCasa.add(TxtIntroCasa1);
		TxtIntroCasa.add(TxtIntroCasa2);

		txtPre = 0;

		try {
			Font optionsFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/BeechlandsDemoRegular.ttf"));
			optionsFont = optionsFont.deriveFont(10f);
			JButton btnContinue = new JButton("CONTINUAR");
			btnContinue.setBounds(819, 468, 115, 23);
			btnContinue.setBackground(new Color(0, 0, 0, 0));
			btnContinue.setOpaque(false);
			btnContinue.setBorderPainted(false);
			btnContinue.setContentAreaFilled(false);
			btnContinue.setForeground(Color.GRAY);

			btnContinue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (txtPre == 1) {
						btnMochila.setVisible(true);
						btnPosit.setVisible(true);
						btnPista.setVisible(true);
						lblPista.setVisible(true);
						btnMaceta.setVisible(true);
						lblMochila.setVisible(true);
						btnMacetaIncorrect.setVisible(true);
						btnPuertaCasa.setVisible(true);
						TxtIntroCasa2.setVisible(false);
						btnContinue.setVisible(false);
						txtPre = 2;
					} else if (txtPre < TxtIntroCasa.size()) {
						TxtIntroCasa.get(txtPre).setVisible(false);
						TxtIntroCasa.get(txtPre + 1).setVisible(true);
						txtPre = txtPre + 1;
					}
					if (txtPre == 2) {
						CasaExterior = "img/CasaExteriorImg.jpeg";
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

			getContentPane().add(btnContinue);

		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}

		getContentPane().add(lblCasa);

	}

	private void upgradeImage() {
		// Cargar la nueva imagen
		ImageIcon originalIcon = new ImageIcon(CasaExterior);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Actualizar el fondo con la nueva imagen
		lblCasa.setIcon(scaledIcon);
		lblCasa.repaint(); // Redibujar para aplicar el cambio
	}

	private ImageIcon loadImage(String filePath) {
		ImageIcon icon = new ImageIcon(filePath);
		Image image = icon.getImage();
		return new ImageIcon(
				image.getScaledInstance(getContentPane().getWidth(), getContentPane().getHeight(), Image.SCALE_SMOOTH));
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			CasaExterior frame = new CasaExterior();
			frame.setVisible(true);
		});
	}
}
