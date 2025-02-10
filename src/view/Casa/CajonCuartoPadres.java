package view.Casa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

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
        
       inventario.setPapelesDivorcio(new Objeto(false, true, 215, "Papeles Del Divorcio", "Parece que se trata de los documentos de separacón de los padres de Mikel", "img/papelesDivorcio.png"));
    	
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
        
        ImageIcon paperImagen = new ImageIcon("img/papelesDivorcio.png");
        JLabel PaperLabel = new JLabel();
        PaperLabel.setBounds(182, 42, 586, 519); // Ajusta el tamaño del JLabel 
        Image imgPaper = paperImagen.getImage().getScaledInstance(PaperLabel.getWidth(), PaperLabel.getHeight(), Image.SCALE_SMOOTH);
        PaperLabel.setIcon(new ImageIcon(imgPaper));
        add(PaperLabel);
        PaperLabel.setVisible(false);
        
        add(LightLabel);
        LightLabel.setVisible(false);

        JButton btnPapelesDiv = new JButton("");
        btnPapelesDiv.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		PaperLabel.setVisible(true);
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
        
        // Mostrar la imagen redimensionada
        lblCajon = new JLabel();
        lblCajon.setBounds(0, 0, 934, 561);
        lblCajon.setIcon(scaledIcon);  // Establecer la imagen por defecto
        add(lblCajon);
    }
    
    private ImageIcon loadImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage();
        return new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
    }

}
