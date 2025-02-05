package view.Casa;

import javax.swing.border.EmptyBorder;

import Objetos.Objeto;
import utilidades.Inventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CuartoMatrimonio extends JFrame {

    private JPanel contentPane;
    String CuartoPadresFile;
    JLabel HomeLabel; 
    JLabel lightLabel;
    
    int txtPre;

    public CuartoMatrimonio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
        setResizable(false);
        
        Inventario inventario = new Inventario();
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(934, 561));
        setContentPane(layeredPane);
        
        CuartoPadresFile = "img/habitacionMatrimonial.jpeg";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(CuartoPadresFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        // Inicializar contentPane
        contentPane = new JPanel();
        contentPane.setLayout(null);
        
        JLabel LightLabel = new JLabel();
        // Cargar la imagen de la bandera inglesa
		ImageIcon LightImagen = new ImageIcon("img/11571045.png");
		LightLabel.setBounds(626, 312, 83, 23); // Ajusta el tamaño del JLabel
		Image imgLight = LightImagen.getImage().getScaledInstance(LightLabel.getWidth(), LightLabel.getHeight(),
				Image.SCALE_SMOOTH);
		LightLabel.setIcon(new ImageIcon(imgLight));
		layeredPane.add(LightLabel, Integer.valueOf(2));
		LightLabel.setVisible(false);

		JLabel PistaCajaLabel = new JLabel();
		// Cargar la imagen de la bandera inglesa
		ImageIcon PistaCajaImagen = new ImageIcon("img/pistaCajaFuerte.png");
		PistaCajaLabel.setBounds(20, 380, 40, 37); // Ajusta el tamaño del JLabel
		Image imgPistaCaja = PistaCajaImagen.getImage().getScaledInstance(PistaCajaLabel.getWidth(),
				PistaCajaLabel.getHeight(), Image.SCALE_SMOOTH);
		PistaCajaLabel.setIcon(new ImageIcon(imgPistaCaja));
		layeredPane.add(PistaCajaLabel, Integer.valueOf(2));

		JLabel LightLabelCaja = new JLabel();
		// Cargar la imagen de la bandera inglesa
		ImageIcon LightImagenCaja = new ImageIcon("img/11571045.png");
		LightLabelCaja.setBounds(815, 318, 83, 23); // Ajusta el tamaño del JLabel
		Image imgLightCaja = LightImagenCaja.getImage().getScaledInstance(LightLabelCaja.getWidth(),
				LightLabelCaja.getHeight(), Image.SCALE_SMOOTH);
		LightLabelCaja.setIcon(new ImageIcon(imgLightCaja));
        layeredPane.add(LightLabelCaja, Integer.valueOf(2));
        LightLabelCaja.setVisible(false);
        
        JLabel RuedaCajaLabel = new JLabel();
		// Cargar la imagen de la bandera inglesa
		ImageIcon ImagenRueda = new ImageIcon("img/cajaFuerteRueda.png");
		RuedaCajaLabel.setBounds(332, 167, 220, 214); // Ajusta el tamaño del JLabel
		Image imgRueda = ImagenRueda.getImage().getScaledInstance(RuedaCajaLabel.getWidth(),
				RuedaCajaLabel.getHeight(), Image.SCALE_SMOOTH);
		RuedaCajaLabel.setIcon(new ImageIcon(imgRueda));
        layeredPane.add(RuedaCajaLabel, Integer.valueOf(2));
        RuedaCajaLabel.setVisible(false);

		ImageIcon PistaCajaGrande = new ImageIcon("img/pistaCajaFuerte.png");
		JLabel lblPistaCajaGrande = new JLabel();
		lblPistaCajaGrande.setBounds(223, 67, 478, 429); // Ajusta el tamaño del JLabel
		// Redimensionar la imagen para que se ajuste al tamaño del JLabel
		Image imgPistaCajaG = PistaCajaGrande.getImage().getScaledInstance(lblPistaCajaGrande.getWidth(),
				lblPistaCajaGrande.getHeight(), Image.SCALE_SMOOTH);
		lblPistaCajaGrande.setIcon(new ImageIcon(imgPistaCajaG));
		getContentPane().add(lblPistaCajaGrande);
		lblPistaCajaGrande.setVisible(false);
		
		ImageIcon CajaZoom = new ImageIcon("img/cajaFuerteCod.png");
		JLabel lblCajaZoom = new JLabel();
		lblCajaZoom.setBounds(223, 67, 478, 429); // Ajusta el tamaño del JLabel
		// Redimensionar la imagen para que se ajuste al tamaño del JLabel
		Image imgCajaZoom = CajaZoom.getImage().getScaledInstance(lblCajaZoom.getWidth(),
				lblCajaZoom.getHeight(), Image.SCALE_SMOOTH);
		lblCajaZoom.setIcon(new ImageIcon(imgCajaZoom));
		
		lblCajaZoom.setVisible(false);
        
        ArrayList<JLabel> TxtCajon = new ArrayList<>();
        
        JLabel Txtcajon1 = new JLabel("El cajón esta cerrado con llave");
		Txtcajon1.setHorizontalAlignment(SwingConstants.CENTER);
		Txtcajon1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Txtcajon1.setForeground(Color.WHITE);
		Txtcajon1.setBounds(50, 495, 875, 50);
		getContentPane().add(Txtcajon1);
		Txtcajon1.setVisible(false);
		
		TxtCajon.add(Txtcajon1);
		
        JButton btnVerCaja = new JButton("");
        
        JButton btnPistaCaja = new JButton("");
        
        JButton btnVerCajon = new JButton("");
        
        JButton btnPuzzleCaja = new JButton("");
        
        JButton btnContinue = new JButton("CONTINUAR");
        
        JButton btnVolver = new JButton("VOLVER");
        
        btnVerCajon.setOpaque(false);
        btnVerCajon.setBackground(new Color(0, 0, 0, 0));
        btnVerCajon.setBorderPainted(false); // No dibujar el borde
        btnVerCajon.setFocusPainted(false);
        btnVerCajon.setContentAreaFilled(false);
        btnVerCajon.setBounds(581, 299, 178, 96);
        btnVerCajon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(new Runnable() {
					public void run() {
						if (inventario.contieneObjeto(inventario.getLlaveCajonPadres())) {
							try {
								CajonCuartoPadres frame = new CajonCuartoPadres();
								frame.setVisible(true);
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
						}
					}
                });
            }
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		LightLabel.setVisible(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		LightLabel.setVisible(false);
        	}
        });
        
        JLabel ImagenCajaFuerteLabel = new JLabel();
        
        btnPuzzleCaja.setOpaque(false);
        btnPuzzleCaja.setBackground(new Color(0, 0, 0, 0));
        btnPuzzleCaja.setBorderPainted(false); // No dibujar el borde
        btnPuzzleCaja.setFocusPainted(false);
        btnPuzzleCaja.setContentAreaFilled(false);
        btnPuzzleCaja.setBounds(345, 187, 194, 191);
        btnPuzzleCaja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        PuzzleCajaFuerte puzzle = new PuzzleCajaFuerte();
                    	puzzle.setVisible(true);
                    	dispose();
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
        layeredPane.add(btnPuzzleCaja);
        getContentPane().add(lblCajaZoom);
        
        btnVerCaja.setOpaque(false);
        btnVerCaja.setBackground(new Color(0, 0, 0, 0));
        btnVerCaja.setBorderPainted(false); // No dibujar el borde
        btnVerCaja.setFocusPainted(false);
        btnVerCaja.setContentAreaFilled(false);
        btnVerCaja.setBounds(830, 303, 63, 55);
        btnVerCaja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                    		lblCajaZoom.setVisible(true);
                    		btnVolver.setVisible(true);
                    		btnVerCaja.setVisible(false);
                    		btnPistaCaja.setVisible(false);
                    		btnVerCajon.setVisible(false);
                    		btnPuzzleCaja.setVisible(true);
                    }
                });
            }
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		LightLabelCaja.setVisible(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		LightLabelCaja.setVisible(false);
        	}
        });
        layeredPane.add(btnVerCaja);
        
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver.setVisible(false);
				btnPuzzleCaja.setVisible(false);
				lblPistaCajaGrande.setVisible(false);
				btnPistaCaja.setVisible(true);
				btnVerCajon.setVisible(true);
				btnVerCaja.setVisible(true);
				lblCajaZoom.setVisible(false);
			}
		});
		btnVolver.setBounds(37, 511, 89, 23);
		layeredPane.add(btnVolver);
		btnVolver.setVisible(false);
       
        btnPistaCaja.setOpaque(false);
        btnPistaCaja.setBackground(new Color(0, 0, 0, 0));
        btnPistaCaja.setBorderPainted(false); // No dibujar el borde
        btnPistaCaja.setFocusPainted(false);
        btnPistaCaja.setContentAreaFilled(false);
        btnPistaCaja.setBounds(20, 380, 40, 37);
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
                    }
                });
            }
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		 ImageIcon hoveredImage = new ImageIcon("img/pistaCajaFuerteON.png");
        	        Image imgHovered = hoveredImage.getImage().getScaledInstance(PistaCajaLabel.getWidth(), PistaCajaLabel.getHeight(), Image.SCALE_SMOOTH);
        	        PistaCajaLabel.setIcon(new ImageIcon(imgHovered));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		 ImageIcon hoveredImage = new ImageIcon("img/pistaCajaFuerte.png");
        	        Image imgHovered = hoveredImage.getImage().getScaledInstance(PistaCajaLabel.getWidth(), PistaCajaLabel.getHeight(), Image.SCALE_SMOOTH);
        	        PistaCajaLabel.setIcon(new ImageIcon(imgHovered));
        	}
        });
        layeredPane.add(btnPistaCaja);   
        
        
		btnContinue.setBounds(819, 468, 115, 23);
		btnContinue.setBackground(new Color(0, 0, 0, 0));
		btnContinue.setOpaque(false);
		btnContinue.setBorderPainted(false);
		btnContinue.setContentAreaFilled(false);
		btnContinue.setForeground(Color.GRAY);
		btnContinue.setVisible(false);
		
		txtPre = 0;

		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuartoPadresFile = "img/habitacionMatrimonial.jpeg";
				upgradeImage();
				btnVerCajon.setVisible(true);
				btnContinue.setVisible(false);
				Txtcajon1.setVisible(false);
				btnVerCaja.setVisible(true);
            	btnPistaCaja.setVisible(true);
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

		layeredPane.add(btnContinue);
        
        ImageIcon ImagenCajaFuerte = new ImageIcon("img/cajaFuerte.png");

        layeredPane.add(btnVerCajon);
        
        ImagenCajaFuerteLabel.setBounds(773, 264, 161, 118); 
        
        Image imgCajaFuerte = ImagenCajaFuerte.getImage().getScaledInstance(ImagenCajaFuerteLabel.getWidth(), ImagenCajaFuerteLabel.getHeight(), Image.SCALE_SMOOTH);
        ImagenCajaFuerteLabel.setIcon(new ImageIcon(imgCajaFuerte)); 
        
        layeredPane.add(ImagenCajaFuerteLabel, Integer.valueOf(1)); 
        
        HomeLabel = new JLabel();
        HomeLabel.setBounds(0, 0, 934, 561);
        HomeLabel.setIcon(scaledIcon);
        
        layeredPane.add(HomeLabel, Integer.valueOf(0)); 
        
        // Ajustar el tamaño de la ventana al contenido
        pack();
    }
    
    private void upgradeImage() {
		// Cargar la nueva imagen
		ImageIcon originalIcon = new ImageIcon(CuartoPadresFile);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Actualizar el fondo con la nueva imagen
		HomeLabel.setIcon(scaledIcon);
		HomeLabel.repaint(); // Redibujar para aplicar el cambio
	}


	private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(contentPane.getWidth(), contentPane.getHeight(), Image.SCALE_SMOOTH));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CuartoMatrimonio frame = new CuartoMatrimonio();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}