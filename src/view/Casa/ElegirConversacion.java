package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ElegirConversacion extends JFrame {

	private JPanel contentPane;
	private JLabel lblTv;
	private JTextField textField;
	private JButton btnSubmit;
	private int attemptCount = 0;  // Contador de intentos
	private JButton btnConver2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElegirConversacion frame = new ElegirConversacion();
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
	public ElegirConversacion() {
		setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(200, 100, 950, 600);

	    contentPane = new JPanel();
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    String backgroundFile = "img/Fototelevision -conver.jpg";
	    ImageIcon originalIcon = new ImageIcon(backgroundFile);
	    Image originalImage = originalIcon.getImage();
	    Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon scaledIcon = new ImageIcon(scaledImage);
	    
	    lblTv = new JLabel();
	    lblTv.setBounds(0, 0, 944, 561);
	    lblTv.setIcon(scaledIcon);
	    contentPane.add(lblTv);
	    
	    JButton btnConver1 = new JButton("");
	    btnConver1.setBounds(259, 190, 208, 141);
	    contentPane.add(btnConver1);
	    
	    btnConver2 = new JButton("");
	    btnConver2.setBounds(497, 190, 208, 141);
	    contentPane.add(btnConver2);

	}
}
