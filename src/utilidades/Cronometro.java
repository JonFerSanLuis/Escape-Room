package utilidades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro {
    private static Cronometro instancia;
    private int segundos;
    private Timer timer;
    private Runnable onFinish; // Acción a ejecutar al finalizar

    private Cronometro() {
        segundos = 3600; // 1 hora en segundos (1:00:00)
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (segundos > 0) {
                    segundos--; // Reducir tiempo
                } else {
                    timer.stop(); // Detener cronómetro
                    if (onFinish != null) {
                        onFinish.run(); // Ejecutar acción cuando llega a 0
                    }
                }
            }
        });
        timer.start();
    }

    public static Cronometro getInstancia() {
        if (instancia == null) {
            instancia = new Cronometro();
        }
        return instancia;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setOnFinish(Runnable onFinish) {
        this.onFinish = onFinish;
    }

    public String getTiempoFormato() {
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int segundosRestantes = segundos % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundosRestantes);
    }
}
