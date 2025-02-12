package view.Casa;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Inicio.Juego;
import Objetos.Objeto;
import utilidades.Inventario;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CajonCuartoPadres extends JPanel {

	String backgroundFile;
    JLabel lblCajon;

    public CajonCuartoPadres(Juego juego) {
        setBounds(0, 0, 950, 600);
        
        Inventario inventario = new Inventario();
        
       inventario.setPapelesDivorcio(new Objeto(false, true, 215, "Papeles Del Divorcio", "Parece que se trata de los documentos de separacón de los padres de Mikel, Hay un número de teléfono subrayado (+34 614 26 85 84)", "img/papelesDivorcio.png"));
    	
        backgroundFile = "img/cajon.png";

        // Cargar la imagen y redimensionarla
        ImageIcon originalIcon = new ImageIcon(backgroundFile);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setLayout(null);
        
        JLabel LightLabel = new JLabel();
        // Cargar la imagen de la bandera inglesa
        ImageIcon LightImagen = new ImageIcon("img/11571045.png");
        LightLabel.setBounds(438, 309, 70, 29); // Ajusta el tamaño del JLabel 
        Image imgLight = LightImagen.getImage().getScaledInstance(LightLabel.getWidth(), LightLabel.getHeight(), Image.SCALE_SMOOTH);
        LightLabel.setIcon(new ImageIcon(imgLight));
        
        add(LightLabel);
        LightLabel.setVisible(false);
        
        JLabel Txtcajon1 = new JLabel("Que será esto...");
		Txtcajon1.setHorizontalAlignment(SwingConstants.CENTER);
		Txtcajon1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Txtcajon1.setForeground(Color.WHITE);
		Txtcajon1.setBounds(50, 495, 875, 50);
		add(Txtcajon1);
		Txtcajon1.setVisible(false);

        JButton btnPapelesDiv = new JButton("");
        btnPapelesDiv.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPapelesDiv.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		backgroundFile = "img/habitacionMatrimonial.jpeg";
				upgradeImage();
        		btnPapelesDiv.setVisible(false);
        		Txtcajon1.setVisible(true);
        		inventario.agregarObjeto(inventario.getPapelesDivorcio());
        	}
        });
        btnPapelesDiv.setBounds(327, 285, 195, 140);
        btnPapelesDiv.setBackground(new Color(0, 0, 0, 0));
        btnPapelesDiv.setOpaque(false);
        btnPapelesDiv.setBorderPainted(false);
        btnPapelesDiv.setContentAreaFilled(false);
        btnPapelesDiv.addMouseListener(new MouseAdapter() {
          	@Override
        	public void mouseEntered(MouseEvent e) {
        		LightLabel.setVisible(true);
        	}
          	@Override
        	public void mouseExited(MouseEvent e) {
        		LightLabel.setVisible(false);
        	}
        });
        add(btnPapelesDiv);
        
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(37, 521, 89, 23);
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnVolver);
        btnVolver.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		juego.cambiarEscena("cuartoPadres");
        	}
        });

        JButton btnContinue = new JButton("CONTINUAR");
        btnContinue.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
				Txtcajon1.setVisible(false);
				btnVolver.setVisible(true);
				btnContinue.setVisible(false);
			}
		});
		
		btnContinue.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        
        // Mostrar la imagen redimensionada
        lblCajon = new JLabel();
        lblCajon.setBounds(0, 0, 934, 561);
        lblCajon.setIcon(scaledIcon);  // Establecer la imagen por defecto
        add(lblCajon);
    }
    
    private void upgradeImage() {
		// Cargar la nueva imagen
		ImageIcon originalIcon = new ImageIcon(backgroundFile);
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(lblCajon.getWidth(), lblCajon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Actualizar el fondo con la nueva imagen
		lblCajon.setIcon(scaledIcon);
		lblCajon.repaint(); // Redibujar para aplicar el cambio
	}
    
    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
    }

}
