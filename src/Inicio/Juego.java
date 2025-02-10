package Inicio;

import javax.swing.*;

import utilidades.Inventario;
import view.Casa.CajaAbierta;
import view.Casa.CajonCuartoPadres;
import view.Casa.CasaExterior;
import view.Casa.CuartoMatrimonio;
import view.Casa.Pasillo2Piso;
import view.Casa.PuzzleCajaFuerte;
import view.Casa.Recibidor;

import java.awt.*;

public class Juego extends JFrame{
    private JFrame frame;
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private Boolean puzzleCajaFinished;
    
    public Boolean getPuzzleCajaFinished() {
		return puzzleCajaFinished;
	}

	public void setPuzzleCajaFinished(Boolean puzzleCajaFinished) {
		this.puzzleCajaFinished = puzzleCajaFinished;
	}

	Inventario inventario = new Inventario();

    public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public Juego() {
        setTitle("Escape Room");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 600);
        puzzleCajaFinished = false;

        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        panelPrincipal.add(new Home(this), "home");
        panelPrincipal.add(new Intro(this), "intro");
        panelPrincipal.add(new CasaExterior(this), "casaExterior");
        panelPrincipal.add(new Recibidor(this), "recibidor");
        panelPrincipal.add(new Pasillo2Piso(this), "pasillo2");
        panelPrincipal.add(new CuartoMatrimonio(this), "cuartoPadres");
        panelPrincipal.add(new PuzzleCajaFuerte(this), "puzzleCaja");
        panelPrincipal.add(new CajaAbierta(this), "cajaAbierta");
        panelPrincipal.add(new CajonCuartoPadres(this), "cajonPadres");

        add(panelPrincipal);
        setVisible(true);
    }
    
    public void mostrarOpciones (String opciones) {
    	
    }

    public void cambiarEscena(String nombreEscena) {
        cardLayout.show(panelPrincipal, nombreEscena);
    }
}
