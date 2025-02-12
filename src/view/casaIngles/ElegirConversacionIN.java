package view.casaIngles;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ElegirConversacionIN extends JFrame {

    private JPanel contentPane;
    private JLabel lblTv; // Background image
    private JLabel lblPhotoConver1;
    private JLabel lblPhotoConver2;
    private JButton btnBack;
    private JButton btnConver1;
    private JButton btnConver2;
    private JButton btnReturn; // New arrow to go to ChildRoom
    private boolean conversationViewed = false; // Flag to check if a conversation has been viewed

    public static void main(String[] args) {
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
    }

    public ElegirConversacionIN() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // --------- BACKGROUND IMAGE ---------
        String backgroundFile = "FotosIngles\\FototelevisionConverINGLES.jpg";
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(950, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // --------- BACK ARROW TO GO TO ChildRoom ---------
        btnReturn = new JButton("");
        btnReturn.setBounds(715, 374, 177, 141);
        ImageIcon iconReturn = new ImageIcon("FotosIngles\\VolverHabitacionINGLES.png");
        btnReturn.setIcon(new ImageIcon(iconReturn.getImage().getScaledInstance(200, 125, Image.SCALE_SMOOTH)));
        btnReturn.setOpaque(false);
        btnReturn.setContentAreaFilled(false);
        btnReturn.setBorderPainted(false);
        btnReturn.setVisible(false);

        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	TvCuartoHijoIN frame = new TvCuartoHijoIN();
            	frame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnReturn);

        lblTv = new JLabel();
        lblTv.setBounds(0, 0, 950, 600);
        lblTv.setIcon(scaledIcon);
        contentPane.add(lblTv);

        // --------- CONVERSATION 1 IMAGE ---------
        lblPhotoConver1 = new JLabel();
        lblPhotoConver1.setBounds(284, 11, 421, 539);
        lblPhotoConver1.setVisible(false);
        ImageIcon imgIcon1 = new ImageIcon("img\\mobileConver1.png");
        lblPhotoConver1.setIcon(new ImageIcon(imgIcon1.getImage().getScaledInstance(421, 539, Image.SCALE_SMOOTH)));
        contentPane.add(lblPhotoConver1);

        // --------- CONVERSATION 2 IMAGE ---------
        lblPhotoConver2 = new JLabel();
        lblPhotoConver2.setBounds(191, -31, 577, 626);
        lblPhotoConver2.setVisible(false);
        ImageIcon imgIcon2 = new ImageIcon("img\\MobileConver2.png");
        lblPhotoConver2.setIcon(new ImageIcon(imgIcon2.getImage().getScaledInstance(577, 626, Image.SCALE_SMOOTH)));
        contentPane.add(lblPhotoConver2);

        // --------- BACK BUTTON (Return to selection) ---------
        btnBack = new JButton("");
        btnBack.setBounds(50, 500, 80, 50);
        ImageIcon iconBack = new ImageIcon("img\\BackArrowTV.png");
        btnBack.setIcon(new ImageIcon(iconBack.getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setVisible(false);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblPhotoConver1.setVisible(false);
                lblPhotoConver2.setVisible(false);
                btnConver1.setVisible(true);
                btnConver2.setVisible(true);
                btnBack.setVisible(false);
                if (conversationViewed) {
                    btnReturn.setVisible(true);
                }
            }
        });
        contentPane.add(btnBack);

        // --------- BUTTON TO OPEN CONVERSATION 1 ---------
        btnConver1 = new JButton("");
        btnConver1.setBounds(259, 190, 208, 141);
        btnConver1.setOpaque(false);
        btnConver1.setContentAreaFilled(false);
        btnConver1.setBorderPainted(false);
        btnConver1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblPhotoConver1.setVisible(true);
                lblPhotoConver2.setVisible(false);
                btnBack.setVisible(true);
                btnConver1.setVisible(false);
                btnConver2.setVisible(false);
                conversationViewed = true;
                btnReturn.setVisible(false);
            }
        });
        contentPane.add(btnConver1);

        // --------- BUTTON TO OPEN CONVERSATION 2 ---------
        btnConver2 = new JButton("");
        btnConver2.setBounds(497, 190, 208, 141);
        btnConver2.setOpaque(false);
        btnConver2.setContentAreaFilled(false);
        btnConver2.setBorderPainted(false);
        btnConver2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblPhotoConver2.setVisible(true);
                lblPhotoConver1.setVisible(false);
                btnBack.setVisible(true);
                btnConver1.setVisible(false);
                btnConver2.setVisible(false);
                conversationViewed = true;
                btnReturn.setVisible(false);
            }
        });
        contentPane.add(btnConver2);

        contentPane.setComponentZOrder(lblTv, contentPane.getComponentCount() - 1);
    }
}
