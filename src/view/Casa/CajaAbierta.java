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

import Objetos.Objeto;
import utilidades.Inventario;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CajaAbierta extends JFrame {

    private JPanel contentPane;
    private Image backgroundImage;
    String backgroundFile;
    JLabel Background;

    public CajaAbierta() {
    	contentPane = new JPanel();
        setContentPane(contentPane);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
        
        Inventario inventario = new Inventario();
        
        inventario.setLlaveCajonPadres(new Objeto(true, true, 002, "Llave del Cajón", "La llave del cajón de la comoda de los padres de Mikel", "img/llaveCajon.png"));
    	
        backgroundFile = "img/cajaFuerteOpen.jpeg";
        
        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        JLabel llaveLabel = new JLabel();
		// Cargar la imagen de la bandera inglesa
		ImageIcon llaveCajonImage = new ImageIcon("img/llaveEnCaja.png");
		llaveLabel.setBounds(326, 208, 332, 166); // Ajusta el tamaño del JLabel
		Image imgllaveCajon = llaveCajonImage.getImage().getScaledInstance(llaveLabel.getWidth(),
				llaveLabel.getHeight(), Image.SCALE_SMOOTH);
		
		JButton btnLlaveCajon = new JButton("");
		btnLlaveCajon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventario.agregarObjeto(inventario.getLlaveCajonPadres());
				llaveLabel.setVisible(false);
				btnLlaveCajon.setVisible(false);
			}
		});
		btnLlaveCajon.setBounds(432, 280, 138, 23);
		btnLlaveCajon.setOpaque(false);
		btnLlaveCajon.setBackground(new Color(0, 0, 0, 0));
		btnLlaveCajon.setBorderPainted(false); // No dibujar el borde
		btnLlaveCajon.setFocusPainted(false);
		btnLlaveCajon.setContentAreaFilled(false);
		contentPane.add(btnLlaveCajon);
		llaveLabel.setIcon(new ImageIcon(imgllaveCajon));
		contentPane.add(llaveLabel, Integer.valueOf(2));
        
        contentPane.setLayout(null);

        JButton btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CuartoMatrimonio cuartoPadres = new CuartoMatrimonio();
        		cuartoPadres.setVisible(true);
        		dispose();
        	}
        });
        btnVolver.setBounds(64, 494, 89, 23);
        contentPane.add(btnVolver);

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
                	CajaAbierta frame = new CajaAbierta();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}