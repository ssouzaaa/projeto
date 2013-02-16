package Tabuleiro;

import java.io.Serializable;

import Imagens.Imagens;
import Interfaces.*;

public class Tabuleiro implements TabuleiroIF,Serializable{

	private static boolean FOICAPTURADA = false;
	private Peça[][] peça;
	private TrocaDePeças troca;
	private MovimentoDasPeças movimneto;
	private Imagens imagens;
	
	public Tabuleiro(Fachada fachada){
		this.peça = new Peça[8][8];
		this.imagens = new Imagens();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				this.peça[i][j] =  new Peça(i,j,fachada);
			}
		}
		this.novaPartida();
		this.troca = new TrocaDePeças(this.peça);
		this.movimneto = new MovimentoDasPeças(this.peça);
	}
	public static void SETFOICAPTURADA(){
		FOICAPTURADA = false;
	}
	public static boolean GETFOICAPTURADA(){
		return FOICAPTURADA;
	}
	public void novaPartida() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(i == 0 || i == 1 || i == 2){
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.peça[i][j].novaPartida(this.imagens.getPreto(),Peça.EHPEÇAPRETA());
						}
						else{
							this.peça[i][j].novaPartida(this.imagens.getAzul(),Peça.EHPEÇAAZUL());
						}
					}
					else{
						if(j % 2 == 0){
							this.peça[i][j].novaPartida(this.imagens.getAzul(),Peça.EHPEÇAAZUL());	
						}else{
							this.peça[i][j].novaPartida(this.imagens.getPreto(),Peça.EHPEÇAPRETA());
						}
					}
				}
				else if(i == 5 || i == 6 || i == 7){
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.peça[i][j].novaPartida(this.imagens.getPreto(),Peça.EHPEÇAPRETA());
						}
						else{
							this.peça[i][j].novaPartida(this.imagens.getVermelho(),Peça.EHPEÇAVERMELHA());
						}
					}
					else{
						if(j % 2 == 0){
							this.peça[i][j].novaPartida(this.imagens.getVermelho(),Peça.EHPEÇAVERMELHA());
						}
						else{
							this.peça[i][j].novaPartida(this.imagens.getPreto(),Peça.EHPEÇAPRETA());
						}
					}
				}else{
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.peça[i][j].novaPartida(this.imagens.getPreto(),Peça.EHPEÇAPRETA());
						}
						else{
							this.peça[i][j].novaPartida(this.imagens.getBranco(),Peça.EHPEÇABRANCA());
						}
					}
					else{
						if(j % 2 == 0){
							this.peça[i][j].novaPartida(this.imagens.getBranco(),Peça.EHPEÇABRANCA());
						}
						else{
							this.peça[i][j].novaPartida(this.imagens.getPreto(),Peça.EHPEÇABRANCA());
						}
					}
				}
			}
		}
	}
	public void movimentosDaPeça(int linha,int coluna){
		if(this.peça[linha][coluna].getEhDama()){
			this.movimneto.movimentoDama(linha, coluna);
		}else{
			if(!MovimentoDasPeças.GETSEGUNDOMOVIMENTO()){
				MovimentoDasPeças.SETSEGUNDOMOVIMENTO(true);
				if(this.peça[linha][coluna].getTipoPeça() == Peça.EHPEÇAAZUL()){
					this.movimneto.movimentoNormalAzul(linha, coluna);
				}else{
					this.movimneto.movimentoNormalVermelho(linha, coluna);
				}
			}else{
				this.movimneto.movimentoCapturaPeca(linha, coluna);
			}
		}
	}
	public void trocaDePeças(int linha,int coluna,int linha2,int coluna2){
		int[] peçaCapturada = {-1,-1};
		if(this.peça[linha][coluna].getTipoPeça() == Peça.EHPEÇAAZUL()){
			if(this.peça[linha][coluna].getEhDama()){
				this.troca.trocaDeDamaAzul(linha, coluna, linha2, coluna2);
				peçaCapturada = this.troca.calculaPecaCapturadaPelaDama(linha, coluna, linha2, coluna2, Peça.EHPEÇAAZUL());
			}else {
				this.troca.trocaDePeçaAzul(linha, coluna, linha2, coluna2);
				peçaCapturada = this.troca.calculaPeçaCapturada(linha, coluna, linha2, coluna2);
			}
		}else{
			if(this.peça[linha][coluna].getEhDama()){
				this.troca.trocaDeDamaVermelha(linha, coluna, linha2, coluna2);
				peçaCapturada = this.troca.calculaPecaCapturadaPelaDama(linha, coluna, linha2, coluna2, Peça.EHPEÇAVERMELHA());
			}else {
				this.troca.trocaDePeçaVermelha(linha, coluna, linha2, coluna2);
				peçaCapturada = this.troca.calculaPeçaCapturada(linha, coluna, linha2, coluna2);
			}
		}
		if(peçaCapturada[0] != -1 & peçaCapturada[1] != -1){
			this.troca.trocaParaCasabranca(peçaCapturada[0], peçaCapturada[1]);
			FOICAPTURADA = true;
		}
	}
	public void jogadaAzul() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.peça[i][j].getTipoPeça() == 4){
					this.peça[i][j].setPordiMover(true);
				}
			}
		}
	}
	public void jogadaVermelha() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.peça[i][j].getTipoPeça() == 3){
					this.peça[i][j].setPordiMover(true);
				}
			}
		}
	}
	public void tudoProibido() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				this.peça[i][j].setPordiMover(false);
			}
		}
	}
	public Peça[][] getPeçaTabuleiro(){
		return this.peça;
	}
}