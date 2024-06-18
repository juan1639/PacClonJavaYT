package main.pacclon.principal;

import java.util.ArrayList;

import main.pacclon.settings.Settings;
import main.pacclon.sprites.Pared;

public class Instancias {
	
	private int filas;
	private int columnas;
	private int ancho;
	private int alto;
	
	private Settings settings;
	private ArrayList<Pared> pared = new ArrayList<>();
	
	public Instancias(Settings settings) {
		
		this.settings = settings;
		
		this.filas = settings.laberinto.FILAS;
		this.columnas = settings.laberinto.COLUMNAS;
		
		this.ancho = settings.laberinto.TILE_X;
		this.alto = settings.laberinto.TILE_Y;
	}
	
	public ArrayList<Pared> instanciarParedesLaberinto() {
		
		for (int i = 0; i < this.filas; i ++) {
			
			for (int ii = 0; ii < this.columnas; ii ++) {
				
				int tile = settings.laberinto.matriz[i][ii];
				
				// 9 = Pared, 1 = puntito...
				
				if (tile == 9) {
					pared.add(new Pared(ii, i, ancho, alto));
				}
			}
		}
		
		return pared;
	}
}
