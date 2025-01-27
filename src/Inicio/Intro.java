package Inicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Intro extends JFrame {

	private JPanel contentPane;
	
	String IntroBackground;
	
	JLabel IntroLabel;
	/**
	 * Create the frame.
	 */
	public Intro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 950, 600);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IntroBackground = "sources/Generate_a_scene_of_two_young_ (2)_Nero AI_Anime_Face (1).jpeg";
		
		ImageIcon originalIcon = new ImageIcon(IntroBackground);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        IntroLabel = new JLabel();
        IntroLabel.setBounds(0, 0, 934, 561);
        IntroLabel.setIcon(scaledIcon);  // Establecer la imagen por defecto
        contentPane.add(IntroLabel);
		
	}
	
	private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(contentPane.getWidth(), contentPane.getHeight(), Image.SCALE_SMOOTH));
    }

}
