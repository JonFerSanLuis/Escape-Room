package utilidades;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Cronometro {
    private static final int horaEnSegundos = 3600; // Tiempo inicial en segundos

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Cronometro::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Configuración del JFrame
        JFrame frame = new JFrame("Cuenta atrás");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200); // Tamaño de la ventana
        frame.setLayout(new BorderLayout());

        // Configuración del fondo del JFrame
        frame.getContentPane().setBackground(Color.WHITE); // Fondo blanco para contraste

        // Etiqueta para mostrar el tiempo restante
        JLabel temporizador = new JLabel("01:00:00", SwingConstants.CENTER); // Texto inicial
        temporizador.setFont(new Font("Arial", Font.BOLD, 40)); // Fuente y tamaño
        temporizador.setForeground(Color.BLACK); // Color del texto negro
        frame.add(temporizador, BorderLayout.CENTER);

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Iniciar la cuenta atrás
        startCountdown(temporizador, horaEnSegundos);
    }

    private static void startCountdown(JLabel timerLabel, int seconds) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int remainingSeconds = seconds;

            @Override
            public void run() {
                if (remainingSeconds <= 0) {
                    timer.cancel();
                    timerLabel.setText("¡Tiempo terminado!"); // Mostrar mensaje al terminar
                } else {
                    remainingSeconds--;
                    timerLabel.setText(formatTime(remainingSeconds)); // Actualizar el tiempo
                }
            }
        }, 0, 1000); // Actualización cada segundo
    }

    private static String formatTime(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds); // Formato HH:MM:SS
    }
}
