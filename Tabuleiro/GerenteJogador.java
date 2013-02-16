package Tabuleiro;

import java.io.Serializable;

public class GerenteJogador implements Serializable{

	private static boolean JOGADORATUAL = true;
	private Jogador jogador1,jogador2;
	
	public GerenteJogador(){
		this.jogador1 = new Jogador();
		this.jogador2 = new Jogador();
	}
	public String ganhador(){
		if(this.jogador1.getPonto() == 0){
			return this.jogador1.getNome();
		}else if(this.jogador2.getPonto() == 0){
			return this.jogador2.getNome();
		}
		return null;
	}
	public void jogadorCapturouPeça(){
		if(Tabuleiro.GETFOICAPTURADA()){
			Tabuleiro.SETFOICAPTURADA();
			if(JOGADORATUAL){
				this.jogador1.setPonto();
			}else{
				this.jogador2.setPonto();
			}
		}
	}
	public void retomaJogadores(Jogador jogador1,Jogador jogador2){
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
	}
	public static void SETJOGADORATUAL(boolean jogadorAtual){
		JOGADORATUAL = jogadorAtual;
	}
	public static boolean GETJOGADORATUAL(){
		return JOGADORATUAL;
	}
	public void setNomeJogador1(String nome){
		this.jogador1.setNome(nome);
	}
	public void setNomeJogador2(String nome){
		this.jogador2.setNome(nome);
	}
	public String getNomeJogado1(){
		return this.jogador1.getNome();
	}
	public String getNomeJogador2(){
		return this.jogador2.getNome();
	}
	public void setPontoJogador1(){
		this.jogador1.setPonto();
	}
	public void setPontoJogador2(){
		this.jogador2.setPonto();
	}
	public int getpontoJogador1(){
		return this.jogador1.getPonto();
	}
	public int getpontoJogador2(){
		return this.jogador2.getPonto();
	}
	public void novaPartida(){
		this.jogador1.novaPartida();
		this.jogador2.novaPartida();
	}
}
