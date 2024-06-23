package main.pacclon.interfaces;

import main.pacclon.settings.Settings;

public interface ISpritesMethods extends ISpritesDraw {
	
	// Para calcular la velocidad -> divide TILE / DIVIDIR_ENTRE_TILE
	// Ejemplo -> (50 / 10 = 5px es la Velocidad)
	static int DIVIDIR_TILE_ENTRE = 10;
	
	void actualiza(int[][] matriz, Settings sett);
	
	default Boolean checkColisionLaberintoVelXY(int x, int y, int[] velXY, int[][] matriz, Settings sett) {
		
		return false;
	}
	
	default int escapatorias(int x, int laberintoLength, int tileX, int direccion) {
		
		return 0;
	}
}
