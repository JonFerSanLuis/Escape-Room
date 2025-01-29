package acertijos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Acertijo2 extends JFrame {

    public Acertijo2() {
        // Configuraci�n b�sica del JFrame
        setTitle("AcertijoImagen");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Ruta completa de la imagen
        String imagePath = "D:\\Josu�\\Reto2\\ImagenesESR\\Acertijo.png";

        // Cargar la imagen
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image scaledImage = imageIcon.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH); // Redimensionar
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Crear un JLabel con la imagen
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, 600, 300);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(imageLabel);

        // Etiqueta de instrucciones
        JLabel instructionLabel = new JLabel("Introduce la combinaci�n (Debe estar en MAY�SCULAS):");
        instructionLabel.setBounds(50, 310, 500, 20);
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        getContentPane().add(instructionLabel);

        // Campo de texto para la combinaci�n
        JTextField textField = new JTextField();
        textField.setBounds(50, 340, 400, 30);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        getContentPane().add(textField);

        // Bot�n de verificaci�n
        JButton verifyButton = new JButton("Verificar");
        verifyButton.setBounds(460, 340, 100, 30);
        verifyButton.setFont(new Font("Arial", Font.BOLD, 14));
        getContentPane().add(verifyButton);

        // Etiqueta para retroalimentaci�n
        JLabel feedbackLabel = new JLabel("");
        feedbackLabel.setBounds(50, 380, 500, 20);
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 14));
        getContentPane().add(feedbackLabel);

        // Acci�n del bot�n
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = textField.getText().trim(); // Obtener texto del campo
                if (userInput.equals("PROMETHEUS")) { // Validaci�n
                    feedbackLabel.setText("�Correcto! La combinaci�n es PROMETHEUS.");
                    feedbackLabel.setForeground(Color.BLUE);
                } else {
                    feedbackLabel.setText("Incorrecto. Vuelve a intentarlo.");
                    feedbackLabel.setForeground(Color.RED);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Acertijo2();
    }
}
