package Tabuleiro;

import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Grafico.EventoPeça;
/**
 * classe com as funcionalidades de uma peça de dama.
 * @author gilson
 */
public class Peça implements Serializable{

	private static final int EHPEÇABRANCA = 1,EHPEÇAPRETA = 2,EHPEÇAVERMELHA = 3,EHPEÇAAZUL = 4;
	private JButton peçaBotao;
	private boolean pordiMover,ehDama;
	private int tipoPeça;
	private EventoPeça evento;
	
	public Peça(int linha,int coluna,Fachada fachada){
		this.peçaBotao = new JButton();
		this.pordiMover = false;
		this.ehDama = false;
		this.tipoPeça = 0;
		this.evento = new EventoPeça(linha,coluna,fachada);
		this.peçaBotao.addActionListener(this.evento);
	}
	public static int EHPEÇABRANCA(){
		return EHPEÇABRANCA;
	}
	public static int EHPEÇAPRETA(){
		return EHPEÇAPRETA;
	}
	public static int EHPEÇAVERMELHA(){
		return EHPEÇAVERMELHA;
	}
	public static int EHPEÇAAZUL(){
		return EHPEÇAAZUL;
	}
	public void novaPartida(ImageIcon imagem,int tipoBotao){
		this.peçaBotao.setIcon(imagem);
		this.tipoPeça = tipoBotao;
		this.pordiMover = false;
		this.ehDama = false;
	}
	public JButton getBotao() {
		return this.peçaBotao;
	}
	public void setImagemBotao(ImageIcon i) {
		this.peçaBotao.setIcon(i);
	}
	public boolean getPordiMover() {
		return this.pordiMover;
	}
	public void setPordiMover(boolean pordi) {
		this.pordiMover = pordi;
	}
	public void setEhDama(boolean ehDama){
		this.ehDama = ehDama;
	}
	public boolean getEhDama(){
		return this.ehDama;
	}
	public void setTipoPeça(int tipoPeça){
		this.tipoPeça = tipoPeça;
	}
	public int getTipoPeça(){
		return this.tipoPeça;
	}
	public int[] posicao() {
		return this.posicao();
	}
}