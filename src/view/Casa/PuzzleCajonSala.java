package view.Casa;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import Objetos.Objeto;
import config.Config;
import utilidades.ImagenLoader;
import utilidades.Inventario;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PuzzleCajonSala extends JPanel {

	private Image backgroundImage;
    String backgroundFile;
    JLabel Background;
    String cod = "";
    
    ImagenLoader img = new ImagenLoader();
    
    Inventario inventario = new Inventario();

	public PuzzleCajonSala(Juego juego) {
		setBounds(0,  0, 950, 600);
		setLayout(null);
		
		backgroundFile = "/img/cajonSalonImg.png";
		
		juego.getInventario().setLlaveHijo(new Objeto(true, true, 100, "Llave del cuarto de Mikel", "Es la llave de la puerta del cuarto de Mikel.", "/img/llavesNiño.png"));
		juego.getInventario().setPistaTelefonoHijo(new Objeto(true, false, 15, "Tablon Encriptado", "¿Qué será este tablón tan raro?", "/img/pistaCodMovil.png"));

		JLabel lblLlavesNiño = new JLabel("");
		JLabel lblPistaMovil = new JLabel("");
		lblLlavesNiño.setBounds(648, 418, 73, 70); // Ajusta el tamaño del JLabel
		
		JButton btnLlave = new JButton("");
		btnLlave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.getInventario().agregarObjeto(juego.getInventario().getLlaveHijo());
				lblLlavesNiño.setVisible(false);
				btnLlave.setVisible(false);
			}
		});
		btnLlave.setBounds(648, 418, 73, 70);
		add(btnLlave);
		
		JButton btnPistaMovil = new JButton("");
		btnPistaMovil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPistaMovil.setVisible(false);
				btnPistaMovil.setVisible(false);
				juego.getInventario().agregarObjeto(juego.getInventario().getPistaTelefonoHijo());
				
			}
		});
		btnPistaMovil.setBounds(699, 201, 225, 119);
		add(btnPistaMovil);
		lblLlavesNiño.setIcon(img.scaleImage("/img/llavesNiño.png",73, 70));
		add(lblLlavesNiño);
		lblLlavesNiño.setVisible(false);

		lblPistaMovil.setBounds(699, 201, 225, 119);
		lblPistaMovil.setIcon(img.scaleImage("/img/pistaCodMovil.png", 225, 119));
		add(lblPistaMovil);
		lblPistaMovil.setVisible(false);

		JTextPane panelCod = new JTextPane();
        panelCod.setForeground(Color.WHITE);
        panelCod.setOpaque(false);
        panelCod.setBackground(new Color(0, 0, 0, 0));
        panelCod.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panelCod.setEditable(false);
        panelCod.setText(cod);
        panelCod.setBounds(289, 214, 131, 43);
        add(panelCod);
        
     		JButton btn1 = new JButton("");
     		btn1.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				cod = cod +"1";
     				panelCod.setText(cod);
     			}
     		});
     		btn1.setBounds(289, 360, 33, 24);
     		add(btn1);
     		
     		JButton btnOK = new JButton("");
     		btnOK.setBounds(387, 397, 33, 24);
     		add(btnOK);
     		
     		JButton btn0 = new JButton("");
     		btn0.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				cod = cod +"0";
     				panelCod.setText(cod);
     			}
     		});
     		btn0.setBounds(338, 397, 33, 24);
     		add(btn0);
     		
     		JButton btn2 = new JButton("");
     		btn2.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				cod = cod +"2";
     				panelCod.setText(cod);
     			}
     		});
     		btn2.setBounds(338, 360, 33, 24);
     		add(btn2);
     		
     		JButton btnCancel = new JButton("");
     		btnCancel.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				cod ="";
     				panelCod.setText(cod);
     			}
     		});
     		btnCancel.setBounds(289, 397, 33, 24);
     		add(btnCancel);
     		
     		JButton btn3 = new JButton("");
     		btn3.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				cod = cod +"3";
     				panelCod.setText(cod);
     			}
     		});
     		btn3.setBounds(387, 360, 33, 24);
     		add(btn3);
     		
     		JButton btn7 = new JButton("");
     		btn7.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				cod = cod +"7";
     				panelCod.setText(cod);
     			}
     		});
     		btn7.setBounds(289, 285, 33, 24);
     		add(btn7);
     		
     		JButton btn8 = new JButton("");
     		btn8.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				cod = cod +"8";
     				panelCod.setText(cod);
     			}
     		});
     		btn8.setBounds(338, 285, 33, 24);
     		add(btn8);
     		
     		JButton btn5 = new JButton("");
     		btn5.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				cod = cod +"5";
     				panelCod.setText(cod);
     			}
     		});
     		btn5.setBounds(338, 322, 33, 24);
     		add(btn5);
     		
     		JButton btn9 = new JButton("");
     		btn9.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				cod = cod +"9";
     				panelCod.setText(cod);
     			}
     		});
     		btn9.setBounds(387, 285, 33, 24);
     		add(btn9);
     		
     		JButton btn4 = new JButton("");
     		btn4.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				cod = cod +"4";
     				panelCod.setText(cod);
     			}
     		});
     		btn4.setBounds(289, 322, 33, 24);
     		add(btn4);
     		
     		JButton btn6 = new JButton("");
     		btn6.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				cod = cod +"6";
     				panelCod.setText(cod);
     			}
     		});
     		btn6.setFont(new Font("Arial", Font.PLAIN, 5));
     		btn6.setBounds(387, 322, 33, 24);
     		add(btn6);
     		
     		btnOK.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				if (panelCod.getText().equals("150317")) {
     					panelCod.setText(Config.getTexto("codigoAcertado"));
     					backgroundFile = "/img/cajonPuzzleEcho.png";
    					upgradeImage();
     				    btn0.setVisible(false);
     				    btn1.setVisible(false);
     				    btn2.setVisible(false);
     				    btn3.setVisible(false);
     				    btn4.setVisible(false);
     				    btn5.setVisible(false);
     				    btn6.setVisible(false);
     				    btn7.setVisible(false);
     				    btn8.setVisible(false);
     				    btn9.setVisible(false);
     				    btnCancel.setVisible(false);
     				    btnOK.setVisible(false);
     				   lblLlavesNiño.setVisible(true);
     				   lblPistaMovil.setVisible(true);
     				} else {
     				    panelCod.setText(Config.getTexto("codigoIncorrecto"));
     				    setEnabled(false);
     				    // Usamos un SwingWorker para evitar bloquear la interfaz gráfica
     				    new SwingWorker<Void, Void>() {
     				        @Override
     				        protected Void doInBackground() throws Exception {
     				            Thread.sleep(1000); // Espera 1 segundo
     				            return null;
     				        }

     				        @Override
     				        protected void done() {
     				        	cod = "";
     				            panelCod.setText(cod);
     				            setEnabled(true);// Borra el texto después de 1 segundo
     				        }
     				    }.execute();
     				}
     			}
     		});
     		
     		JButton btnVolver = new JButton(Config.getTexto("btnVolver"));
            btnVolver.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		juego.cambiarEscena("salon");
            	}
            });
            btnVolver.setBounds(51, 506, 89, 23);
            add(btnVolver);
            
            btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
     		
     		configButton(btnCancel);
     		configButton(btnOK);
     		configButton(btn0);
     		configButton(btn1);
     		configButton(btn2);
     		configButton(btn3);
     		configButton(btn4);
     		configButton(btn5);
     		configButton(btn6);
     		configButton(btn7);
     		configButton(btn8);
     		configButton(btn9);
     		configButton(btnLlave);
     		configButton(btnPistaMovil);
     		   
     // Mostrar la imagen de fondo
     		Background = new JLabel();
     		Background.setBounds(0, 0, 950, 600);
     		Background.setIcon(img.scaleImage(backgroundFile, 950, 600)); // Establecer la imagen por defecto
     		add(Background); // Agregar al final para que quede encima del botón
     		// Cargar la imagen de la bandera inglesa
        
	}
	
	private void configButton(JButton boton){
		boton.setBackground(new Color(0, 0, 0, 0));
		boton.setOpaque(false);
		boton.setBorderPainted(false);
		boton.setContentAreaFilled(false);
		boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	private void upgradeImage() {
		Background.setIcon(img.scaleImage(backgroundFile, 950, 600));
		Background.repaint(); // Redibujar para aplicar el cambio
	}
    
}
