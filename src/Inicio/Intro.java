package Inicio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import view.Casa.CasaExterior;

public class Intro extends JPanel {

    private JLabel IntroLabel;
    private int txt;
    private String IntroBackground;
    private ArrayList<JTextPane> TxtIntro;

    public Intro(Juego juego) {
        setLayout(null);
        setBounds(0, 0, 950, 600);
        setBackground(Color.BLACK);

        IntroBackground = "img/Generate_a_scene_of_two_young__(2)_Nero_AI_Anime_Face_(1)_(1)-transformed (1).png";
        ImageIcon scaledIcon = loadImage(IntroBackground);

        TxtIntro = new ArrayList<>();
        txt = 0;

        String[] textos = {
            "Me llamo Yuri, soy una estudiante de secundaria y mi mejor amigo sufre BULLYING.",
            "Me di cuenta mientras charlábamos en el parque. Me confesó que dentro de poco se iba a mudar bastante lejos y se puso sentimental.",
            "Entonces comentó que al menos esperaba no tener que lidiar con 'gente así' en su futuro hogar.",
            "Agregarle a eso que no era la primera vez que lo veía con moratones.",
            "Tanto silencio me hizo pensar y darme cuenta de lo despistada que fui.",
            "La sorpresa me hizo enfadarme sin razón y comenzar a levantar la voz.",
            "'¡Por qué no me dijiste nada!' Le grité, cegada por la impotencia.",
            "Tuvimos una fuerte discusión por culpa de mi falta de tacto. Y por alguna razón no dejaba de echarle la culpa a él.",
            "Si tan solo hubiera sido un poco más considerada y atenta...",
            "Hace unos días, Mikel se escapó de casa.",
            "No soporto pensar que tengo parte de culpa.",
            "TENGO QUE ENCONTRARLE"
        };

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

        JButton btnContinue = new JButton("CONTINUAR");
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
        IntroLabel.setIcon(scaledIcon);
        add(IntroLabel);
    }

    private void cambiarFondo() {
        String[] fondos = {"img/confesion.jpg", "img/Por qué.png", "img/pixelcut-export (1).png", ""};
        if (txt == 2 || txt == 5 || txt == 7 || txt == 8) {
            IntroBackground = fondos[(txt == 2) ? 0 : (txt == 5) ? 1 : (txt == 7) ? 2 : 3];
            IntroLabel.setIcon(loadImage(IntroBackground));
            IntroLabel.repaint();
        }
    }

    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(950, 600, Image.SCALE_SMOOTH));
    }
}

