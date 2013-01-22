package Tabuleiro;

import java.io.Serializable;

import Grafico.*;
import Imagens.Imagens;
import Interfaces.*;

public class Tabuleiro implements TabuleiroIF,Serializable{

	private Botao[][] botao;
	private Imagens imagens;
	
	public Tabuleiro(Jogado jogado1,Jogado jogado2){
		this.botao = new Botao[8][8];
		this.imagens = new Imagens();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				this.botao[i][j] =  new Botao(i,j);
			}
		}
		this.novaPartida(jogado1,jogado2);
	}
	public void novaPartida(Jogado jogado1,Jogado jogado2) {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(i == 0 || i == 1 || i == 2){
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.botao[i][j].novaPartida(this.imagens.getPreto(),2);
							this.botao[i][j].setEvento(new EventoBotaoPreto(i,j,this));
						}
						else{
							this.botao[i][j].novaPartida(this.imagens.getAzul(),4);
							this.botao[i][j].setEvento(new EventoBotaoAzul(i,j,this));
							EventoBotaoAzul e = (EventoBotaoAzul) this.botao[i][j].getEvento();
						}
					}
					else{
						if(j % 2 == 0){
							this.botao[i][j].novaPartida(this.imagens.getAzul(),4);	
							this.botao[i][j].setEvento(new EventoBotaoAzul(i,j,this));
							EventoBotaoAzul e = (EventoBotaoAzul) this.botao[i][j].getEvento();
						}else{
							this.botao[i][j].novaPartida(this.imagens.getPreto(),2);
							this.botao[i][j].setEvento(new EventoBotaoPreto(i,j,this));
						}
					}
				}
				else if(i == 5 || i == 6 || i == 7){
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.botao[i][j].novaPartida(this.imagens.getPreto(),2);
							this.botao[i][j].setEvento(new EventoBotaoPreto(i,j,this));
						}
						else{
							this.botao[i][j].novaPartida(this.imagens.getVermelho(),3);
							this.botao[i][j].setEvento(new EventoBotaoVermelho(i,j,this));
							EventoBotaoVermelho e = (EventoBotaoVermelho) this.botao[i][j].getEvento();
						}
					}
					else{
						if(j % 2 == 0){
							this.botao[i][j].novaPartida(this.imagens.getVermelho(),3);
							this.botao[i][j].setEvento(new EventoBotaoVermelho(i,j,this));
							EventoBotaoVermelho e = (EventoBotaoVermelho) this.botao[i][j].getEvento();
						}
						else{
							this.botao[i][j].novaPartida(this.imagens.getPreto(),2);
							this.botao[i][j].setEvento(new EventoBotaoPreto(i,j,this));
						}
					}
				}else{
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.botao[i][j].novaPartida(this.imagens.getPreto(),2);
							this.botao[i][j].setEvento(new EventoBotaoPreto(i,j,this));
						}
						else{
							this.botao[i][j].novaPartida(this.imagens.getBranco(),1);
							this.botao[i][j].setEvento(new EventoBotaoBranco(i,j,this));
							EventoBotaoBranco e = (EventoBotaoBranco)this.botao[i][j].getEvento();
							e.setEvento(jogado1, jogado2);
						}
					}
					else{
						if(j % 2 == 0){
							this.botao[i][j].novaPartida(this.imagens.getBranco(),1);
							this.botao[i][j].setEvento(new EventoBotaoBranco(i,j,this));
							EventoBotaoBranco e = (EventoBotaoBranco)this.botao[i][j].getEvento();
							e.setEvento(jogado1, jogado2);
						}
						else{
							this.botao[i][j].novaPartida(this.imagens.getPreto(),1);
							this.botao[i][j].setEvento(new EventoBotaoBranco(i,j,this));
							EventoBotaoBranco e = (EventoBotaoBranco)this.botao[i][j].getEvento();
							e.setEvento(jogado1, jogado2);
						}
					}
				}
			}
		}
	}
	public int[] botaoClicado(){
		int[] posicao = {0,0};
		for(int i = 0; i < 8; i++){
			for(int  j = 0; j < 8; j++){
				if(this.botao[i][j].getClicou()){
					posicao[0] = i;
					posicao[1] = j;
					this.botao[i][j].setClicou(false);
				}
			}
		}
		return posicao;
	}
	public void jogadaAzul() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.botao[i][j].getTipoBotao() == 4){
					this.botao[i][j].setPordi(true);
				}
			}
		}
	}
	public void jogadaVermelha() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.botao[i][j].getTipoBotao() == 3){
					this.botao[i][j].setPordi(true);
				}
			}
		}
	}
	public void tudoProibido() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				this.botao[i][j].setPordi(false);
			}
		}
	}
	public Botao[][] getBotao(){
		return this.botao;
	}
}