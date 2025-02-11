package view.Casa;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ElegirConversacion extends JFrame {

    private JPanel contentPane;
    private JLabel lblTv; // Imagen de fondo
    private JLabel lblfotoconver1;
    private JLabel lblfotoconver2;
    private JButton btnVolver;
    private JButton btnConver1;
    private JButton btnConver2;
    private JButton btnAtras; // Nueva flecha para ir a CuartoHijo
    private boolean conversacionVista = false; // Bandera para saber si ya vieron una conversación

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

        // --------- IMAGEN DE FONDO ---------
        String backgroundFile = "img/Fototelevision -conver.jpg";
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(950, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
                // --------- FLECHA ATRÁS PARA IR A CuartoHijo ---------
                btnAtras = new JButton("");
                btnAtras.setBounds(715, 374, 177, 141);
                ImageIcon iconAtras = new ImageIcon("img\\VolverHabitacion.png");
                btnAtras.setIcon(new ImageIcon(iconAtras.getImage().getScaledInstance(200, 125, Image.SCALE_SMOOTH)));
                btnAtras.setOpaque(false);
                btnAtras.setContentAreaFilled(false);
                btnAtras.setBorderPainted(false);
                btnAtras.setVisible(false);
                
                        btnAtras.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CuartoHijo frame = new CuartoHijo();
                                frame.setVisible(true);
                                dispose(); 
                            }
                        });
                        contentPane.add(btnAtras);

        lblTv = new JLabel();
        lblTv.setBounds(0, 0, 950, 600);
        lblTv.setIcon(scaledIcon);
        contentPane.add(lblTv);

        // --------- IMAGEN DE LA CONVERSACIÓN 1 ---------
        lblfotoconver1 = new JLabel();
        lblfotoconver1.setBounds(284, 11, 421, 539);
        lblfotoconver1.setVisible(false);
        ImageIcon imgIcon1 = new ImageIcon("img\\movilconver1 (1).png");
        lblfotoconver1.setIcon(new ImageIcon(imgIcon1.getImage().getScaledInstance(421, 539, Image.SCALE_SMOOTH)));
        contentPane.add(lblfotoconver1);

        // --------- IMAGEN DE LA CONVERSACIÓN 2 ---------
        lblfotoconver2 = new JLabel();
        lblfotoconver2.setBounds(191, -31, 577, 626);
        lblfotoconver2.setVisible(false);
        ImageIcon imgIcon2 = new ImageIcon("img\\MovilConver2.png");
        lblfotoconver2.setIcon(new ImageIcon(imgIcon2.getImage().getScaledInstance(577, 626, Image.SCALE_SMOOTH)));
        contentPane.add(lblfotoconver2);

        // --------- BOTÓN VOLVER (Regresar a selección) ---------
        btnVolver = new JButton("");
        btnVolver.setBounds(50, 500, 80, 50);
        ImageIcon iconVolver = new ImageIcon("img\\FlechaAtrasTV.png");
        btnVolver.setIcon(new ImageIcon(iconVolver.getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
        btnVolver.setOpaque(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setVisible(false); // Se oculta inicialmente

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Oculta las imágenes de las conversaciones
                lblfotoconver1.setVisible(false);
                lblfotoconver2.setVisible(false);
                // Muestra nuevamente las opciones de conversación
                btnConver1.setVisible(true);
                btnConver2.setVisible(true);
                // Oculta el botón "Volver"
                btnVolver.setVisible(false);
                // Si ya vio al menos una conversación, mostrar la flecha atrás
                if (conversacionVista) {
                    btnAtras.setVisible(true);
                }
            }
        });
        contentPane.add(btnVolver);

        // --------- BOTÓN PARA ABRIR CONVERSACIÓN 1 ---------
        btnConver1 = new JButton("");
        btnConver1.setBounds(259, 190, 208, 141);
        btnConver1.setOpaque(false);
        btnConver1.setContentAreaFilled(false);
        btnConver1.setBorderPainted(false);
        btnConver1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblfotoconver1.setVisible(true);
                lblfotoconver2.setVisible(false);
                btnVolver.setVisible(true);
                // Oculta los botones de selección de conversación
                btnConver1.setVisible(false);
                btnConver2.setVisible(false);
                // Marca que el usuario ya vio una conversación
                conversacionVista = true;
                // Oculta la flecha de "Atras" mientras ve una conversación
                btnAtras.setVisible(false);
            }
        });
        contentPane.add(btnConver1);

        // --------- BOTÓN PARA ABRIR CONVERSACIÓN 2 ---------
        btnConver2 = new JButton("");
        btnConver2.setBounds(497, 190, 208, 141);
        btnConver2.setOpaque(false);
        btnConver2.setContentAreaFilled(false);
        btnConver2.setBorderPainted(false);
        btnConver2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblfotoconver2.setVisible(true);
                lblfotoconver1.setVisible(false);
                btnVolver.setVisible(true);
                // Oculta los botones de selección de conversación
                btnConver1.setVisible(false);
                btnConver2.setVisible(false);
                // Marca que el usuario ya vio una conversación
                conversacionVista = true;
                // Oculta la flecha de "Atras" mientras ve una conversación
                btnAtras.setVisible(false);
            }
        });
        contentPane.add(btnConver2);

        contentPane.setComponentZOrder(lblTv, contentPane.getComponentCount() - 1);
    }
}
