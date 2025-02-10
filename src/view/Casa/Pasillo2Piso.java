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
        
        // Flecha
        ImageIcon flechaPasilloOFF = new ImageIcon("img/flechaArribaOFF.png");
        ImageIcon flechaPasilloON = new ImageIcon("img/flechaArribaON.png");

        Image imgPasilloOFF = flechaPasilloOFF.getImage().getScaledInstance(81, 77, Image.SCALE_SMOOTH);
        Image imgPasilloON = flechaPasilloON.getImage().getScaledInstance(81, 77, Image.SCALE_SMOOTH);

        ImageIcon iconPasilloOFF = new ImageIcon(imgPasilloOFF);
        ImageIcon iconPasilloON = new ImageIcon(imgPasilloON);

        JLabel lblPasillo = new JLabel(iconPasilloOFF);
        lblPasillo.setBounds(445, 336, 81, 77);
        contentPane.add(lblPasillo);
        
        JButton btnPasillo = new JButton("");
        btnPasillo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CuartoMatrimonio cuartoM = new CuartoMatrimonio();
        		cuartoM.setVisible(true);
        		dispose();
        	}
        });
        btnPasillo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblPasillo.setIcon(iconPasilloON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblPasillo.setIcon(iconPasilloOFF);
            }
        });
        btnPasillo.setBounds(435, 346, 53, 52);
        btnPasillo.setBackground(new Color(0, 0, 0, 0));
        btnPasillo.setOpaque(false);
        btnPasillo.setBorderPainted(false);
        btnPasillo.setContentAreaFilled(false);
        contentPane.add(btnPasillo);
        // --------------
        
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
