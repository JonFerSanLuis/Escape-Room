package Inicio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import config.Config;

public class Casa extends JFrame {

	private JPanel contentPanel;
	private JLabel HomeLabel;
	private JButton play, btnOptions, ranking, guardar;

	public Casa() {
		Config.cargarIdiomas();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 80, 950, 600);
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 950, 600);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		getContentPane().setLayout(null);
		setResizable(false);
		setUndecorated(true);
		
		try {
            Font buttonFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/BonaNovaSC-Bold.ttf"));
            buttonFont = buttonFont.deriveFont(30f);

            play = new JButton(Config.getTexto("jugar"));
            play.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		Juego juego = new Juego();
            		juego.setVisible(true);
            		dispose();
            	}
            });
			play.setBounds(348, 155, 246, 57);
			play.setContentAreaFilled(false);
			configurarBoton(play, buttonFont);

			JButton btnSpanish = new JButton("");
			btnSpanish.setBounds(363, 124, 94, 52);
			btnSpanish.setBackground(new Color(0, 0, 0, 0));
			btnSpanish.setOpaque(false);
			btnSpanish.setBorderPainted(false);
			btnSpanish.setContentAreaFilled(false);
			btnSpanish.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnSpanish.setBorderPainted(true);
					btnSpanish.setBorder(new LineBorder(Color.RED, 3));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnSpanish.setBorderPainted(false);
				}
				
				// elegir idioma
				@Override
				public void mouseClicked(MouseEvent e) {
					Config.idioma = "es";
					actualizarTextos();
				}
			});
			btnSpanish.setVisible(false);

			JButton btnEnglish = new JButton("");
			btnEnglish.setBounds(480, 124, 94, 52);
			btnEnglish.setBackground(new Color(0, 0, 0, 0));
			btnEnglish.setOpaque(false);
			btnEnglish.setBorderPainted(false);
			btnEnglish.setContentAreaFilled(false);
			btnEnglish.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnEnglish.setBorderPainted(true);
					btnEnglish.setBorder(new LineBorder(Color.RED, 3));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnEnglish.setBorderPainted(false);
				}
				// elegir idioma
				@Override
				public void mouseClicked(MouseEvent e) {
					Config.idioma = "en";
					actualizarTextos();
				}
			});
			btnEnglish.setVisible(false);

			contentPanel.add(btnEnglish);
			contentPanel.add(btnSpanish);

			JLabel idioma = new JLabel(Config.getTexto("idioma"));
			idioma.setBounds(348, 39, 246, 57);
			idioma.setOpaque(false);
			idioma.setForeground(Color.white);
			contentPanel.add(idioma);
			idioma.setVisible(false);
			
			ImageIcon SpanishImagen = new ImageIcon("img/Bandera_de_España.svg (1).png");
	        JLabel Spanishlabel = new JLabel();
	        Spanishlabel.setBounds(363, 124, 94, 52);
	        Spanishlabel.setIcon(escalarImagen(SpanishImagen, Spanishlabel.getWidth(), Spanishlabel.getHeight()));
	        contentPanel.add(Spanishlabel);
	        Spanishlabel.setVisible(false);
	        
	        ImageIcon EnglishImagen = new ImageIcon("img/Flag_of_the_United_Kingdom_(1-2).svg.png");
	        JLabel Englishlabel = new JLabel();
	        Englishlabel.setBounds(480, 124, 94, 52);
	        Englishlabel.setIcon(escalarImagen(EnglishImagen, Englishlabel.getWidth(), Englishlabel.getHeight()));
	        contentPanel.add(Englishlabel);
	        Englishlabel.setVisible(false);

			JLabel lblOpciones = new JLabel();
			guardar = new JButton(Config.getTexto("guardar"));
			contentPanel.add(guardar);
			
	        lblOpciones.setBounds(257, 11, 410, 489);
	        String imagePath = "img/pixelcut-export (1) (1).png";
	        ImageIcon originalIcon = new ImageIcon(imagePath);
	        lblOpciones.setIcon(escalarImagen(originalIcon, lblOpciones.getWidth(), lblOpciones.getHeight()));
	        contentPanel.add(lblOpciones);
	        lblOpciones.setVisible(false);
	        
	        ranking = new JButton(Config.getTexto("ranking"));
			
			btnOptions = new JButton(Config.getTexto("opciones"));
			
			guardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guardar.setVisible(false);
					btnSpanish.setVisible(false);
					lblOpciones.setVisible(false);
					btnEnglish.setVisible(false);
			        Spanishlabel.setVisible(false);
			        Englishlabel.setVisible(false);
			        idioma.setVisible(false);
			        play.setVisible(true);
			        btnOptions.setVisible(true);
			        ranking.setVisible(true);
				}
			});
			guardar.setBounds(380, 386, 194, 39);
			guardar.setBackground(new Color(0, 0, 0, 0));
			guardar.setOpaque(false);
			guardar.setBorderPainted(false);
			guardar.setContentAreaFilled(false);
			guardar.setForeground(Color.white);
			guardar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					guardar.setForeground(Color.red);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					guardar.setForeground(Color.white);
				}
			});
			guardar.setVisible(false);
	
			btnOptions.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guardar.setVisible(true);
					btnSpanish.setVisible(true);
					lblOpciones.setVisible(true);
					btnEnglish.setVisible(true);
			        Spanishlabel.setVisible(true);
			        Englishlabel.setVisible(true);
			        idioma.setVisible(true);
			        play.setVisible(false);
			        btnOptions.setVisible(false);
			        ranking.setVisible(false);
				}
			});
			btnOptions.setBounds(348, 231, 246, 57);
			btnOptions.setContentAreaFilled(false);
			configurarBoton(btnOptions, buttonFont);

			ranking.setBounds(348, 303, 246, 57);
			ranking.setContentAreaFilled(false);
			configurarBoton(ranking, buttonFont);

			play.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnOptions.setCursor(new Cursor(Cursor.HAND_CURSOR));
			ranking.setCursor(new Cursor(Cursor.HAND_CURSOR));
			guardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnEnglish.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnSpanish.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			contentPanel.add(play);
			contentPanel.add(btnOptions);
			contentPanel.add(ranking);
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}

        // Cargar la imagen de fondo
        String backgroundFile = "img/JUGAR.png";
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(950, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        HomeLabel = new JLabel();
        HomeLabel.setBounds(0, 0, 950, 600);
        HomeLabel.setIcon(scaledIcon);
        contentPanel.add(HomeLabel);
        
    }
    
    private ImageIcon escalarImagen(ImageIcon icon, int width, int height) {
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    private void configurarBoton(JButton boton, Font fuente) {
        boton.setOpaque(false);
        boton.setBackground(new Color(0, 0, 0, 0));
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setFont(fuente);
        boton.setForeground(Color.black);
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setForeground(Color.red);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                boton.setForeground(Color.black);
            }
        });
    }
    private void actualizarTextos() {
        play.setText(Config.getTexto("jugar"));
        btnOptions.setText(Config.getTexto("opciones"));
        ranking.setText(Config.getTexto("ranking"));
        guardar.setText(Config.getTexto("guardar"));
    }
}