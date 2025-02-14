package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import Objetos.Objeto;
import config.Config;
import utilidades.ImagenLoader;
import utilidades.Inventario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SalonCasa extends JPanel {

	private Image backgroundImage;
    private String backgroundFile;
    JLabel salonLabel;
    
    ImagenLoader img = new ImagenLoader();
    
    Inventario inventario = new Inventario();

	public SalonCasa(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		backgroundFile = "/img/salonCasa.jpg";
		
		JButton btnContinue = new JButton(Config.getTexto("btnContinuar"));
		
		juego.getInventario().setNotaHijoSalon(new Objeto(true, false, 105, "Nota del salón", "Parece una nota antigua. Y su letra se parece mucho a la de Mikel", "/img/notaMikel.png"));
        
        JLabel LightLabel = new JLabel();
        LightLabel.setBounds(313, 382, 61, 17); // Ajusta el tamaño del JLabel 
        LightLabel.setIcon(img.scaleImage("/img/11571045.png", 61, 17));
        LightLabel.setVisible(false);
        
        JLabel TxtAlmohada = new JLabel(Config.getTexto("1S"));
		TxtAlmohada.setHorizontalAlignment(SwingConstants.CENTER);
		TxtAlmohada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtAlmohada.setForeground(Color.WHITE);
		TxtAlmohada.setBounds(50, 495, 875, 50);
		add(TxtAlmohada);
		TxtAlmohada.setVisible(false);
		
		add(TxtAlmohada);

        JButton btnRecibidor = new JButton("");
        JLabel lblFlecha = new JLabel();
        lblFlecha.setIcon(img.scaleImage("/img/FlechaVolverSalonOFF.png", 117, 71));
        JButton btnCuadroPerro = new JButton("");
        btnCuadroPerro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCuadroPerro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("cuadroP");
        	}
        });
        btnCuadroPerro.setBounds(887, 114, 47, 186);
        btnCuadroPerro.setBackground(new Color(0, 0, 0, 0));
        btnCuadroPerro.setOpaque(false);
        btnCuadroPerro.setBorderPainted(false);
        btnCuadroPerro.setContentAreaFilled(false);
        add(btnCuadroPerro);
        
        JButton btnCuadroCod = new JButton("");
        btnCuadroCod.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCuadroCod.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("cuadroM");
        	}
        });
        btnCuadroCod.setBounds(149, 142, 89, 99);
        btnCuadroCod.setBackground(new Color(0, 0, 0, 0));
        btnCuadroCod.setOpaque(false);
        btnCuadroCod.setBorderPainted(false);
        btnCuadroCod.setContentAreaFilled(false);
        add(btnCuadroCod);
        
        JButton btnMueble = new JButton("");
        btnMueble.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMueble.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("cajonSalon");
        	}
        });
        btnMueble.setBounds(808, 410, 104, 83);
        btnMueble.setBackground(new Color(0, 0, 0, 0));
        btnMueble.setOpaque(false);
        btnMueble.setBorderPainted(false);
        btnMueble.setContentAreaFilled(false);
        add(btnMueble);
        
        JButton btnAlmohada = new JButton("");
        btnAlmohada.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		LightLabel.setVisible(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		LightLabel.setVisible(false);
        	}
        });
        btnAlmohada.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAlmohada.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		backgroundFile = "/img/salonCasaTxt.jpg";
				upgradeImage();
				btnAlmohada.setVisible(false);
				btnContinue.setVisible(true);
				btnCuadroCod.setVisible(false);
				btnCuadroPerro.setVisible(false);
				btnMueble.setVisible(false);
				TxtAlmohada.setVisible(true);
				lblFlecha.setVisible(false);
				btnRecibidor.setVisible(false);
				juego.getInventario().agregarObjeto(juego.getInventario().getNotaHijoSalon());
        	}
        });
        btnAlmohada.setBounds(264, 323, 80, 71);
        btnAlmohada.setBackground(new Color(0, 0, 0, 0));
        btnAlmohada.setOpaque(false);
        btnAlmohada.setBorderPainted(false);
        btnAlmohada.setContentAreaFilled(false);
        add(btnAlmohada);
        
        lblFlecha.setBounds(696, 479, 117, 71);
        btnRecibidor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRecibidor.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblFlecha.setIcon(img.scaleImage("/img/FlechaVolverSalonON.png", 117, 71));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblFlecha.setIcon(img.scaleImage("/img/FlechaVolverSalonOFF.png", 117, 71));
        	}
        });
        btnRecibidor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("recibidor");
        	}
        });
        btnRecibidor.setBounds(723, 479, 75, 71);
        btnRecibidor.setBackground(new Color(0, 0, 0, 0));
        btnRecibidor.setOpaque(false);
        btnRecibidor.setBorderPainted(false);
        btnRecibidor.setContentAreaFilled(false);
        add(btnRecibidor);
        
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
				backgroundFile = "/img/salonCasa.jpg";
				upgradeImage();
				btnContinue.setVisible(false);
				btnCuadroCod.setVisible(true);
				btnCuadroPerro.setVisible(true);
				btnMueble.setVisible(true);
				TxtAlmohada.setVisible(false);
				lblFlecha.setVisible(true);
				btnRecibidor.setVisible(true);
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
        add(lblFlecha);
        add(LightLabel);
        
        // Mostrar la imagen de fondo
        salonLabel = new JLabel();
        salonLabel.setBounds(0, 0, 950, 600);
        salonLabel.setIcon(img.scaleImage(backgroundFile, 950, 600));  // Establecer la imagen por defecto
        add(salonLabel); // Agregar al final para que quede encima del botón
	}
	private void upgradeImage() {
		salonLabel.setIcon(img.scaleImage(backgroundFile, 950, 600));
		salonLabel.repaint(); // Redibujar para aplicar el cambio
	}

}
