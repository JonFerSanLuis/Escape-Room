package config;

import java.util.HashMap;
import java.util.Map;

public class Config {
    // Variable para almacenar el idioma actual
    public static String idioma = "es";

    public static Map<String, Map<String, String>> textos = new HashMap<>();

    public static void cargarIdiomas() {
        // Textos en ingl�s
        Map<String, String> textosEn = new HashMap<>();
        // menu principal
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
        textosEn.put("1", "My name is Yuri, I�m a high school student, and my best friend is a victim of BULLYING.");
        textosEn.put("2", "I realized it while we were talking in the park. He confessed to me that he would be moving far away soon and got sentimental.");
        textosEn.put("3", "Then he mentioned that at least he hoped he wouldn�t have to deal with 'people like that' in his new home.");
        textosEn.put("4", "Adding to that, it wasn�t the first time I�d seen him with bruises.");
        textosEn.put("5", "So much silence made me think and realize how oblivious I had been.");
        textosEn.put("6", "The shock made me irrationally angry, and I started raising my voice");
        textosEn.put("7", "'Why didn�t you tell me anything?!' I shouted at him, blinded by frustration.'");
        textosEn.put("8", "We had a big argument because of my lack of tact. And for some reason, I kept blaming him.");
        textosEn.put("9", "If only I had been a little more considerate and attentive...");
        textosEn.put("10", "A few days ago, Mikel ran away from home.");
        textosEn.put("11", "I can�t stand thinking that I might be partly to blame.");
        textosEn.put("12", "I HAVE TO FIND HIM.");
        
     // Casa exterior
        textosEn.put("", "");
        textosEn.put("1CE", "-You move the flowerpot carefully and find the house key-");
        textosEn.put("2CE", "I won't make it");
        textosEn.put("3CE", "Nah, I can't get in through the window either.");
        textosEn.put("4CE", "This door won't open either.");
        textosEn.put("5CE", "-You move the flowerpot, but there's nothing underneath.-");
        textosEn.put("btnContinuar", "CONTINUE");
        textosEn.put("postit", "/img/PostitIngles.png");
        textosEn.put("8CE", "It looks like no one is home.");
        textosEn.put("9CE", "But the door is closed.");
        textosEn.put("10CE", "I must find a way to get in.");
        textosEn.put("btnVolver", "RETURN");
        textosEn.put("12CE", "This is Mikel's house.");
        textosEn.put("13CE", "I should see his parents to see if they can give me some information.");
        
        // Caj�n Sal�n
        textosEn.put("codigoAcertado", "�CORRECT CODE!");
        textosEn.put("codigoIncorrecto", "�INCORRECT CODE!");
        
        // Cuarto Matrimonio
        textosEn.put("1CM", "The drawer is locked");
        
        // Sal�n
        textosEn.put("1S", "It seems that there was a note under the pillow.");
        
        // Diario
        textosEn.put("1D", "With Juan, things are going well. I like how he has found his way into our lives without rushing anything. I don�t know what the future holds for us, but right now, here and like this, I feel happy. It�s beautiful to have someone to share with, someone who sees me beyond just �mom� and still loves that part of me. Life isn�t always perfect, but today, in this small moment of calm, I feel like everything is in its place.");
        textosEn.put("2D", "Today has been a long day, but full of moments I want to remember. Sometimes I feel like time is passing too fast� My son grows a little more every day, and even though his mischief can drive me crazy at times, there is nothing in the world I love more than seeing him laugh. It�s amazing how his smile can erase any worry.");
        textosEn.put("3D", "It remains guarding the door of the library where the most highly secret information about the descendant of the exiled lord, deprived of his treasures, is kept�the great painting that the matron gifted to the people                         <=@ qr sroerb qry @=!(>\"");
        textosEn.put("4D", "Today was one of those days when I stopped to look at my life and felt a mix of love, exhaustion, and happiness. Being a mother isn�t easy, but every �I love you� from my son makes it all worthwhile. Sometimes I worry if I�m doing it right, if I�m giving him everything he needs� but then I see him play, laugh, and hug me so tightly that I know, in some way, we�re doing just fine.");

      //Puerta mikel
        textosEn.put("1PM", "Wow, Mikel's door is closed...");
        
     // Di�logo con el padre de Mikel en ingl�s
        textosEn.put("1DP", "Hello?");
        textosEn.put("2DP", "-Yes? Who is this?- ");
        textosEn.put("3DP", "Am I speaking to Mikel's father?");
        textosEn.put("4DP", "-Yes, I am his...-");
        textosEn.put("5DP", "-Yes... I am Omar-");
        textosEn.put("6DP", "Is something wrong?");
        textosEn.put("7DP", "-I'm not his legal guardian, but I am his father-");
        textosEn.put("8DP", "-I understand you're calling about his disappearance-");
        textosEn.put("9DP", "-But why are you calling from his phone?- ");
        textosEn.put("10DP", "Well, it's complicated to explain");
        textosEn.put("11DP", "I want to know where he is. I want to find my best friend.");
        textosEn.put("12DP", "-So, you're Yuri-");
        textosEn.put("13DP", "-Nice to finally hear your voice-");
        textosEn.put("14DP", "-Tell me, how can I help you?- ");
        textosEn.put("15DP", "By any chance, do you know his computer password?");
        textosEn.put("16DP", "I think I might find information there that could help me find him");
        textosEn.put("17DP", "-Well, I'd try with his favorite movie, Gladiator�he has it as his wallpaper�or something related to his dog-");
        textosEn.put("18DP", "-I remember his smile so clearly when it came to either of those things-");
        textosEn.put("19DP", "Thank you so much!");
        textosEn.put("20DP", "-You're welcome, good luck. And if you see him...-");
        textosEn.put("21DP", "-Tell him I love him for me-");
        textosEn.put("22DP", "Consider it done, Omar");
        textosEn.put("23DP", "Oops... Wrong number.");
        
     // Agregar traducciones al ingl�s
        textosEn.put("1PS", "The password has 13 characters.");
        textosEn.put("2PS", "The password is all in lowercase");
        textosEn.put("3PS", "It contains numbers and letters");
        textosEn.put("4PS", "Perhaps the note refers to his biological father");
        
     // Agregar traducciones al ingl�s
        textosEn.put("thisIsHorrible", "This is horrible.");
        textosEn.put("mikelEnduresThisEveryDay", "Mikel endures this EVERY day...");
        
     // Agregar traducciones al ingl�s
        textosEn.put("iCantBelieve", "I can't believe I let all of this slip by.");
        textosEn.put("iMustRush", "I must hurry and go to school as soon as possible.");
        
        // Continuar�
        textosEn.put("continuara", "To be continued...");
        
        
        // Textos en espa�ol
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
        textosEs.put("2", "Me di cuenta mientras charl�bamos en el parque. Me confes� que dentro de poco se iba a mudar bastante lejos y se puso sentimental.");
        textosEs.put("3", "Entonces coment� que al menos esperaba no tener que lidiar con 'gente as�' en su futuro hogar.");
        textosEs.put("4", "Agregarle a eso que no era la primera vez que lo ve�a con moratones.");
        textosEs.put("5", "Tanto silencio me hizo pensar y darme cuenta de lo despistada que fui.");
        textosEs.put("6", "La sorpresa me hizo enfadarme sin raz�n y comenzar a levantar la voz.");
        textosEs.put("7", "'�Por qu� no me dijiste nada!' Le grit�, cegada por la impotencia.'");
        textosEs.put("8", "Tuvimos una fuerte discusi�n por culpa de mi falta de tacto. Y por alguna raz�n no dejaba de echarle la culpa a �l.");
        textosEs.put("9", "Si tan solo hubiera sido un poco m�s considerada y atenta...");
        textosEs.put("10", "Hace unos d�as, Mikel se escap� de casa.");
        textosEs.put("11", "No soporto pensar que tengo parte de culpa.");
        textosEs.put("12", "TENGO QUE ENCONTRARLE.");
        
        // Casa exterior
        textosEs.put("1CE", "-Mueves la maceta cuidadosamente y encuentras la llave de la casa-");
        textosEs.put("2CE", "No llego ni de co�a.");
        textosEs.put("3CE", "Nah, tampoco puedo entrar por la ventana.");
        textosEs.put("4CE", "Esta puerta tampoco se abre.");
        textosEs.put("5CE", "-Mueves la maceta, pero no hay nada debajo-");
        textosEs.put("btnContinuar", "CONTINUAR");
        textosEs.put("postit", "/img/postitGrande (2).png");
        textosEs.put("8CE", "Parece que no hay nadie en casa.");
        textosEs.put("9CE", "Pero la puerta esta cerrada.");
        textosEs.put("10CE", "Debo encontrar la forma de entrar");
        textosEs.put("btnVolver", "VOLVER");
        textosEs.put("12CE", "Esta es la casa de Mikel.");
        textosEs.put("13CE", "Deber�a ver a sus padres por si me pueden dar algo de informaci�n.");
        
        // Caj�n sal�n
        textosEs.put("codigoAcertado", "�CODIGO ACERTADO!");
        textosEs.put("codigoIncorrecto", "�CODIGO INCORRECTO!");
        
        // Cuarto matrimonio
        textosEs.put("1CM", "El caj�n esta cerrado con llave");
        
        // SaloM
        textosEs.put("1S", "Parece que debajo de la almohada hab�a una nota");
        
        // Diario
        textosEs.put("1D", "Con Juan las cosas van bien. Me gusta c�mo ha sabido entrar en nuestra vida sin apresurar nada. No s� qu� nos deparar� el futuro, pero s� que ahora mismo, aqu� y as�, me siento feliz. Es bonito tener a alguien con quien compartir, que me vea m�s all� de \\\"mam�\\\" y que a�n as� ame esa parte de m�. A veces la vida no es perfecta, pero hoy, en este peque�o instante de calma, siento que todo est� en su lugar.");
        textosEs.put("2D", "Hoy ha sido un d�a largo, pero lleno de momentos que quiero recordar. A veces siento que el tiempo pasa demasiado r�pido� Mi hijo crece cada d�a, y aunque a veces me vuelva loca con sus travesuras, no hay nada en el mundo que ame m�s que verlo re�r. Es incre�ble c�mo su sonrisa puede borrar cualquier preocupaci�n.");
        textosEs.put("3D", "Queda aguardando la puerta de la biblioteca en la que se encuentra la m�s altamente secreta informaci�n del descendiente del se�or desterrado y privado de sus tesoros, la gran pintura que la matrona le obsequio al pueblo                         <=@ qr sroerb qry @=!(>\"");
        textosEs.put("4D", "Hoy fue uno de esos d�as en los que me detuve a observar mi vida y sent� una mezcla de amor, cansancio y felicidad. Ser madre no es f�cil, pero cada \\\"te quiero\\\" de mi hijo hace que todo valga la pena. A veces me preocupa si lo estoy haciendo bien, si le estoy dando todo lo que necesita� pero luego lo veo jugar, re�r y abrazarme con tanta fuerza que s� que, de alguna manera, estamos bien.");
        
        
        //Puerta mikel
        textosEs.put("1PM", "Vaya, la puerte de Mikel esta cerrada...");
        
     // Di�logo con el padre de Mikel
        textosEs.put("1DP", "�Hola?");
        textosEs.put("2DP", "-�Si? �Qui�n es?-");
        textosEs.put("3DP", "�Hablo el padre de Mikel?");
        textosEs.put("4DP", "-S�, soy su...-");
        textosEs.put("5DP", "-S�... Soy Omar-");
        textosEs.put("6DP", "�Pasa algo?");
        textosEs.put("7DP", "-No soy su tutor legal, pero s� su progenitor-");
        textosEs.put("8DP", "-Entiendo que llamas por su desaparici�n-");
        textosEs.put("9DP", "-Pero, �por qu� llamas desde su m�vil?- ");
        textosEs.put("10DP", "Bueno, es complicado de explicar");
        textosEs.put("11DP", "Quiero saber d�nde est�. Quiero encontrar a mi mejor amigo.");
        textosEs.put("12DP", "-As� que t� eres Yuri-");
        textosEs.put("13DP", "-Me alegro de ponerte voz-");
        textosEs.put("14DP", "-Dime, �en qu� puedo ayudarte?- ");
        textosEs.put("15DP", "�Por casualidad no sabr�s la contrase�a de su ordenador?");
        textosEs.put("16DP", "Creo que puedo encontrar informaci�n que me ayudar�a a encontrarle ah�");
        textosEs.put("17DP", "-Pues yo probar�a con su pel�cula favorita Gladiator, la tiene de fondo de pantalla, o algo que tenga que ver con su perro-");
        textosEs.put("18DP", "-Recuerdo bien su sonrisa cuando se trataba de cualquiera de las dos cosas-");
        textosEs.put("19DP", "�Muchas gracias!");
        textosEs.put("20DP", "-De nada, suerte. Y si lo ves...-");
        textosEs.put("21DP", "-Dile que lo quiero de mi parte-");
        textosEs.put("22DP", "Eso est� hecho, Omar");
        textosEs.put("23DP", "Ups... N�mero equivocado.");
        
     // Agregar traducciones al espa�ol
        textosEs.put("1PS", "La contrase�a tiene 13 caracteres.");
        textosEs.put("2PS", "La contrase�a est� todo en min�sculas");
        textosEs.put("3PS", "Contiene n�meros y letras");
        textosEs.put("4PS", "Es quiz� la nota se refiere a su padre biol�gico");
        
     // Agregar traducciones al espa�ol
        textosEs.put("estoEsHorrible", "Esto es horrible.");
        textosEs.put("mikelSoportaTodosLosDias", "Mikel soporta esto TODOS los d�as...");
        
     // Agregar traducciones al espa�ol
        textosEs.put("noMePuedoCreer", "No me puedo creer que haya dejado pasar todo esto.");
        textosEs.put("deboDarmePrisa", "Debo darme prisa e ir al colegio lo antes posible.");
        
        // Continuar�
        textosEs.put("continuara", "Continuar�...");
        
        // Guardar los textos de cada idioma en el hashmap
        textos.put("en", textosEn);
        textos.put("es", textosEs);
    }

    public static String getTexto(String texto) {
        return textos.get(idioma).get(texto);
    }
}
