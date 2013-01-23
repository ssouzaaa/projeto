package Interfaces;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * Interface com as funcionalidades basicas de um botão 
 * no jogo de dama.
 * @author gilson
 */
public interface BotaoIF {
	
	void novaPartida(ImageIcon imagem,int tipoBotao);
	/**
	 * metodo que endica a posição do botão no tabuleiro.
	 * @return um verto de inteiro.
	 */
	int[] posicao();
	/**
	 * @return um JButoon, um botão do jogo.
	 */
	JButton getBotao();
	/**
	 * metodo para altera a imagem do botão no jogo.
	 * @param i um imagem para coloca no botão.
	 */
	void setImagemBotao(ImageIcon i);
	
	void setClicou(boolean clicou);
	
	boolean getClicou();
	/**
	 * @return um boolean para endica se essa casa pordi ou não se clicada.
	 */
	boolean getPordi();
	/**
	 * altera o valor do canpo para verdadeiro ou falso.
	 */
	void setPordi(boolean pordi);
	/**
	 * @param ehDama um boolean que endica se a peça é uma dama ou não.
	 */
	void setEhDama(boolean ehDama);
	/**
	 * @return um boolean que endica se a peça é uma dama ou não.
	 */
	boolean getEhDama();
	/**
	 * metodo que altera o tipo do botão para uma 
	 * casa branca, casa preta, casa azul ou casa vermelha.
	 * @param tipoBotao um inteiro.
	 */
	void setTipoBotao(int tipoBotao);
	/**
	 * metodo que diz qual é o tipo do botão.
	 * 1 o botão é uma casa vazia branca,
	 * 2 o botão é uma casa vazia preta,
	 * 3 o botão é uma casa branca com uma peça vermelha,
	 * 4 o botão é uma casa branca com uma peça azul,
	 * @return um inteiro.
	 */
	int getTipoBotao();
}