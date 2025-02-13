package utilidades;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImagenLoader {
	// Método que escala la imagen con las dimensiones especificadas por el usuario
    public static ImageIcon scaleImage(String imagePath, int width, int height) {
        try {
            // Usar getClass().getResource() para obtener la URL del recurso
            URL imageUrl = ImagenLoader.class.getResource(imagePath);

            // Verificar si la imagen existe en el classpath
            if (imageUrl == null) {
                System.out.println("La imagen no fue encontrada en el recurso: " + imagePath);
                return null;
            }

            // Cargar la imagen desde la URL obtenida
            BufferedImage originalImage = ImageIO.read(imageUrl);

            // Crear una imagen con el tamaño proporcionado por el usuario
            BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            // Obtener el Graphics2D de la imagen escalada
            Graphics2D g2d = scaledImage.createGraphics();

            // Configurar calidad de escala
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC); // Mejor interpolación
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY); // Mejor calidad
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Suavizado
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY); // Mejor manejo de transparencias

            // Dibujar la imagen escalada
            g2d.drawImage(originalImage, 0, 0, width, height, null);
            g2d.dispose();  // Liberar recursos

            // Devolver el ImageIcon con la imagen escalada
            return new ImageIcon(scaledImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;  // Si ocurre un error, retornar null
        }
    }

}
