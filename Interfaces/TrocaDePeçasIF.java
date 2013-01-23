package Interfaces;

public interface TrocaDePe�asIF {

	/**
	 * metodo que calcula qual foi a pe�a comida pela dama.
	 * @param linha primeiro indeci do verto de bot�es da primeira pe�a.
	 * @param coluna seundo indeci do verto de bot�es da primeira pe�a.
	 * @param linha2 primeiro indeci do verto de bot�es da segunda pe�a.
	 * @param coluna2 segundo indeci do verto de bot�es da segunda pe�a.
	 * @param qualJogado endica qual � a pe�a vermelha ou azul.
	 * @return um verto de inteiro que � a posi��o da pe�a comida pela dama.
	 
	int[] calculaPecaComidaPelaDama(int linha,int coluna,int linha2,int coluna2,boolean qualPe�a);*/
	/**
	 * metodo que faz a troca da primeira pe�a em uma casa branca e a outra na sua corespondente, ou seja,
	 * em uma azul ou vermelha.
	 * @param linha primeiro indeci do verto de bot�es da primeira pe�a.
	 * @param coluna seundo indeci do verto de bot�es da primeira pe�a.
	 * @param linha2 primeiro indeci do verto de bot�es da segunda pe�a.
	 * @param coluna2 segundo indeci do verto de bot�es da segunda pe�a
	 */
	void trocaDePe�a(int linha,int coluna,int linha2,int coluna2);
	/**
	 * metodo que faz a troca da primeira pe�a em uma casa branca e a outra em uma casa com uma
	 * pe�a que � dama.
	 * @param linha primeiro indeci do verto de bot�es da primeira pe�a.
	 * @param coluna seundo indeci do verto de bot�es da primeira pe�a.
	 * @param linha2 primeiro indeci do verto de bot�es da segunda pe�a.
	 * @param coluna2 segundo indeci do verto de bot�es da segunda pe�a
	 */
	void trocaDeDama(int linha,int coluna,int linha2,int coluna2);
	/**
	 * metodo para encontra a pe�a comida e mudala para uma casa branca.
	 * @param linha primeiro indeci do verto de bot�es da primeira pe�a.
	 * @param coluna seundo indeci do verto de bot�es da primeira pe�a.
	 * @param linha2 primeiro indeci do verto de bot�es da segunda pe�a.
	 * @param coluna2 segundo indeci do verto de bot�es da segunda pe�a.
	 * @param qualPe�a endica qual � o tipo e pe�a azul ou vermelha.
	 */
	void trocaDePe�aComida(int linha,int coluna,int linha2,int coluna2,boolean qualPe�a);
}
