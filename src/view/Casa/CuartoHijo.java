package view.Casa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CuartoHijo extends JFrame {

	private JPanel contentPane;
	private JLabel lblPasillo2Piso;
	private JButton btnTV;
	private JLabel lblDestello;

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

	public CuartoHijo() {
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(200, 100, 950, 600);

	    contentPane = new JPanel();
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    String backgroundFile = "img/CuartoHijo.jpeg";
	    ImageIcon originalIcon = new ImageIcon(backgroundFile);
	    Image originalImage = originalIcon.getImage();
	    Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon scaledIcon = new ImageIcon(scaledImage);

	    lblDestello = new JLabel();
	    ImageIcon destelloImagen = new ImageIcon("img/11571045.png");

	    lblDestello.setBounds(10, 282, 99, 50);

	    Image imgDestello = destelloImagen.getImage().getScaledInstance(
	            lblDestello.getWidth(), lblDestello.getHeight(), Image.SCALE_SMOOTH);
	    lblDestello.setIcon(new ImageIcon(imgDestello));

	    contentPane.add(lblDestello);

	    // Crear la imagen de fondo
	    lblPasillo2Piso = new JLabel();
	    lblPasillo2Piso.setBounds(0, 0, 934, 561);
	    lblPasillo2Piso.setIcon(scaledIcon);
	    contentPane.add(lblPasillo2Piso);

	    btnTV = new JButton("");
	    btnTV.setBounds(20, 212, 89, 102);
	    btnTV.setContentAreaFilled(false);
	    btnTV.setBorderPainted(false);
	    btnTV.setFocusPainted(false);
	    lblDestello.setVisible(false);

	    btnTV.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            EventQueue.invokeLater(new Runnable() {
	                public void run() {
	                    try {
	                        TvCuartoHijo frame = new TvCuartoHijo();
	                        frame.setVisible(true);
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
	                }
	            });
	        }
	        @Override
	        public void mouseEntered(MouseEvent e) {
	            lblDestello.setVisible(true);
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            lblDestello.setVisible(false);
	        }
	    });

	    contentPane.add(btnTV);
	}
}
