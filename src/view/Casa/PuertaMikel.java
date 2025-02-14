package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import config.Config;
import utilidades.Cronometro;
import utilidades.ImagenLoader;
import utilidades.Inventario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PuertaMikel extends JPanel {

    private String backgroundFile;
    JLabel puertaLabel;
    
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro

	ImagenLoader img = new ImagenLoader();
    
    Inventario inventario = new Inventario();
    
	public PuertaMikel(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		backgroundFile = "/img/puertaMikel.jpg";
		
		JLabel lblVolver = new JLabel();
        lblVolver.setIcon(img.scaleImage("/img/flechaIzqOFF.png", 89, 83));
        
        JLabel Txt1 = new JLabel("Vaya, la puerte de Mikel esta cerrada...");
		Txt1.setHorizontalAlignment(SwingConstants.CENTER);
		Txt1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Txt1.setForeground(Color.WHITE);
		Txt1.setBounds(50, 495, 875, 50);
		add(Txt1);
		Txt1.setVisible(false);

        
        JButton btnVolverRecibidor = new JButton("");
		
        JButton btnPuerta = new JButton("");
        
		JButton btnContinue = new JButton(Config.getTexto("btnContinuar"));
		btnContinue.setBounds(819, 468, 115, 23);
		btnContinue.setBackground(new Color(0, 0, 0, 0));
		btnContinue.setOpaque(false);
		btnContinue.setBorderPainted(false);
		btnContinue.setContentAreaFilled(false);
		btnContinue.setForeground(Color.GRAY);
		btnContinue.setVisible(false);

		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backgroundFile = "/img/puertaMikel.jpg";
				upgradeImage();
				Txt1.setVisible(false);
				btnContinue.setVisible(false);
				btnPuerta.setVisible(true);
				btnVolverRecibidor.setVisible(true);
				lblVolver.setVisible(true);
			}
		});
		
		btnContinue.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		
        btnVolverRecibidor.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblVolver.setIcon(img.scaleImage("/img/flechaIzqON.png", 89, 83));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblVolver.setIcon(img.scaleImage("/img/flechaIzqOFF.png", 89, 83));
        	}
        });
        btnVolverRecibidor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("pasillo2");
        	}
        });
        btnVolverRecibidor.setBackground(new Color(0, 0, 0, 0));
        btnVolverRecibidor.setOpaque(false);
        btnVolverRecibidor.setBorderPainted(false);
        btnVolverRecibidor.setContentAreaFilled(false);
        btnVolverRecibidor.setBounds(243, 482, 58, 66);
        add(btnVolverRecibidor);
        btnVolverRecibidor.setVisible(true);  // Hace el botón no visible
        
        lblVolver.setBounds(229, 475, 89, 83);
        add(lblVolver);
        add(btnPuerta);
        
        btnPuerta.setOpaque(false);
        btnPuerta.setBackground(new Color(0, 0, 0, 0));
        btnPuerta.setBorderPainted(false); // No dibujar el borde
        btnPuerta.setFocusPainted(false);
        btnPuerta.setContentAreaFilled(false);
        btnPuerta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPuerta.setBounds(402, 125, 184, 450);
		btnPuerta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						if (juego.getInventario().contieneObjeto(inventario.getLlaveHijo())) {
								juego.cambiarEscena("cuartoHijo");
						} else {
							backgroundFile = "/img/puertaMikelTxt.png";
							upgradeImage();
							Txt1.setVisible(true);
							btnContinue.setVisible(true);
							btnVolverRecibidor.setVisible(false);
							lblVolver.setVisible(false);
						}
					}
				});
			}
		});

		btnVolverRecibidor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPuerta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// Mostrar la imagen de fondo
		puertaLabel = new JLabel();
		puertaLabel.setBounds(0, 0, 950, 600);
		puertaLabel.setIcon(img.scaleImage(backgroundFile, 950, 600)); // Establecer la imagen por defecto
		add(puertaLabel); // Agregar al final para que quede encima del botón
		
		// Cronometro
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
        
     // Actualizar la etiqueta cada segundo (formato HH:MM:SS)
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText(Cronometro.getInstancia().getTiempoFormato()));
        actualizarTimer.start();
	}
	
	private void upgradeImage() {
		puertaLabel.setIcon(img.scaleImage(backgroundFile, 950, 600));
		puertaLabel.repaint(); // Redibujar para aplicar el cambio
	}

}
