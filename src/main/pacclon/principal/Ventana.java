package main.pacclon.principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.pacclon.settings.Settings;
import main.pacclon.sprites.Pared;
import main.pacclon.sprites.Puntitos;

public class Ventana extends JPanel {
	
	private static final long serialVersionUID = 5413669749544194676L;
	
	private Settings settings;
	private Instancias instancias;
	
	private ArrayList<Pared> pared;
	private ArrayList<Puntitos> puntitos;
	
	public Ventana() {
		
		inicializa();
	}
	
	private void inicializa() {
		
		settings = Settings.getInstancia();
		
		int[] rgb = settings.getColorFondos();
		setBackground(new Color(rgb[3], rgb[4], rgb[5]));
		setFocusable(true);
		setPreferredSize(new Dimension(settings.laberinto.RES_X, settings.laberinto.RES_Y));
		
		comenzar();
	}
	
	private void comenzar() {
		
		instancias = new Instancias(settings);
		
		pared = instancias.instanciarParedesLaberinto();
		puntitos = instancias.instanciarPuntitosLaberinto();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		renderiza(g);
	}
	
	private void renderiza(Graphics g) {
		
		int[][] matriz = settings.laberinto.matriz;
		
		for (Pared tile: pared) {
			tile.dibuja(g);
		}
		
		for (Puntitos punt: puntitos) {
			punt.dibuja(g, matriz, settings);
		}
	}
}
