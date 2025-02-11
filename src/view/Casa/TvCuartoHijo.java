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

public class TvCuartoHijo extends JFrame {

	private JPanel contentPane;
	private JLabel lblTv;
	private JTextField textField;
	private JButton btnSubmit;
	private int attemptCount = 0;  // Contador de intentos

	// La contraseña correcta
	private final String correctPassword = "acoso";
	
	// Pistas
	private final String[] clues = {
		"La contraseña tiene 5 letras.",
		"Es una palabra en español.",
		"La primera letra es 'a'.",
		"La contraseña es algo que ocurre cuando alguien se comporta de manera inapropiada."
	};

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
	    
	    // Crear el JLabel y asignar la imagen redimensionada
        ImageIcon flechaIcon = new ImageIcon("img\\botonenter.png");

	    
	    JLabel btnenter = new JLabel("");
        Image flechaImage = flechaIcon.getImage().getScaledInstance(150, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledFlechaIcon = new ImageIcon(flechaImage);
        btnenter.setIcon(scaledFlechaIcon);
	    
        btnenter.setBounds(390, 298, 160, 88);  // Establecer el mismo tamaño que el botón
	    contentPane.add(btnenter);
	    
	    JLabel lblPosit = new JLabel("");
	    lblPosit.setIcon(new ImageIcon("img\\PositTv.png"));
	    lblPosit.setBounds(-114, 54, 430, 217);
	    contentPane.add(lblPosit);
	    
	    lblTv = new JLabel();
	    lblTv.setBounds(0, 0, 944, 561);
	    lblTv.setIcon(scaledIcon);
	    contentPane.add(lblTv);
	    
	    textField = new JTextField();
	    textField.setBounds(358, 254, 208, 33);
	    contentPane.add(textField);
	    textField.setColumns(10);
        Color backgroundColor = new Color(209, 238, 253);
        textField.setBackground(backgroundColor);
        textField.setForeground(Color.BLACK);
        textField.setBorder(new LineBorder(backgroundColor, 2)); 
        
        btnSubmit = new JButton("");
        btnSubmit.setBounds(379, 298, 171, 100);  
        contentPane.add(btnSubmit);
        btnSubmit.setOpaque(false);
        btnSubmit.setContentAreaFilled(false);
        btnSubmit.setBorderPainted(false);
                
                btnSubmit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String userInput = textField.getText().trim().toLowerCase();
                        
                        if (userInput.equals(correctPassword)) {
                    		EventQueue.invokeLater(new Runnable() {
                    			public void run() {
                    				try {
                    					ElegirConversacion frame = new ElegirConversacion();
                    					frame.setVisible(true);
                    				} catch (Exception e) {
                    					e.printStackTrace();
                    				}
                    			}
                    		});                        } else {
                            attemptCount++;
                            if (attemptCount < clues.length) {
                                JOptionPane.showMessageDialog(null, "¡Contraseña incorrecta! Pista: " + clues[attemptCount]);
                            } else {
                                JOptionPane.showMessageDialog(null, "¡Contraseña incorrecta! Ya no hay más pistas.");
                            }
                        }
                    }
                }); 
	}
}
