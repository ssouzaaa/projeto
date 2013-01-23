package Interfaces;

import Tabuleiro.Jogado;

public interface TabuleiroIF {

	void novaPartida(Jogado jogado1,Jogado jogado2);
	
	void jogadaAzul();
	
	void jogadaVermelha();
	
	void tudoProibido();
}
