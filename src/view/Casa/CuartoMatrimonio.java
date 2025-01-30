package view.Casa;

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
    JLabel lightLabel;

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
        
        JLabel LightLabel = new JLabel();
        // Cargar la imagen de la bandera inglesa
        ImageIcon LightImagen = new ImageIcon("img/11571045.png");
        LightLabel.setBounds(602, 315, 122, 47); // Ajusta el tama�o del JLabel 
        Image imgLight = LightImagen.getImage().getScaledInstance(LightLabel.getWidth(), LightLabel.getHeight(), Image.SCALE_SMOOTH);
        LightLabel.setIcon(new ImageIcon(imgLight));
        layeredPane.add(LightLabel, Integer.valueOf(2));
        LightLabel.setVisible(false);

        JButton btnVerCaj�n = new JButton("");
        btnVerCaj�n.setOpaque(false);
        btnVerCaj�n.setBackground(new Color(0, 0, 0, 0));
        btnVerCaj�n.setBorderPainted(false); // No dibujar el borde
        btnVerCaj�n.setFocusPainted(false);
        btnVerCaj�n.setContentAreaFilled(false);
        btnVerCaj�n.addMouseListener(new MouseAdapter() {
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
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		LightLabel.setVisible(true);
        	}
        	public void mouseExited(MouseEvent e) {
        		LightLabel.setVisible(false);
        	}
        });
        
        ImageIcon ImagenCajaFuerte = new ImageIcon("img/cajaFuerte.png");
        
        btnVerCaj�n.setBounds(575, 305, 178, 111);
        layeredPane.add(btnVerCaj�n);
        
        
        
        JLabel ImagenCajaFuerteLabel = new JLabel();
        ImagenCajaFuerteLabel.setBounds(773, 264, 161, 118); 
        
        Image imgCajaFuerte = ImagenCajaFuerte.getImage().getScaledInstance(ImagenCajaFuerteLabel.getWidth(), ImagenCajaFuerteLabel.getHeight(), Image.SCALE_SMOOTH);
        ImagenCajaFuerteLabel.setIcon(new ImageIcon(imgCajaFuerte)); 
        
        layeredPane.add(ImagenCajaFuerteLabel, Integer.valueOf(1)); 
        
        HomeLabel = new JLabel();
        HomeLabel.setBounds(0, 0, 934, 561);
        HomeLabel.setIcon(scaledIcon);
        
        layeredPane.add(HomeLabel, Integer.valueOf(0)); 
        
        // Ajustar el tama�o de la ventana al contenido
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