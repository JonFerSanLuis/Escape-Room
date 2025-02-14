package Inicio;

import javax.swing.*;

import utilidades.Cronometro;
import utilidades.ImagenLoader;
import utilidades.Inventario;
import view.Casa.BanoCasa;
import view.Casa.CajaAbierta;
import view.Casa.CajonCuartoPadres;
import view.Casa.CasaExterior;
import view.Casa.CasaExteriorFinal;
import view.Casa.CocinaCasa;
import view.Casa.CuadroMadre;
import view.Casa.CuadroPerro;
import view.Casa.CuartoHijo;
import view.Casa.CuartoMatrimonio;
import view.Casa.DiarioMadre;
import view.Casa.ElegirConversacion;
import view.Casa.FinJuego;
import view.Casa.NeveraCalendario;
import view.Casa.Pasillo2Piso;
import view.Casa.PuertaMikel;
import view.Casa.PuzzleCajaFuerte;
import view.Casa.PuzzleCajonSala;
import view.Casa.Recibidor;
import view.Casa.SalonCasa;
import view.Casa.TelefonoDesbloq;
import view.Casa.TvCuartoHijo;
import view.Casa.puzzlePapelera;
import view.Casa.puzzleTelefono;
import view.Colegio.ColegioXFuera;

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
    private Boolean coverPadreFin;
    private JButton btnMochila;
    private JLabel lblMochila;
    
    JButton ranura1 = new JButton("");
    
    JButton ranura2 = new JButton("");
    
    JButton ranura3 = new JButton("");
    JButton ranura4 = new JButton("");
    
    JButton ranura5 = new JButton("");
    
    JButton ranura6 = new JButton("");
    JButton ranura7 = new JButton("");
    
    JButton ranura8 = new JButton("");
    
    JButton ranura9 = new JButton("");
    
    JButton ranura10 = new JButton("");
    
    JButton ranura11 = new JButton("");
    JButton ranura12 = new JButton("");
    
    JButton ranura13 = new JButton("");
    
    JButton ranura14 = new JButton("");
    
    JButton ranura15 = new JButton("");
    
    JLabel lblPanel1 = new JLabel();
    
    JLabel lblPanel2 = new JLabel();
    
    JLabel lblPanel3 = new JLabel();
    
    JLabel lblPanel4 = new JLabel();
    
    JLabel lblPanel5 = new JLabel();
    
    JLabel lblPanel6 = new JLabel();
    
    JLabel lblPanel7 = new JLabel();
    
    JLabel lblPanel8 = new JLabel();
    
    JLabel lblPanel9 = new JLabel();
    
    JLabel lblPanel10 = new JLabel();
    
    JLabel lblPanel11 = new JLabel();
    
    JLabel lblPanel12 = new JLabel();
    
    JLabel lblPanel13 = new JLabel();
    
    JLabel lblPanel14 = new JLabel();
    
    JLabel lblPanel15 = new JLabel();
    
    ImagenLoader Img = new ImagenLoader();
    
    ArrayList <JLabel> iconos = new ArrayList<JLabel>();
    
    public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	public JLabel getLblMochila() {
		return lblMochila;
	}

	public void setLblMochila(JLabel lblMochila) {
		this.lblMochila = lblMochila;
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

	public Boolean getCoverPadreFin() {
		return coverPadreFin;
	}

	public void setCoverPadreFin(Boolean coverPadreFin) {
		this.coverPadreFin = coverPadreFin;
	}

	public Boolean getPuzzleCajaFinished() {
		return puzzleCajaFinished;
	}

	public void setPuzzleCajaFinished(Boolean puzzleCajaFinished) {
		this.puzzleCajaFinished = puzzleCajaFinished;
	}

	Inventario inventario = new Inventario();
	private final JLabel lblInspeccionado = new JLabel("");
	private final JTextPane lblDescripcion = new JTextPane();

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
        coverPadreFin = false;

        cardLayout = new CardLayout();
        
        panelPrincipal = new JPanel(cardLayout);
        panelPrincipal.setBounds(0, 0, getWidth(), getHeight());
        panelPrincipal.setBackground(new Color(0, 0, 0));
        
        lblMochila = new JLabel();
        lblMochila.setIcon(Img.scaleImage("/img/IconoMochilaEX.png", 60, 60));
        btnMochila = new JButton("");

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
        panelPrincipal.add(new ElegirConversacion(this), "conversacionesPc");
        panelPrincipal.add(new TvCuartoHijo(this), "verPantalla");
        panelPrincipal.add(new CuartoHijo(this), "cuartoHijo");
        panelPrincipal.add(new ColegioXFuera(this), "colegioIntro");
        panelPrincipal.add(new CasaExteriorFinal(this), "casaFinal");
        panelPrincipal.add(new FinJuego(this), "finJuego");
        panelPrincipal.add(new DiarioMadre(this), "diario");
        panelPrincipal.add(new puzzleTelefono(this), "telefono");
        panelPrincipal.add(new TelefonoDesbloq(this), "telDesbloq");
        
        setVisible(true);
        
     // Gestiona que el cronometro cuando llegue a 0 termine con el Escape Room
        Cronometro.getInstancia().setOnFinish(() -> {
            cardLayout.show(panelPrincipal, "finJuego");
        });
        
     // Cargar la imagen de fondo
        String backgroundFile = "/img/fondoInv.png";
        
        panelMochila = new JPanel();
        panelMochila.setLayout(null);

        lblPanel1.setBounds(123, 122, 83, 81);

        lblPanel2.setBounds(253, 122, 83, 81);

        lblPanel3.setBounds(384, 122, 83, 81);

        lblPanel4.setBounds(514, 122, 83, 81);

        lblPanel5.setBounds(644, 122, 83, 81);

        lblPanel6.setBounds(123, 231, 83, 81);

        lblPanel7.setBounds(253, 231, 83, 81);

        lblPanel8.setBounds(384, 231, 83, 81);

        lblPanel9.setBounds(514, 231, 83, 81);

        lblPanel10.setBounds(644, 231, 83, 81);

        lblPanel11.setBounds(123, 339, 83, 81);

        lblPanel12.setBounds(253, 339, 83, 81);
        
        lblPanel13.setBounds(384, 339, 83, 81);
        
        lblPanel14.setBounds(514, 339, 83, 81);
        
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
        
        JLabel inspeccionarLabel = new JLabel();

        JLabel PanelesLabel = new JLabel();        
        
        JButton btnVolver = new JButton("Dejar de Inspeccionar");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		PanelesLabel.setVisible(true);
        		inspeccionarLabel.setVisible(false);
        		btnVolver.setVisible(false);
        		revelarPaneles();
        	}
        });
        lblDescripcion.setForeground(new Color(255, 255, 255));
        lblDescripcion.setFont(new Font("Courier New", Font.BOLD, 18));
        lblDescripcion.setForeground(Color.WHITE);
        lblDescripcion.setOpaque(false);
        lblDescripcion.setBackground(new Color(0, 0, 0, 0));
        lblDescripcion.setEditable(false);
        lblDescripcion.setVisible(false);
        lblDescripcion.setBounds(499, 122, 228, 298);
        
        panelMochila.add(lblDescripcion);
        lblInspeccionado.setBounds(123, 122, 331, 298);
        panelMochila.add(lblInspeccionado);
        btnVolver.setBounds(318, 469, 182, 23);
        panelMochila.add(btnVolver);
        btnVolver.setVisible(false);
        
        ranura1.setBounds(123, 122, 83, 81);
        ranura1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(0), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(0));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        panelMochila.add(ranura1);

        ranura2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(1), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(1));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura2.setBounds(253, 122, 83, 81);
        panelMochila.add(ranura2);

        ranura3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(2), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(2));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura3.setBounds(384, 122, 83, 81);
        panelMochila.add(ranura3);
        
        ranura4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(3), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(3));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura4.setBounds(514, 122, 83, 81);
        panelMochila.add(ranura4);

        ranura5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(4), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(4));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura5.setBounds(644, 122, 83, 81);
        panelMochila.add(ranura5);

        ranura6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(5), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(5));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura6.setBounds(123, 231, 83, 81);
        panelMochila.add(ranura6);
        
        ranura7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(6), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(6));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura7.setBounds(253, 231, 83, 81);
        panelMochila.add(ranura7);

        ranura8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(7), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(7));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura8.setBounds(384, 231, 83, 81);
        panelMochila.add(ranura8);

        ranura9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(8), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(8));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura9.setBounds(514, 231, 83, 81);
        panelMochila.add(ranura9);

        ranura10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(9), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(9));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura10.setBounds(644, 231, 83, 81);
        panelMochila.add(ranura10);

        ranura11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(10), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(10));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura11.setBounds(123, 339, 83, 81);
        panelMochila.add(ranura11);
        
        ranura12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(11), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(11));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura12.setBounds(253, 339, 83, 81);
        panelMochila.add(ranura12);

        ranura13.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(12), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(12));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura13.setBounds(384, 339, 83, 81);
        panelMochila.add(ranura13);

        ranura14.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(13), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(13));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
        	}
        });
        ranura14.setBounds(514, 339, 83, 81);
        panelMochila.add(ranura14);

        ranura15.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblInspeccionado.setIcon(Img.scaleImage(inventario.getObjetoFile(14), 331, 298));
        		lblDescripcion.setText(inventario.getObjetoDesc(14));
        		PanelesLabel.setVisible(false);
        		inspeccionarLabel.setVisible(true);
        		btnVolver.setVisible(true);
        		esconderPaneles();
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

		btnMochila.setBounds(870, 11, 60, 60);
		btnMochila.setOpaque(false);
		btnMochila.setBackground(new Color(0, 0, 0, 0));
		btnMochila.setBorderPainted(false); 
		btnMochila.setFocusPainted(false);
		btnMochila.setContentAreaFilled(false);

		lblMochila.setBounds(870, 11, 60, 60); 
		getContentPane().add(lblMochila);
		getContentPane().add(btnMochila);
		btnMochila.setVisible(false);
		lblMochila.setVisible(false);

        PanelesLabel.setBounds(77, 86, 689, 372); // Ajusta el tamaño del JLabel 
        PanelesLabel.setIcon(Img.scaleImage("/img/inventarioUI-removebg-preview.png", 689, 372));
        
        panelMochila.add(PanelesLabel);

        inspeccionarLabel.setBounds(77, 86, 689, 372); // Ajusta el tamaño del JLabel 
        inspeccionarLabel.setIcon(Img.scaleImage("/img/Insepccionar.png", 689, 372));
        inspeccionarLabel.setVisible(false);
        panelMochila.add(inspeccionarLabel);
        
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
	
	private void esconderPaneles() {
		lblPanel1.setVisible(false);
		lblPanel2.setVisible(false);
		lblPanel3.setVisible(false);
		lblPanel4.setVisible(false);
		lblPanel5.setVisible(false);
		lblPanel6.setVisible(false);
		lblPanel7.setVisible(false);
		lblPanel8.setVisible(false);
		lblPanel9.setVisible(false);
		lblPanel10.setVisible(false);
		lblPanel11.setVisible(false);
		lblPanel12.setVisible(false);
		lblPanel13.setVisible(false);
		lblPanel14.setVisible(false);
		lblPanel15.setVisible(false);
		
		lblInspeccionado.setVisible(true);
		lblDescripcion.setVisible(true);
		
		ranura1.setVisible(false);
		ranura2.setVisible(false);
		ranura3.setVisible(false);
		ranura4.setVisible(false);
		ranura5.setVisible(false);
		ranura6.setVisible(false);
		ranura7.setVisible(false);
		ranura8.setVisible(false);
		ranura9.setVisible(false);
		ranura10.setVisible(false);
		ranura11.setVisible(false);
		ranura12.setVisible(false);
		ranura13.setVisible(false);
		ranura14.setVisible(false);
		ranura15.setVisible(false);
	}
	
	private void revelarPaneles() {
		lblPanel1.setVisible(true);
		lblPanel2.setVisible(true);
		lblPanel3.setVisible(true);
		lblPanel4.setVisible(true);
		lblPanel5.setVisible(true);
		lblPanel6.setVisible(true);
		lblPanel7.setVisible(true);
		lblPanel8.setVisible(true);
		lblPanel9.setVisible(true);
		lblPanel10.setVisible(true);
		lblPanel11.setVisible(true);
		lblPanel12.setVisible(true);
		lblPanel13.setVisible(true);
		lblPanel14.setVisible(true);
		lblPanel15.setVisible(true);
		
		lblInspeccionado.setVisible(false);
		lblDescripcion.setVisible(false);
		
		ranura1.setVisible(true);
		ranura2.setVisible(true);
		ranura3.setVisible(true);
		ranura4.setVisible(true);
		ranura5.setVisible(true);
		ranura6.setVisible(true);
		ranura7.setVisible(true);
		ranura8.setVisible(true);
		ranura9.setVisible(true);
		ranura10.setVisible(true);
		ranura11.setVisible(true);
		ranura12.setVisible(true);
		ranura13.setVisible(true);
		ranura14.setVisible(true);
		ranura15.setVisible(true);
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
