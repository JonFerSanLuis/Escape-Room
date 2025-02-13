package view.Casa;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Inicio.Juego;
import utilidades.ImagenLoader;

public class ElegirConversacion extends JPanel {

    private JLabel lblTv; // Imagen de fondo
    private JLabel lblfotoconver1;
    private JLabel lblfotoconver2;
    private JButton btnConver1;
    private JButton btnConver2;
    private JButton btnAtras; // Nueva flecha para ir a CuartoHijo
    private boolean conversacion1Vista = false; 
    private boolean conversacion2Vista = false;// Bandera para saber si ya vieron una conversaci�n
    
    ImagenLoader img = new ImagenLoader();

    public ElegirConversacion(Juego juego) {

        setBounds(0, 0, 950, 600);
        setLayout(null);

        // --------- IMAGEN DE FONDO ---------
        String backgroundFile = "/img/Fototelevision -conver.jpg";
        
                // --------- FLECHA ATR�S PARA IR A CuartoHijo ---------
                btnAtras = new JButton("");
                btnAtras.setBounds(715, 374, 177, 141);
                btnAtras.setIcon(img.scaleImage("/img/VolverHabitacion.png", 177, 141));
                btnAtras.setOpaque(false);
                btnAtras.setContentAreaFilled(false);
                btnAtras.setBorderPainted(false);
                btnAtras.setVisible(false);
                        btnAtras.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                
                            }
                        });
                add(btnAtras);

        lblTv = new JLabel();
        lblTv.setBounds(0, 0, 950, 600);
        lblTv.setIcon(img.scaleImage(backgroundFile, 950, 600));
        add(lblTv);

        // --------- IMAGEN DE LA CONVERSACI�N 1 ---------
        lblfotoconver1 = new JLabel();
        lblfotoconver1.setBounds(284, 11, 421, 539);
        lblfotoconver1.setVisible(false);
        lblfotoconver1.setIcon(img.scaleImage("/img/movilconver1 (1).png", 421, 539));
        add(lblfotoconver1);

        // --------- IMAGEN DE LA CONVERSACI�N 2 ---------
        lblfotoconver2 = new JLabel();
        lblfotoconver2.setBounds(191, -31, 577, 626);
        lblfotoconver2.setVisible(false);
        lblfotoconver2.setIcon(img.scaleImage("/img/MovilConver2.png", 577, 626));
        add(lblfotoconver2);


        // --------- BOT�N PARA ABRIR CONVERSACI�N 1 ---------
        btnConver1 = new JButton("");
        btnConver1.setBounds(259, 190, 208, 141);
        btnConver1.setOpaque(false);
        btnConver1.setContentAreaFilled(false);
        btnConver1.setBorderPainted(false);
        btnConver1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblfotoconver1.setVisible(true);
                lblfotoconver2.setVisible(false);
                // Oculta los botones de selecci�n de conversaci�n
                btnConver1.setVisible(false);
                btnConver2.setVisible(false);
                // Marca que el usuario ya vio una conversaci�n
                conversacion1Vista = true;
                // Oculta la flecha de "Atras" mientras ve una conversaci�n
                btnAtras.setVisible(false);
            }
        });
        add(btnConver1);

        // --------- BOT�N PARA ABRIR CONVERSACI�N 2 ---------
        btnConver2 = new JButton("");
        btnConver2.setBounds(497, 190, 208, 141);
        btnConver2.setOpaque(false);
        btnConver2.setContentAreaFilled(false);
        btnConver2.setBorderPainted(false);
        btnConver2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblfotoconver2.setVisible(true);
                lblfotoconver1.setVisible(false);
                // Oculta los botones de selecci�n de conversaci�n
                btnConver1.setVisible(false);
                btnConver2.setVisible(false);
                // Marca que el usuario ya vio una conversaci�n
                conversacion2Vista = true;
                // Oculta la flecha de "Atras" mientras ve una conversaci�n
                btnAtras.setVisible(false);
            }
        });
        add(btnConver2);
        
        if(conversacion1Vista == true && conversacion2Vista == true) {
        	
        }

        setComponentZOrder(lblTv, getComponentCount() - 1);
    }
}
