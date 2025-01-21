package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuPrincipal extends JFrame {

    public menuPrincipal() {
        // Configuración básica del JFrame
        setTitle("Escape Room - Menú Principal");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Pantalla completa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Crear el panel principal con fondo
        JPanel panelPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Fondo degradado
                Graphics2D g2d = (Graphics2D) g;
                Color colorInicio = new Color(33, 37, 41);
                Color colorFin = new Color(100, 110, 120);
                GradientPaint gradiente = new GradientPaint(0, 0, colorInicio, 0, getHeight(), colorFin);
                g2d.setPaint(gradiente);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelPrincipal.setLayout(new GridBagLayout()); // Usar GridBagLayout para centrar todo

        // Crear un sub-panel para organizar título y botones
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setOpaque(false); // Hacer el sub-panel transparente

        // Título del menú
        JLabel titulo = new JLabel("Escape Room");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 50)); // Fuente más grande
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));

        // Obtener el ancho del título para ajustar los botones
        titulo.setSize(titulo.getPreferredSize());
        int anchoTitulo = titulo.getWidth();

        // Botones estilizados
        JButton btnJugar = crearBoton("Jugar", anchoTitulo);
        JButton btnInfo = crearBoton("Más Información", anchoTitulo);
        JButton btnRanking = crearBoton("Ranking", anchoTitulo);

        // Añadir acción a los botones
        btnJugar.addActionListener(e -> JOptionPane.showMessageDialog(this, "¡Comenzando el juego!"));
        btnInfo.addActionListener(e -> JOptionPane.showMessageDialog(this, "Información del Escape Room..."));
        btnRanking.addActionListener(e -> JOptionPane.showMessageDialog(this, "Ranking de jugadores..."));

        // Espaciado entre botones
        int espaciado = 30;
        subPanel.add(titulo);
        subPanel.add(Box.createVerticalStrut(espaciado));
        subPanel.add(btnJugar);
        subPanel.add(Box.createVerticalStrut(espaciado));
        subPanel.add(btnInfo);
        subPanel.add(Box.createVerticalStrut(espaciado));
        subPanel.add(btnRanking);

        // Añadir el sub-panel al panel principal
        panelPrincipal.add(subPanel);

        // Añadir el panel principal al JFrame
        add(panelPrincipal);
    }

    private JButton crearBoton(String texto, int anchoTitulo) {
        JButton boton = new JButton(texto);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setFont(new Font("SansSerif", Font.BOLD, 24)); // Fuente más grande para los botones
        boton.setBackground(new Color(52, 152, 219)); // Azul claro
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setMaximumSize(new Dimension(anchoTitulo, 60)); // Ancho igual al del título
        boton.setPreferredSize(new Dimension(anchoTitulo, 60)); // Ajustar tamaño preferido
        return boton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            menuPrincipal menu = new menuPrincipal();
            menu.setVisible(true);
        });
    }
}
