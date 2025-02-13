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
import java.util.Random;

public class puzzlePapelera extends JFrame {

    private JPanel contentPane;
    private JLabel pieza1, pieza2, pieza3, pieza4, pieza5, pieza6, pieza7, pieza8, pieza9, pieza10;
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
        btnMostrar.setBounds(10, 10, 150, 70);
        btnMostrar.addActionListener(e -> {
            pieza1.setVisible(true);
            pieza2.setVisible(true);
            pieza3.setVisible(true);
            pieza4.setVisible(true);
            pieza5.setVisible(true);
            pieza6.setVisible(true);
            pieza7.setVisible(true);
            pieza8.setVisible(true);
            pieza9.setVisible(true);
            pieza10.setVisible(true);
        });
        contentPane.add(btnMostrar);
        
        // Crear y agregar las piezas manualmente
        pieza1 = createPieza("Pieza 1");
        pieza2 = createPieza("Pieza 2");
        pieza3 = createPieza("Pieza 3");
        pieza4 = createPieza("Pieza 4");
        pieza5 = createPieza("Pieza 5");
        pieza6 = createPieza("Pieza 6");
        pieza7 = createPieza("Pieza 7");
        pieza8 = createPieza("Pieza 8");
        pieza9 = createPieza("Pieza 9");
        pieza10 = createPieza("Pieza 10");
    }
    
    private JLabel createPieza(String texto) {
        JLabel pieza = new JLabel(texto);
        pieza.setVisible(false);
        pieza.setBorder(new LineBorder(Color.BLACK));
        DragListener dragListener = new DragListener();
        pieza.addMouseListener(dragListener);
        pieza.addMouseMotionListener(dragListener);
        contentPane.add(pieza);

        // Desordenar las posiciones horizontalmente y ponerlas cerca de la parte inferior
        Random rand = new Random();
        int x = 500 - rand.nextInt(200);  // Genera un valor aleatorio para la posición X (ancho de la ventana)
        int y = 400 - rand.nextInt(50);  // Genera un valor aleatorio para la posición Y (parte inferior)
        pieza.setBounds(x, y, 80, 80);

        return pieza;
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


