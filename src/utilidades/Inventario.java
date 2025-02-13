package utilidades;

import java.util.ArrayList;

import Objetos.Objeto;

public class Inventario {
	ArrayList <Objeto> Inventario = new ArrayList<>();
	
	public Boolean isInventarioVacio() {
		return Inventario.isEmpty();
	}
	
	public int getInventarioSize() {
		return Inventario.size();
	}
	
	public String getObjetoFile(int i) {
		if (Inventario.isEmpty() || i > Inventario.size()) { // Condición corregida
            return ""; 
        } else {
            return Inventario.get(i).getFileName();
        }
	}
	
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
	
	private static Objeto LlavePuerta;
	
	public Objeto getLlavePuerta() {
		return LlavePuerta;
	}

	public static void setLlavePuerta(Objeto llavePuerta) {
		LlavePuerta = llavePuerta;
	}
		
	private static Objeto LlaveCajonPadres;
	
	public Objeto getLlaveCajonPadres() {
		return LlaveCajonPadres;
	}

	public static void setLlaveCajonPadres(Objeto llaveCajonPadres) {
		LlaveCajonPadres = llaveCajonPadres;
	}
	
	private static Objeto PapelesDivorcio;
	
	public Objeto getPapelesDivorcio() {
		return PapelesDivorcio;
	}

	public static void setPapelesDivorcio(Objeto papelesDivorcio) {
		PapelesDivorcio = papelesDivorcio;
	}

	public Objeto getNotaHijoSalon() {
		return notaHijoSalon;
	}

	public void setNotaHijoSalon(Objeto notaHijoSalon) {
		this.notaHijoSalon = notaHijoSalon;
	}
	
	private static Objeto notaHijoSalon;

	public Objeto getLlaveHijo() {
		return llaveHijo;
	}

	public void setLlaveHijo(Objeto llaveHijo) {
		this.llaveHijo = llaveHijo;
	}
	
	private static Objeto llaveHijo;
	
	public Objeto getPistaTelefonoHijo() {
		return PistaTelefonoHijo;
	}
	
	private Objeto PistaTelefonoHijo;

	public void setPistaTelefonoHijo(Objeto pistaTelefonoHijo) {
		PistaTelefonoHijo = pistaTelefonoHijo;
	}
	
}
