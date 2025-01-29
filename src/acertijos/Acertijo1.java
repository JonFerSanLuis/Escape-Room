package acertijos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Acertijo1 extends JFrame {
    public Acertijo1() {
        // Configuración básica de la ventana
        setTitle("Escape Room - Desafío Matemático");
        setSize(455, 161);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel();

        // Mensaje inicial del acertijo
        JLabel questionLabel = new JLabel(
                "Tu acosador te envió 3 mensajes cada hora durante 4 horas.",
                SwingConstants.CENTER);
        questionLabel.setBounds(0, 0, 444, 27);
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        // Campo de texto para la respuesta
        JTextField answerField = new JTextField();
        answerField.setBounds(10, 38, 36, 27);
        answerField.setFont(new Font("Arial", Font.PLAIN, 16));

        // Botón para enviar respuesta
        JButton submitButton = new JButton("Enviar");
        submitButton.setBounds(10, 76, 89, 27);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Etiqueta para retroalimentación
        JLabel feedbackLabel = new JLabel("", SwingConstants.CENTER);
        feedbackLabel.setBounds(101, 76, 328, 27);
        feedbackLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        feedbackLabel.setForeground(Color.RED);

        // Acción del botón
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userAnswer = answerField.getText().trim();

                if (userAnswer.equals("12")) { // Respuesta correcta
                    feedbackLabel.setText("¡Correcto! Has bloqueado 12 mensajes.");
                    feedbackLabel.setForeground(Color.blue);
                } else {
                    feedbackLabel.setText("Incorrecto. Revisa cuántos mensajes hay por hora.");
                    feedbackLabel.setForeground(Color.RED);
                }
            }
        });
        mainPanel.setLayout(null);

        // Diseño del panel
        mainPanel.add(questionLabel);
        mainPanel.add(answerField);
        mainPanel.add(submitButton);
        mainPanel.add(feedbackLabel);

        // Añadir panel a la ventana
        getContentPane().add(mainPanel);
        
        JLabel lblNewLabel = new JLabel("¿Cuantos mensajes deberas bloquear?");
        lblNewLabel.setBounds(56, 38, 228, 27);
        mainPanel.add(lblNewLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Acertijo1();
    }
}
