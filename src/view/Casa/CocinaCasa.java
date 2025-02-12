package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Inicio.Juego;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class CocinaCasa extends JFrame {

	private JPanel contentPane;
	private Image backgroundImage;
    private String backgroundFile;
    JLabel bañoLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CocinaCasa frame = new CocinaCasa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CocinaCasa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 950, 600);
		contentPane = new JPanel();
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		backgroundFile = "img/cocinaCasa.jpg";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        getContentPane().setLayout(null);
        
        JButton btnVolverPasillo = new JButton("New button");
        btnVolverPasillo.setBounds(730, 455, 89, 83);
        contentPane.add(btnVolverPasillo);
        btnVolverPasillo.setVisible(true);  // Hace el botón no visible
        
        JLabel lblVolverP = new JLabel("New label");
        lblVolverP.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
				//juego.cambiarEscena("recibidor");
			}
		});
        lblVolverP.setIcon(new ImageIcon("img/fechaAbajoOFF.png"));
        lblVolverP.setBounds(730, 455, 89, 83);
        contentPane.add(lblVolverP);
        
        
        // Mostrar la imagen de fondo
        bañoLabel = new JLabel();
        bañoLabel.setBounds(0, 0, 950, 600);
        bañoLabel.setIcon(scaledIcon);  // Establecer la imagen por defecto
        getContentPane().add(bañoLabel); // Agregar al final para que quede encima del botón
	}
	
    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
    }
}
