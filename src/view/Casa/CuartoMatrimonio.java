package view.Casa;

import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import Objetos.Objeto;
import utilidades.Cronometro;
import utilidades.Inventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CuartoMatrimonio extends JPanel {
    String CuartoPadresFile;
    JLabel HomeLabel; 
    JLabel lightLabel;
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro

    
    int txtPre;

    public CuartoMatrimonio(Juego juego) {
        setBounds(0, 0, 950, 600); 
        setLayout(null);
        
        CuartoPadresFile = "img/habitacionMatrimonial.jpeg";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(CuartoPadresFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
		 // Flecha pasillo
		
 		JLabel lblFlechaPasillo = new JLabel("");
 		lblFlechaPasillo.setBounds(527, 390, 309, 190);
 		
 		
 		 ImageIcon flechaPasilloOFF = new ImageIcon("img/FlechaVolverPasilloPadresOFF.png");
         ImageIcon flechaPasilloON = new ImageIcon("img/FlechaVolverPasilloPadresON.png");

         Image imgPasilloOFF = flechaPasilloOFF.getImage().getScaledInstance(309, 190, Image.SCALE_SMOOTH);
         Image imgPasilloON = flechaPasilloON.getImage().getScaledInstance(309, 190, Image.SCALE_SMOOTH);

         ImageIcon iconPasilloOFF = new ImageIcon(imgPasilloOFF);
         ImageIcon iconPasilloON = new ImageIcon(imgPasilloON);

         lblFlechaPasillo.setIcon(iconPasilloOFF);
    // Boton pasillo
    JButton btnVolverPasillo = new JButton("");
	btnVolverPasillo.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			juego.cambiarEscena("pasillo2");
		}
	});
	btnVolverPasillo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	lblFlechaPasillo.setIcon(iconPasilloON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	lblFlechaPasillo.setIcon(iconPasilloOFF);
            }
        });
	
	btnVolverPasillo.setBounds(612, 436, 155, 106);
	btnVolverPasillo.setBackground(new Color(0, 0, 0, 0));
	btnVolverPasillo.setOpaque(false);
	btnVolverPasillo.setBorderPainted(false);
	btnVolverPasillo.setContentAreaFilled(false);
	
	JButton btnVerCajon = new JButton("");
    add(btnVerCajon);
	
	add(btnVolverPasillo);
	add(lblFlechaPasillo);
	

    JButton btnVerCaja = new JButton("");
    
    JButton btnPistaCaja = new JButton("");
    
    JButton btnPuzzleCaja = new JButton("");
    
    JButton btnContinue = new JButton("CONTINUAR");
    
    JButton btnVolver = new JButton("VOLVER");
    add(btnPuzzleCaja);
    add(btnPistaCaja); 

		JLabel PistaCajaLabel = new JLabel();
		// Cargar la imagen de la bandera inglesa
		ImageIcon PistaCajaImagen = new ImageIcon("img/pistaCajaFuerte.png");
		PistaCajaLabel.setBounds(20, 405, 40, 37); // Ajusta el tamaño del JLabel
		Image imgPistaCaja = PistaCajaImagen.getImage().getScaledInstance(PistaCajaLabel.getWidth(),
				PistaCajaLabel.getHeight(), Image.SCALE_SMOOTH);
		PistaCajaLabel.setIcon(new ImageIcon(imgPistaCaja));
		add(PistaCajaLabel, Integer.valueOf(2));
        
        JLabel RuedaCajaLabel = new JLabel();
		// Cargar la imagen de la bandera inglesa
		ImageIcon ImagenRueda = new ImageIcon("img/cajaFuerteRueda.png");
		RuedaCajaLabel.setBounds(336, 177, 220, 214); // Ajusta el tamaño del JLabel
		Image imgRueda = ImagenRueda.getImage().getScaledInstance(RuedaCajaLabel.getWidth(),
				RuedaCajaLabel.getHeight(), Image.SCALE_SMOOTH);
		RuedaCajaLabel.setIcon(new ImageIcon(imgRueda));
        add(RuedaCajaLabel, Integer.valueOf(2));
        RuedaCajaLabel.setVisible(false);

		ImageIcon PistaCajaGrande = new ImageIcon("img/pistaCajaFuerte.png");
		JLabel lblPistaCajaGrande = new JLabel();
		lblPistaCajaGrande.setBounds(223, 67, 488, 429); // Ajusta el tamaño del JLabel
		// Redimensionar la imagen para que se ajuste al tamaño del JLabel
		Image imgPistaCajaG = PistaCajaGrande.getImage().getScaledInstance(lblPistaCajaGrande.getWidth(),
				lblPistaCajaGrande.getHeight(), Image.SCALE_SMOOTH);
		lblPistaCajaGrande.setIcon(new ImageIcon(imgPistaCajaG));
		add(lblPistaCajaGrande);
		lblPistaCajaGrande.setVisible(false);
		
		ImageIcon CajaZoom = new ImageIcon("img/cajaFuerteCod.png");
		JLabel lblCajaZoom = new JLabel();
		lblCajaZoom.setBounds(223, 77, 488, 429); // Ajusta el tamaño del JLabel
		// Redimensionar la imagen para que se ajuste al tamaño del JLabel
		Image imgCajaZoom = CajaZoom.getImage().getScaledInstance(lblCajaZoom.getWidth(),
				lblCajaZoom.getHeight(), Image.SCALE_SMOOTH);
		lblCajaZoom.setIcon(new ImageIcon(imgCajaZoom));
		
		lblCajaZoom.setVisible(false);
        
        JLabel Txtcajon1 = new JLabel("El cajón esta cerrado con llave");
		Txtcajon1.setHorizontalAlignment(SwingConstants.CENTER);
		Txtcajon1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Txtcajon1.setForeground(Color.WHITE);
		Txtcajon1.setBounds(50, 495, 875, 50);
		add(Txtcajon1);
		Txtcajon1.setVisible(false);
		
        btnVolver.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		juego.cambiarEscena("pasillo2");
        	}
        });
        
        btnVerCajon.setOpaque(false);
        btnVerCajon.setBackground(new Color(0, 0, 0, 0));
        btnVerCajon.setBorderPainted(false); // No dibujar el borde
        btnVerCajon.setFocusPainted(false);
        btnVerCajon.setContentAreaFilled(false);
        btnVerCajon.setBounds(581, 310, 188, 106);
        btnVerCajon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(new Runnable() {
					public void run() {
						if (juego.getInventario().contieneObjeto(juego.getInventario().getLlaveCajonPadres())) {
							try {
								juego.cambiarEscena("cajonPadres");
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else {
							CuartoPadresFile = "img/CuartoPadresTexto.png";
							upgradeImage();
							btnContinue.setVisible(true);
							Txtcajon1.setVisible(true);
							btnVerCaja.setVisible(false);
							btnPistaCaja.setVisible(false);
							btnVerCajon.setVisible(false);
							lblFlechaPasillo.setVisible(false);
						}
					}
                });
            }
        });
        
        JLabel ImagenCajaFuerteLabel = new JLabel();

        add(btnVerCaja);
        
        btnPuzzleCaja.setOpaque(false);
        btnPuzzleCaja.setBackground(new Color(0, 0, 0, 0));
        btnPuzzleCaja.setBorderPainted(false); // No dibujar el borde
        btnPuzzleCaja.setFocusPainted(false);
        btnPuzzleCaja.setContentAreaFilled(false);
        btnPuzzleCaja.setBounds(345, 197, 194, 191);
        btnPuzzleCaja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        juego.cambiarEscena("puzzleCaja");
                        btnPuzzleCaja.setVisible(false);
                        btnVolver.setVisible(false);
                        lblCajaZoom.setVisible(false);
                        RuedaCajaLabel.setVisible(false);
                        btnVerCaja.setVisible(true);
                        btnVerCajon.setVisible(true);
                        btnPistaCaja.setVisible(true);
                    }
                });
            }
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		RuedaCajaLabel.setVisible(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		RuedaCajaLabel.setVisible(false);
        	}
        }); 
        btnPuzzleCaja.setVisible(false);
        
        add(lblCajaZoom);
        
        btnVerCaja.setOpaque(false);
        btnVerCaja.setBackground(new Color(0, 0, 0, 0));
        btnVerCaja.setBorderPainted(false); // No dibujar el borde
        btnVerCaja.setFocusPainted(false);
        btnVerCaja.setContentAreaFilled(false);
        btnVerCaja.setBounds(830, 319, 63, 55);
        btnVerCaja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                    	if(juego.getPuzzleCajaFinished()==true) {
                    		juego.cambiarEscena("cajaAbierta");
                    	}else {
                    		lblCajaZoom.setVisible(true);
                    		btnVolver.setVisible(true);
                    		btnVerCaja.setVisible(false);
                    		btnPistaCaja.setVisible(false);
                    		btnVerCajon.setVisible(false);
                    		btnPuzzleCaja.setVisible(true);
                    		lblFlechaPasillo.setVisible(false);
                    		btnVolverPasillo.setVisible(false);
                    	}
                    }
                });
            }
        });

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver.setVisible(false);
				btnPuzzleCaja.setVisible(false);
				lblPistaCajaGrande.setVisible(false);
				btnPistaCaja.setVisible(true);
				btnVerCajon.setVisible(true);
				btnVerCaja.setVisible(true);
				lblCajaZoom.setVisible(false);
				lblFlechaPasillo.setVisible(true);
				btnVolverPasillo.setVisible(true);
			}
		});
		btnVolver.setBounds(37, 521, 89, 23);
		add(btnVolver);
		btnVolver.setVisible(false);
		btnPistaCaja.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPistaCaja.setOpaque(false);
        btnPistaCaja.setBackground(new Color(0, 0, 0, 0));
        btnPistaCaja.setBorderPainted(false); // No dibujar el borde
        btnPistaCaja.setFocusPainted(false);
        btnPistaCaja.setContentAreaFilled(false);
        btnPistaCaja.setBounds(20, 405, 40, 37);
        btnPistaCaja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                    	lblPistaCajaGrande.setVisible(true);
                    	btnVolver.setVisible(true);
                    	btnVerCaja.setVisible(false);
                    	btnPistaCaja.setVisible(false);
                    	btnVerCajon.setVisible(false);
                    	lblFlechaPasillo.setVisible(false);
                    	btnVolverPasillo.setVisible(false);
                    }
                });
            }
        });  
        
        btnPuzzleCaja.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVerCaja.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVerCajon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVolverPasillo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
		btnContinue.setBounds(819, 468, 115, 23);
		btnContinue.setBackground(new Color(0, 0, 0, 0));
		btnContinue.setOpaque(false);
		btnContinue.setBorderPainted(false);
		btnContinue.setContentAreaFilled(false);
		btnContinue.setForeground(Color.GRAY);
		btnContinue.setVisible(false);

		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuartoPadresFile = "img/habitacionMatrimonial.jpeg";
				upgradeImage();
				btnVerCajon.setVisible(true);
				btnContinue.setVisible(false);
				Txtcajon1.setVisible(false);
				btnVerCaja.setVisible(true);
            	btnPistaCaja.setVisible(true);
            	lblFlechaPasillo.setVisible(true);
            	btnVolverPasillo.setVisible(true);
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
        
        ImageIcon ImagenCajaFuerte = new ImageIcon("img/cajaFuerte.png");
        
        ImagenCajaFuerteLabel.setBounds(773, 284, 161, 118); 
        
        Image imgCajaFuerte = ImagenCajaFuerte.getImage().getScaledInstance(ImagenCajaFuerteLabel.getWidth(), ImagenCajaFuerteLabel.getHeight(), Image.SCALE_SMOOTH);
        ImagenCajaFuerteLabel.setIcon(new ImageIcon(imgCajaFuerte)); 
        
        add(ImagenCajaFuerteLabel, Integer.valueOf(1)); 
        
        HomeLabel = new JLabel();
        HomeLabel.setBounds(0, 0, 950, 600);
        HomeLabel.setIcon(scaledIcon);
        upgradeImage();
        
        add(HomeLabel, Integer.valueOf(0)); 
        
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
		setComponentZOrder(labelTiempo, 0);
		
		
        // Actualizar la etiqueta cada segundo (formato HH:MM:SS)
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText(Cronometro.getInstancia().getTiempoFormato()));
        actualizarTimer.start();

    }
    
    private void upgradeImage() {
		// Cargar la nueva imagen
		ImageIcon originalIcon = new ImageIcon(CuartoPadresFile);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(HomeLabel.getWidth(), HomeLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Actualizar el fondo con la nueva imagen
		HomeLabel.setIcon(scaledIcon);
		HomeLabel.repaint(); // Redibujar para aplicar el cambio
	}


	private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
   
        
	}
}
