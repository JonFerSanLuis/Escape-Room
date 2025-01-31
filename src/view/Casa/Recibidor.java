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

public class Recibidor extends JFrame {

    private JPanel contentPane;
    private Image backgroundImage;
    String backgroundFile;
    JLabel RecibidorLabel;

    public Recibidor() {
    	contentPane = new JPanel();
        setContentPane(contentPane);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
    	
        backgroundFile = "img/recibidor.jpeg";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        contentPane.setLayout(null);
        
     // Cargar y redimensionar imágenes una sola vez
        ImageIcon flechaEscaleraOFF = new ImageIcon("img/flechaEscaleraOFF.png");
        ImageIcon flechaEscaleraON = new ImageIcon("img/flechaEscaleraON.png");

        Image imgEscaleraOFF = flechaEscaleraOFF.getImage().getScaledInstance(81, 77, Image.SCALE_SMOOTH);
        Image imgEscaleraON = flechaEscaleraON.getImage().getScaledInstance(81, 77, Image.SCALE_SMOOTH);

        ImageIcon iconEscaleraOFF = new ImageIcon(imgEscaleraOFF);
        ImageIcon iconEscaleraON = new ImageIcon(imgEscaleraON);

        JLabel lblEscalera = new JLabel(iconEscaleraOFF);
        lblEscalera.setBounds(797, 247, 81, 77);
        contentPane.add(lblEscalera);
        
        JButton btnEscaleras = new JButton("");
        btnEscaleras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Pasillo2ºPiso pasillo2 = new Pasillo2ºPiso();
        		pasillo2.setVisible(true);
        		dispose();
        	}
        });
        btnEscaleras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblEscalera.setIcon(iconEscaleraON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblEscalera.setIcon(iconEscaleraOFF);
            }
        });
        btnEscaleras.setBounds(797, 247, 81, 77);
        btnEscaleras.setBackground(new Color(0, 0, 0, 0));
        btnEscaleras.setOpaque(false);
        btnEscaleras.setBorderPainted(false);
        btnEscaleras.setContentAreaFilled(false);
        contentPane.add(btnEscaleras);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(318, 337, 81, 77);
        contentPane.add(btnNewButton);
        
        // Mostrar la imagen redimensionada
        RecibidorLabel = new JLabel();
        RecibidorLabel.setBounds(0, 0, 934, 561);
        RecibidorLabel.setIcon(scaledIcon);  // Establecer la imagen por defecto
        contentPane.add(RecibidorLabel);
    	
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