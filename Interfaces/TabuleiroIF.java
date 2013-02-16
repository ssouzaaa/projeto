package Interfaces;

public interface TabuleiroIF {

	/**
	 * metodo para inicia um novo jogo, restaurando
	 * assim o tabuleiro e as pe�as as suas formas
	 * inicias.
	 */
	void novaPartida();
	
	/**
	 * metodo que permite apenas as pe�as azuis serem 
	 * clicadas no jogo.
	 */
	void jogadaAzul();
	
	/**
	 * metodo que permite apenas as pe�as vermelhas a
	 * serem clicadas no jogo.
	 */
	void jogadaVermelha();
	
	/**
	 * metodo que proibi tudo com a finalidade de 
	 * quando o jogado termia sua partida n�o seja
	 * deixada nenhua pe�a que possa ser clicada.
	 */
	void tudoProibido();
}
