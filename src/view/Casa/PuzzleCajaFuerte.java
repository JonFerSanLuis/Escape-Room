package view.Casa;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class PuzzleCajaFuerte extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel; // Para la imagen de fondo

    /**
     * Create the frame.
     */
    public PuzzleCajaFuerte() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(478, 150, 410, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        setResizable(false);
        setUndecorated(true);

        try {
        	Font optionsFont = Font.createFont(Font.TRUETYPE_FONT,new File("fonts/BeechlandsDemoRegular.ttf"));
			optionsFont = optionsFont.deriveFont(30f);
            contentPane.setLayout(null);
            
            JButton btnSpanish = new JButton("");
            btnSpanish.setBounds(65, 124, 94, 52);
            btnSpanish.setBackground(new Color(0, 0, 0, 0));
            btnSpanish.setOpaque(false);
            btnSpanish.setBorderPainted(false);
            btnSpanish.setContentAreaFilled(false);
            btnSpanish.addMouseListener(new MouseAdapter() {
    	        	@Override
    	        	public void mouseEntered(MouseEvent e) {
    	        		btnSpanish.setBorderPainted(true);
    	        		btnSpanish.setBorder(new LineBorder(Color.RED, 3));
    	        		}
    	        	@Override
    	        	public void mouseExited(MouseEvent e) {
    	        		btnSpanish.setBorderPainted(false);
    	        		}
    				});
            
            JButton btnEnglish = new JButton("");
            btnEnglish.setBounds(182, 124, 94, 52);
            btnEnglish.setBackground(new Color(0, 0, 0, 0));
            btnEnglish.setOpaque(false);
            btnEnglish.setBorderPainted(false);
            btnEnglish.setContentAreaFilled(false);
            btnEnglish.addMouseListener(new MouseAdapter() {
    	        	@Override
    	        	public void mouseEntered(MouseEvent e) {
    	        		btnEnglish.setBorderPainted(true);
    	        		btnEnglish.setBorder(new LineBorder(Color.RED, 3));
    	        		}
    	        	@Override
    	        	public void mouseExited(MouseEvent e) {
    	        		btnEnglish.setBorderPainted(false);
    	        		}
    				});
            contentPane.add(btnEnglish);
            contentPane.add(btnSpanish);

            JLabel sonido = new JLabel("Sonido");
            sonido.setBounds(65, 215, 246, 57);
            sonido.setOpaque(false);
            sonido.setForeground(Color.white);
            sonido.setFont(optionsFont);
            contentPane.add(sonido);

            JLabel idioma = new JLabel("Idioma");
            idioma.setBounds(65, 42, 246, 57);
            idioma.setOpaque(false);
            idioma.setForeground(Color.white);
            idioma.setFont(optionsFont);
            contentPane.add(idioma);
            
            JButton guardar = new JButton("GUARDAR");
            guardar.setBounds(10, 423, 194, 39);
            guardar.setOpaque(false);
            guardar.setForeground(Color.white);
            guardar.setBackground(new Color(0, 0, 0, 0));
			guardar.setBorderPainted(false); // No dibujar el borde
			guardar.setFocusPainted(false);
            guardar.setFont(optionsFont);
            guardar.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseEntered(MouseEvent e) {
	        		guardar.setForeground(Color.red);
	        		}
	        	@Override
	        	public void mouseExited(MouseEvent e) {
	        		guardar.setForeground(Color.white);
	        		}
				});
	        guardar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		volverHome();
	        	}
	        });
	        contentPane.add(guardar);
	        
	        guardar.setOpaque(false);
			guardar.setBorderPainted(false);
			guardar.setContentAreaFilled(false);
        } catch (FontFormatException | IOException e1) {
            e1.printStackTrace();
        }
        
     // Cargar las imágenes
        ImageIcon SpanishImagen = new ImageIcon("img/Bandera_de_España.svg (1).png");
        JLabel Spanishlabel = new JLabel();
        Spanishlabel.setBounds(65, 124, 94, 52); // Ajusta el tamaño del JLabel
        // Redimensionar la imagen para que se ajuste al tamaño del JLabel
        Image imgSpanish = SpanishImagen.getImage().getScaledInstance(Spanishlabel.getWidth(), Spanishlabel.getHeight(), Image.SCALE_SMOOTH);
        Spanishlabel.setIcon(new ImageIcon(imgSpanish));

        // Cargar la imagen de la bandera inglesa
        ImageIcon EnglishImagen = new ImageIcon("img/Flag_of_the_United_Kingdom_(1-2).svg.png");
        JLabel Englishlabel = new JLabel();
        Englishlabel.setBounds(182, 124, 94, 52); // Ajusta el tamaño del JLabel
        // Redimensionar la imagen para que se ajuste al tamaño del JLabel
        Image imgEnglish = EnglishImagen.getImage().getScaledInstance(Englishlabel.getWidth(), Englishlabel.getHeight(), Image.SCALE_SMOOTH);
        Englishlabel.setIcon(new ImageIcon(imgEnglish));

        // Añadir las etiquetas al panel
        contentPane.add(Spanishlabel);
        contentPane.add(Englishlabel);
        
                // Configurar la imagen de fondo
                lblNewLabel = new JLabel();
                lblNewLabel.setBounds(0, 0, 410, 500);
                contentPane.add(lblNewLabel);

        // Ajustar la imagen de fondo al tamaño del panel
        ajustarImagenDeFondo();

        // Escuchar cambios en el tamaño del panel para redimensionar la imagen
        contentPane.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ajustarImagenDeFondo();
            }
        });
        setVisible(true);
    }
    private void volverHome() {
        home.setEnabled(true);  // Habilitar la ventana Home
        dispose();              // Cerrar la ventana Opciones
    }

    private void ajustarImagenDeFondo() {
        String imagePath = "img/pixelcut-export (1) (1).png"; // Ruta de la imagen

        try {
            // Cargar la imagen desde la ruta
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image originalImage = originalIcon.getImage();

            // Obtener el tamaño actual del panel
            int panelWidth = contentPane.getWidth();
            int panelHeight = contentPane.getHeight();

            // Evitar redimensionar si el tamaño es inválido
            if (panelWidth > 0 && panelHeight > 0) {
                // Escalar la imagen al tamaño del panel
                Image scaledImage = originalImage.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                // Actualizar la etiqueta de fondo con la imagen escalada
                lblNewLabel.setIcon(scaledIcon);
                lblNewLabel.setBounds(0, 0, panelWidth, panelHeight);
            }
        } catch (Exception e) {
            System.err.println("Error al cargar o ajustar la imagen: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
