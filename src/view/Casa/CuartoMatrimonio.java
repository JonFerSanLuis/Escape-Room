package view.Casa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CuartoMatrimonio extends JFrame {

    private JPanel contentPane;
    String CuartoPadresFile;
    JLabel HomeLabel;

    public CuartoMatrimonio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
        setResizable(false);
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(934, 561));
        setContentPane(layeredPane);
        
        CuartoPadresFile = "img/habitacionMatrimonial.jpeg";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(CuartoPadresFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        // Inicializar contentPane
        contentPane = new JPanel();
        contentPane.setLayout(null);
        
        HomeLabel = new JLabel();
        HomeLabel.setBounds(0, 0, 934, 561);
        HomeLabel.setIcon(scaledIcon);
        
        layeredPane.add(HomeLabel, Integer.valueOf(0)); 
        
        ImageIcon ImagenCajaFuerte = new ImageIcon("D:\\Erlantz\\Programacion\\Escape-Room\\src\\img\\cajaFuerte.png");
        JLabel ImagenCajaFuerteLabel = new JLabel();
        ImagenCajaFuerteLabel.setBounds(810, 288, 161, 118); 
        
        Image imgCajaFuerte = ImagenCajaFuerte.getImage().getScaledInstance(ImagenCajaFuerteLabel.getWidth(), ImagenCajaFuerteLabel.getHeight(), Image.SCALE_SMOOTH);
        ImagenCajaFuerteLabel.setIcon(new ImageIcon(imgCajaFuerte)); 
        
        layeredPane.add(ImagenCajaFuerteLabel, Integer.valueOf(1)); 
        
        JButton btnVerCajón = new JButton("BotonEnlaceCajon");
        btnVerCajón.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            CajonCuartoPadres frame = new CajonCuartoPadres();
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        btnVerCajón.setBounds(589, 315, 178, 111);
        layeredPane.add(btnVerCajón);
        
        // Ajustar el tamaño de la ventana al contenido
        pack();
    }

    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(contentPane.getWidth(), contentPane.getHeight(), Image.SCALE_SMOOTH));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CuartoMatrimonio frame = new CuartoMatrimonio();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}