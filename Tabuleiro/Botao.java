package Tabuleiro;

import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Arquivo.EventoBotao;
import Grafico.EventoBotaoAbstract;
import Interfaces.BotaoIF;
/**
 * classe com as funcionalidades de uma peça de dama.
 * @author gilson
 */
public class Botao implements BotaoIF,Serializable{

	private JButton imagensBotao;
	private boolean pordi,ehDama,clicou;
	private int tipoBotao;
	private EventoBotaoAbstract evento;
	
	public Botao(int linha,int coluna){
		this.imagensBotao = new JButton();
		this.pordi = false;
		this.ehDama = false;
		this.clicou = false;
		this.tipoBotao = 0;
		this.evento = null;
	}
	public void setEvento(EventoBotaoAbstract evento){
		this.evento = evento;
		this.imagensBotao.addActionListener(this.evento);
	}
	public void novaPartida(ImageIcon imagem,int tipoBotao){
		this.imagensBotao.setIcon(imagem);
		this.tipoBotao = tipoBotao;
		this.pordi = false;
		this.ehDama = false;
	}
	public JButton getBotao() {
		return this.imagensBotao;
	}
	public void setImagemBotao(ImageIcon i) {
		this.imagensBotao.setIcon(i);
	}
	public void setClicou(boolean clicou){
		this.clicou = clicou;
	}
	public boolean getClicou(){
		return this.clicou;
	}
	public boolean getPordi() {
		return this.pordi;
	}
	public void setPordi(boolean pordi) {
		this.pordi = pordi;
	}
	public void setEhDama(boolean ehDama){
		this.ehDama = ehDama;
	}
	public boolean getEhDama(){
		return this.ehDama;
	}
	public void setTipoBotao(int tipoBotao){
		this.tipoBotao = tipoBotao;
	}
	public int getTipoBotao(){
		return this.tipoBotao;
	}
	public EventoBotaoAbstract getEvento(){
		return this.evento;
	}
	@Override
	public int[] posicao() {
		return null;
	}
}