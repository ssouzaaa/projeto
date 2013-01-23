package Interfaces;

public interface TrocaDePeçasIF {

	/**
	 * metodo que calcula qual foi a peça comida pela dama.
	 * @param linha primeiro indeci do verto de botões da primeira peça.
	 * @param coluna seundo indeci do verto de botões da primeira peça.
	 * @param linha2 primeiro indeci do verto de botões da segunda peça.
	 * @param coluna2 segundo indeci do verto de botões da segunda peça.
	 * @param qualJogado endica qual é a peça vermelha ou azul.
	 * @return um verto de inteiro que é a posição da peça comida pela dama.
	 
	int[] calculaPecaComidaPelaDama(int linha,int coluna,int linha2,int coluna2,boolean qualPeça);*/
	/**
	 * metodo que faz a troca da primeira peça em uma casa branca e a outra na sua corespondente, ou seja,
	 * em uma azul ou vermelha.
	 * @param linha primeiro indeci do verto de botões da primeira peça.
	 * @param coluna seundo indeci do verto de botões da primeira peça.
	 * @param linha2 primeiro indeci do verto de botões da segunda peça.
	 * @param coluna2 segundo indeci do verto de botões da segunda peça
	 */
	void trocaDePeça(int linha,int coluna,int linha2,int coluna2);
	/**
	 * metodo que faz a troca da primeira peça em uma casa branca e a outra em uma casa com uma
	 * peça que é dama.
	 * @param linha primeiro indeci do verto de botões da primeira peça.
	 * @param coluna seundo indeci do verto de botões da primeira peça.
	 * @param linha2 primeiro indeci do verto de botões da segunda peça.
	 * @param coluna2 segundo indeci do verto de botões da segunda peça
	 */
	void trocaDeDama(int linha,int coluna,int linha2,int coluna2);
	/**
	 * metodo para encontra a peça comida e mudala para uma casa branca.
	 * @param linha primeiro indeci do verto de botões da primeira peça.
	 * @param coluna seundo indeci do verto de botões da primeira peça.
	 * @param linha2 primeiro indeci do verto de botões da segunda peça.
	 * @param coluna2 segundo indeci do verto de botões da segunda peça.
	 * @param qualPeça endica qual é o tipo e peça azul ou vermelha.
	 */
	void trocaDePeçaComida(int linha,int coluna,int linha2,int coluna2,boolean qualPeça);
}
