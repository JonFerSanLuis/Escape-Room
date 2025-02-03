package view.Casa;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PapelesDivorcio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public PapelesDivorcio() {
		 JPanel contentPane;
		    String CuartoPadresFile;
		    JLabel HomeLabel;
		    
		    
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(200, 100, 950, 600);
	        setResizable(false);
	        
	        // Usar un JLayeredPane para manejar el orden de los componentes
	        JLayeredPane layeredPane = new JLayeredPane();
	        layeredPane.setPreferredSize(new Dimension(950, 604));
	        setContentPane(layeredPane);
	        CuartoPadresFile ="img/papelesDivorcio.jpeg";

	        
	        // Cargar la imagen y redimensionarla
	        ImageIcon originalIcon = new ImageIcon(CuartoPadresFile);
	        Image originalImage = originalIcon.getImage();
	        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon scaledIcon = new ImageIcon(scaledImage);
	        
	        // Mostrar la imagen redimensionada
	        HomeLabel = new JLabel();
	        HomeLabel.setBounds(0, 0, 944, 571);
	        HomeLabel.setIcon(scaledIcon);
	        
	        // Añadir la imagen de fondo al JLayeredPane
	        layeredPane.add(HomeLabel, Integer.valueOf(0)); // Fondo en la capa 0
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PapelesDivorcio frame = new PapelesDivorcio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
