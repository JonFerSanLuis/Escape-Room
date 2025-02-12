 package view.Casa;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.Timer;

import Inicio.Juego;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Objetos.Objeto;
import utilidades.Cronometro;
import utilidades.Inventario;

public class CasaExterior extends JPanel {
	
	private JTextField textField;

	int txtPuerta;

	int txtPre;

	String CasaExterior;

	JLabel lblCasa;
	
	private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro

	public CasaExterior(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		juego.getInventario().setLlavePuerta(new Objeto(true, true, 001, "Llave", "La llave de la puerta delantera de la casa de Mikel", "img/llaveCasa.png"));

		JLabel LightLabel = new JLabel();
        // Cargar la imagen de la bandera inglesa
        ImageIcon LightImagen = new ImageIcon("img/11571045.png");
        LightLabel.setBounds(502, 448, 61, 17); // Ajusta el tama�o del JLabel 
        Image imgLight = LightImagen.getImage().getScaledInstance(LightLabel.getWidth(), LightLabel.getHeight(), Image.SCALE_SMOOTH);
        LightLabel.setIcon(new ImageIcon(imgLight));
        LightLabel.setVisible(false);
		
		JButton btnPuertaDoble = new JButton("");
		btnPuertaDoble.setBounds(317, 326, 90, 121);
		btnPuertaDoble.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPuertaDoble.setOpaque(false);
		btnPuertaDoble.setBackground(new Color(0, 0, 0, 0));
		btnPuertaDoble.setBorderPainted(false); // No dibujar el borde
		btnPuertaDoble.setFocusPainted(false);
		btnPuertaDoble.setContentAreaFilled(false);
		btnPuertaDoble.setVisible(false);
		add(btnPuertaDoble);
		
		JLabel txtLlaveEncontrada = new JLabel("-Mueves la maceta cuidadosamente y encuentras la llave de la casa-");
		txtLlaveEncontrada.setHorizontalAlignment(SwingConstants.CENTER);
		txtLlaveEncontrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLlaveEncontrada.setForeground(Color.WHITE);
		txtLlaveEncontrada.setBounds(50, 495, 875, 50);
		add(txtLlaveEncontrada);
		txtLlaveEncontrada.setVisible(false);
		
		JLabel txtSegundaVentana = new JLabel("No llego ni de co�a.");
		txtSegundaVentana.setHorizontalAlignment(SwingConstants.CENTER);
		txtSegundaVentana.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSegundaVentana.setForeground(Color.WHITE);
		txtSegundaVentana.setBounds(50, 495, 875, 50);
		add(txtSegundaVentana);
		txtSegundaVentana.setVisible(false);
		
		JLabel txtVentana = new JLabel("Nah, tampoco puedo entrar por la ventana.");
		txtVentana.setHorizontalAlignment(SwingConstants.CENTER);
		txtVentana.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtVentana.setForeground(Color.WHITE);
		txtVentana.setBounds(50, 495, 875, 50);
		add(txtVentana);
		txtVentana.setVisible(false);
		
		JLabel txtOtraPuerta = new JLabel("Esta puerta tampoco se habre.");
		txtOtraPuerta.setHorizontalAlignment(SwingConstants.CENTER);
		txtOtraPuerta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtOtraPuerta.setForeground(Color.WHITE);
		txtOtraPuerta.setBounds(50, 495, 875, 50);
		add(txtOtraPuerta);
		txtOtraPuerta.setVisible(false);
		
		JLabel txtLlaveNOEncontrada = new JLabel("-Mueves la maceta, pero no hay nada debajo-");
		txtLlaveNOEncontrada.setHorizontalAlignment(SwingConstants.CENTER);
		txtLlaveNOEncontrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLlaveNOEncontrada.setForeground(Color.WHITE);
		txtLlaveNOEncontrada.setBounds(50, 495, 875, 50);
		add(txtLlaveNOEncontrada);
		txtLlaveNOEncontrada.setVisible(false);

		JButton btnContinueMaceta = new JButton("CONTINUAR");
		btnContinueMaceta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JButton btnMaceta = new JButton("");
		btnMaceta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMaceta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LightLabel.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LightLabel.setVisible(false);
			}
		});
		
		JButton btnPuertaCasa = new JButton("");
		btnPuertaCasa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JButton btnPosit = new JButton("");
		btnPosit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JButton btnMacetaIncorrect = new JButton("");
		btnMacetaIncorrect.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnMaceta.setBounds(517, 433, 23, 23);
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
				juego.getBtnPista().setVisible(false);
				juego.getBtnMochila().setVisible(false);
				btnPosit.setVisible(false);
				btnPuertaDoble.setVisible(false);
				btnMaceta.setVisible(false);
				btnMacetaIncorrect.setVisible(false);
				txtLlaveEncontrada.setVisible(true);
				btnContinueMaceta.setVisible(true);
				juego.getInventario().agregarObjeto(juego.getInventario().getLlavePuerta());
			}
		});
		
		btnMacetaIncorrect.setBounds(431, 433, 23, 23);
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
				juego.getBtnPista().setVisible(false);
				juego.getBtnMochila().setVisible(false);
				btnPosit.setVisible(false);
				btnMaceta.setVisible(false);
				btnPuertaDoble.setVisible(false);
				btnMacetaIncorrect.setVisible(false);
				btnContinueMaceta.setVisible(true);
				txtLlaveNOEncontrada.setVisible(true);
			}
		});
		
		add(btnMacetaIncorrect);

		ImageIcon PositImagen = new ImageIcon("img/postitGrande (2).png");
		JLabel lblPositGrande = new JLabel();
		lblPositGrande.setBounds(240, 100, 478, 429); // Ajusta el tama�o del JLabel
		// Redimensionar la imagen para que se ajuste al tama�o del JLabel
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
					juego.getBtnPista().setVisible(true);
					juego.getBtnMochila().setVisible(true);
					btnPosit.setVisible(true);
					txtLlaveEncontrada.setVisible(false);
					btnContinueMaceta.setVisible(false);
					txtOtraPuerta.setVisible(false);
					btnPuertaDoble.setVisible(true);
					btnMacetaIncorrect.setVisible(true);
					btnMaceta.setEnabled(true);
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
			
			
			add(btnContinueMaceta);

		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}

		add(btnMaceta);
		add(LightLabel);

		lblPositGrande.setIcon(new ImageIcon(imgPositG));
		add(lblPositGrande);
		lblPositGrande.setVisible(false);

		JLabel TxtPuerta1 = new JLabel("Parece que no hay nadie en casa.");
		TxtPuerta1.setHorizontalAlignment(SwingConstants.CENTER);
		TxtPuerta1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtPuerta1.setForeground(Color.WHITE);
		TxtPuerta1.setBounds(50, 495, 875, 50);
		add(TxtPuerta1);
		TxtPuerta1.setVisible(false);

		JLabel TxtPuerta2 = new JLabel("Pero la puerta esta cerrada.");
		TxtPuerta2.setHorizontalAlignment(SwingConstants.CENTER);
		TxtPuerta2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtPuerta2.setForeground(Color.WHITE);
		TxtPuerta2.setBounds(50, 495, 875, 50);
		add(TxtPuerta2);
		TxtPuerta2.setVisible(false);

		JLabel TxtPuerta3 = new JLabel("Debo encontrar la forma de entrar");
		TxtPuerta3.setHorizontalAlignment(SwingConstants.CENTER);
		TxtPuerta3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtPuerta3.setForeground(Color.WHITE);
		TxtPuerta3.setBounds(50, 495, 875, 50);
		add(TxtPuerta3);
		TxtPuerta3.setVisible(false);

		ArrayList<JLabel> ReaccionPuerta = new ArrayList<>();

		ReaccionPuerta.add(TxtPuerta1);
		ReaccionPuerta.add(TxtPuerta2);
		ReaccionPuerta.add(TxtPuerta3);

		txtPuerta = 0;

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPuertaCasa.setVisible(true);
				juego.getBtnPista().setVisible(true);
				juego.getBtnMochila().setVisible(true);
				btnPosit.setVisible(true);
				btnVolver.setVisible(false);
				btnPuertaDoble.setVisible(true);
				btnMaceta.setVisible(true);
				btnMacetaIncorrect.setVisible(true);
				lblPositGrande.setVisible(false);
			}
		});
		btnVolver.setBounds(37, 511, 89, 23);
		add(btnVolver);
		btnVolver.setVisible(false);

		JLabel lblPostit = new JLabel();
		lblPostit.setIcon(new ImageIcon("img/PostitEntrada.png"));
		lblPostit.setBounds(270, 378, 46, 50);

		btnPosit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPuertaCasa.setVisible(false);
				juego.getBtnPista().setVisible(false);
				juego.getBtnMochila().setVisible(false);
				btnPosit.setVisible(false);
				btnVolver.setVisible(true);
				btnPuertaDoble.setVisible(false);
				btnMaceta.setVisible(false);
				lblPositGrande.setVisible(true);
			}
		});
		btnPosit.setBounds(270, 378, 37, 37);
		btnPosit.setOpaque(false);
		btnPosit.setBackground(new Color(0, 0, 0, 0));
		btnPosit.setBorderPainted(false); // No dibujar el borde
		btnPosit.setFocusPainted(false);
		btnPosit.setContentAreaFilled(false);
		add(btnPosit);
		add(lblPostit);
		btnPosit.setVisible(false);

		CasaExterior = "img/CasaExteriorTexto.jpeg";

		ImageIcon originalIcon = new ImageIcon(CasaExterior);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		lblCasa = new JLabel();
		lblCasa.setBackground(Color.BLACK);
		lblCasa.setIcon(scaledIcon); // Establecer la imagen por defecto
		add(lblCasa);
		
		upgradeImage();

		// Bot�n (btnPuertaCasa)

		btnPuertaCasa.setBounds(455, 328, 53, 130);
		btnPuertaCasa.setOpaque(false);
		btnPuertaCasa.setBackground(new Color(0, 0, 0, 0));
		btnPuertaCasa.setBorderPainted(false); // No dibujar el borde
		btnPuertaCasa.setFocusPainted(false);
		btnPuertaCasa.setContentAreaFilled(false);
		add(btnPuertaCasa);

		JButton btnContinuePuerta = new JButton("CONTINUAR");
		btnContinuePuerta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnPuertaDoble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CasaExterior = "img/CasaExteriorTexto.jpeg";
				upgradeImage();
				btnPuertaCasa.setVisible(false);
				juego.getBtnPista().setVisible(false);
				juego.getBtnMochila().setVisible(false);
				btnPosit.setVisible(false);
				btnPuertaDoble.setVisible(false);
				btnMaceta.setVisible(false);
				btnMacetaIncorrect.setVisible(false);
				txtOtraPuerta.setVisible(true);
				btnContinueMaceta.setVisible(true);
			}
		});

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
						juego.getBtnPista().setVisible(true);
						juego.getBtnMochila().setVisible(true);
						btnPosit.setVisible(true);
						btnMaceta.setVisible(true);
						btnMacetaIncorrect.setVisible(true);
						btnContinuePuerta.setVisible(false);
						btnPuertaDoble.setVisible(true);
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

			add(btnContinuePuerta);

		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}

		btnPuertaCasa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(juego.getInventario().contieneObjeto(juego.getInventario().getLlavePuerta())){
					juego.cambiarEscena("recibidor");
				}else {
					btnContinuePuerta.setVisible(true);
				btnPuertaCasa.setVisible(false);
				juego.getBtnPista().setVisible(false);
				btnPuertaCasa.setVisible(false);
				juego.getBtnMochila().setVisible(false);
				btnMacetaIncorrect.setVisible(false);
				btnMaceta.setVisible(false);
				btnPuertaDoble.setVisible(false);
				btnPosit.setVisible(false);
				CasaExterior = "img/CasaExteriorTexto.jpeg";
				upgradeImage();
				TxtPuerta1.setVisible(true);
				}
			}
		});

		// A�adir la imagen de fondo primero
		lblCasa.setBounds(0, 0, 950, 600);
		lblCasa.setHorizontalAlignment(SwingConstants.CENTER);

		ArrayList<JLabel> TxtIntroCasa = new ArrayList<>();

		JLabel TxtIntroCasa1 = new JLabel("Esta es la casa de Mikel.");
		TxtIntroCasa1.setHorizontalAlignment(SwingConstants.CENTER);
		TxtIntroCasa1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtIntroCasa1.setForeground(Color.WHITE);
		TxtIntroCasa1.setBounds(50, 495, 875, 50);
		add(TxtIntroCasa1);
		TxtIntroCasa1.setVisible(true);

		JLabel TxtIntroCasa2 = new JLabel("Deber�a ver a sus padres por si me pueden dar algo de informaci�n");
		TxtIntroCasa2.setHorizontalAlignment(SwingConstants.CENTER);
		TxtIntroCasa2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtIntroCasa2.setForeground(Color.WHITE);
		TxtIntroCasa2.setBounds(50, 495, 875, 50);
		add(TxtIntroCasa2);
		TxtIntroCasa2.setVisible(false);

		TxtIntroCasa.add(TxtIntroCasa1);
		TxtIntroCasa.add(TxtIntroCasa2);

		txtPre = 0;

		try {
			Font optionsFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/BeechlandsDemoRegular.ttf"));
			optionsFont = optionsFont.deriveFont(10f);
			JButton btnContinue = new JButton("CONTINUAR");
			btnContinue.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnContinue.setBounds(819, 468, 115, 23);
			btnContinue.setBackground(new Color(0, 0, 0, 0));
			btnContinue.setOpaque(false);
			btnContinue.setBorderPainted(false);
			btnContinue.setContentAreaFilled(false);
			btnContinue.setForeground(Color.GRAY);

			btnContinue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (txtPre == 1) {
						juego.getBtnMochila().setVisible(true);
						btnPosit.setVisible(true);
						juego.getBtnPista().setVisible(true);
						juego.getLblPista().setVisible(true);
						btnMaceta.setVisible(true);
						juego.getLblMochila().setVisible(true);
						btnMacetaIncorrect.setVisible(true);
						btnPuertaCasa.setVisible(true);
						btnPuertaDoble.setVisible(true);
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

			add(btnContinue);

		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
		

		add(lblCasa);
		
		labelTiempo = new JLabel(Cronometro.getInstancia().getTiempoFormato());
		labelTiempo.setFont(new Font("Tahoma", Font.BOLD, 18)); // Fuente m�s grande para mejor visibilidad
		labelTiempo.setForeground(Color.WHITE); // Texto en blanco
		labelTiempo.setBackground(new Color(0, 0, 0)); // Fondo negro semi-transparente
		labelTiempo.setOpaque(true);
		labelTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTiempo.setBounds(10, 10, 102, 30); 
		
		// Agregar primero labelTiempo para asegurarnos de que est� al frente
		add(labelTiempo);
		setComponentZOrder(labelTiempo, 0); // Lo pone en la capa superior

        // Actualizar la etiqueta cada segundo con el formato HH:MM:SS
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText(Cronometro.getInstancia().getTiempoFormato()));
        actualizarTimer.start();

	}

	private void upgradeImage() {
		// Cargar la nueva imagen
		ImageIcon originalIcon = new ImageIcon(CasaExterior);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(950, 600, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Actualizar el fondo con la nueva imagen
		lblCasa.setIcon(scaledIcon);
		lblCasa.repaint(); // Redibujar para aplicar el cambio
	}

	private ImageIcon loadImage(String filePath) {
		ImageIcon icon = new ImageIcon(filePath);
		Image image = icon.getImage();
		return new ImageIcon(
				image.getScaledInstance(950, 600, Image.SCALE_SMOOTH));
	}
}
