package Tabuleiro;

import java.io.IOException;
import java.io.Serializable;

import Arquivo.Gravador;

public class Fachada implements Serializable{

	private GerenteJogador gerente;
	private Tabuleiro tabuleiro;
	private Gravador gravador;
	
	public Fachada(){
		this.gerente = new GerenteJogador();
		this.tabuleiro = new Tabuleiro(this);
		this.gravador = new Gravador();
	}
	public void iniciarPartida(String nome,String nome2){
		this.gerente.setNomeJogador1(nome);
		this.gerente.setNomeJogador2(nome2);
		this.gerente.novaPartida();
		this.tabuleiro.jogadaAzul();
	}
	public void retomaJogo() throws IOException{
		this.gerente = this.gravador.lerJogado();
		this.tabuleiro = this.gravador.lerTabuleiro();
	}
	public void salvaJogo() throws IOException{
		this.gravador.gravaTabuleiro(this.tabuleiro);
		this.gravador.gravaJogado(this.gerente);
	}
	public void novaPartida(){
		this.gerente.novaPartida();
		this.tabuleiro.novaPartida();
		this.tabuleiro.tudoProibido();
		this.tabuleiro.jogadaAzul();
	}
	public void movimentosDaPeça(int linha,int coluna){
		this.tabuleiro.movimentosDaPeça(linha, coluna);
	}
	public void trocaDePeças(int linha,int coluna,int linha2,int coluna2){
		this.tabuleiro.trocaDePeças(linha, coluna, linha2, coluna2);
		this.gerente.jogadorCapturouPeça();
	}
	public String ganhador(){
		return this.gerente.ganhador();
	}
	public Tabuleiro getTabuleiro(){
		return this.tabuleiro;
	}
}