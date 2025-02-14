package view.Casa;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Inicio.Juego;
import Objetos.Objeto;
import utilidades.Cronometro;
import utilidades.ImagenLoader;
import utilidades.Inventario;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CajonCuartoPadres extends JPanel {

	String backgroundFile;
    JLabel lblCajon;
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro
    
    ImagenLoader img = new ImagenLoader();

    public CajonCuartoPadres(Juego juego) {
        setBounds(0, 0, 950, 600);
        
        Inventario inventario = new Inventario();
        
        juego.getInventario().setPapelesDivorcio(new Objeto(false, true, 215, "Papeles Del Divorcio", "Parece que se trata de los documentos de separacón de los padres de Mikel, Hay un número de teléfono subrayado (+34 614 26 85 84)", "/img/papelesDivorcio.png"));
    	
        backgroundFile = "/img/cajon.png";

        setLayout(null);
        
        JButton btnPapelesDiv = new JButton("");
        add(btnPapelesDiv);
        
        JLabel LightLabel = new JLabel();
        LightLabel.setBounds(448, 319, 70, 29); // Ajusta el tamaño del JLabel 
        LightLabel.setIcon(img.scaleImage("/img/11571045.png", 70, 29));
        
        add(LightLabel);
        LightLabel.setVisible(false);
        
        JLabel Txtcajon1 = new JLabel("Qué será esto...");
		Txtcajon1.setHorizontalAlignment(SwingConstants.CENTER);
		Txtcajon1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Txtcajon1.setForeground(Color.WHITE);
		Txtcajon1.setBounds(50, 495, 875, 50);
		add(Txtcajon1);
		Txtcajon1.setVisible(false);


        JButton btnVolver = new JButton("VOLVER");

        JButton btnContinue = new JButton("CONTINUAR");
		
        btnPapelesDiv.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPapelesDiv.setBackground(new Color(0, 0, 0, 0));
        btnPapelesDiv.setOpaque(false);
        btnPapelesDiv.setBorderPainted(false);
        btnPapelesDiv.setContentAreaFilled(false);
        btnPapelesDiv.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		backgroundFile = "/img/cajonTxt.png";
				upgradeImage();
        		btnPapelesDiv.setVisible(false);
        		Txtcajon1.setVisible(true);
        		juego.getInventario().agregarObjeto(juego.getInventario().getPapelesDivorcio());
        		btnVolver.setVisible(false);
        		btnContinue.setVisible(true);
        	}
        });
        btnPapelesDiv.setBounds(327, 295, 195, 140);

        btnPapelesDiv.addMouseListener(new MouseAdapter() {
          	@Override
        	public void mouseEntered(MouseEvent e) {
        		LightLabel.setVisible(true);
        	}
          	@Override
        	public void mouseExited(MouseEvent e) {
        		LightLabel.setVisible(false);
        	}
        });
        
        btnVolver.setBounds(37, 521, 89, 23);
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnVolver);
        btnVolver.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		juego.cambiarEscena("cuartoPadres");
        	}
        });

        btnContinue.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnContinue.setBounds(819, 468, 115, 23);
		btnContinue.setBackground(new Color(0, 0, 0, 0));
		btnContinue.setOpaque(false);
		btnContinue.setBorderPainted(false);
		btnContinue.setContentAreaFilled(false);
		btnContinue.setForeground(Color.GRAY);
		btnContinue.setVisible(false);

		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backgroundFile = "/img/cajon.png";
				upgradeImage();
				Txtcajon1.setVisible(false);
				btnVolver.setVisible(true);
				btnContinue.setVisible(false);
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
        
        // Mostrar la imagen redimensionada
        lblCajon = new JLabel();
        lblCajon.setBounds(0, 0, 950, 600);
        lblCajon.setIcon(img.scaleImage(backgroundFile, 950, 600));  // Establecer la imagen por defecto
        add(lblCajon);
        
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
		lblCajon.setIcon(img.scaleImage(backgroundFile, 950, 600));
		lblCajon.repaint();
	}

}
