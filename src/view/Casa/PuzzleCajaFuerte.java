package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import utilidades.Cronometro;
import utilidades.ImagenLoader;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;

public class PuzzleCajaFuerte extends JPanel {
    private Image backgroundImage;
    String backgroundFile;
    JLabel Background;
    
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro
    
    int posNum1;
    int posNum2;
    int posNum3;
    
    ImagenLoader img = new ImagenLoader();

    public PuzzleCajaFuerte(Juego juego) {
        setBounds(0, 0, 950, 600);
    	
        backgroundFile = "/img/puzzleCajaFuerte.png";

        JLabel RuedaLabel = new JLabel();
        RuedaLabel.setBounds(393, 52, 170, 170);
        setLayout(null);
        
        posNum1 = 0;
        posNum2 = 0;
        posNum3 = 0;
        
        int[] PrimerNumero = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] SegundoNumero = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] TercerNumero = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        JButton btnArriba1 = new JButton("");
        JButton btnArriba2 = new JButton("");
        JButton btnArriba3 = new JButton("");
        JButton btnAbajo1 = new JButton("");
        JButton btnAbajo2 = new JButton("");
        JButton btnAbajo3 = new JButton("");
        
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("cuartoPadres");
        	}
        });
        btnVolver.setBounds(64, 494, 89, 23);
        add(btnVolver);
        
        
        JLabel thirdNum = new JLabel("0");
        thirdNum.setForeground(Color.WHITE);
        thirdNum.setBackground(Color.ORANGE);
        thirdNum.setFont(new Font("Tahoma", Font.PLAIN, 40));
        thirdNum.setHorizontalAlignment(SwingConstants.CENTER);
        thirdNum.setBounds(595, 327, 91, 117);
        add(thirdNum);
        
        JLabel firstNum = new JLabel("0");
        firstNum.setForeground(Color.WHITE);
        firstNum.setBackground(Color.ORANGE);
        firstNum.setFont(new Font("Tahoma", Font.PLAIN, 40));
        firstNum.setHorizontalAlignment(SwingConstants.CENTER);
        firstNum.setBounds(262, 327, 91, 117);
        add(firstNum);
        
        JLabel secondNum = new JLabel("0");
        secondNum.setForeground(Color.WHITE);
        secondNum.setBackground(Color.ORANGE);
        secondNum.setFont(new Font("Tahoma", Font.PLAIN, 40));
        secondNum.setHorizontalAlignment(SwingConstants.CENTER);
        secondNum.setBounds(434, 327, 91, 117);
        add(secondNum);
                
		JLabel falloLabel = new JLabel("COMBINACI\u00D3N INCORRECTA");
		
        JButton btnAceptar = new JButton("ACEPTAR");

        RuedaLabel.setIcon(img.scaleImage("/img/RuedaPuzzle.png", 170, 170));
        add(RuedaLabel, Integer.valueOf(2));
        
        JLabel flechaArriba1 = new JLabel("");
        flechaArriba1.setBounds(262, 269, 91, 47);
        
        flechaArriba1.setIcon(img.scaleImage("/img/botonArribaPuzzle.png", 91, 47));
        
        JLabel flechaArriba2 = new JLabel("");
        flechaArriba2.setBounds(434, 269, 91, 47);
        flechaArriba2.setIcon(img.scaleImage("/img/botonArribaPuzzle.png", 91, 47));
        
        JLabel flechaArriba3 = new JLabel("");
        flechaArriba3.setBounds(595, 269, 91, 47);
        flechaArriba3.setIcon(img.scaleImage("/img/botonArribaPuzzle.png", 91, 47));
        
        JLabel flechaAbajo3 = new JLabel("");
        flechaAbajo3.setBounds(595, 455, 91, 47);
        flechaAbajo3.setIcon(img.scaleImage("/img/botonAbajoPuzzle.png", 91, 47));
        
        JLabel flechaAbajo2 = new JLabel("");
        flechaAbajo2.setBounds(434, 455, 91, 47);
        flechaAbajo2.setIcon(img.scaleImage("/img/botonAbajoPuzzle.png", 91, 47));
        
        JLabel flechaAbajo1 = new JLabel("");
        flechaAbajo1.setBounds(262, 455, 91, 47);
        flechaAbajo1.setIcon(img.scaleImage("/img/botonAbajoPuzzle.png", 91, 47));
        
        btnArriba1.setBounds(262, 269, 91, 47);
        btnArriba1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(posNum1 == 9) {
        			posNum1 = 0;
        			firstNum.setText(String.valueOf(PrimerNumero[posNum1]));
        		}else if (posNum1 > 1 || posNum1<8) {
        			posNum1= posNum1+1;
        			firstNum.setText(String.valueOf(PrimerNumero[posNum1]));
        		}else if (posNum1 == 0) {
        			posNum1 = 9;
        			firstNum.setText(String.valueOf(PrimerNumero[posNum1]));
        		}
        	}
        });
        btnArriba1.setOpaque(false);
        btnArriba1.setBackground(new Color(0, 0, 0, 0));
        btnArriba1.setBorderPainted(false); // No dibujar el borde
        btnArriba1.setFocusPainted(false);
        btnArriba1.setContentAreaFilled(false);
        add(btnArriba1);
        
        btnArriba2.setBounds(434, 269, 91, 47);
        btnArriba2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(posNum2 == 9) {
        			posNum2 = 0;
        			secondNum.setText(String.valueOf(SegundoNumero[posNum2]));
        		}else if (posNum2 > 1 || posNum2<8) {
        			posNum2= posNum2+1;
        			secondNum.setText(String.valueOf(SegundoNumero[posNum2]));
        		}else if (posNum2 == 0) {
        			posNum2 = 9;
        			secondNum.setText(String.valueOf(SegundoNumero[posNum2]));
        		}
        	}
        });
        btnArriba2.setOpaque(false);
        btnArriba2.setBackground(new Color(0, 0, 0, 0));
        btnArriba2.setBorderPainted(false); // No dibujar el borde
        btnArriba2.setFocusPainted(false);
        btnArriba2.setContentAreaFilled(false);
        add(btnArriba2);
        
        btnArriba3.setBounds(595, 269, 91, 47);
        btnArriba3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(posNum3 == 9) {
        			posNum3 = 0;
        			thirdNum.setText(String.valueOf(TercerNumero[posNum3]));
        		}else if (posNum3 > 1 || posNum3<8) {
        			posNum3= posNum3+1;
        			thirdNum.setText(String.valueOf(TercerNumero[posNum3]));
        		}else if (posNum3 == 0) {
        			posNum3 = 9;
        			thirdNum.setText(String.valueOf(TercerNumero[posNum3]));
        		}
        	}
        });
        btnArriba3.setOpaque(false);
        btnArriba3.setBackground(new Color(0, 0, 0, 0));
        btnArriba3.setBorderPainted(false); // No dibujar el borde
        btnArriba3.setFocusPainted(false);
        btnArriba3.setContentAreaFilled(false);
        add(btnArriba3);
        
        btnAbajo1.setBounds(262, 455, 91, 47);
        btnAbajo1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(posNum1 == 0) {
        			posNum1 = 9;
        			firstNum.setText(String.valueOf(PrimerNumero[posNum1]));
        		}else if (posNum1 > 1 || posNum1<8) {
        			posNum1= posNum1-1;
        			firstNum.setText(String.valueOf(PrimerNumero[posNum1]));
        		}else if (posNum1 == 9) {
        			posNum1 = 0;
        			firstNum.setText(String.valueOf(PrimerNumero[posNum1]));
        		}
        	}
        });
        btnAbajo1.setOpaque(false);
        btnAbajo1.setBackground(new Color(0, 0, 0, 0));
        btnAbajo1.setBorderPainted(false); // No dibujar el borde
        btnAbajo1.setFocusPainted(false);
        btnAbajo1.setContentAreaFilled(false);
        add(btnAbajo1);
        
        btnAbajo2.setBounds(434, 455, 91, 47);
        btnAbajo2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(posNum2 == 0) {
        			posNum2 = 9;
        			secondNum.setText(String.valueOf(SegundoNumero[posNum2]));
        		}else if (posNum2 > 1 || posNum2<8) {
        			posNum2= posNum2-1;
        			secondNum.setText(String.valueOf(SegundoNumero[posNum2]));
        		}else if (posNum2 == 9) {
        			posNum2 = 0;
        			secondNum.setText(String.valueOf(SegundoNumero[posNum2]));
        		}
        	}
        });
        btnAbajo2.setOpaque(false);
        btnAbajo2.setBackground(new Color(0, 0, 0, 0));
        btnAbajo2.setBorderPainted(false); // No dibujar el borde
        btnAbajo2.setFocusPainted(false);
        btnAbajo2.setContentAreaFilled(false);
        add(btnAbajo2);
        
        btnAbajo3.setBounds(595, 455, 91, 47);
        btnAbajo3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(posNum3 == 0) {
        			posNum3 = 9;
        			thirdNum.setText(String.valueOf(TercerNumero[posNum3]));
        		}else if (posNum3 > 1 || posNum3<8) {
        			posNum3= posNum3-1;
        			thirdNum.setText(String.valueOf(TercerNumero[posNum3]));
        		}else if (posNum3 == 9) {
        			posNum3 = 0;
        			thirdNum.setText(String.valueOf(TercerNumero[posNum3]));
        		}
        	}
        });
        btnAbajo3.setOpaque(false);
		btnAbajo3.setBackground(new Color(0, 0, 0, 0));
		btnAbajo3.setBorderPainted(false); // No dibujar el borde
		btnAbajo3.setFocusPainted(false);
		btnAbajo3.setContentAreaFilled(false);
		add(btnAbajo3);

		falloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		falloLabel.setForeground(new Color(255, 128, 128));
		falloLabel.setBounds(402, 513, 161, 14);
		add(falloLabel);
		falloLabel.setVisible(false);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = firstNum.getText() + secondNum.getText() + thirdNum.getText();
				if (codigo.equals("283")) {
					juego.cambiarEscena("cajaAbierta");
					juego.setPuzzleCajaFinished(true);
				} else {
					falloLabel.setVisible(true);
				}
			}
		});
		btnAceptar.setBounds(796, 494, 89, 23);
		add(btnAceptar);
		
        add(flechaAbajo1);
        add(flechaAbajo2);
        add(flechaAbajo3);
        add(flechaArriba3);
        add(flechaArriba2);
        add(flechaArriba1);
		
		btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAbajo1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAbajo2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAbajo3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnArriba1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnArriba2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnArriba3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// Mostrar la imagen de fondo
		Background = new JLabel();
		Background.setBounds(0, 0, 950, 600);
		Background.setIcon(img.scaleImage(backgroundFile, 950, 600)); // Establecer la imagen por defecto
		add(Background); // Agregar al final para que quede encima del botón
		// Cargar la imagen de la bandera inglesa
		
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
    private void upgradeImage() {
		Background.setIcon(img.scaleImage(backgroundFile, 950, 600));
		Background.repaint(); // Redibujar para aplicar el cambio
	}

}