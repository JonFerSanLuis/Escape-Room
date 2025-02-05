package view.Casa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Pasillo2Piso extends JFrame {
	private JPanel contentPane;
    private Image backgroundImage;
    String backgroundFile;
    JLabel lblPasillo2Piso;

    public Pasillo2Piso() {
    	contentPane = new JPanel();
        setContentPane(contentPane);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
    	
        backgroundFile = "img/pasillo2Piso.jpg";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        contentPane.setLayout(null);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CuartoMatrimonio cuartoM = new CuartoMatrimonio();
        		cuartoM.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton.setBounds(213, 200, 89, 23);
        contentPane.add(btnNewButton);
        
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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Recibidor frame = new Recibidor();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
