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
        
        // Intro
        textosEn.put("1", "My name is Yuri, I’m a high school student, and my best friend is a victim of BULLYING.");
        textosEn.put("2", "I realized it while we were talking in the park. He confessed to me that he would be moving far away soon and got sentimental.");
        textosEn.put("3", "Then he mentioned that at least he hoped he wouldn’t have to deal with 'people like that' in his new home.");
        textosEn.put("4", "Adding to that, it wasn’t the first time I’d seen him with bruises.");
        textosEn.put("5", "So much silence made me think and realize how oblivious I had been.");
        textosEn.put("6", "The shock made me irrationally angry, and I started raising my voice");
        textosEn.put("7", "'Why didn’t you tell me anything?!' I shouted at him, blinded by frustration.'");
        textosEn.put("8", "We had a big argument because of my lack of tact. And for some reason, I kept blaming him.");
        textosEn.put("9", "If only I had been a little more considerate and attentive...");
        textosEn.put("10", "A few days ago, Mikel ran away from home.");
        textosEn.put("11", "I can’t stand thinking that I might be partly to blame.");
        textosEn.put("12", "I HAVE TO FIND HIM.");
        
     // Casa exterior
        textosEn.put("", "");
        textosEn.put("1CE", "-You move the flowerpot carefully and find the house key-");
        textosEn.put("2CE", "I won't make it");
        textosEn.put("3CE", "Nah, I can't get in through the window either.");
        textosEn.put("4CE", "This door won't open either.");
        textosEn.put("5CE", "-You move the flowerpot, but there's nothing underneath.-");
        textosEn.put("btnContinuar", "CONTINUE");
        textosEn.put("postit", "img/PostitIngles.png");
        textosEn.put("8CE", "It looks like no one is home.");
        textosEn.put("9CE", "But the door is closed.");
        textosEn.put("10CE", "I must find a way to get in.");
        textosEn.put("btnVolver", "RETURN");
        textosEn.put("12CE", "");

        // Textos en español
        Map<String, String> textosEs = new HashMap<>();
        // menu principal
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
        // Intro
        textosEs.put("1", "Me llamo Yuri, soy una estudiante de secundaria y mi mejor amigo sufre BULLYING.");
        textosEs.put("2", "Me di cuenta mientras charlábamos en el parque. Me confesó que dentro de poco se iba a mudar bastante lejos y se puso sentimental.");
        textosEs.put("3", "Entonces comentó que al menos esperaba no tener que lidiar con 'gente así' en su futuro hogar.");
        textosEs.put("4", "Agregarle a eso que no era la primera vez que lo veía con moratones.");
        textosEs.put("5", "Tanto silencio me hizo pensar y darme cuenta de lo despistada que fui.");
        textosEs.put("6", "La sorpresa me hizo enfadarme sin razón y comenzar a levantar la voz.");
        textosEs.put("7", "'¡Por qué no me dijiste nada!' Le grité, cegada por la impotencia.'");
        textosEs.put("8", "Tuvimos una fuerte discusión por culpa de mi falta de tacto. Y por alguna razón no dejaba de echarle la culpa a él.");
        textosEs.put("9", "Si tan solo hubiera sido un poco más considerada y atenta...");
        textosEs.put("10", "Hace unos días, Mikel se escapó de casa.");
        textosEs.put("11", "No soporto pensar que tengo parte de culpa.");
        textosEs.put("12", "TENGO QUE ENCONTRARLE.");
        
        // Casa exterior
        textosEs.put("", "");
        textosEs.put("1CE", "-Mueves la maceta cuidadosamente y encuentras la llave de la casa-");
        textosEs.put("2CE", "No llego ni de coña.");
        textosEs.put("3CE", "Nah, tampoco puedo entrar por la ventana.");
        textosEs.put("4CE", "Esta puerta tampoco se abre.");
        textosEs.put("5CE", "-Mueves la maceta, pero no hay nada debajo-");
        textosEs.put("btnContinuar", "CONTINUAR");
        textosEs.put("postit", "img/postitGrande (2).png");
        textosEs.put("8CE", "Parece que no hay nadie en casa.");
        textosEs.put("9CE", "Pero la puerta esta cerrada.");
        textosEs.put("10CE", "Debo encontrar la forma de entrar");
        textosEs.put("btnVolver", "VOLVER");
        textosEs.put("12CE", "");
        
        
        // Guardar los textos de cada idioma en el hashmap
        textos.put("en", textosEn);
        textos.put("es", textosEs);
    }

    public static String getTexto(String texto) {
        return textos.get(idioma).get(texto);
    }
}
