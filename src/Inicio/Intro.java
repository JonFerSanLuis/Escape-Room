package Inicio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.*;
import config.Config;
import utilidades.ImagenLoader;

public class Intro extends JPanel {

    private JLabel IntroLabel;
    private int txt;
    private String IntroBackground;
    private ArrayList<JTextPane> TxtIntro;
    
    ImagenLoader img = new ImagenLoader();

    public Intro(Juego juego) {
        setLayout(null);
        setBounds(0, 0, 950, 600);
        setBackground(Color.BLACK);

        IntroBackground = "/img/Generate_a_scene_of_two_young__(2)_Nero_AI_Anime_Face_(1)_(1)-transformed (1).png";

        TxtIntro = new ArrayList<>();
        txt = 0;

        // Array de textos cogidos de la clase Config
        String[] textos = {
            Config.getTexto("1"),
            Config.getTexto("2"),
            Config.getTexto("3"),
            Config.getTexto("4"),
            Config.getTexto("5"),
            Config.getTexto("6"),
            Config.getTexto("7"),
            Config.getTexto("8"),
            Config.getTexto("9"),
            Config.getTexto("10"),
            Config.getTexto("11"),
            Config.getTexto("12")
        };

        // Crear JTextPane para cada texto
        for (int i = 0; i < textos.length; i++) {
            JTextPane historia = new JTextPane();
            historia.setForeground(Color.WHITE);
            historia.setOpaque(false);
            historia.setBackground(new Color(0, 0, 0, 0));
            historia.setFont(new Font("Tahoma", Font.PLAIN, 15));
            historia.setEditable(false);
            historia.setText(textos[i]);
            historia.setBounds(48, 538, 855, 58);
            historia.setVisible(i == 0);
            add(historia);
            TxtIntro.add(historia);
        }

        JButton btnContinue = new JButton(Config.getTexto("btnContinuar"));  // Usamos el texto para el botón
        btnContinue.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnContinue.setBounds(819, 468, 115, 23);
        btnContinue.setBackground(new Color(0, 0, 0, 0));
        btnContinue.setOpaque(false);
        btnContinue.setBorderPainted(false);
        btnContinue.setContentAreaFilled(false);
        btnContinue.setForeground(Color.GRAY);

        btnContinue.addActionListener(e -> {
            if (txt == TxtIntro.size() - 1) {
                juego.cambiarEscena("casaExterior");
                txt = 0;
            } else {
                TxtIntro.get(txt).setVisible(false);
                TxtIntro.get(++txt).setVisible(true);
            }

            cambiarFondo();
        });

        btnContinue.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnContinue.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnContinue.setForeground(Color.GRAY);
            }
        });

        add(btnContinue);

        IntroLabel = new JLabel();
        IntroLabel.setBounds(0, 0, 950, 600);
        IntroLabel.setIcon(img.scaleImage(IntroBackground, 950, 600));
        add(IntroLabel);
    }

    private void cambiarFondo() {
        String[] fondos = {"/img/confesion.jpg", "/img/Por qué.png", "/img/pixelcut-export (1).png", ""};
        if (txt == 2 || txt == 5 || txt == 7 || txt == 8) {
            IntroBackground = fondos[(txt == 2) ? 0 : (txt == 5) ? 1 : (txt == 7) ? 2 : 3];
            IntroLabel.setIcon(img.scaleImage(IntroBackground, 950, 600));
            IntroLabel.repaint();
        }
    }

}
