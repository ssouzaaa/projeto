package Tabuleiro;

import java.io.Serializable;

import Imagens.Imagens;

public class TrocaDePeças implements Serializable{

	private Peça[][] peça;
	private Imagens imagem;
	
	public TrocaDePeças(Peça[][] peça){
		this.peça = peça;
		this.imagem = new Imagens();
	}
	public void trocaParaCasabranca(int linha,int coluna){
		Imagens imagem = new Imagens();
		this.peça[linha][coluna].setImagemBotao(imagem.getBranco());
		this.peça[linha][coluna].setTipoPeça(1);
	}
	public void trocaDePeçaAzul(int linha, int coluna, int linha2, int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.peça[linha2][coluna2].setImagemBotao(this.imagem.getAzul());
		this.peça[linha2][coluna2].setTipoPeça(4);
	}
	public void trocaDeDamaAzul(int linha, int coluna, int linha2, int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.peça[linha2][coluna2].setImagemBotao(this.imagem.getAzulDama());
		this.peça[linha2][coluna2].setTipoPeça(4);
	}
	public void trocaDePeçaVermelha(int linha, int coluna, int linha2,int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.peça[linha2][coluna2].setImagemBotao(this.imagem.getVermelho());
		this.peça[linha2][coluna2].setTipoPeça(3);
	}
	public void trocaDeDamaVermelha(int linha, int coluna, int linha2,int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.peça[linha2][coluna2].setImagemBotao(this.imagem.getVermelhoDama());
		this.peça[linha2][coluna2].setTipoPeça(3);
	}
	public int[] calculaPeçaCapturada(int linha,int coluna,int linha2,int coluna2){
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
	public int[] calculaPecaCapturadaPelaDama(int linha, int coluna, int linha2,int coluna2,int qualPeça) {
		int[] posicao = {-1,-1};
		int x = linha,y = coluna;
		if(linha > linha2 & coluna < coluna ){
			while(x > linha2){
				x--;
				y++;
				if(this.peça[x][y].getTipoPeça() == qualPeça){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				 }
			}
		}else if(linha > linha2 & coluna > coluna2){
			while(x > linha2){
				x--;
				y--;
				if(this.peça[x][y].getTipoPeça() == qualPeça){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				 }
			}
		}else if(linha < linha2 & coluna > coluna2){
			while(x < linha2){
				x++;
				y--;
				if(this.peça[x][y].getTipoPeça() == qualPeça){
					 posicao[0] = x;
					 posicao[1] = y;
					 return posicao;
				 }
			}
		}else{
			while(x < linha){
				x++;
				y++;
				if(this.peça[x][y].getTipoPeça() == qualPeça){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				}
			}
		}return posicao;
	}
}