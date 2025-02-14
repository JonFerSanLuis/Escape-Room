package view.Casa;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Inicio.Juego;
import utilidades.Cronometro;
import utilidades.ImagenLoader;

public class DiarioMadre extends JPanel {

    String ImagenDiario;
    ImagenLoader img = new ImagenLoader();

    JTextPane lblaparecer2 = new JTextPane();
    
    JTextPane lblcap2 = new JTextPane();
    
    JTextPane lblaparecer1 = new JTextPane();
    
    JTextPane lblcap1 = new JTextPane();
    
    private JLabel labelTiempo; // Sirve para almacenar el tiempo del cronometro

    public DiarioMadre(Juego juego) {
        setBounds(0, 0, 950, 600);
        setLayout(null);
        
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	juego.cambiarEscena("bano");
            }
        });
        btnVolver.setBounds(51, 506, 89, 23);
        add(btnVolver);
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblaparecer2.setFont(new Font("Tahoma", Font.PLAIN, 8));

        lblaparecer2.setBounds(497, 218, 110, 176);
        lblaparecer2.setForeground(Color.black);
        lblaparecer2.setOpaque(false);
        lblaparecer2.setBackground(new Color(0, 0, 0, 0));
        lblaparecer2.setEditable(false);
        lblaparecer2.setText("Con Juan las cosas van bien. Me gusta cómo ha sabido entrar en nuestra vida sin apresurar nada. No sé qué nos deparará el futuro, pero sé que ahora mismo, aquí y así, me siento feliz. Es bonito tener a alguien con quien compartir, que me vea más allá de \"mamá\" y que aún así ame esa parte de mí. A veces la vida no es perfecta, pero hoy, en este pequeño instante de calma, siento que todo está en su lugar.");
        lblaparecer2.setVisible(false);
        add(lblaparecer2);
        lblaparecer2.setVisible(false);
        lblcap2.setFont(new Font("Tahoma", Font.PLAIN, 8));

        lblcap2.setBounds(497, 218, 110, 170);
        lblcap2.setForeground(Color.black);
        lblcap2.setOpaque(false);
        lblcap2.setBackground(new Color(0, 0, 0, 0));
        lblcap2.setEditable(false);
        lblcap2.setText("Hoy ha sido un día largo, pero lleno de momentos que quiero recordar. A veces siento que el tiempo pasa demasiado rápido… Mi hijo crece cada día, y aunque a veces me vuelva loca con sus travesuras, no hay nada en el mundo que ame más que verlo reír. Es increíble cómo su sonrisa puede borrar cualquier preocupación.");
        lblcap2.setVisible(true);
        add(lblcap2);
        lblaparecer1.setFont(new Font("Tahoma", Font.PLAIN, 8));

        lblaparecer1.setBounds(347, 218, 110, 170);
        lblaparecer1.setForeground(Color.black);
        lblaparecer1.setOpaque(false);
        lblaparecer1.setBackground(new Color(0, 0, 0, 0));
        lblaparecer1.setEditable(false);
        lblaparecer1.setText("Queda aguardando la puerta de la biblioteca en la que se encuentra la más altamente secreta información del descendiente del señor desterrado y privado de sus tesoros, la gran pintura que la matrona le obsequio al pueblo                         <=@ qr sroerb qry @=!(>");
        lblaparecer1.setVisible(false);
        add(lblaparecer1);
        lblaparecer1.setVisible(false); 
        lblcap1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        
        lblcap1.setBounds(347, 218, 110, 170);
        lblcap1.setForeground(Color.black);
        lblcap1.setOpaque(false);
        lblcap1.setBackground(new Color(0, 0, 0, 0));
        lblcap1.setEditable(false);
        lblcap1.setText("Hoy fue uno de esos días en los que me detuve a observar mi vida y sentí una mezcla de amor, cansancio y felicidad. Ser madre no es fácil, pero cada \"te quiero\" de mi hijo hace que todo valga la pena. A veces me preocupa si lo estoy haciendo bien, si le estoy dando todo lo que necesita… pero luego lo veo jugar, reír y abrazarme con tanta fuerza que sé que, de alguna manera, estamos bien.");
        lblcap1.setVisible(true);
        add(lblcap1);
        
        JButton btn1 = new JButton("New button");
        btn1.setBounds(290, 296, 23, 23);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblaparecer1.setVisible(true);
                lblaparecer2.setVisible(true);
                lblcap1.setVisible(false);
                lblcap2.setVisible(false);
            }
        });
        add(btn1);
        
        JButton btn2 = new JButton("New button");
        btn2.setBounds(636, 296, 23, 23);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblaparecer1.setVisible(false);
                lblaparecer2.setVisible(false);
                lblcap1.setVisible(true);
                lblcap2.setVisible(true);
            }
        });
        add(btn2);
        
        // Imagen de fondo
        JLabel lblDiario = new JLabel();
        lblDiario.setBounds(0, 0, 950, 600);
        add(lblDiario);
        ImagenDiario = "/img/diariomesaBano.png";
        lblDiario.setIcon(img.scaleImage(ImagenDiario, 950, 600));
        
     // Cronometro
        labelTiempo = new JLabel(Cronometro.getInstancia().getTiempoFormato());
        labelTiempo.setFont(new Font("Tahoma", Font.BOLD, 18)); // Fuente más grande para mejor visibilidad
        labelTiempo.setForeground(Color.WHITE); // Texto en blanco
        labelTiempo.setBackground(new Color(0, 0, 0)); // Fondo negro semi-transparente
        labelTiempo.setOpaque(true);
        labelTiempo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTiempo.setBounds(10, 10, 102, 30); 
        
     // Agregar primero labelTiempo para asegurarnos de que está al frente
        add(labelTiempo);
        setComponentZOrder(labelTiempo, 0); // Lo pone en la capa superior
        
     // Actualizar la etiqueta cada segundo (formato HH:MM:SS)
        Timer actualizarTimer = new Timer(1000, e -> 
            labelTiempo.setText(Cronometro.getInstancia().getTiempoFormato()));
        actualizarTimer.start();

    }
}
