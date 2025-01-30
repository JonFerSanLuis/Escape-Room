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

}
