package view.Casa;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Inicio.Juego;
import config.Config;
import utilidades.Cronometro;
import utilidades.ImagenLoader;

public class DiarioMadre extends JPanel {

    String ImagenDiario;
    ImagenLoader img = new ImagenLoader();

    JTextPane lblaparecer2 = new JTextPane();
    
    JTextPane lblcap2 = new JTextPane();
    
    JTextPane lblaparecer1 = new JTextPane();
    
    JTextPane lblcap1 = new JTextPane();
    
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro

    public DiarioMadre(Juego juego) {
        setBounds(0, 0, 950, 600);
        setLayout(null);
        
        JButton btnVolver = new JButton(Config.getTexto("btnVolver"));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	juego.cambiarEscena("bano");
            }
        });
        btnVolver.setBounds(51, 506, 89, 23);
        add(btnVolver);
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblaparecer2.setFont(new Font("Tahoma", Font.PLAIN, 8));

        lblaparecer2.setBounds(497, 218, 110, 176);
        lblaparecer2.setForeground(Color.black);
        lblaparecer2.setOpaque(false);
        lblaparecer2.setBackground(new Color(0, 0, 0, 0));
        lblaparecer2.setEditable(false);
        lblaparecer2.setText(Config.getTexto("1D"));
        lblaparecer2.setVisible(false);
        add(lblaparecer2);
        lblaparecer2.setVisible(false);
        lblcap2.setFont(new Font("Tahoma", Font.PLAIN, 8));

        lblcap2.setBounds(497, 218, 110, 170);
        lblcap2.setForeground(Color.black);
        lblcap2.setOpaque(false);
        lblcap2.setBackground(new Color(0, 0, 0, 0));
        lblcap2.setEditable(false);
        lblcap2.setText(Config.getTexto("2D"));
        lblcap2.setVisible(true);
        add(lblcap2);
        lblaparecer1.setFont(new Font("Tahoma", Font.PLAIN, 8));

        lblaparecer1.setBounds(347, 218, 110, 170);
        lblaparecer1.setForeground(Color.black);
        lblaparecer1.setOpaque(false);
        lblaparecer1.setBackground(new Color(0, 0, 0, 0));
        lblaparecer1.setEditable(false);
        lblaparecer1.setText(Config.getTexto("3D"));
        lblaparecer1.setVisible(false);
        add(lblaparecer1);
        lblaparecer1.setVisible(false); 
        lblcap1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        
        lblcap1.setBounds(347, 218, 110, 170);
        lblcap1.setForeground(Color.black);
        lblcap1.setOpaque(false);
        lblcap1.setBackground(new Color(0, 0, 0, 0));
        lblcap1.setEditable(false);
        lblcap1.setText(Config.getTexto("4D"));
        lblcap1.setVisible(true);
        add(lblcap1);
        
        JButton btn1 = new JButton("New button");
        btn1.setBounds(290, 296, 23, 23);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblaparecer1.setVisible(true);
                lblaparecer2.setVisible(true);
                lblcap1.setVisible(false);
                lblcap2.setVisible(false);
            }
        });
        add(btn1);
        
        JButton btn2 = new JButton("New button");
        btn2.setBounds(636, 296, 23, 23);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblaparecer1.setVisible(false);
                lblaparecer2.setVisible(false);
                lblcap1.setVisible(true);
                lblcap2.setVisible(true);
            }
        });
        add(btn2);
        
        // Imagen de fondo
        JLabel lblDiario = new JLabel();
        lblDiario.setBounds(0, 0, 950, 600);
        add(lblDiario);
        ImagenDiario = "/img/diariomesaBano.png";
        lblDiario.setIcon(img.scaleImage(ImagenDiario, 950, 600));
        
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
}
