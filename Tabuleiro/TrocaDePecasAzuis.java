package Tabuleiro;

import Grafico.*;
import Imagens.Imagens;

public class TrocaDePecasAzuis extends TrocaDePe�asAbstract{
	
	private Imagens imagem;
	
	public TrocaDePecasAzuis(Tabuleiro tabuleiro){
		super(tabuleiro);
		this.imagem = new Imagens();
	}
	public void trocaDePe�a(int linha, int coluna, int linha2, int coluna2) {
		Botao[][] botao = super.tabuleiro.getBotao();
		super.trocaParaCasabranca(linha, coluna);
		
		botao[linha2][coluna2].setImagemBotao(imagem.getAzul());
		botao[linha2][coluna2].setTipoBotao(4);
		botao[linha][coluna].setEvento(new EventoBotaoAzul(linha,coluna,super.tabuleiro));
	}
	public void trocaDeDama(int linha, int coluna, int linha2, int coluna2) {
		Botao[][] botao = super.tabuleiro.getBotao();
		super.trocaParaCasabranca(linha, coluna);
		
		botao[linha2][coluna2].setImagemBotao(this.imagem.getAzulDama());
		botao[linha2][coluna2].setTipoBotao(4);
		botao[linha][coluna].setEvento(new EventoBotaoAzul(linha,coluna,super.tabuleiro));
	}
	public void trocaDePe�aComida(int linha, int coluna, int linha2,int coluna2, boolean qualPe�a) {
		Botao[][] botao = super.tabuleiro.getBotao();
		int[] posicao = {-1,-1};
		if(botao[linha][coluna].getEhDama()){
			posicao = this.calculaPecaComidaPelaDama(linha, coluna, linha2, coluna2, qualPe�a);
		}else{
			posicao = this.calculaPe�aComida(linha, coluna, linha2, coluna2);
		}
		if(posicao[0] != -1 & posicao[1] != -1){
			super.trocaParaCasabranca(linha, coluna);
		}
	}
}
