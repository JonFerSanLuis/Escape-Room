package view.Casa;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CajonCuartoPadres extends JFrame {

    private JPanel contentPane;

    public CajonCuartoPadres() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
        setResizable(false);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(950, 604));
        setContentPane(layeredPane);

        String CuartoPadresFile = "img/cajon.jpeg";
        ImageIcon originalIcon = new ImageIcon(CuartoPadresFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel HomeLabel = new JLabel();
        HomeLabel.setBounds(0, 0, 944, 571);
        HomeLabel.setIcon(scaledIcon);
        layeredPane.add(HomeLabel, Integer.valueOf(0));

        JLabel LightLabel = new JLabel();
        ImageIcon LightImagen = new ImageIcon("img/11571045.png");
        LightLabel.setBounds(315, 336, 122, 47);
        Image imgLight = LightImagen.getImage().getScaledInstance(LightLabel.getWidth(), LightLabel.getHeight(), Image.SCALE_SMOOTH);
        LightLabel.setIcon(new ImageIcon(imgLight));
        layeredPane.add(LightLabel, Integer.valueOf(3));  // Capa más alta para asegurarnos de que se vea encima de todo

        LightLabel.setVisible(false);

        LightLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                LightLabel.setVisible(true); // Mostrar imagen cuando el ratón entra
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LightLabel.setVisible(false); // Ocultar imagen cuando el ratón sale
            }
        });

        JButton BtnVerPapeles = new JButton("");
        BtnVerPapeles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(() -> {
                    try {
                        PapelesDivorcio frame = new PapelesDivorcio();
                        frame.setVisible(true);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });
            }
        });
        BtnVerPapeles.setBounds(257, 329, 223, 119);
        layeredPane.add(BtnVerPapeles);
        BtnVerPapeles.setOpaque(false);
        BtnVerPapeles.setBackground(null);
        BtnVerPapeles.setBorderPainted(false);
        BtnVerPapeles.setFocusPainted(false);
        BtnVerPapeles.setContentAreaFilled(false);

        JButton btnVerPapeles2 = new JButton("");
        btnVerPapeles2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(() -> {
                    try {
                        PapelesDivorcio frame = new PapelesDivorcio();
                        frame.setVisible(true);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });
            }
        });
        btnVerPapeles2.setBounds(422, 277, 199, 145);
        layeredPane.add(btnVerPapeles2);
        btnVerPapeles2.setOpaque(false);
        btnVerPapeles2.setBackground(null);
        btnVerPapeles2.setBorderPainted(false);
        btnVerPapeles2.setFocusPainted(false);
        btnVerPapeles2.setContentAreaFilled(false);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CajonCuartoPadres frame = new CajonCuartoPadres();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
