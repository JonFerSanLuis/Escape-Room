package view.Casa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TvCuartoHijo extends JFrame {

	private JPanel contentPane;
	private JLabel lblTv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public TvCuartoHijo() {
		setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(200, 100, 950, 600);

	    contentPane = new JPanel();
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    String backgroundFile = "img/Fototelevision.png";
	    ImageIcon originalIcon = new ImageIcon(backgroundFile);
	    Image originalImage = originalIcon.getImage();
	    Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon scaledIcon = new ImageIcon(scaledImage);
	    
	    lblTv = new JLabel();
	    lblTv.setBounds(0, 0, 934, 561);
	    lblTv.setIcon(scaledIcon);
	    contentPane.add(lblTv);
	}

}
