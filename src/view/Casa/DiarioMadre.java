package view.Casa;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilidades.ImagenLoader;

public class DiarioMadre extends JFrame {

    private JPanel contentPane;
    String ImagenDiario;
    ImagenLoader img = new ImagenLoader();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DiarioMadre frame = new DiarioMadre();
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
    public DiarioMadre() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnVolver.setBounds(51, 506, 89, 23);
        getContentPane().add(btnVolver);
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel lblaparecer2 = new JLabel("New label");
        lblaparecer2.setBounds(526, 300, 46, 14);
        contentPane.add(lblaparecer2);
        lblaparecer2.setVisible(false);
        
        JLabel lblcap2 = new JLabel("New label");
        lblcap2.setBounds(526, 265, 46, 14);
        contentPane.add(lblcap2);
        
        JLabel lblaparecer1 = new JLabel("New label");
        lblaparecer1.setBounds(379, 300, 46, 14);
        contentPane.add(lblaparecer1);
        lblaparecer1.setVisible(false); 
        
        JLabel lblcap1 = new JLabel("New label");
        lblcap1.setBounds(379, 265, 46, 14);
        contentPane.add(lblcap1);
        
        JButton btn1 = new JButton("New button");
        btn1.setBounds(357, 231, 89, 23);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblaparecer1.setVisible(true);
                lblaparecer2.setVisible(true);
                lblcap1.setVisible(false);
                lblcap2.setVisible(false);
            }
        });
        contentPane.add(btn1);
        
        JButton btn2 = new JButton("New button");
        btn2.setBounds(505, 231, 89, 23);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblaparecer1.setVisible(false);
                lblaparecer2.setVisible(false);
                lblcap1.setVisible(true);
                lblcap2.setVisible(true);
            }
        });
        contentPane.add(btn2);
        
        // Imagen de fondo
        JLabel lblDiario = new JLabel();
        lblDiario.setBounds(0, 0, 950, 600);
        contentPane.add(lblDiario);
        ImagenDiario = "/img/diariomesaBano.png";
        lblDiario.setIcon(img.scaleImage(ImagenDiario, 950, 600));
        
        String cod = "=@ qr sroerb qry @=!(";
        //2 de Febrero del 2018
    }
}
