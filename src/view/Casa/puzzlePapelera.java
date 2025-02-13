package view.Casa;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class puzzlePapelera extends JFrame {

    private JPanel contentPane;
    private JLabel[] piezas = new JLabel[10];
    private Point mouseOffset;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    puzzlePapelera frame = new puzzlePapelera();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public puzzlePapelera() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Botón para mostrar los labels
        JButton btnMostrar = new JButton("Mostrar Piezas");
        btnMostrar.setBounds(10, 10, 150, 30);
        btnMostrar.addActionListener(e -> {
            for (JLabel pieza : piezas) {
                pieza.setVisible(true);
            }
        });
        contentPane.add(btnMostrar);
        
        // Crear y agregar las piezas
        for (int i = 0; i < piezas.length; i++) {
            piezas[i] = new JLabel("Pieza " + (i + 1));
            piezas[i].setBounds(50 + (i * 60), 100, 80, 30); // Posición inicial
            piezas[i].setVisible(false); // Invisibles al inicio
            piezas[i].setBorder(new LineBorder(Color.BLACK));
            DragListener dragListener = new DragListener();
            piezas[i].addMouseListener(dragListener);
            piezas[i].addMouseMotionListener(dragListener);
            contentPane.add(piezas[i]);
        }
    }
    
    private class DragListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            mouseOffset = new Point(e.getPoint());
        }

        public void mouseDragged(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            Point newLocation = label.getLocation();
            newLocation.translate(e.getX() - mouseOffset.x, e.getY() - mouseOffset.y);
            label.setLocation(newLocation);
        }
    }
} 
