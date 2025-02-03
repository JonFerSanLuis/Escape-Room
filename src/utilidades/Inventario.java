package utilidades;

import java.util.ArrayList;

import Objetos.Objeto;

public class Inventario {
	ArrayList <Objeto> Inventario = new ArrayList<>();
	
	public void agregarObjeto(Objeto o) {
		Inventario.add(o);
    }
	
	public boolean contieneObjeto(Objeto objeto) {
        return Inventario.contains(objeto);
    }
	
	public void mostrarNombre() {
        for (Objeto o : Inventario) {
            System.out.println(o.getObjName());
        }
    }
	
	public void mostrarId() {
        for (Objeto o : Inventario) {
            System.out.println(o.getObjId());
        }
    }
	
	public void mostrarDescripcion() {
        for (Objeto o : Inventario) {
            System.out.println(o.getObjDescrip());
        }
    }
	
	public Objeto getLlavePuerta() {
		return LlavePuerta;
	}

	public static void setLlavePuerta(Objeto llavePuerta) {
		LlavePuerta = llavePuerta;
	}

	private static Objeto LlavePuerta;
	
	public Objeto getLlaveCajonPadres() {
		return LlaveCajonPadres;
	}

	public static void setLlaveCajonPadres(Objeto llaveCajonPadres) {
		LlaveCajonPadres = llaveCajonPadres;
	}
	
	private static Objeto LlaveCajonPadres;
	
	public Objeto getPapelesDivorcio() {
		return PapelesDivorcio;
	}

	public static void setPapelesDivorcio(Objeto papelesDivorcio) {
		PapelesDivorcio = papelesDivorcio;
	}
	
	private static Objeto PapelesDivorcio;
}
