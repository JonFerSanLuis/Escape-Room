package view.Casa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ba�oCasa extends JFrame {

	private JPanel contentPane;
	private Image backgroundImage;
    private String backgroundFile;
    JLabel ba�oLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ba�oCasa frame = new Ba�oCasa();
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
	public Ba�oCasa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 950, 600);
		contentPane = new JPanel();
		setLayout(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		backgroundFile = "img/recibidor.jpeg";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setLayout(null);
        
        // Mostrar la imagen de fondo
        ba�oLabel = new JLabel();
        ba�oLabel.setBounds(0, 0, 934, 561);
        ba�oLabel.setIcon(scaledIcon);  // Establecer la imagen por defecto
        add(ba�oLabel); // Agregar al final para que quede encima del bot�n
	}
	
    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
    }

}
