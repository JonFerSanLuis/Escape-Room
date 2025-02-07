package utilidades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro {
    private static Cronometro instancia; // Singleton
    private int segundos;
    private Timer timer;

    private Cronometro() {
        segundos = 0;
        timer = new Timer(1000, new ActionListener() { // Cada 1000ms (1s)
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
            }
        });
        timer.start();
    }

    // Método para obtener la instancia única
    public static Cronometro getInstancia() {
        if (instancia == null) {
            instancia = new Cronometro();
        }
        return instancia;
    }

    public int getSegundos() {
        return segundos;
    }
}


	/*
    private static final int horaEnSegundos = 3600; // Tiempo inicial en segundos
    private static Cronometro instanciaUnicaCronometro; // Instancia única del cronómetro
    private JLabel labelTiempo; // Variable para almacenar el JLabel donde se mostrará el tiempo

    // Constructor privado para evitar la creación de instancias externas
    private Cronometro() {
    }

    // Método para obtener la instancia única del cronómetro
    public static Cronometro getInstance() {
        if (instanciaUnicaCronometro == null) {
            instanciaUnicaCronometro = new Cronometro(); // Crear la instancia si no existe
        }
        return instanciaUnicaCronometro;
    }

    // Método para asignar el JLabel donde se mostrará el tiempo
    public void asignarLabel(JLabel label) {
        this.labelTiempo = label;
    }

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

        // Obtener la instancia única del cronómetro
        Cronometro cronometro = Cronometro.getInstance();
        cronometro.asignarLabel(temporizador); // Asignamos el JLabel al cronómetro

        // Iniciar la cuenta atrás
        cronometro.startCountdown(horaEnSegundos); // Empezar la cuenta atrás con la duración inicial
    }

    // Método para iniciar la cuenta atrás y actualizar el JLabel cada segundo
    public void startCountdown(int seconds) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int remainingSeconds = seconds;

            @Override
            public void run() {
                if (remainingSeconds <= 0) {
                    timer.cancel();
                    if (labelTiempo != null) {
                        labelTiempo.setText("¡Tiempo terminado!"); // Mostrar mensaje al terminar
                    }
                } else {
                    remainingSeconds--;
                    if (labelTiempo != null) {
                        labelTiempo.setText(formatTime(remainingSeconds)); // Actualizar el tiempo
                    }
                }
            }
        }, 0, 1000); // Actualización cada segundo
    }

    // Formatear el tiempo de segundos a formato HH:MM:SS
    private String formatTime(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds); // Formato HH:MM:SS
    }
}
*/
