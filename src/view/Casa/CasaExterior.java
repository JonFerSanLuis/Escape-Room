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
import config.Config;
import utilidades.Cronometro;
import utilidades.ImagenLoader;
import utilidades.Inventario;

public class CasaExterior extends JPanel {
	
	private JTextField textField;

	int txtPuerta;

	int txtPre;

	String CasaExterior;

	JLabel lblCasa;
	
	private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro
	
	ImagenLoader img = new ImagenLoader();

	public CasaExterior(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		juego.getInventario().setLlavePuerta(new Objeto(true, true, 001, "Llave", "La llave de la puerta delantera de la casa de Mikel", "/img/llaveCasa.png"));

		JLabel LightLabel = new JLabel();
        LightLabel.setBounds(502, 448, 61, 17); // Ajusta el tamaño del JLabel 
        LightLabel.setIcon(img.scaleImage("/img/11571045.png", 61, 17));
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
		
		JLabel txtLlaveEncontrada = new JLabel(Config.getTexto("1CE"));
		txtLlaveEncontrada.setHorizontalAlignment(SwingConstants.CENTER);
		txtLlaveEncontrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLlaveEncontrada.setForeground(Color.WHITE);
		txtLlaveEncontrada.setBounds(50, 495, 875, 50);
		add(txtLlaveEncontrada);
		txtLlaveEncontrada.setVisible(false);
		
		JLabel txtSegundaVentana = new JLabel(Config.getTexto("2CE"));
		txtSegundaVentana.setHorizontalAlignment(SwingConstants.CENTER);
		txtSegundaVentana.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSegundaVentana.setForeground(Color.WHITE);
		txtSegundaVentana.setBounds(50, 495, 875, 50);
		add(txtSegundaVentana);
		txtSegundaVentana.setVisible(false);
		
		JLabel txtVentana = new JLabel(Config.getTexto("3CE"));
		txtVentana.setHorizontalAlignment(SwingConstants.CENTER);
		txtVentana.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtVentana.setForeground(Color.WHITE);
		txtVentana.setBounds(50, 495, 875, 50);
		add(txtVentana);
		txtVentana.setVisible(false);
		
		JLabel txtOtraPuerta = new JLabel(Config.getTexto("4CE"));
		txtOtraPuerta.setHorizontalAlignment(SwingConstants.CENTER);
		txtOtraPuerta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtOtraPuerta.setForeground(Color.WHITE);
		txtOtraPuerta.setBounds(50, 495, 875, 50);
		add(txtOtraPuerta);
		txtOtraPuerta.setVisible(false);
		
		JLabel txtLlaveNOEncontrada = new JLabel(Config.getTexto("5CE"));
		txtLlaveNOEncontrada.setHorizontalAlignment(SwingConstants.CENTER);
		txtLlaveNOEncontrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLlaveNOEncontrada.setForeground(Color.WHITE);
		txtLlaveNOEncontrada.setBounds(50, 495, 875, 50);
		add(txtLlaveNOEncontrada);
		txtLlaveNOEncontrada.setVisible(false);

		JButton btnContinueMaceta = new JButton(Config.getTexto("btnContinuar"));
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
				if(juego.getInventario().contieneObjeto(juego.getInventario().getLlavePuerta())==false) {
					CasaExterior = "/img/CasaExteriorTexto.jpeg";
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
					btnMaceta.setEnabled(true);
					juego.getInventario().agregarObjeto(juego.getInventario().getLlavePuerta());
				}
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
				CasaExterior = "/img/CasaExteriorTexto.jpeg";
				upgradeImage();
				btnPuertaCasa.setVisible(false);
				juego.getBtnPista().setVisible(false);
				juego.getBtnMochila().setVisible(false);
				btnPosit.setVisible(false);
				if(juego.getInventario().contieneObjeto(juego.getInventario().getLlavePuerta())==false) {
					btnMaceta.setVisible(true);
				}else {
					btnMaceta.setVisible(false);
				}
				btnPuertaDoble.setVisible(false);
				btnMacetaIncorrect.setVisible(false);
				btnContinueMaceta.setVisible(true);
				txtLlaveNOEncontrada.setVisible(true);
			}
		});
		
		add(btnMacetaIncorrect);

		JLabel lblPositGrande = new JLabel();
		lblPositGrande.setBounds(240, 100, 478, 429); // Ajusta el tamaño del JLabel

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
						if(juego.getInventario().contieneObjeto(juego.getInventario().getLlavePuerta())==false) {
							btnMaceta.setVisible(true);
						}else {
							btnMaceta.setVisible(false);
						}
						txtLlaveNOEncontrada.setVisible(false);
						CasaExterior = "/img/CasaExteriorImg.jpeg";
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

		add(btnMaceta);
		add(LightLabel);

		lblPositGrande.setIcon(img.scaleImage("/img/postitGrande (2).png", 478, 429));
		add(lblPositGrande);
		lblPositGrande.setVisible(false);

		JLabel TxtPuerta1 = new JLabel(Config.getTexto("8CE"));
		TxtPuerta1.setHorizontalAlignment(SwingConstants.CENTER);
		TxtPuerta1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtPuerta1.setForeground(Color.WHITE);
		TxtPuerta1.setBounds(50, 495, 875, 50);
		add(TxtPuerta1);
		TxtPuerta1.setVisible(false);

		JLabel TxtPuerta2 = new JLabel(Config.getTexto("9CE"));
		TxtPuerta2.setHorizontalAlignment(SwingConstants.CENTER);
		TxtPuerta2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtPuerta2.setForeground(Color.WHITE);
		TxtPuerta2.setBounds(50, 495, 875, 50);
		add(TxtPuerta2);
		TxtPuerta2.setVisible(false);

		JLabel TxtPuerta3 = new JLabel(Config.getTexto("10CE"));
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

		JButton btnVolver = new JButton(Config.getTexto("btnVolver"));
		btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPuertaCasa.setVisible(true);
				juego.getBtnPista().setVisible(true);
				juego.getBtnMochila().setVisible(true);
				btnPosit.setVisible(true);
				btnVolver.setVisible(false);
				btnPuertaDoble.setVisible(true);
				if(juego.getInventario().contieneObjeto(juego.getInventario().getLlavePuerta())==false) {
					btnMaceta.setVisible(true);
				}else {
					btnMaceta.setVisible(false);
				}
				btnMacetaIncorrect.setVisible(true);
				lblPositGrande.setVisible(false);
			}
		});
		btnVolver.setBounds(37, 511, 89, 23);
		add(btnVolver);
		btnVolver.setVisible(false);

		JLabel lblPostit = new JLabel();
		lblPostit.setIcon(img.scaleImage("/img/postitGrande (2).png", 46, 50));
		lblPostit.setBounds(270, 378, 46, 50);

		btnPosit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPuertaCasa.setVisible(false);
				juego.getBtnPista().setVisible(false);
				juego.getBtnMochila().setVisible(false);
				btnPosit.setVisible(false);
				btnVolver.setVisible(true);
				btnPuertaDoble.setVisible(false);
				if(juego.getInventario().contieneObjeto(juego.getInventario().getLlavePuerta())==false) {
					btnMaceta.setVisible(true);
				}else {
					btnMaceta.setVisible(false);
				}
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

		CasaExterior = "/img/CasaExteriorTexto.jpeg";

		lblCasa = new JLabel();
		lblCasa.setBackground(Color.BLACK);
		lblCasa.setIcon(img.scaleImage(CasaExterior, 950, 600)); // Establecer la imagen por defecto
		add(lblCasa);
		
		upgradeImage();

		// Botón (btnPuertaCasa)

		btnPuertaCasa.setBounds(455, 328, 53, 130);
		btnPuertaCasa.setOpaque(false);
		btnPuertaCasa.setBackground(new Color(0, 0, 0, 0));
		btnPuertaCasa.setBorderPainted(false); // No dibujar el borde
		btnPuertaCasa.setFocusPainted(false);
		btnPuertaCasa.setContentAreaFilled(false);
		add(btnPuertaCasa);

		JButton btnContinuePuerta = new JButton(Config.getTexto("btnContinuar"));
		btnContinuePuerta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnPuertaDoble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CasaExterior = "/img/CasaExteriorTexto.jpeg";
				upgradeImage();
				btnPuertaCasa.setVisible(false);
				juego.getBtnPista().setVisible(false);
				juego.getBtnMochila().setVisible(false);
				btnPosit.setVisible(false);
				btnPuertaDoble.setVisible(false);
				if(juego.getInventario().contieneObjeto(juego.getInventario().getLlavePuerta())==false) {
					btnMaceta.setVisible(true);
				}else {
					btnMaceta.setVisible(false);
				}
				btnMacetaIncorrect.setVisible(false);
				txtOtraPuerta.setVisible(true);
				btnContinueMaceta.setVisible(true);
			}
		});

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
						if(juego.getInventario().contieneObjeto(juego.getInventario().getLlavePuerta())==false) {
							btnMaceta.setVisible(true);
						}else {
							btnMaceta.setVisible(false);
						}
						btnMacetaIncorrect.setVisible(true);
						btnContinuePuerta.setVisible(false);
						btnPuertaDoble.setVisible(true);
						CasaExterior = "/img/CasaExteriorImg.jpeg";
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
				if(juego.getInventario().contieneObjeto(juego.getInventario().getLlavePuerta())==false) {
					btnMaceta.setVisible(true);
				}else {
					btnMaceta.setVisible(false);
				}
				btnPuertaDoble.setVisible(false);
				btnPosit.setVisible(false);
				CasaExterior = "/img/CasaExteriorTexto.jpeg";
				upgradeImage();
				TxtPuerta1.setVisible(true);
				}
			}
		});

		// Añadir la imagen de fondo primero
		lblCasa.setBounds(0, 0, 950, 600);
		lblCasa.setHorizontalAlignment(SwingConstants.CENTER);

		ArrayList<JLabel> TxtIntroCasa = new ArrayList<>();

		JLabel TxtIntroCasa1 = new JLabel(Config.getTexto("12CE"));
		TxtIntroCasa1.setHorizontalAlignment(SwingConstants.CENTER);
		TxtIntroCasa1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtIntroCasa1.setForeground(Color.WHITE);
		TxtIntroCasa1.setBounds(50, 495, 875, 50);
		add(TxtIntroCasa1);
		TxtIntroCasa1.setVisible(true);

		JLabel TxtIntroCasa2 = new JLabel(Config.getTexto("13CE"));
		TxtIntroCasa2.setHorizontalAlignment(SwingConstants.CENTER);
		TxtIntroCasa2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtIntroCasa2.setForeground(Color.WHITE);
		TxtIntroCasa2.setBounds(50, 495, 875, 50);
		add(TxtIntroCasa2);
		TxtIntroCasa2.setVisible(false);

		TxtIntroCasa.add(TxtIntroCasa1);
		TxtIntroCasa.add(TxtIntroCasa2);

		txtPre = 0;

			JButton btnContinue = new JButton(Config.getTexto("btnContinuar"));
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
						CasaExterior = "/img/CasaExteriorImg.jpeg";
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

		add(lblCasa);
		
		labelTiempo = new JLabel(Cronometro.getInstancia().getTiempoFormato());
		labelTiempo.setFont(new Font("Tahoma", Font.BOLD, 18)); // Fuente más grande para mejor visibilidad
		labelTiempo.setForeground(Color.WHITE); // Texto en blanco
		labelTiempo.setBackground(new Color(0, 0, 0)); // Fondo negro semi-transparente
		labelTiempo.setOpaque(true);
		labelTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTiempo.setBounds(10, 10, 102, 30); 
		
		// Agregar primero labelTiempo para asegurarnos de que está al frente
		add(labelTiempo);
		setComponentZOrder(labelTiempo, 0); // Lo pone en la capa superior

        // Actualizar la etiqueta cada segundo con el formato HH:MM:SS
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText(Cronometro.getInstancia().getTiempoFormato()));
        actualizarTimer.start();

	}

	private void upgradeImage() {
		// Actualizar el fondo con la nueva imagen
		lblCasa.setIcon(img.scaleImage(CasaExterior, 950, 600));
		lblCasa.repaint(); // Redibujar para aplicar el cambio
	}

}
