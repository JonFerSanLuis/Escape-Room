package view.Casa;

import java.awt.BorderLayout;
import view.Casa.CocinaCasa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import utilidades.Cronometro;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recibidor extends JPanel {
    private Image backgroundImage;
    String backgroundFile;
    JLabel RecibidorLabel;
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro

    public Recibidor(Juego juego) {
        setBounds(0, 0, 950, 600);
    	
        backgroundFile = "img/recibidor.jpeg";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setLayout(null);
        
     // Cargar y redimensionar imágenes una sola vez
        ImageIcon flechaEscaleraOFF = new ImageIcon("img/flechaEscaleraOFF.png");
        ImageIcon flechaEscaleraON = new ImageIcon("img/flechaEscaleraON.png");

        Image imgEscaleraOFF = flechaEscaleraOFF.getImage().getScaledInstance(81, 77, Image.SCALE_SMOOTH);
        Image imgEscaleraON = flechaEscaleraON.getImage().getScaledInstance(81, 77, Image.SCALE_SMOOTH);

        ImageIcon iconEscaleraOFF = new ImageIcon(imgEscaleraOFF);
        ImageIcon iconEscaleraON = new ImageIcon(imgEscaleraON);

        JLabel lblEscalera = new JLabel(iconEscaleraOFF);
        lblEscalera.setBounds(797, 247, 81, 77);
        add(lblEscalera);
        
        JButton btnEscaleras = new JButton("");
        btnEscaleras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("pasillo2");
        	}
        });
        btnEscaleras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblEscalera.setIcon(iconEscaleraON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblEscalera.setIcon(iconEscaleraOFF);
            }
        });
        btnEscaleras.setBounds(797, 247, 81, 77);
        btnEscaleras.setBackground(new Color(0, 0, 0, 0));
        btnEscaleras.setOpaque(false);
        btnEscaleras.setBorderPainted(false);
        btnEscaleras.setContentAreaFilled(false);
        add(btnEscaleras);
        
     // Cargar y redimensionar imágenes una sola vez
        ImageIcon flechaPuertaOFF = new ImageIcon("img/FlechaSalonOFF.png");
        ImageIcon flechaPuertaON = new ImageIcon("img/FlechaSalonON.png");

        Image imgPuertaOFF = flechaPuertaOFF.getImage().getScaledInstance(212, 137, Image.SCALE_SMOOTH);
        Image imgPuertaON = flechaPuertaON.getImage().getScaledInstance(212, 137, Image.SCALE_SMOOTH);

        ImageIcon iconPuertaOFF = new ImageIcon(imgPuertaOFF);
        ImageIcon iconPuertaON = new ImageIcon(imgPuertaON);

        JLabel lblSalon = new JLabel(iconPuertaOFF);
        lblSalon.setBounds(250, 390, 212, 137);
        add(lblSalon);
        
        
        JButton btnSalon = new JButton("");
        btnSalon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Crear una instancia de SalonCasa y hacerla visible
                SalonCasa salon = new SalonCasa();
                salon.setVisible(true);
                
                // Si quieres cerrar la ventana actual (Recibidor), puedes hacerlo así:
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(btnSalon);
                parentFrame.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblSalon.setIcon(iconPuertaON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblSalon.setIcon(iconPuertaOFF);
            }
        });

        btnSalon.setBounds(332, 405, 95, 88);
        btnSalon.setBackground(new Color(0, 0, 0, 0)); // Hacer el fondo transparente
        btnSalon.setOpaque(false);
        btnSalon.setBorderPainted(false);
        btnSalon.setContentAreaFilled(false);
        add(btnSalon); // Agregarlo antes de la imagen
        
     // Cargar y redimensionar imágenes una sola vez
        ImageIcon flechaCocinaOFF = new ImageIcon("img/flechaCocinaOFF.png");
        ImageIcon flechaCocinaON = new ImageIcon("img/flechaCocinaON.png");

        Image imgCocinaOFF = flechaCocinaOFF.getImage().getScaledInstance(212, 137, Image.SCALE_SMOOTH);
        Image imgCocinaON = flechaCocinaON.getImage().getScaledInstance(212, 137, Image.SCALE_SMOOTH);

        ImageIcon iconCocinaOFF = new ImageIcon(imgCocinaOFF);
        ImageIcon iconCocinaON = new ImageIcon(imgCocinaON);

        JLabel lblCocina = new JLabel(iconCocinaOFF);
        lblCocina.setBounds(150, 450, 212, 137);
        add(lblCocina);
        
        
        JButton btnCocina = new JButton("");
        btnCocina.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Crear una instancia de CocinaCasa
                CocinaCasa cocina = new CocinaCasa();
                
                // Hacer visible la ventana CocinaCasa
                cocina.setVisible(true);

                // Si deseas ocultar la ventana actual (Recibidor), puedes hacerlo así:
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(btnCocina);
                parentFrame.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblCocina.setIcon(iconCocinaON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblCocina.setIcon(iconCocinaOFF);
            }
        });

        btnCocina.setBounds(183, 471, 147, 88);
        btnCocina.setBackground(new Color(0, 0, 0, 0)); // Hacer el fondo transparente
        btnCocina.setOpaque(false);
        btnCocina.setBorderPainted(false);
        btnCocina.setContentAreaFilled(false);
        add(btnCocina); // Agregarlo antes de la imagen
        
        JLabel LightLabel = new JLabel();
        // Cargar la imagen de la bandera inglesa
		ImageIcon LightImagen = new ImageIcon("img/11571045.png");
		LightLabel.setBounds(620, 315, 83, 23); // Ajusta el tamaño del JLabel
		Image imgLight = LightImagen.getImage().getScaledInstance(LightLabel.getWidth(), LightLabel.getHeight(),
				Image.SCALE_SMOOTH);
		LightLabel.setIcon(new ImageIcon(imgLight));
		add(LightLabel, Integer.valueOf(2));
		LightLabel.setVisible(false);
        
        JButton btnBano = new JButton("");
        btnBano.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		LightLabel.setVisible(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		LightLabel.setVisible(false);
        	}
        });
        btnBano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de BanoCasa y hacerla visible
                BanoCasa bano = new BanoCasa();
                bano.setVisible(true);
                
                // Si quieres cerrar la ventana actual (Recibidor), puedes hacerlo así:
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(btnBano);
                parentFrame.setVisible(false);
            }
        });

        btnBano.setBounds(591, 171, 89, 256);
        btnBano.setBackground(new Color(0, 0, 0, 0)); // Hacer el fondo transparente
        btnBano.setOpaque(false);
        btnBano.setBorderPainted(false);
        btnBano.setContentAreaFilled(false);
        add(btnBano);
        
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

        // Mostrar la imagen de fondo
        RecibidorLabel = new JLabel();
        RecibidorLabel.setBounds(0, 0, 950, 600);
        RecibidorLabel.setIcon(scaledIcon);  // Establecer la imagen por defecto
        add(RecibidorLabel); // Agregar al final para que quede encima del botón

        // Actualizar la etiqueta cada segundo (formato HH:MM:SS)
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText(Cronometro.getInstancia().getTiempoFormato()));
        actualizarTimer.start();

    }
    
    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
    }
}