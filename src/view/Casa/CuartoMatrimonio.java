package view.Casa;

import javax.swing.border.EmptyBorder;

import Objetos.Objeto;
import utilidades.Inventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CuartoMatrimonio extends JFrame {

    private JPanel contentPane;
    String CuartoPadresFile;
    JLabel HomeLabel; 
    JLabel lightLabel;
    
    int txtPre;

    public CuartoMatrimonio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
        setResizable(false);
        
        Inventario inventario = new Inventario();
        
        inventario.setLlaveCajonPadres(new Objeto(true, true, 002, "Llave", "La llave de la puerta delantera de la casa de Mikel"));
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(934, 561));
        setContentPane(layeredPane);
        
        CuartoPadresFile = "img/habitacionMatrimonial.jpeg";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(CuartoPadresFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        // Inicializar contentPane
        contentPane = new JPanel();
        contentPane.setLayout(null);
        
        JLabel LightLabel = new JLabel();
        // Cargar la imagen de la bandera inglesa
        ImageIcon LightImagen = new ImageIcon("img/11571045.png");
        LightLabel.setBounds(626, 312, 83, 23); // Ajusta el tamaño del JLabel 
        Image imgLight = LightImagen.getImage().getScaledInstance(LightLabel.getWidth(), LightLabel.getHeight(), Image.SCALE_SMOOTH);
        LightLabel.setIcon(new ImageIcon(imgLight));
        layeredPane.add(LightLabel, Integer.valueOf(2));
        LightLabel.setVisible(false);
        
        ArrayList<JLabel> TxtCajon = new ArrayList<>();
        
        JLabel Txtcajon1 = new JLabel("El cajón esta cerrado con llave");
		Txtcajon1.setHorizontalAlignment(SwingConstants.CENTER);
		Txtcajon1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Txtcajon1.setForeground(Color.WHITE);
		Txtcajon1.setBounds(50, 495, 875, 50);
		getContentPane().add(Txtcajon1);
		Txtcajon1.setVisible(false);
		
		TxtCajon.add(Txtcajon1);
        
        JButton btnContinue = new JButton("CONTINUAR");

        JButton btnVerCajon = new JButton("");
        btnVerCajon.setOpaque(false);
        btnVerCajon.setBackground(new Color(0, 0, 0, 0));
        btnVerCajon.setBorderPainted(false); // No dibujar el borde
        btnVerCajon.setFocusPainted(false);
        btnVerCajon.setContentAreaFilled(false);
        btnVerCajon.setBounds(581, 299, 178, 96);
        btnVerCajon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                    	if (inventario.contieneObjeto(inventario.getLlaveCajonPadres())) {
                    		try {
                            CajonCuartoPadres frame = new CajonCuartoPadres();
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    	}else {
                    		CuartoPadresFile = "img/CuartoPadresTexto.png";
                    		upgradeImage();
                    		btnContinue.setVisible(true);
                    		Txtcajon1.setVisible(true);
                    	}
                    }
                });
            }
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		LightLabel.setVisible(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		LightLabel.setVisible(false);
        	}
        });
        
		btnContinue.setBounds(819, 468, 115, 23);
		btnContinue.setBackground(new Color(0, 0, 0, 0));
		btnContinue.setOpaque(false);
		btnContinue.setBorderPainted(false);
		btnContinue.setContentAreaFilled(false);
		btnContinue.setForeground(Color.GRAY);
		btnContinue.setVisible(false);
		
		txtPre = 0;

		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuartoPadresFile = "img/habitacionMatrimonial.jpeg";
				upgradeImage();
				btnVerCajon.setVisible(true);
				btnContinue.setVisible(false);
				Txtcajon1.setVisible(false);
			}
		});

		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnContinue.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnContinue.setForeground(Color.GRAY);
			}
		});

		btnContinue.setOpaque(false);
		btnContinue.setBorderPainted(false);
		btnContinue.setContentAreaFilled(false);

		layeredPane.add(btnContinue);
        
        ImageIcon ImagenCajaFuerte = new ImageIcon("img/cajaFuerte.png");

        layeredPane.add(btnVerCajon);
        
        
        
        JLabel ImagenCajaFuerteLabel = new JLabel();
        ImagenCajaFuerteLabel.setBounds(773, 264, 161, 118); 
        
        Image imgCajaFuerte = ImagenCajaFuerte.getImage().getScaledInstance(ImagenCajaFuerteLabel.getWidth(), ImagenCajaFuerteLabel.getHeight(), Image.SCALE_SMOOTH);
        ImagenCajaFuerteLabel.setIcon(new ImageIcon(imgCajaFuerte)); 
        
        layeredPane.add(ImagenCajaFuerteLabel, Integer.valueOf(1)); 
        
        HomeLabel = new JLabel();
        HomeLabel.setBounds(0, 0, 934, 561);
        HomeLabel.setIcon(scaledIcon);
        
        layeredPane.add(HomeLabel, Integer.valueOf(0)); 
        
        // Ajustar el tamaño de la ventana al contenido
        pack();
    }
    
    private void upgradeImage() {
		// Cargar la nueva imagen
		ImageIcon originalIcon = new ImageIcon(CuartoPadresFile);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Actualizar el fondo con la nueva imagen
		HomeLabel.setIcon(scaledIcon);
		HomeLabel.repaint(); // Redibujar para aplicar el cambio
	}

    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(contentPane.getWidth(), contentPane.getHeight(), Image.SCALE_SMOOTH));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CuartoMatrimonio frame = new CuartoMatrimonio();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}