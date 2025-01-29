package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CuartoMatrimonio2 extends JFrame {

    private JLabel HomeLabel;

    public CuartoMatrimonio2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600); // Asegúrate de que las dimensiones sean las mismas
        
        // Usar un JLayeredPane para manejar el orden de los componentes
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(950, 600));
        setContentPane(layeredPane);
        
        String CuartoPadresFile = "D:\\Erlantz\\Programacion\\Escape-Room\\src\\img\\habitacionMatrimonial.jpeg";
        
        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(CuartoPadresFile);
        Image originalImage = originalIcon.getImage();
        
        // Escalar la imagen a las dimensiones de la ventana
        Image scaledImage = originalImage.getScaledInstance(950, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        // Mostrar la imagen redimensionada
        HomeLabel = new JLabel();
        HomeLabel.setBounds(0, 0, 950, 600); // Ajusta el tamaño del JLabel
        HomeLabel.setIcon(scaledIcon);
        
        // Añadir la imagen de fondo al JLayeredPane
        layeredPane.add(HomeLabel, Integer.valueOf(0)); // Fondo en la capa 0
        
        JButton btnVerCajón = new JButton("New button");
        btnVerCajón.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(() -> {
                    try {
                        CajonCuartoPadres frame = new CajonCuartoPadres();
                        frame.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnVerCajón.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cambiar a cursor de mano
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnVerCajón.setCursor(Cursor.getDefaultCursor()); // Volver al cursor por defecto
            }
        });
        btnVerCajón.setBounds(589, 315, 178, 111);
        layeredPane.add(btnVerCajón);
        
        // Ajustar el tamaño de la ventana al contenido
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CuartoMatrimonio2 frame = new CuartoMatrimonio2();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}