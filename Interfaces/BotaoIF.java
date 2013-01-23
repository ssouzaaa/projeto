package Interfaces;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * Interface com as funcionalidades basicas de um bot�o 
 * no jogo de dama.
 * @author gilson
 */
public interface BotaoIF {
	
	void novaPartida(ImageIcon imagem,int tipoBotao);
	/**
	 * metodo que endica a posi��o do bot�o no tabuleiro.
	 * @return um verto de inteiro.
	 */
	int[] posicao();
	/**
	 * @return um JButoon, um bot�o do jogo.
	 */
	JButton getBotao();
	/**
	 * metodo para altera a imagem do bot�o no jogo.
	 * @param i um imagem para coloca no bot�o.
	 */
	void setImagemBotao(ImageIcon i);
	
	void setClicou(boolean clicou);
	
	boolean getClicou();
	/**
	 * @return um boolean para endica se essa casa pordi ou n�o se clicada.
	 */
	boolean getPordi();
	/**
	 * altera o valor do canpo para verdadeiro ou falso.
	 */
	void setPordi(boolean pordi);
	/**
	 * @param ehDama um boolean que endica se a pe�a � uma dama ou n�o.
	 */
	void setEhDama(boolean ehDama);
	/**
	 * @return um boolean que endica se a pe�a � uma dama ou n�o.
	 */
	boolean getEhDama();
	/**
	 * metodo que altera o tipo do bot�o para uma 
	 * casa branca, casa preta, casa azul ou casa vermelha.
	 * @param tipoBotao um inteiro.
	 */
	void setTipoBotao(int tipoBotao);
	/**
	 * metodo que diz qual � o tipo do bot�o.
	 * 1 o bot�o � uma casa vazia branca,
	 * 2 o bot�o � uma casa vazia preta,
	 * 3 o bot�o � uma casa branca com uma pe�a vermelha,
	 * 4 o bot�o � uma casa branca com uma pe�a azul,
	 * @return um inteiro.
	 */
	int getTipoBotao();
}