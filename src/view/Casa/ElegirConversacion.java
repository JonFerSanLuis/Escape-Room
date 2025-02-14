package view.Casa;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Inicio.Juego;
import config.Config;
import utilidades.ImagenLoader;

public class ElegirConversacion extends JPanel {

    private JLabel lblTv; // Imagen de fondo
    private JLabel lblfotoconver1;
    private JLabel lblfotoconver2;
    private JButton btnConver1;
    private JButton btnConver2;
    String backgroundFile;
    private boolean conversacion1Vista = false; 
    private boolean conversacion2Vista = false;// Bandera para saber si ya vieron una conversación
    JLabel TxtOutroCasa1;
    JLabel TxtOutroCasa2;
    
    int txtPre;
    
    ImagenLoader img = new ImagenLoader();

    public ElegirConversacion(Juego juego) {

        setBounds(0, 0, 950, 600);
        setLayout(null);
        
        ArrayList<JLabel> TxtFinalCasa = new ArrayList<>();

		TxtOutroCasa1 = new JLabel("Esto es horrible.");
		TxtOutroCasa1.setHorizontalAlignment(SwingConstants.CENTER);
		TxtOutroCasa1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtOutroCasa1.setForeground(Color.WHITE);
		TxtOutroCasa1.setBounds(50, 495, 875, 50);
		add(TxtOutroCasa1);
		TxtOutroCasa1.setVisible(false);

		TxtOutroCasa2 = new JLabel("Mikel soporta esto TODOS lo días...");
		TxtOutroCasa2.setHorizontalAlignment(SwingConstants.CENTER);
		TxtOutroCasa2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtOutroCasa2.setForeground(Color.WHITE);
		TxtOutroCasa2.setBounds(50, 495, 875, 50);
		add(TxtOutroCasa2);
		TxtOutroCasa2.setVisible(false);

		TxtFinalCasa.add(TxtOutroCasa1);
		TxtFinalCasa.add(TxtOutroCasa2);

        // --------- IMAGEN DE FONDO ---------
        backgroundFile = "/img/Fototelevision -conver.jpg";

        lblTv = new JLabel();
        lblTv.setBounds(0, 0, 950, 600);
        lblTv.setIcon(img.scaleImage(backgroundFile, 950, 600));

        // --------- IMAGEN DE LA CONVERSACIÓN 1 ---------
        lblfotoconver1 = new JLabel();
        lblfotoconver1.setBounds(284, 11, 421, 539);
        lblfotoconver1.setVisible(false);
        lblfotoconver1.setIcon(img.scaleImage("/img/movilconver1 (1).png", 421, 539));
        add(lblfotoconver1);

        // --------- IMAGEN DE LA CONVERSACIÓN 2 ---------
        lblfotoconver2 = new JLabel();
        lblfotoconver2.setBounds(191, -31, 577, 626);
        lblfotoconver2.setVisible(false);
        lblfotoconver2.setIcon(img.scaleImage("/img/MovilConver2.png", 577, 626));
        add(lblfotoconver2);

        JButton btnVolver = new JButton("VOLVER");
        
        // --------- BOTÓN PARA ABRIR CONVERSACIÓN 1 ---------
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
                // Oculta los botones de selección de conversación
                btnConver1.setVisible(false);
                btnConver2.setVisible(false);
                btnVolver.setVisible(true);
                // Marca que el usuario ya vio una conversación
                conversacion1Vista = true;
                // Oculta la flecha de "Atras" mientras ve una conversación
            }
        });
        add(btnConver1);

        // --------- BOTÓN PARA ABRIR CONVERSACIÓN 2 ---------
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
                // Oculta los botones de selección de conversación
                btnConver1.setVisible(false);
                btnConver2.setVisible(false);
                // Marca que el usuario ya vio una conversación
                conversacion2Vista = true;
                btnVolver.setVisible(true);
                // Oculta la flecha de "Atras" mientras ve una conversación
            }
        });
        add(btnConver2);     

		JButton btnContinue = new JButton(Config.getTexto("btnContinuar"));

        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if(conversacion1Vista == true && conversacion2Vista == true) {
                	backgroundFile = "/img/CasaTxtFinal.png";
                	upgradeImage();
                	btnVolver.setVisible(false);
                	btnConver1.setVisible(false);
                	btnConver2.setVisible(false);
                	TxtOutroCasa1.setVisible(true);
                	lblfotoconver2.setVisible(false);
                    lblfotoconver1.setVisible(false);
                    btnVolver.setVisible(false);
                	btnContinue.setVisible(true);
                	juego.getBtnMochila().setVisible(false);
					juego.getLblMochila().setVisible(false);
                }else {
                	lblfotoconver2.setVisible(false);
                    lblfotoconver1.setVisible(false);

                    btnConver1.setVisible(true);
                    btnConver2.setVisible(true);
                    btnVolver.setVisible(false);
                }
                
        	}
        });
        btnVolver.setBounds(51, 506, 89, 23);
        btnVolver.setVisible(false);
        add(btnVolver);
        
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        
        txtPre = 0;

		btnContinue.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnContinue.setBounds(819, 468, 115, 23);
		btnContinue.setBackground(new Color(0, 0, 0, 0));
		btnContinue.setOpaque(false);
		btnContinue.setBorderPainted(false);
		btnContinue.setContentAreaFilled(false);
		btnContinue.setForeground(Color.GRAY);

		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPre == TxtFinalCasa.size() - 1) {
					juego.cambiarEscena("casaFinal");
					txtPre = 0;
				} else {
					TxtFinalCasa.get(txtPre).setVisible(false);
					TxtFinalCasa.get(++txtPre).setVisible(true);
				}
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
		btnContinue.setVisible(false);
		add(btnContinue);
		
		add(lblTv);

        setComponentZOrder(lblTv, getComponentCount() - 1);
    }
    
    private void upgradeImage() {
    	lblTv.setIcon(img.scaleImage(backgroundFile, 950, 600));
    	lblTv.repaint(); // Redibujar para aplicar el cambio
	}
}
