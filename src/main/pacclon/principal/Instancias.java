package main.pacclon.principal;

import java.util.ArrayList;

import main.pacclon.settings.Settings;
import main.pacclon.sprites.PacMan;
import main.pacclon.sprites.Pared;
import main.pacclon.sprites.Puntitos;

public class Instancias {
	
	private int filas;
	private int columnas;
	private int ancho;
	private int alto;
	
	private Settings settings;
	private ArrayList<Pared> pared = new ArrayList<>();
	private ArrayList<Puntitos> puntitos = new ArrayList<>();
	private PacMan pacman;
	
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
				
				if (tile == settings.laberinto.PARED) {
					pared.add(new Pared(ii, i, ancho, alto));
				}
			}
		}
		
		return pared;
	}
	
	public ArrayList<Puntitos> instanciarPuntitosLaberinto() {
		
		for (int i = 0; i < this.filas; i ++) {
			
			for (int ii = 0; ii < this.columnas; ii ++) {
				
				int tile = settings.laberinto.matriz[i][ii];
				
				// 1 = Puntito, 5 = puntito Gordo
				if (tile == settings.laberinto.PUNTITO) {
					
					puntitos.add(new Puntitos(ii, i, ancho, alto, false));
					int acum = settings.laberinto.getContadorPuntitos();
					settings.laberinto.setContadorPuntitos(acum + 1);
					
				} else if (tile == settings.laberinto.PUNTITO_GORDO) {
					
					puntitos.add(new Puntitos(ii, i, ancho, alto, true));
					int acum = settings.laberinto.getContadorPuntitosGordos();
					settings.laberinto.setContadorPuntitosGordos(acum + 1);
				}
			}
		}
		
		return puntitos;
	}
	
	public PacMan instanciarPacMan() {
		
		int[][] args = settings.getIniSprites();
		
		pacman = new PacMan(args[0][0], args[0][1],
				settings.laberinto.TILE_X, settings.laberinto.TILE_Y, args[0][3]);
		
		return pacman;
	}
}
