package Tabuleiro;

import java.io.Serializable;

import Imagens.Imagens;
import Interfaces.*;

public class Tabuleiro implements TabuleiroIF,Serializable{

	private static boolean FOICAPTURADA = false;
	private Pe�a[][] pe�a;
	private TrocaDePe�as troca;
	private MovimentoDasPe�as movimneto;
	private Imagens imagens;
	
	public Tabuleiro(Fachada fachada){
		this.pe�a = new Pe�a[8][8];
		this.imagens = new Imagens();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				this.pe�a[i][j] =  new Pe�a(i,j,fachada);
			}
		}
		this.novaPartida();
		this.troca = new TrocaDePe�as(this.pe�a);
		this.movimneto = new MovimentoDasPe�as(this.pe�a);
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
							this.pe�a[i][j].novaPartida(this.imagens.getPreto(),Pe�a.EHPE�APRETA());
						}
						else{
							this.pe�a[i][j].novaPartida(this.imagens.getAzul(),Pe�a.EHPE�AAZUL());
						}
					}
					else{
						if(j % 2 == 0){
							this.pe�a[i][j].novaPartida(this.imagens.getAzul(),Pe�a.EHPE�AAZUL());	
						}else{
							this.pe�a[i][j].novaPartida(this.imagens.getPreto(),Pe�a.EHPE�APRETA());
						}
					}
				}
				else if(i == 5 || i == 6 || i == 7){
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.pe�a[i][j].novaPartida(this.imagens.getPreto(),Pe�a.EHPE�APRETA());
						}
						else{
							this.pe�a[i][j].novaPartida(this.imagens.getVermelho(),Pe�a.EHPE�AVERMELHA());
						}
					}
					else{
						if(j % 2 == 0){
							this.pe�a[i][j].novaPartida(this.imagens.getVermelho(),Pe�a.EHPE�AVERMELHA());
						}
						else{
							this.pe�a[i][j].novaPartida(this.imagens.getPreto(),Pe�a.EHPE�APRETA());
						}
					}
				}else{
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.pe�a[i][j].novaPartida(this.imagens.getPreto(),Pe�a.EHPE�APRETA());
						}
						else{
							this.pe�a[i][j].novaPartida(this.imagens.getBranco(),Pe�a.EHPE�ABRANCA());
						}
					}
					else{
						if(j % 2 == 0){
							this.pe�a[i][j].novaPartida(this.imagens.getBranco(),Pe�a.EHPE�ABRANCA());
						}
						else{
							this.pe�a[i][j].novaPartida(this.imagens.getPreto(),Pe�a.EHPE�ABRANCA());
						}
					}
				}
			}
		}
	}
	public void movimentosDaPe�a(int linha,int coluna){
		if(this.pe�a[linha][coluna].getEhDama()){
			this.movimneto.movimentoDama(linha, coluna);
		}else{
			if(!MovimentoDasPe�as.GETSEGUNDOMOVIMENTO()){
				MovimentoDasPe�as.SETSEGUNDOMOVIMENTO(true);
				if(this.pe�a[linha][coluna].getTipoPe�a() == Pe�a.EHPE�AAZUL()){
					this.movimneto.movimentoNormalAzul(linha, coluna);
				}else{
					this.movimneto.movimentoNormalVermelho(linha, coluna);
				}
			}else{
				this.movimneto.movimentoCapturaPeca(linha, coluna);
			}
		}
	}
	public void trocaDePe�as(int linha,int coluna,int linha2,int coluna2){
		int[] pe�aCapturada = {-1,-1};
		if(this.pe�a[linha][coluna].getTipoPe�a() == Pe�a.EHPE�AAZUL()){
			if(this.pe�a[linha][coluna].getEhDama()){
				this.troca.trocaDeDamaAzul(linha, coluna, linha2, coluna2);
				pe�aCapturada = this.troca.calculaPecaCapturadaPelaDama(linha, coluna, linha2, coluna2, Pe�a.EHPE�AAZUL());
			}else {
				this.troca.trocaDePe�aAzul(linha, coluna, linha2, coluna2);
				pe�aCapturada = this.troca.calculaPe�aCapturada(linha, coluna, linha2, coluna2);
			}
		}else{
			if(this.pe�a[linha][coluna].getEhDama()){
				this.troca.trocaDeDamaVermelha(linha, coluna, linha2, coluna2);
				pe�aCapturada = this.troca.calculaPecaCapturadaPelaDama(linha, coluna, linha2, coluna2, Pe�a.EHPE�AVERMELHA());
			}else {
				this.troca.trocaDePe�aVermelha(linha, coluna, linha2, coluna2);
				pe�aCapturada = this.troca.calculaPe�aCapturada(linha, coluna, linha2, coluna2);
			}
		}
		if(pe�aCapturada[0] != -1 & pe�aCapturada[1] != -1){
			this.troca.trocaParaCasabranca(pe�aCapturada[0], pe�aCapturada[1]);
			FOICAPTURADA = true;
		}
	}
	public void jogadaAzul() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.pe�a[i][j].getTipoPe�a() == 4){
					this.pe�a[i][j].setPordiMover(true);
				}
			}
		}
	}
	public void jogadaVermelha() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.pe�a[i][j].getTipoPe�a() == 3){
					this.pe�a[i][j].setPordiMover(true);
				}
			}
		}
	}
	public void tudoProibido() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				this.pe�a[i][j].setPordiMover(false);
			}
		}
	}
	public Pe�a[][] getPe�aTabuleiro(){
		return this.pe�a;
	}
}