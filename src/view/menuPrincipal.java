package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menuPrincipal extends JFrame {

    private int segundos = 3600; // 1 hora en segundos (3600 segundos)
    private JLabel labelCronometro;

    public menuPrincipal() {
        // Configuraci�n b�sica del JFrame
        setTitle("Escape Room - Men� Principal");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Pantalla completa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Crear el panel principal con fondo
        JPanel panelPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar y dibujar la imagen de fondo
                ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/img/image.jpg"));
                Image imagen = imagenFondo.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelPrincipal.setLayout(new GridBagLayout()); // Usar GridBagLayout para centrar todo

        // Crear un sub-panel para organizar t�tulo y botones
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setOpaque(false); // Hacer el sub-panel transparente

        // T�tulo del men�
        JLabel titulo = new JLabel("Escape Room");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 50)); // Fuente m�s grande
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));

        // Obtener el ancho del t�tulo para ajustar los botones
        titulo.setSize(titulo.getPreferredSize());
        int anchoTitulo = titulo.getWidth();

        // Botones estilizados
        JButton btnJugar = crearBoton("Jugar", anchoTitulo);
        JButton btnInfo = crearBoton("M�s Informaci�n", anchoTitulo);
        JButton btnRanking = crearBoton("Ranking", anchoTitulo);

        // Espaciado entre botones
        int espaciado = 30;
        subPanel.add(titulo);
        subPanel.add(Box.createVerticalStrut(espaciado));
        subPanel.add(btnJugar);
        subPanel.add(Box.createVerticalStrut(espaciado));
        subPanel.add(btnInfo);
        subPanel.add(Box.createVerticalStrut(espaciado));
        subPanel.add(btnRanking);

        // A�adir el cron�metro
        labelCronometro = new JLabel("01:00:00");
        labelCronometro.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelCronometro.setFont(new Font("SansSerif", Font.BOLD, 30));
        labelCronometro.setForeground(Color.BLACK); // Cambiar el color del texto a negro
        subPanel.add(Box.createVerticalStrut(50)); // Espacio antes del cron�metro
        subPanel.add(labelCronometro);

        // A�adir el sub-panel al panel principal
        panelPrincipal.add(subPanel);

        // A�adir el panel principal al JFrame
        getContentPane().add(panelPrincipal);

        // Iniciar el cron�metro
        iniciarCronometro();
    }

    private void iniciarCronometro() {
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            if (segundos > 0) {
                segundos--;
                int horas = segundos / 3600;
                int minutos = (segundos % 3600) / 60;
                int segundosRestantes = segundos % 60;
                labelCronometro.setText(String.format("%02d:%02d:%02d", horas, minutos, segundosRestantes));
            } else {
                ((Timer) e.getSource()).stop(); // Detener el cron�metro al llegar a 00:00
                labelCronometro.setText("�Tiempo terminado!");
            }
        });
        timer.start(); // Iniciar el temporizador
    }

    private JButton crearBoton(String texto, int anchoTitulo) {
        JButton boton = new JButton(texto);
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Cuando se haga clic en el bot�n "Jugar", se inicia la clase Recibidor
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            // Crear y mostrar la ventana Recibidor
                            Recibidor frame = new Recibidor();
                            frame.setVisible(true);

                            // Ocultar el men� principal al abrir Recibidor
                            setVisible(false); 
                            dispose(); // Liberar recursos de la ventana actual
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setFont(new Font("SansSerif", Font.BOLD, 24)); // Fuente m�s grande para los botones
        boton.setBackground(new Color(52, 152, 219)); // Azul claro
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setMaximumSize(new Dimension(anchoTitulo, 60)); // Ancho igual al del t�tulo
        boton.setPreferredSize(new Dimension(anchoTitulo, 60)); // Ajustar tama�o preferido
        return boton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            menuPrincipal menu = new menuPrincipal();
            menu.setVisible(true);
        });
    }
}
