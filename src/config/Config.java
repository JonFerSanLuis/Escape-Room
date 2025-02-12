package config;

import java.util.HashMap;
import java.util.Map;

public class Config {
    // Variable para almacenar el idioma actual
    public static String idioma = "es";

    public static Map<String, Map<String, String>> textos = new HashMap<>();

    public static void cargarIdiomas() {
        // Textos en inglés
        Map<String, String> textosEn = new HashMap<>();
        textosEn.put("saludo", "Hello");
        textosEn.put("siguiente", "Next");
        textosEn.put("bienvenida", "Welcome");
        textosEn.put("OTRO", "OTHER");
        textosEn.put("imagen1", "image1_en.jpg");
        textosEn.put("jugar", "PLAY");
        textosEn.put("guardar", "SAVE");
        textosEn.put("opciones", "OPTIONS");
        textosEn.put("ranking", "RANKING");
        textosEn.put("idioma", "Language");

        // Textos en español
        Map<String, String> textosEs = new HashMap<>();
        textosEs.put("saludo", "Hola");
        textosEs.put("siguiente", "Siguiente");
        textosEs.put("bienvenida", "Bienvenido");
        textosEs.put("OTRO", "OTRO");
        textosEs.put("imagen1", "imagen1_es.jpg");
        textosEs.put("jugar", "JUGAR");
        textosEs.put("guardar", "GUARDAR");
        textosEs.put("opciones", "OPCIONES");
        textosEs.put("ranking", "RANKING");
        textosEs.put("idioma", "Idioma");

        // Guardar los textos de cada idioma en el hashmap
        textos.put("en", textosEn);
        textos.put("es", textosEs);
    }

    public static String getTexto(String texto) {
        return textos.get(idioma).get(texto);
    }
}
