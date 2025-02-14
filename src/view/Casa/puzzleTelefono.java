package view.Casa;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import config.Config;
import utilidades.Cronometro;
import utilidades.ImagenLoader;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class puzzleTelefono extends JPanel {
	
	ImagenLoader img = new ImagenLoader();
	
	JLabel lblMovil = new JLabel("");
	
	private int txt;
	
    private ArrayList<JTextPane> TxtIntro;
	
	String cod = "";
	
	String background;
	
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro

	public puzzleTelefono(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		background = "/img/tlfnBlock.png";
		
		JTextPane panelCod = new JTextPane();
        panelCod.setForeground(Color.WHITE);
        panelCod.setOpaque(false);
        panelCod.setBackground(Color.WHITE);
        panelCod.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panelCod.setEditable(false);
        panelCod.setText(cod);
        panelCod.setBounds(406, 213, 131, 43);
        add(panelCod);

		JButton btnTlfn = new JButton("");
		
		JButton btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"3";
 				panelCod.setText(cod);
			}
		});
		btn3.setBounds(509, 397, 39, 41);
		add(btn3);
		
		JButton btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"2";
 				panelCod.setText(cod);
			}
		});
		btn2.setBounds(455, 397, 39, 41);
		add(btn2);
		
		JButton btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"5";
 				panelCod.setText(cod);
			}
		});
		btn5.setBounds(455, 349, 39, 41);
		add(btn5);
		
		JButton btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"4";
 				panelCod.setText(cod);
			}
		});
		btn4.setBounds(401, 349, 39, 41);
		add(btn4);
		
		JButton btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"1";
 				panelCod.setText(cod);
			}
		});
		btn1.setBounds(401, 397, 39, 41);
		add(btn1);
		
		JButton btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"6";
 				panelCod.setText(cod);
			}
		});
		btn6.setBounds(509, 349, 39, 41);
		add(btn6);
		
		JButton btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"9";
 				panelCod.setText(cod);
			}
		});
		btn9.setBounds(509, 299, 39, 41);
		add(btn9);
		
		JButton btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"8";
 				panelCod.setText(cod);
			}
		});
		btn8.setBounds(455, 299, 39, 41);
		add(btn8);
		
		JButton btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"7";
 				panelCod.setText(cod);
			}
		});
		btn7.setBounds(401, 299, 39, 41);
		add(btn7);
		
		JButton btn0 = new JButton("");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"0";
 				panelCod.setText(cod);
			}
		});
		btn0.setBounds(455, 448, 39, 41);
		add(btn0);
		
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
		
		JButton btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("cuartoHijo");
        	}
        });
        btnVolver.setBounds(51, 506, 89, 23);
        add(btnVolver);
        
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		
		JButton btnOK = new JButton("V");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelCod.getText().equals("222018")) {
 					background = "/img/telefono.png";
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
 				    btnOK.setVisible(false);
 				    panelCod.setVisible(false);
 				    btnTlfn.setVisible(true);
 				    cod = "";
		            panelCod.setText(cod);
 				} else {
 				    panelCod.setText("PIN INCORRECTO");
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
		btnOK.setForeground(new Color(255, 255, 255));
		btnOK.setFont(new Font("Arial Black", Font.PLAIN, 9));
		btnOK.setContentAreaFilled(false);
		btnOK.setBackground(new Color(0, 0, 0));
		btnOK.setBounds(509, 448, 39, 41);
		btnOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnOK);
		
		JButton btn3Tlfn = new JButton("");
		btn3Tlfn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"3";
 				panelCod.setText(cod);
			}
		});
		btn3Tlfn.setBounds(509, 397, 39, 41);
		add(btn3Tlfn);
		
		JButton btn2Tlfn = new JButton("");
		btn2Tlfn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"2";
 				panelCod.setText(cod);
			}
		});
		btn2Tlfn.setBounds(455, 397, 39, 41);
		add(btn2Tlfn);
		
		JButton btn5Tlfn = new JButton("");
		btn5Tlfn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"5";
 				panelCod.setText(cod);
			}
		});
		btn5Tlfn.setBounds(455, 349, 39, 41);
		add(btn5Tlfn);
		
		JButton btn4Tlfn = new JButton("");
		btn4Tlfn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"4";
 				panelCod.setText(cod);
			}
		});
		btn4Tlfn.setBounds(401, 349, 39, 41);
		add(btn4Tlfn);
		
		JButton btn1Tlfn = new JButton("");
		btn1Tlfn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"1";
 				panelCod.setText(cod);
			}
		});
		btn1Tlfn.setBounds(401, 397, 39, 41);
		add(btn1Tlfn);
		
		JButton btn6Tlfn = new JButton("");
		btn6Tlfn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"6";
 				panelCod.setText(cod);
			}
		});
		btn6Tlfn.setBounds(509, 349, 39, 41);
		add(btn6Tlfn);
		
		JButton btn9Tlfn = new JButton("");
		btn9Tlfn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"9";
 				panelCod.setText(cod);
			}
		});
		btn9Tlfn.setBounds(509, 299, 39, 41);
		add(btn9Tlfn);
		
		JButton btn8Tlfn = new JButton("");
		btn8Tlfn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"8";
 				panelCod.setText(cod);
			}
		});
		btn8Tlfn.setBounds(455, 299, 39, 41);
		add(btn8Tlfn);
		
		JButton btn7Tlfn = new JButton("");
		btn7Tlfn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"7";
 				panelCod.setText(cod);
			}
		});
		btn7Tlfn.setBounds(401, 299, 39, 41);
		add(btn7Tlfn);
		
		JButton btn0Tlfn = new JButton("");
		btn0Tlfn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cod = cod +"0";
 				panelCod.setText(cod);
			}
		});
		btn0Tlfn.setBounds(455, 448, 39, 41);
		add(btn0Tlfn);

		TxtIntro = new ArrayList<>();
        txt = 0;

        // Array de textos cogidos de la clase Config
        String[] textos = {
            "¿Hola?",
            "-¿Si? ¿Quién es?-",
            "¿Hablo el padre de Mikel?",
            "-Sí, soy su...-",
            "-Sí... Soy Omar-",
            "¿Pasa algo?",
            "-No soy su tutor legal, pero si su progenitor-",
            "-Entiendo que llamas por su desaparición-",
            "-Pero, ¿por qué llamas desde su movil?-",
            "Bueno, es complicado de explicar",
            "Quiero saber dónde esta. Quiero encontrar a mi mejor amigo.",
            "-Así que tu eres Yuri-",
            "-Me alegro de ponerte voz-",
            "-Dime, ¿en qué puedo ayudarte?-",
            "¿Por casualidad no sabras la contraseña de su ordenador?", 
            "Creo que puedo encontrar información que me ayudaría a encontrarle ahí",
            "-Pues yo probaría con su pelicula favorita Gladiator, la tiene de fondo de pantalla, o algo que tenga que ver con su perro-",
            "-Recuerdo bien su sonrisa cuando se trataba de cualquiera de las dos cosas-",
            "¡Muchas gracias!",
            "-De nada, suerte. Y si lo ves...-",
            "-Dile que lo quiero de mi parte-",
            "Eso esta hecho Omar"
        };

        // Crear JTextPane para cada texto
        for (int i = 0; i < textos.length; i++) {
             JTextPane historia = new JTextPane();
            historia.setForeground(Color.WHITE);
            historia.setOpaque(false);
            historia.setBackground(new Color(0, 0, 0, 0));
            historia.setFont(new Font("Tahoma", Font.PLAIN, 15));
            historia.setEditable(false);
            historia.setText(textos[i]);
            historia.setBounds(48, 515, 855, 58);
            historia.setVisible(false);
            add(historia);
            TxtIntro.add(historia);
        }
		

		JButton btnContinue = new JButton("CONTINUAR");  // Usamos el texto para el botón
        btnContinue.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnContinue.setBounds(819, 468, 115, 23);
        btnContinue.setBackground(new Color(0, 0, 0, 0));
        btnContinue.setOpaque(false);
        btnContinue.setBorderPainted(false);
        btnContinue.setContentAreaFilled(false);
        btnContinue.setForeground(Color.GRAY);

        btnContinue.addActionListener(e -> {
            if (txt == TxtIntro.size() - 1) {
            	juego.setCoverPadreFin(true);
                juego.cambiarEscena("cuartoHijo");
                txt = 0;
            } else {
                TxtIntro.get(txt).setVisible(false);
                TxtIntro.get(++txt).setVisible(true);
            }
            upgradeImage();
        });

        btnContinue.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnContinue.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnContinue.setForeground(Color.GRAY);
            }
        });
        btnContinue.setVisible(false);
        add(btnContinue);
		
		JButton btnOKTlfn = new JButton("");
		
		configButton(btn0Tlfn);
		configButton(btn1Tlfn);
		configButton(btn2Tlfn);
		configButton(btn3Tlfn);
		configButton(btn4Tlfn);
		configButton(btn5Tlfn);
		configButton(btn6Tlfn);
		configButton(btn7Tlfn);
		configButton(btn8Tlfn);
		configButton(btn9Tlfn);

		btn0Tlfn.setVisible(false);
		btn1Tlfn.setVisible(false);
		btn2Tlfn.setVisible(false);
		btn3Tlfn.setVisible(false);
		btn4Tlfn.setVisible(false);
		btn5Tlfn.setVisible(false);
		btn6Tlfn.setVisible(false);
		btn7Tlfn.setVisible(false);
		btn8Tlfn.setVisible(false);
		btn9Tlfn.setVisible(false);
		btnOKTlfn.setVisible(false);
		
 		JLabel Txtcajon1 = new JLabel("Ups... Número equivocado.");
		Txtcajon1.setHorizontalAlignment(SwingConstants.CENTER);
		Txtcajon1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Txtcajon1.setForeground(Color.WHITE);
		Txtcajon1.setBounds(50, 495, 875, 50);
		add(Txtcajon1);
		Txtcajon1.setVisible(false);

		btnOKTlfn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelCod.getText().equals("614268584")) {
					background = "/img/conversaionPadre.png";
					upgradeImage();
					btn0Tlfn.setVisible(false);
					btn1Tlfn.setVisible(false);
					btn2Tlfn.setVisible(false);
					btn3Tlfn.setVisible(false);
					btn4Tlfn.setVisible(false);
					btn5Tlfn.setVisible(false);
					btn6Tlfn.setVisible(false);
					btn7Tlfn.setVisible(false);
					btn8Tlfn.setVisible(false);
					btn9Tlfn.setVisible(false);
					btnOKTlfn.setVisible(false);
					panelCod.setVisible(false);
					btnVolver.setVisible(false);
					btnContinue.setVisible(true);
					
					for (int i = 0; i < textos.length; i++) {
			             JTextPane historia = new JTextPane();
			            historia.setVisible(true);
			        }
					
				} else {
					background = "/img/numError.png";
					upgradeImage();
					Txtcajon1.setVisible(true);
					setEnabled(false);
					btnVolver.setVisible(false);
					// Usamos un SwingWorker para evitar bloquear la interfaz gráfica
					new SwingWorker<Void, Void>() {
						@Override
						protected Void doInBackground() throws Exception {
							Thread.sleep(1000); // Espera 1 segundo
							return null;
						}

						@Override
						protected void done() {
							background = "/img/numero de telefono.png";
							upgradeImage();
							cod = "";
							panelCod.setText(cod);
							btnVolver.setVisible(true);
							Txtcajon1.setVisible(false);
							setEnabled(true);// Borra el texto después de 1 segundo
						}
					}.execute();
				}
			}
		});
		btnOKTlfn.setBackground(new Color(0, 0, 0, 0));
		btnOKTlfn.setOpaque(false);
		btnOKTlfn.setBorderPainted(false);
		btnOKTlfn.setContentAreaFilled(false);
		btnOKTlfn.setBounds(509, 448, 39, 41);
		btnOKTlfn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnOKTlfn);

		btnTlfn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background = "/img/numero de telefono.png";
				upgradeImage();
				btnTlfn.setVisible(false);
				btn0Tlfn.setVisible(true);
				btn1Tlfn.setVisible(true);
				btn2Tlfn.setVisible(true);
				btn3Tlfn.setVisible(true);
				btn4Tlfn.setVisible(true);
				btn5Tlfn.setVisible(true);
				btn6Tlfn.setVisible(true);
				btn7Tlfn.setVisible(true);
				btn8Tlfn.setVisible(true);
				btn9Tlfn.setVisible(true);
				btnOKTlfn.setVisible(true);
				panelCod.setVisible(true);
			}
		});
		btnTlfn.setBackground(new Color(0, 0, 0, 0));
		btnTlfn.setOpaque(false);
		btnTlfn.setBorderPainted(false);
		btnTlfn.setContentAreaFilled(false);
		btnTlfn.setBounds(519, 421, 39, 41);
		btnTlfn.setVisible(false);
		btnTlfn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnTlfn);
		
		lblMovil.setIcon(img.scaleImage(background, 950, 600));
		lblMovil.setBounds(0, 0, 950, 600);
		add(lblMovil);
		
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
	
	private void configButton(JButton boton){
		boton.setBackground(new Color(0, 0, 0, 0));
		boton.setOpaque(false);
		boton.setBorderPainted(false);
		boton.setContentAreaFilled(false);
		boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	private void upgradeImage() {
		// Actualizar el fondo con la nueva imagen
		lblMovil.setIcon(img.scaleImage(background, 950, 600));
		lblMovil.repaint(); // Redibujar para aplicar el cambio
	}

}
