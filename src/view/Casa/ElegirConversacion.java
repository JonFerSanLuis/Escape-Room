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
    private int attemptCount = 0;
    private JButton btnConver2;
    private JLabel lblfotoconver1;
    private JLabel lblfotoconver2;
    private JButton btnVolver;

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

        lblfotoconver1 = new JLabel();
        lblfotoconver1.setBounds(332, 72, 309, 389);
        String imgPath = "img\\movilconver1 (1).png";
        ImageIcon imgIcon = new ImageIcon(imgPath);
        lblfotoconver1.setVisible(false);
        Image img = imgIcon.getImage().getScaledInstance(lblfotoconver1.getWidth(), lblfotoconver1.getHeight(), Image.SCALE_SMOOTH);
        
                // Botón de volver
                btnVolver = new JButton("");
                btnVolver.setBounds(50, 500, 80, 50);
                ImageIcon iconVolver = new ImageIcon("img\\FlechaAtrasTV.png");
                Image imgVolver = iconVolver.getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
                btnVolver.setIcon(new ImageIcon(imgVolver));
                btnVolver.setVisible(false);
                btnVolver.setOpaque(false);
                btnVolver.setContentAreaFilled(false);
                btnVolver.setBorderPainted(false);
                btnVolver.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        lblfotoconver1.setVisible(false);
                        lblfotoconver2.setVisible(false);
                        btnVolver.setVisible(false);
                    }
                });
                
                        contentPane.add(btnVolver);
        lblfotoconver1.setIcon(new ImageIcon(img));
        contentPane.add(lblfotoconver1);

        String imgPath2 = "img\\MovilConver2.png";
        ImageIcon imgIcon2 = new ImageIcon(imgPath2);

        lblfotoconver2 = new JLabel();
        lblfotoconver2.setBounds(298, 33, 395, 485);
        lblfotoconver2.setVisible(false);
        Image img2 = imgIcon2.getImage().getScaledInstance(lblfotoconver2.getWidth(), lblfotoconver2.getHeight(), Image.SCALE_SMOOTH);
        lblfotoconver2.setIcon(new ImageIcon(img2));
        contentPane.add(lblfotoconver2);

        lblTv = new JLabel();
        lblTv.setBounds(0, 0, 944, 561);
        lblTv.setIcon(scaledIcon);
        contentPane.add(lblTv);

        btnConver2 = new JButton("");
        btnConver2.setBounds(497, 190, 208, 141);
        contentPane.add(btnConver2);
        btnConver2.setOpaque(false);
        btnConver2.setContentAreaFilled(false);
        btnConver2.setBorderPainted(false);
        btnConver2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblfotoconver2.setVisible(true);
                btnVolver.setVisible(true);
            }
        });

        JButton btnConver1 = new JButton("");
        btnConver1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblfotoconver1.setVisible(true);
                btnVolver.setVisible(true);
            }
        });

        btnConver1.setBounds(259, 190, 208, 141);
        contentPane.add(btnConver1);
        btnConver1.setOpaque(false);
        btnConver1.setContentAreaFilled(false);
        btnConver1.setBorderPainted(false);
    }
}
