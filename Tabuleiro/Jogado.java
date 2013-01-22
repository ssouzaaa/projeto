package Tabuleiro;

import java.io.Serializable;

public class Jogado implements Serializable{

	private int ponto;
	private String nome;
	private boolean qualJogado;
	
	public Jogado(){
		this("");
	}
	public Jogado(String nome){
		this.ponto = 12;
		this.nome = nome;
		this.qualJogado = false;
	}
	public void setQualJogado(boolean qualJogado){
		this.qualJogado = qualJogado;
	}
	public boolean getQualogado(){
		return this.qualJogado;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	public void setPonto(){
		this.ponto--;
	}
	public void novaPartida(){
		this.ponto = 12;
	}
	public int getPonto(){
		return this.ponto;
	}
}
