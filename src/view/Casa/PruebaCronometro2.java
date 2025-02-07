package view.Casa;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import utilidades.Cronometro;

public class PruebaCronometro2 extends JFrame {
    private JLabel labelTiempo;

    public PruebaCronometro2(String titulo) {
        setTitle(titulo);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new FlowLayout());

        labelTiempo = new JLabel("Tiempo: " + Cronometro.getInstancia().getSegundos() + " s");
        getContentPane().add(labelTiempo);

        // Actualizar el tiempo cada segundo
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText("Tiempo: " + Cronometro.getInstancia().getSegundos() + " s"));
        actualizarTimer.start();

        JButton volverVentana = new JButton("Volver");
        volverVentana.addActionListener(e -> {
            this.dispose();  // Cerrar ventana actual
            new PruebaCronometro1("Volver al Nivel Anterior").setVisible(true);
        });

        getContentPane().add(volverVentana);
        
        JLabel lblNewLabel = new JLabel("VENTANA 2");
        getContentPane().add(lblNewLabel);
    }
}
