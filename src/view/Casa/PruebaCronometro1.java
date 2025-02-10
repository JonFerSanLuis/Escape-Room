package view.Casa;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import utilidades.Cronometro;

public class PruebaCronometro1 extends JFrame {
    private JLabel labelTiempo;

    public PruebaCronometro1(String titulo) {
        setTitle(titulo);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        labelTiempo = new JLabel("Tiempo: " + Cronometro.getInstancia().getTiempoFormato());
        add(labelTiempo);

        // Actualizar la etiqueta cada segundo con el formato HH:MM:SS
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText("Tiempo: " + Cronometro.getInstancia().getTiempoFormato()));
        actualizarTimer.start();

        JButton siguienteVentana = new JButton("Siguiente");
        siguienteVentana.addActionListener(e -> {
            this.dispose();
            new PruebaCronometro2("Siguiente Nivel").setVisible(true);
        });

        add(siguienteVentana);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PruebaCronometro1("Escape Room - Inicio").setVisible(true));
    }
}
