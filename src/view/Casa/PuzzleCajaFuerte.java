package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PuzzleCajaFuerte extends JFrame {

    private JPanel contentPane;
    private Image backgroundImage;
    String backgroundFile;
    JLabel Background;
    
    int posNum1;
    int posNum2;
    int posNum3;

    public PuzzleCajaFuerte() {
    	contentPane = new JPanel();
        setContentPane(contentPane);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
    	
        backgroundFile = "img/puzzleCajaFuerte.png";
        
        CuartoMatrimonio cuarto = new CuartoMatrimonio();

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        ImageIcon RuedaImage = new ImageIcon("img/RuedaPuzzle.png");
        JLabel RuedaLabel = new JLabel();
        RuedaLabel.setBounds(393, 52, 170, 170);
        Image imgRueda = RuedaImage.getImage().getScaledInstance(RuedaLabel.getWidth(), RuedaLabel.getHeight(),
        		Image.SCALE_SMOOTH);
        
        contentPane.setLayout(null);
        
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
        		cuarto.setVisible(true);
        		dispose();
        	}
        });
        btnVolver.setBounds(64, 494, 89, 23);
        contentPane.add(btnVolver);
        
        
        JLabel thirdNum = new JLabel("0");
        thirdNum.setForeground(Color.WHITE);
        thirdNum.setBackground(Color.ORANGE);
        thirdNum.setFont(new Font("Tahoma", Font.PLAIN, 40));
        thirdNum.setHorizontalAlignment(SwingConstants.CENTER);
        thirdNum.setBounds(595, 327, 91, 117);
        contentPane.add(thirdNum);
        
        JLabel firstNum = new JLabel("0");
        firstNum.setForeground(Color.WHITE);
        firstNum.setBackground(Color.ORANGE);
        firstNum.setFont(new Font("Tahoma", Font.PLAIN, 40));
        firstNum.setHorizontalAlignment(SwingConstants.CENTER);
        firstNum.setBounds(262, 327, 91, 117);
        contentPane.add(firstNum);
        
        JLabel secondNum = new JLabel("0");
        secondNum.setForeground(Color.WHITE);
        secondNum.setBackground(Color.ORANGE);
        secondNum.setFont(new Font("Tahoma", Font.PLAIN, 40));
        secondNum.setHorizontalAlignment(SwingConstants.CENTER);
        secondNum.setBounds(434, 327, 91, 117);
        contentPane.add(secondNum);
                
		JLabel falloLabel = new JLabel("COMBINACI\u00D3N INCORRECTA");
		
        JButton btnAceptar = new JButton("ACEPTAR");

        RuedaLabel.setIcon(new ImageIcon(imgRueda));
        contentPane.add(RuedaLabel, Integer.valueOf(2));
        
        JLabel flechaArriba1 = new JLabel("");
        flechaArriba1.setBounds(262, 269, 91, 47);
        
        ImageIcon FlechaArriba = new ImageIcon("img/botonArribaPuzzle.png");
        Image imgFlechaArriba = FlechaArriba.getImage().getScaledInstance(flechaArriba1.getWidth(), flechaArriba1.getHeight(),
        		Image.SCALE_SMOOTH);
        
        ImageIcon FlechaAbajo = new ImageIcon("img/botonAbajoPuzzle.png");
        Image imgFlechaAbajo = FlechaAbajo.getImage().getScaledInstance(flechaArriba1.getWidth(), flechaArriba1.getHeight(),
        		Image.SCALE_SMOOTH);
        
        flechaArriba1.setIcon(new ImageIcon(imgFlechaArriba));
        contentPane.add(flechaArriba1);
        
        JLabel flechaArriba2 = new JLabel("");
        flechaArriba2.setBounds(434, 269, 91, 47);
        flechaArriba2.setIcon(new ImageIcon(imgFlechaArriba));
        contentPane.add(flechaArriba2);
        
        JLabel flechaArriba3 = new JLabel("");
        flechaArriba3.setBounds(595, 269, 91, 47);
        flechaArriba3.setIcon(new ImageIcon(imgFlechaArriba));
        contentPane.add(flechaArriba3);
        
        JLabel flechaAbajo3 = new JLabel("");
        flechaAbajo3.setBounds(595, 455, 91, 47);
        flechaAbajo3.setIcon(new ImageIcon(imgFlechaAbajo));
        contentPane.add(flechaAbajo3);
        
        JLabel flechaAbajo2 = new JLabel("");
        flechaAbajo2.setBounds(434, 455, 91, 47);
        flechaAbajo2.setIcon(new ImageIcon(imgFlechaAbajo));
        contentPane.add(flechaAbajo2);
        
        JLabel flechaAbajo1 = new JLabel("");
        flechaAbajo1.setBounds(262, 455, 91, 47);
        flechaAbajo1.setIcon(new ImageIcon(imgFlechaAbajo));
        contentPane.add(flechaAbajo1);
        
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
        contentPane.add(btnArriba1);
        
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
        contentPane.add(btnArriba2);
        
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
        contentPane.add(btnArriba3);
        
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
        contentPane.add(btnAbajo1);
        
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
        contentPane.add(btnAbajo2);
        
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
		contentPane.add(btnAbajo3);

		falloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		falloLabel.setForeground(new Color(255, 128, 128));
		falloLabel.setBounds(402, 513, 161, 14);
		contentPane.add(falloLabel);
		falloLabel.setVisible(false);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = firstNum.getText() + secondNum.getText() + thirdNum.getText();
				if (codigo.equals("283")) {
					CajaAbierta open = new CajaAbierta();
					open.setVisible(true);
					dispose();
				} else {
					falloLabel.setVisible(true);
				}
			}
		});
		btnAceptar.setBounds(796, 494, 89, 23);
		contentPane.add(btnAceptar);
		// Mostrar la imagen de fondo
		Background = new JLabel();
		Background.setBounds(0, 0, 934, 561);
		Background.setIcon(scaledIcon); // Establecer la imagen por defecto
		contentPane.add(Background); // Agregar al final para que quede encima del botón
		// Cargar la imagen de la bandera inglesa

	}
    private void upgradeImage() {
		// Cargar la nueva imagen
		ImageIcon originalIcon = new ImageIcon(backgroundFile);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Actualizar el fondo con la nueva imagen
		Background.setIcon(scaledIcon);
		Background.repaint(); // Redibujar para aplicar el cambio
	}
    
    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(contentPane.getWidth(), contentPane.getHeight(), Image.SCALE_SMOOTH));
    }
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	PuzzleCajaFuerte frame = new PuzzleCajaFuerte();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}