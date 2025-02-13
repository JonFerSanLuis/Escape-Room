package Inicio;

import javax.swing.*;

import utilidades.ImagenLoader;
import utilidades.Inventario;
import view.Casa.BanoCasa;
import view.Casa.CajaAbierta;
import view.Casa.CajonCuartoPadres;
import view.Casa.CasaExterior;
import view.Casa.CocinaCasa;
import view.Casa.CuadroMadre;
import view.Casa.CuadroPerro;
import view.Casa.CuartoHijo;
import view.Casa.CuartoMatrimonio;
import view.Casa.NeveraCalendario;
import view.Casa.Pasillo2Piso;
import view.Casa.PuertaMikel;
import view.Casa.PuzzleCajaFuerte;
import view.Casa.PuzzleCajonSala;
import view.Casa.Recibidor;
import view.Casa.SalonCasa;
import view.Casa.puzzlePapelera;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Juego extends JFrame{
    private JFrame frame;
    private JPanel panelPrincipal;
    private JPanel panelMochila;
    private CardLayout cardLayout;
    private Boolean puzzleCajaFinished;
    private JButton btnPista;
    private JButton btnMochila;
    private JLabel lblPista;
    private JLabel lblMochila;
    
    ImagenLoader Img = new ImagenLoader();
    
    ArrayList <JLabel> iconos = new ArrayList<JLabel>();
    
    public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	public JLabel getLblPista() {
		return lblPista;
	}

	public void setLblPista(JLabel lblPista) {
		this.lblPista = lblPista;
	}

	public JLabel getLblMochila() {
		return lblMochila;
	}

	public void setLblMochila(JLabel lblMochila) {
		this.lblMochila = lblMochila;
	}

	public JButton getBtnPista() {
		return btnPista;
	}

	public void setBtnPista(JButton btnPista) {
		this.btnPista = btnPista;
	}

	public JButton getBtnMochila() {
		return btnMochila;
	}

	public void setBtnMochila(JButton btnMochila) {
		this.btnMochila = btnMochila;
	}

	public JPanel getPanelMochila() {
		return panelMochila;
	}

	public void setPanelMochila(JPanel panelMochila) {
		this.panelMochila = panelMochila;
	}

	public Boolean getPuzzleCajaFinished() {
		return puzzleCajaFinished;
	}

	public void setPuzzleCajaFinished(Boolean puzzleCajaFinished) {
		this.puzzleCajaFinished = puzzleCajaFinished;
	}

	Inventario inventario = new Inventario();

    public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public Juego() {
        setTitle("Escape Room");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 80, 950, 600);
        setResizable(false);
        getContentPane().setLayout(null);
        setBackground(Color.black);
        setUndecorated(true);
        puzzleCajaFinished = false;

        cardLayout = new CardLayout();
        
        panelPrincipal = new JPanel(cardLayout);
        panelPrincipal.setBounds(0, 0, getWidth(), getHeight());
        panelPrincipal.setBackground(new Color(0, 0, 0));
        
        lblMochila = new JLabel();
        lblMochila.setIcon(Img.scaleImage("/img/IconoMochilaEX.png", 60, 60));
        btnPista = new JButton("");
        btnMochila = new JButton("");
        lblPista = new JLabel();
        lblPista.setIcon(Img.scaleImage("/img/IconoPistaEX.png", 60, 60));

        panelPrincipal.add(new Intro(this), "intro");
        panelPrincipal.add(new CasaExterior(this), "casaExterior");
        panelPrincipal.add(new Recibidor(this), "recibidor");
        panelPrincipal.add(new Pasillo2Piso(this), "pasillo2");
        panelPrincipal.add(new CuartoMatrimonio(this), "cuartoPadres");
        panelPrincipal.add(new PuzzleCajaFuerte(this), "puzzleCaja");
        panelPrincipal.add(new CajaAbierta(this), "cajaAbierta");
        panelPrincipal.add(new CajonCuartoPadres(this), "cajonPadres");
        panelPrincipal.add(new SalonCasa(this), "salon");
        panelPrincipal.add(new CuadroPerro(this), "cuadroP");
        panelPrincipal.add(new CuadroMadre(this), "cuadroM");
        panelPrincipal.add(new NeveraCalendario(this), "nevera");
        panelPrincipal.add(new CocinaCasa(this), "cocina");
        panelPrincipal.add(new puzzlePapelera(this), "papelera");
        panelPrincipal.add(new BanoCasa(this), "bano");
        panelPrincipal.add(new PuzzleCajonSala(this), "cajonSalon");
        panelPrincipal.add(new PuertaMikel(this), "puertaMikel");
        panelPrincipal.add(new CuartoHijo(this), "cuartoHijo");
        
        setVisible(true);
        
     // Cargar la imagen de fondo
        String backgroundFile = "/img/fondoInv.png";
        
        panelMochila = new JPanel();
        panelMochila.setLayout(null);
        
        JLabel lblPanel1 = new JLabel();
        lblPanel1.setBounds(123, 122, 83, 81);
        
        JLabel lblPanel2 = new JLabel();
        lblPanel2.setBounds(253, 122, 83, 81);
        
        JLabel lblPanel3 = new JLabel();
        lblPanel3.setBounds(384, 122, 83, 81);
        
        JLabel lblPanel4 = new JLabel();
        lblPanel4.setBounds(514, 122, 83, 81);
        
        JLabel lblPanel5 = new JLabel();
        lblPanel5.setBounds(644, 122, 83, 81);
        
        JLabel lblPanel6 = new JLabel();
        lblPanel6.setBounds(123, 231, 83, 81);
        
        JLabel lblPanel7 = new JLabel();
        lblPanel7.setBounds(253, 231, 83, 81);
        
        JLabel lblPanel8 = new JLabel();
        lblPanel8.setBounds(384, 231, 83, 81);
        
        JLabel lblPanel9 = new JLabel();
        lblPanel9.setBounds(514, 231, 83, 81);
        
        JLabel lblPanel10 = new JLabel();
        lblPanel10.setBounds(644, 231, 83, 81);
        
        JLabel lblPanel11 = new JLabel();
        lblPanel11.setBounds(123, 339, 83, 81);
        
        JLabel lblPanel12 = new JLabel();
        lblPanel12.setBounds(253, 339, 83, 81);
        
        JLabel lblPanel13 = new JLabel();
        lblPanel13.setBounds(384, 339, 83, 81);
        
        JLabel lblPanel14 = new JLabel();
        lblPanel14.setBounds(514, 339, 83, 81);
        
        JLabel lblPanel15 = new JLabel();
        lblPanel15.setBounds(644, 339, 83, 81);
        
        cargarIcono(lblPanel15, inventario.getObjetoFile(14));
        cargarIcono(lblPanel14, inventario.getObjetoFile(13));
        cargarIcono(lblPanel13, inventario.getObjetoFile(12));
        cargarIcono(lblPanel12, inventario.getObjetoFile(11));
        cargarIcono(lblPanel11, inventario.getObjetoFile(10));
        cargarIcono(lblPanel10, inventario.getObjetoFile(9));
        cargarIcono(lblPanel9, inventario.getObjetoFile(8));
        cargarIcono(lblPanel8, inventario.getObjetoFile(7));
        cargarIcono(lblPanel7, inventario.getObjetoFile(6));
        cargarIcono(lblPanel6, inventario.getObjetoFile(5));
        cargarIcono(lblPanel5, inventario.getObjetoFile(4));
        cargarIcono(lblPanel4, inventario.getObjetoFile(3));
        cargarIcono(lblPanel3, inventario.getObjetoFile(2));
        cargarIcono(lblPanel2, inventario.getObjetoFile(1));
        cargarIcono(lblPanel1, inventario.getObjetoFile(0));

        
        iconos.add(lblPanel1);
        iconos.add(lblPanel2);
        iconos.add(lblPanel3);
        iconos.add(lblPanel4);
        iconos.add(lblPanel5);
        iconos.add(lblPanel6);
        iconos.add(lblPanel7);
        iconos.add(lblPanel8);
        iconos.add(lblPanel9);
        iconos.add(lblPanel10);
        iconos.add(lblPanel11);
        iconos.add(lblPanel12);
        iconos.add(lblPanel13);
        iconos.add(lblPanel14);
        iconos.add(lblPanel15);   
        
        JButton ranura1 = new JButton("");
        ranura1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura1.setBounds(123, 122, 83, 81);
        panelMochila.add(ranura1);
        
        JButton ranura2 = new JButton("");
        ranura2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura2.setBounds(253, 122, 83, 81);
        panelMochila.add(ranura2);
        
        JButton ranura3 = new JButton("");
        ranura3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura3.setBounds(384, 122, 83, 81);
        panelMochila.add(ranura3);
        
        JButton ranura4 = new JButton("");
        ranura4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura4.setBounds(514, 122, 83, 81);
        panelMochila.add(ranura4);
        
        JButton ranura5 = new JButton("");
        ranura5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura5.setBounds(644, 122, 83, 81);
        panelMochila.add(ranura5);
        
        JButton ranura6 = new JButton("");
        ranura6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura6.setBounds(123, 231, 83, 81);
        panelMochila.add(ranura6);
        
        JButton ranura7 = new JButton("");
        ranura7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura7.setBounds(253, 231, 83, 81);
        panelMochila.add(ranura7);
        
        JButton ranura8 = new JButton("");
        ranura8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura8.setBounds(384, 231, 83, 81);
        panelMochila.add(ranura8);
        
        JButton ranura9 = new JButton("");
        ranura9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura9.setBounds(514, 231, 83, 81);
        panelMochila.add(ranura9);
        
        JButton ranura10 = new JButton("");
        ranura10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura10.setBounds(644, 231, 83, 81);
        panelMochila.add(ranura10);
        
        JButton ranura11 = new JButton("");
        ranura11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura11.setBounds(123, 339, 83, 81);
        panelMochila.add(ranura11);
        
        JButton ranura12 = new JButton("");
        ranura12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura12.setBounds(253, 339, 83, 81);
        panelMochila.add(ranura12);
        
        JButton ranura13 = new JButton("");
        ranura13.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura13.setBounds(384, 339, 83, 81);
        panelMochila.add(ranura13);
        
        JButton ranura14 = new JButton("");
        ranura14.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura14.setBounds(514, 339, 83, 81);
        panelMochila.add(ranura14);
        
        JButton ranura15 = new JButton("");
        ranura15.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        ranura15.setBounds(644, 339, 83, 81);
        panelMochila.add(ranura15);
        
        panelMochila.add(lblPanel1);
        panelMochila.add(lblPanel2);
        panelMochila.add(lblPanel3);
        panelMochila.add(lblPanel4);
        panelMochila.add(lblPanel5);
        panelMochila.add(lblPanel6);
        panelMochila.add(lblPanel7);
        panelMochila.add(lblPanel8);
        panelMochila.add(lblPanel9);
        panelMochila.add(lblPanel10);
        panelMochila.add(lblPanel11);
        panelMochila.add(lblPanel12);
        panelMochila.add(lblPanel13);
        panelMochila.add(lblPanel14);
        panelMochila.add(lblPanel15);
        
        configurarRanuras(ranura1);
        configurarRanuras(ranura2);
        configurarRanuras(ranura3);
        configurarRanuras(ranura4);
        configurarRanuras(ranura5);
        configurarRanuras(ranura6);
        configurarRanuras(ranura7);
        configurarRanuras(ranura8);
        configurarRanuras(ranura9);
        configurarRanuras(ranura10);
        configurarRanuras(ranura11);
        configurarRanuras(ranura12);
        configurarRanuras(ranura13);
        configurarRanuras(ranura14);
        configurarRanuras(ranura15);
        
        btnMochila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isVisible = panelMochila.isVisible();
				updatePaneles();
				panelMochila.setVisible(!isVisible);
				panelPrincipal.setVisible(isVisible);
				}
		});
        
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

		btnMochila.setBounds(800, 11, 60, 60);
		btnMochila.setOpaque(false);
		btnMochila.setBackground(new Color(0, 0, 0, 0));
		btnMochila.setBorderPainted(false); 
		btnMochila.setFocusPainted(false);
		btnMochila.setContentAreaFilled(false);

		lblMochila.setBounds(800, 11, 60, 60); 
		getContentPane().add(lblMochila);
		getContentPane().add(btnMochila);
		btnMochila.setVisible(false);
		lblMochila.setVisible(false);

		btnPista.setBounds(870, 11, 60, 60);
		btnPista.setOpaque(false);
		btnPista.setBackground(new Color(0, 0, 0, 0));
		btnPista.setBorderPainted(false); 
		btnPista.setFocusPainted(false);
		btnPista.setContentAreaFilled(false);

		lblPista.setBounds(870, 11, 60, 60);
		getContentPane().add(btnPista);
		getContentPane().add(lblPista);
		btnPista.setVisible(false);
		lblPista.setVisible(false);
        JLabel PanelesLabel = new JLabel();
        PanelesLabel.setBounds(77, 86, 689, 372); // Ajusta el tamaño del JLabel 
        PanelesLabel.setIcon(Img.scaleImage("/img/inventarioUI-removebg-preview.png", 689, 372));
        
        panelMochila.add(PanelesLabel);
        
        JLabel inventarioLabel = new JLabel();
        inventarioLabel.setBounds(0, 0, 950, 600);
        inventarioLabel.setIcon(Img.scaleImage(backgroundFile, 950, 600));
        
        panelMochila.add(inventarioLabel);
        panelMochila.setBounds(0, 0, getWidth(), getHeight());
        panelMochila.setVisible(false);
        getContentPane().add(panelMochila);
        getContentPane().add(panelPrincipal);

    }
	
	public void updatePaneles() {
			for (int i = 0; inventario.isInventarioVacio()==false && i < inventario.getInventarioSize(); i++) {
				cargarIcono(iconos.get(i), inventario.getObjetoFile(i));
			}
	}
	
	private void cargarIcono(JLabel icono, String file) {
		icono.setIcon(Img.scaleImage(file, icono.getWidth(), icono.getHeight()));
	}

    private void configurarRanuras(JButton boton) {
    	boton.setOpaque(false);
        boton.setBackground(new Color(0, 0, 0, 0));
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void cambiarEscena(String nombreEscena) {
        cardLayout.show(panelPrincipal, nombreEscena);
    }
}
