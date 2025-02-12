package Inicio;

import javax.swing.*;

import utilidades.Inventario;
import view.Casa.BanoCasa;
import view.Casa.CajaAbierta;
import view.Casa.CajonCuartoPadres;
import view.Casa.CasaExterior;
import view.Casa.CocinaCasa;
import view.Casa.CuadroMadre;
import view.Casa.CuadroPerro;
import view.Casa.CuartoMatrimonio;
import view.Casa.NeveraCalendario;
import view.Casa.Pasillo2Piso;
import view.Casa.PuzzleCajaFuerte;
import view.Casa.Recibidor;
import view.Casa.SalonCasa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        
        lblMochila = new JLabel(new ImageIcon("img/IconoMochilaEX.png"));
        btnPista = new JButton("");
        btnMochila = new JButton("");
        lblPista = new JLabel(new ImageIcon("img/IconoPistaEX.png"));

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
        panelPrincipal.add(new BanoCasa(this), "bano");
        
        setVisible(true);
        
     // Cargar la imagen de fondo
        String backgroundFile = "img/fondoInv.png";
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(950, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        ImageIcon paperImagen = new ImageIcon("img/inventarioUI-removebg-preview.png");
        
        panelMochila = new JPanel();
        panelMochila.setLayout(null);
         
        JButton ranura1 = new JButton("New button");
        ranura1.setBounds(123, 122, 83, 81);
        panelMochila.add(ranura1);
        
        JButton ranura2 = new JButton("New button");
        ranura2.setBounds(253, 122, 83, 81);
        panelMochila.add(ranura2);
        
        JButton ranura3 = new JButton("New button");
        ranura3.setBounds(384, 122, 83, 81);
        panelMochila.add(ranura3);
        
        JButton ranura4 = new JButton("New button");
        ranura4.setBounds(514, 122, 83, 81);
        panelMochila.add(ranura4);
        
        JButton ranura5 = new JButton("New button");
        ranura5.setBounds(644, 122, 83, 81);
        panelMochila.add(ranura5);
        
        JButton ranura6 = new JButton("New button");
        ranura6.setBounds(123, 231, 83, 81);
        panelMochila.add(ranura6);
        
        JButton ranura7 = new JButton("New button");
        ranura7.setBounds(253, 231, 83, 81);
        panelMochila.add(ranura7);
        
        JButton ranura8 = new JButton("New button");
        ranura8.setBounds(384, 231, 83, 81);
        panelMochila.add(ranura8);
        
        JButton ranura9 = new JButton("New button");
        ranura9.setBounds(514, 231, 83, 81);
        panelMochila.add(ranura9);
        
        JButton ranura10 = new JButton("New button");
        ranura10.setBounds(644, 231, 83, 81);
        panelMochila.add(ranura10);
        
        JButton ranura11 = new JButton("New button");
        ranura11.setBounds(123, 339, 83, 81);
        panelMochila.add(ranura11);
        
        JButton ranura12 = new JButton("New button");
        ranura12.setBounds(253, 339, 83, 81);
        panelMochila.add(ranura12);
        
        JButton ranura13 = new JButton("New button");
        ranura13.setBounds(384, 339, 83, 81);
        panelMochila.add(ranura13);
        
        JButton ranura14 = new JButton("New button");
        ranura14.setBounds(514, 339, 83, 81);
        panelMochila.add(ranura14);
        
        JButton ranura15 = new JButton("New button");
        ranura15.setBounds(644, 339, 83, 81);
        panelMochila.add(ranura15);
        
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
        PanelesLabel.setBounds(74, 84, 689, 372); // Ajusta el tama�o del JLabel 
        Image imgPaper = paperImagen.getImage().getScaledInstance(PanelesLabel.getWidth(), PanelesLabel.getHeight(), Image.SCALE_SMOOTH);
        PanelesLabel.setIcon(new ImageIcon(imgPaper));
        
        panelMochila.add(PanelesLabel);
        
        JLabel inventarioLabel = new JLabel();
        inventarioLabel.setBounds(0, 0, 950, 600);
        inventarioLabel.setIcon(scaledIcon);
        
        panelMochila.add(inventarioLabel);
        panelMochila.setBounds(0, 0, getWidth(), getHeight());
        panelMochila.setVisible(false);
        getContentPane().add(panelMochila);
        getContentPane().add(panelPrincipal);

    }

    private void configurarRanuras(JButton boton) {
    	boton.setOpaque(false);
        boton.setBackground(new Color(0, 0, 0, 0));
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
    }

    public void cambiarEscena(String nombreEscena) {
        cardLayout.show(panelPrincipal, nombreEscena);
    }
}
