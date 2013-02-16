package Tabuleiro;

import java.io.Serializable;

import Imagens.Imagens;

public class TrocaDePe�as implements Serializable{

	private Pe�a[][] pe�a;
	private Imagens imagem;
	
	public TrocaDePe�as(Pe�a[][] pe�a){
		this.pe�a = pe�a;
		this.imagem = new Imagens();
	}
	public void trocaParaCasabranca(int linha,int coluna){
		Imagens imagem = new Imagens();
		this.pe�a[linha][coluna].setImagemBotao(imagem.getBranco());
		this.pe�a[linha][coluna].setTipoPe�a(1);
	}
	public void trocaDePe�aAzul(int linha, int coluna, int linha2, int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.pe�a[linha2][coluna2].setImagemBotao(this.imagem.getAzul());
		this.pe�a[linha2][coluna2].setTipoPe�a(4);
	}
	public void trocaDeDamaAzul(int linha, int coluna, int linha2, int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.pe�a[linha2][coluna2].setImagemBotao(this.imagem.getAzulDama());
		this.pe�a[linha2][coluna2].setTipoPe�a(4);
	}
	public void trocaDePe�aVermelha(int linha, int coluna, int linha2,int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.pe�a[linha2][coluna2].setImagemBotao(this.imagem.getVermelho());
		this.pe�a[linha2][coluna2].setTipoPe�a(3);
	}
	public void trocaDeDamaVermelha(int linha, int coluna, int linha2,int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.pe�a[linha2][coluna2].setImagemBotao(this.imagem.getVermelhoDama());
		this.pe�a[linha2][coluna2].setTipoPe�a(3);
	}
	public int[] calculaPe�aCapturada(int linha,int coluna,int linha2,int coluna2){
		int[] posicao = {-1,-1};
		if(linha - 2 == linha2){
			if(coluna - 2 == coluna2){
				posicao[0] = linha - 1;
				posicao[1] = coluna - 1;
			}else{
				posicao[0] = linha - 1;
				posicao[1] = coluna + 1;
			}
		}else{
			if(coluna - 2 == coluna2){
				posicao[0] = linha + 1;
				posicao[1] = coluna - 1;
			}else{
				posicao[0] = linha + 1;
				posicao[1] = coluna + 1;
			}
		}
		return posicao;
	}
	public int[] calculaPecaCapturadaPelaDama(int linha, int coluna, int linha2,int coluna2,int qualPe�a) {
		int[] posicao = {-1,-1};
		int x = linha,y = coluna;
		if(linha > linha2 & coluna < coluna ){
			while(x > linha2){
				x--;
				y++;
				if(this.pe�a[x][y].getTipoPe�a() == qualPe�a){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				 }
			}
		}else if(linha > linha2 & coluna > coluna2){
			while(x > linha2){
				x--;
				y--;
				if(this.pe�a[x][y].getTipoPe�a() == qualPe�a){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				 }
			}
		}else if(linha < linha2 & coluna > coluna2){
			while(x < linha2){
				x++;
				y--;
				if(this.pe�a[x][y].getTipoPe�a() == qualPe�a){
					 posicao[0] = x;
					 posicao[1] = y;
					 return posicao;
				 }
			}
		}else{
			while(x < linha){
				x++;
				y++;
				if(this.pe�a[x][y].getTipoPe�a() == qualPe�a){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				}
			}
		}return posicao;
	}
}