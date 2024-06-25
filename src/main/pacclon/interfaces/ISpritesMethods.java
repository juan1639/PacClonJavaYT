package main.pacclon.interfaces;

import main.pacclon.settings.Settings;

public interface ISpritesMethods extends ISpritesDraw {
	
	// Para calcular la velocidad -> divide TILE / DIVIDIR_ENTRE_TILE
	// Ejemplo -> (50 / 10 = 5px es la Velocidad)
	static int DIVIDIR_TILE_ENTRE = 10;
	
	void actualiza(int[][] matriz, Settings sett);
	
	default Boolean checkColisionLaberintoVelXY(int x, int y, int[] velXY, int[][] matriz, Settings sett) {
		
		// PRIMERO VERIFICAMOS QUE EL VALOR ESTE DENTRO DEL ARRAY...
		if (x + velXY[0] < 0 || x + velXY[0] >= sett.laberinto.matriz[0].length) return false;
		
		if (matriz[y + velXY[1]][x + velXY[0]] == sett.laberinto.PARED) {
			return true;
		}
		
		return false;
	}
	
	default int escapatorias(int x, int laberintoLength, int tileX, int direccion) {
		
		return 0;
	}
}
