package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Recibidor extends JFrame {

    private JPanel contentPane;
    private Image backgroundImage;

    public Recibidor() {
        // Intentar cargar la imagen
        backgroundImage = loadImage("/img/recibidor.jpg");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } else {
                    // En caso de que no se haya cargado la imagen, dibujar un color de fondo predeterminado
                    g.setColor(java.awt.Color.LIGHT_GRAY);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 434, 261);
        contentPane.add(lblNewLabel);
        
        System.out.println(System.getProperty("java.class.path"));

    }

    // Método para cargar la imagen de fondo
    private Image loadImage(String path) {
        try {
            // Usamos getResource para cargar la imagen desde el classpath
            ImageIcon icon = new ImageIcon(getClass().getResource(path));
            
            // Verificamos si la imagen fue cargada correctamente
            if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                System.out.println("No se pudo cargar la imagen en la ruta: " + path);
                return null; // Retornamos null si no se pudo cargar la imagen
            }
            return icon.getImage();
        } catch (Exception e) {
            // Capturamos excepciones y mostramos un mensaje de error
            System.out.println("Error al cargar la imagen: " + e.getMessage());
            return null; // Retornamos null si ocurre un error
        }
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
