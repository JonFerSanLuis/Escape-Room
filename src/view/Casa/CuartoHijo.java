package view.Casa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CuartoHijo extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuartoHijo frame = new CuartoHijo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    private Image backgroundImage;
    String backgroundFile;
    JLabel lblPasillo2Piso;

    public CuartoHijo() {
    	contentPane = new JPanel();
        setContentPane(contentPane);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
    	
        backgroundFile = "img/CuartoHijo.jpeg";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        contentPane.setLayout(null);
        
        // Mostrar la imagen redimensionada
        lblPasillo2Piso = new JLabel();
        lblPasillo2Piso.setBounds(0, 0, 934, 561);
        lblPasillo2Piso.setIcon(scaledIcon);  // Establecer la imagen por defecto
        contentPane.add(lblPasillo2Piso);
    	
    }
    
    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(contentPane.getWidth(), contentPane.getHeight(), Image.SCALE_SMOOTH));
    }
}
