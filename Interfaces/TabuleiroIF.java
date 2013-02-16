package Interfaces;

public interface TabuleiroIF {

	/**
	 * metodo para inicia um novo jogo, restaurando
	 * assim o tabuleiro e as peças as suas formas
	 * inicias.
	 */
	void novaPartida();
	
	/**
	 * metodo que permite apenas as peças azuis serem 
	 * clicadas no jogo.
	 */
	void jogadaAzul();
	
	/**
	 * metodo que permite apenas as peças vermelhas a
	 * serem clicadas no jogo.
	 */
	void jogadaVermelha();
	
	/**
	 * metodo que proibi tudo com a finalidade de 
	 * quando o jogado termia sua partida não seja
	 * deixada nenhua peça que possa ser clicada.
	 */
	void tudoProibido();
}
