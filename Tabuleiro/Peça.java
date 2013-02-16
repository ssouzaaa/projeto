package Tabuleiro;

import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Grafico.EventoPe�a;
/**
 * classe com as funcionalidades de uma pe�a de dama.
 * @author gilson
 */
public class Pe�a implements Serializable{

	private static final int EHPE�ABRANCA = 1,EHPE�APRETA = 2,EHPE�AVERMELHA = 3,EHPE�AAZUL = 4;
	private JButton pe�aBotao;
	private boolean pordiMover,ehDama;
	private int tipoPe�a;
	private EventoPe�a evento;
	
	public Pe�a(int linha,int coluna,Fachada fachada){
		this.pe�aBotao = new JButton();
		this.pordiMover = false;
		this.ehDama = false;
		this.tipoPe�a = 0;
		this.evento = new EventoPe�a(linha,coluna,fachada);
		this.pe�aBotao.addActionListener(this.evento);
	}
	public static int EHPE�ABRANCA(){
		return EHPE�ABRANCA;
	}
	public static int EHPE�APRETA(){
		return EHPE�APRETA;
	}
	public static int EHPE�AVERMELHA(){
		return EHPE�AVERMELHA;
	}
	public static int EHPE�AAZUL(){
		return EHPE�AAZUL;
	}
	public void novaPartida(ImageIcon imagem,int tipoBotao){
		this.pe�aBotao.setIcon(imagem);
		this.tipoPe�a = tipoBotao;
		this.pordiMover = false;
		this.ehDama = false;
	}
	public JButton getBotao() {
		return this.pe�aBotao;
	}
	public void setImagemBotao(ImageIcon i) {
		this.pe�aBotao.setIcon(i);
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
	public void setTipoPe�a(int tipoPe�a){
		this.tipoPe�a = tipoPe�a;
	}
	public int getTipoPe�a(){
		return this.tipoPe�a;
	}
	public int[] posicao() {
		return this.posicao();
	}
}