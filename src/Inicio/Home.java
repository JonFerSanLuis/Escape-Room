package Inicio;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	String backgroundFile;
    private JPanel contentPane;
    private JLabel HomeLabel;  // Añadimos una referencia a lblNewLabel

    public Home() {
    	
    	contentPane = new JPanel();
        setContentPane(contentPane);
        setResizable(false);
        
    	try {
			Font buttonFont = Font.createFont(Font.TRUETYPE_FONT,new File("fonts/BonaNovaSC-Bold.ttf"));
			buttonFont = buttonFont.deriveFont(30f);
			JButton play = new JButton("JUGAR");
			play.setBounds(348, 135, 246, 57);
			play.setOpaque(false);
			play.setBackground(new Color(0, 0, 0, 0));
			play.setBorderPainted(false); // No dibujar el borde
			play.setFont(buttonFont);
			play.setFocusPainted(false);
			play.setForeground(Color.black);
			contentPane.add(play);
			play.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Intro intro = new Intro();
					intro.setVisible(true);
					dispose();
				}
			});
			play.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseEntered(MouseEvent e) {
	        		play.setForeground(Color.red);
	        		}
	        	@Override
	        	public void mouseExited(MouseEvent e) {
	        		play.setForeground(Color.black);
	        		}
				});
			JButton btnOptions = new JButton("OPCIONES");
			btnOptions.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirVentanaOpciones();
				}
			});
			btnOptions.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnOptions.setForeground(Color.red);
        		}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnOptions.setForeground(Color.black);
        		}
			});
			btnOptions.setBounds(348, 211, 246, 57);
			btnOptions.setOpaque(false);
			btnOptions.setBackground(new Color(0, 0, 0, 0));
			btnOptions.setBorderPainted(false); // No dibujar el borde
			btnOptions.setFocusPainted(false);
			btnOptions.setForeground(Color.black);
			btnOptions.setFont(buttonFont);
			contentPane.add(btnOptions);
        	
			JButton ranking = new JButton("RANKING");
			ranking.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		ranking.setForeground(Color.red);
        		}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		ranking.setForeground(Color.black);
        		}
			});
			ranking.setBounds(348, 287, 246, 57);
			ranking.setOpaque(false);
			ranking.setBackground(new Color(0, 0, 0, 0));
			ranking.setBorderPainted(false); // No dibujar el borde
			ranking.setFocusPainted(false);
			ranking.setFont(buttonFont);
			ranking.setForeground(Color.black);
			contentPane.add(ranking);
			
			play.setOpaque(false);
			play.setBorderPainted(false);
			play.setContentAreaFilled(false);

			btnOptions.setOpaque(false);
			btnOptions.setBorderPainted(false);
			btnOptions.setContentAreaFilled(false);

			ranking.setOpaque(false);
			ranking.setBorderPainted(false);
			ranking.setContentAreaFilled(false);
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
        
        
        backgroundFile = "sources/JUGAR.png";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        contentPane.setLayout(null);
        
        // Mostrar la imagen redimensionada
        HomeLabel = new JLabel();
        HomeLabel.setBounds(0, 0, 934, 561);
        HomeLabel.setIcon(scaledIcon);
        contentPane.add(HomeLabel);
    }
    
    private void abrirVentanaOpciones() {
        this.setEnabled(false);  // Deshabilitar la ventana Home
        new Opciones(this);      // Pasar la instancia de Home a Opciones
    }

    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(contentPane.getWidth(), contentPane.getHeight(), Image.SCALE_SMOOTH));
    }
}

