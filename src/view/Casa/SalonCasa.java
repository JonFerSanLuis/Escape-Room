package view.Casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Inicio.Juego;
import Objetos.Objeto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SalonCasa extends JPanel {

	private Image backgroundImage;
    private String backgroundFile;
    JLabel salonLabel;

	public SalonCasa(Juego juego) {
		setBounds(0, 0, 950, 600);
		setLayout(null);
		
		backgroundFile = "img/salonCasa.jpg";
		
		JButton btnContinue = new JButton("CONTINUAR");
		
		juego.getInventario().setNotaHijoSalon(new Objeto(true, false, 105, "Nota del salón", "Parece que es una nota desgastada por los días que lleva bajo la almohada, además la letra parece de Mikel", "img/......."));

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        JLabel LightLabel = new JLabel();
        // Cargar la imagen de la bandera inglesa
        ImageIcon LightImagen = new ImageIcon("img/11571045.png");
        LightLabel.setBounds(825, 437, 61, 17); // Ajusta el tamaño del JLabel 
        Image imgLight = LightImagen.getImage().getScaledInstance(LightLabel.getWidth(), LightLabel.getHeight(), Image.SCALE_SMOOTH);
        LightLabel.setIcon(new ImageIcon(imgLight));
        LightLabel.setVisible(false);
        add(LightLabel);
        
        JLabel LightPerro = new JLabel();
        // Cargar la imagen de la bandera inglesa
        ImageIcon LightImagenPerro = new ImageIcon("img/11571045.png");
        LightPerro.setBounds(898, 282, 47, 17); // Ajusta el tamaño del JLabel 
        Image imgLightPerro = LightImagenPerro.getImage().getScaledInstance(LightPerro.getWidth(), LightPerro.getHeight(), Image.SCALE_SMOOTH);
        LightPerro.setIcon(new ImageIcon(imgLightPerro));
        LightPerro.setVisible(false);
        add(LightPerro);
        
        JLabel LightCod = new JLabel();
        // Cargar la imagen de la bandera inglesa
        ImageIcon CodImagen = new ImageIcon("img/11571045.png");
        LightCod.setBounds(174, 232, 47, 17); // Ajusta el tamaño del JLabel 
        Image imgLightCod = CodImagen.getImage().getScaledInstance(LightCod.getWidth(), LightCod.getHeight(), Image.SCALE_SMOOTH);
        LightCod.setIcon(new ImageIcon(imgLightCod));
        LightCod.setVisible(false);
        add(LightCod);
        
        JLabel TxtAlmohada = new JLabel("Parece que debajo de la almohada había una nota");
		TxtAlmohada.setHorizontalAlignment(SwingConstants.CENTER);
		TxtAlmohada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TxtAlmohada.setForeground(Color.WHITE);
		TxtAlmohada.setBounds(50, 495, 875, 50);
		add(TxtAlmohada);
		TxtAlmohada.setVisible(false);
		
		add(TxtAlmohada);
        
        ImageIcon flechaOFF = new ImageIcon("img/FlechaVolverSalonOFF.png");
        ImageIcon flechaON = new ImageIcon("img/FlechaVolverSalonON.png");

        Image imgOFF = flechaOFF.getImage().getScaledInstance(117, 71, Image.SCALE_SMOOTH);
        Image imgON = flechaON.getImage().getScaledInstance(117, 71, Image.SCALE_SMOOTH);

        ImageIcon iconOFF = new ImageIcon(imgOFF);
        ImageIcon iconON = new ImageIcon(imgON);
        JButton btnRecibidor = new JButton("");
        JLabel lblFlecha = new JLabel(iconOFF);
        
        JButton btnCuadroPerro = new JButton("");
        btnCuadroPerro.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		LightPerro.setVisible(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		LightPerro.setVisible(false);
        	}
        });
        btnCuadroPerro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnCuadroPerro.setBounds(887, 114, 47, 186);
        btnCuadroPerro.setBackground(new Color(0, 0, 0, 0));
        btnCuadroPerro.setOpaque(false);
        btnCuadroPerro.setBorderPainted(false);
        btnCuadroPerro.setContentAreaFilled(false);
        add(btnCuadroPerro);
        
        JButton btnCuadroCod = new JButton("");
        btnCuadroCod.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		LightCod.setVisible(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		LightCod.setVisible(false);
        	}
        });
        btnCuadroCod.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnCuadroCod.setBounds(149, 142, 89, 99);
        btnCuadroCod.setBackground(new Color(0, 0, 0, 0));
        btnCuadroCod.setOpaque(false);
        btnCuadroCod.setBorderPainted(false);
        btnCuadroCod.setContentAreaFilled(false);
        add(btnCuadroCod);
        
        JButton btnMueble = new JButton("");
        btnMueble.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		LightLabel.setVisible(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		LightLabel.setVisible(false);
        	}
        });
        btnMueble.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnMueble.setBounds(808, 410, 104, 83);
        btnMueble.setBackground(new Color(0, 0, 0, 0));
        btnMueble.setOpaque(false);
        btnMueble.setBorderPainted(false);
        btnMueble.setContentAreaFilled(false);
        add(btnMueble);
        
        JButton btnAlmohada = new JButton("");
        btnAlmohada.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		LightCod.setVisible(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		LightCod.setVisible(false);
        	}
        });
        btnAlmohada.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		backgroundFile = "img/salonCasaTxt.jpg";
				upgradeImage();
				btnAlmohada.setVisible(false);
				btnContinue.setVisible(true);
				btnCuadroCod.setVisible(false);
				btnCuadroPerro.setVisible(false);
				btnMueble.setVisible(false);
				TxtAlmohada.setVisible(true);
				lblFlecha.setVisible(true);
				btnRecibidor.setVisible(false);
				juego.getInventario().agregarObjeto(juego.getInventario().getNotaHijoSalon());
        	}
        });
        btnAlmohada.setBounds(264, 323, 80, 71);
        btnAlmohada.setBackground(new Color(0, 0, 0, 0));
        btnAlmohada.setOpaque(false);
        btnAlmohada.setBorderPainted(false);
        btnAlmohada.setContentAreaFilled(false);
        add(btnAlmohada);
        
        lblFlecha.setBounds(696, 479, 117, 71);
        add(lblFlecha);
        
        btnRecibidor.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblFlecha.setIcon(iconON);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblFlecha.setIcon(iconOFF);
        	}
        });
        btnRecibidor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		juego.cambiarEscena("recibidor");
        	}
        });
        btnRecibidor.setBounds(723, 479, 75, 71);
        btnRecibidor.setBackground(new Color(0, 0, 0, 0));
        btnRecibidor.setOpaque(false);
        btnRecibidor.setBorderPainted(false);
        btnRecibidor.setContentAreaFilled(false);
        add(btnRecibidor);
        
        btnContinue.setBounds(819, 468, 115, 23);
		btnContinue.setBackground(new Color(0, 0, 0, 0));
		btnContinue.setOpaque(false);
		btnContinue.setBorderPainted(false);
		btnContinue.setContentAreaFilled(false);
		btnContinue.setForeground(Color.GRAY);
		btnContinue.setVisible(false);

		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backgroundFile = "img/habitacionMatrimonial.jpeg";
				upgradeImage();
				btnContinue.setVisible(false);
				btnCuadroCod.setVisible(true);
				btnCuadroPerro.setVisible(true);
				btnMueble.setVisible(true);
				TxtAlmohada.setVisible(false);
				lblFlecha.setVisible(false);
				btnRecibidor.setVisible(true);
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

		add(btnContinue);
        
        // Mostrar la imagen de fondo
        salonLabel = new JLabel();
        salonLabel.setBounds(0, 0, 950, 600);
        salonLabel.setIcon(scaledIcon);  // Establecer la imagen por defecto
        add(salonLabel); // Agregar al final para que quede encima del botón
	}
	private void upgradeImage() {
		// Cargar la nueva imagen
		ImageIcon originalIcon = new ImageIcon(backgroundFile);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(950, 600, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Actualizar el fondo con la nueva imagen
		salonLabel.setIcon(scaledIcon);
		salonLabel.repaint(); // Redibujar para aplicar el cambio
	}
	
    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
    }
}
