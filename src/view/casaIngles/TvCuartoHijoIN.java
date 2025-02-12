package view.casaIngles;

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

public class TvCuartoHijoIN extends JFrame {

    private JPanel contentPane;
    private JLabel lblTv;
    private JTextField textField;
    private JButton btnSubmit;
    private int attemptCount = 0;

    private final String correctPassword = "harassment";
    
    private final String[] clues = {
        "The password has 5 letters.",
        "It is a word in English.",
        "The first letter is 'h'.",
        "The password refers to inappropriate behavior towards someone."
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TvCuartoHijoIN frame = new TvCuartoHijoIN();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TvCuartoHijoIN() {
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
        
        ImageIcon arrowIcon = new ImageIcon("img\\botonenter.png");

        JLabel btnEnter = new JLabel("");
        Image arrowImage = arrowIcon.getImage().getScaledInstance(150, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledArrowIcon = new ImageIcon(arrowImage);
        btnEnter.setIcon(scaledArrowIcon);
        
        btnEnter.setBounds(390, 298, 160, 88);
        contentPane.add(btnEnter);
        
        JLabel lblNote = new JLabel("");
        lblNote.setIcon(new ImageIcon("img\\PositTv.png"));
        lblNote.setBounds(-114, 54, 430, 217);
        contentPane.add(lblNote);
        
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
                                ElegirConversacionIN frame = new ElegirConversacionIN();
                                frame.setVisible(true);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    attemptCount++;
                    if (attemptCount < clues.length) {
                        JOptionPane.showMessageDialog(null, "Incorrect password! Hint: " + clues[attemptCount]);
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect password! No more hints available.");
                    }
                }
            }
        }); 
    }
}
