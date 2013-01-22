package Tabuleiro;

import Interfaces.TrocaDePeçasIF;

public abstract class TrocaDePeçasAbstract implements TrocaDePeçasIF{

	protected Tabuleiro tabuleiro;
	
	public TrocaDePeçasAbstract(Tabuleiro tabuleiro){
		this.tabuleiro = tabuleiro;
	}
	public abstract void trocaDePeça(int linha, int coluna, int linha2, int coluna2);
	
	public abstract void trocaDeDama(int linha, int coluna, int linha2, int coluna2);
	
	public abstract void trocaDePeçaComida(int linha, int coluna, int linha2,int coluna2, boolean qualPeça);
	
	protected int[] calculaPeçaComida(int linha,int coluna,int linha2,int coluna2){
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
	protected int[] calculaPecaComidaPelaDama(int linha, int coluna, int linha2,int coluna2,boolean qualPeça) {
		int[] posicao = {-1,-1};
		int x = linha,y = coluna,peça;
		if(qualPeça){
			peça = 3;
		}else{
			peça = 4;
		}
		if(linha > linha2 & coluna < coluna ){
			while(x > linha2){
				x--;
				y++;
				if(this.tabuleiro.getBotao()[x][y].getTipoBotao() == peça){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				 }
			}
		}else if(linha > linha2 & coluna > coluna2){
			while(x > linha2){
				x--;
				y--;
				if(this.tabuleiro.getBotao()[x][y].getTipoBotao() == peça){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				 }
			}
		}else if(linha < linha2 & coluna > coluna2){
			while(x < linha2){
				x++;
				y--;
				if(this.tabuleiro.getBotao()[x][y].getTipoBotao() == peça){
					 posicao[0] = x;
					 posicao[1] = y;
					 return posicao;
				 }
			}
		}else{
			while(x < linha){
				x++;
				y++;
				if(this.tabuleiro.getBotao()[x][y].getTipoBotao() == peça){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				}
			}
		}return posicao;
	}
}
