package Tabuleiro;

import Grafico.*;
import Imagens.Imagens;

public class TrocaDePecasVermelhas extends TrocaDePeçasAbstract{
	
	private Imagens imagem;
	
	public TrocaDePecasVermelhas(Tabuleiro tabuleiro){
		super(tabuleiro);
		this.imagem = new Imagens();
	}
	public void trocaDePeça(int linha, int coluna, int linha2, int coluna2) {
		Botao[][] botao = super.tabuleiro.getBotao();
		super.trocaParaCasabranca(linha, coluna);
		
		botao[linha2][coluna2].setImagemBotao(this.imagem.getVermelho());
		botao[linha2][coluna2].setTipoBotao(3);
		botao[linha][coluna].setEvento(new EventoBotaoVermelho(linha,coluna,super.tabuleiro));
	}
	public void trocaDeDama(int linha, int coluna, int linha2, int coluna2) {
		Botao[][] botao = super.tabuleiro.getBotao();
		super.trocaParaCasabranca(linha, coluna);
		
		botao[linha2][coluna2].setImagemBotao(this.imagem.getVermelhoDama());
		botao[linha2][coluna2].setTipoBotao(3);
		botao[linha][coluna].setEvento(new EventoBotaoVermelho(linha,coluna,super.tabuleiro));
	}
	public void trocaDePeçaComida(int linha, int coluna, int linha2, int coluna2,boolean qualPeça) {
		Botao[][] botao = super.tabuleiro.getBotao();
		int[] posicao = new int[2];
		if(botao[linha][coluna].getEhDama()){
			posicao = this.calculaPecaComidaPelaDama(linha, coluna, linha2, coluna2, qualPeça);
		}else{
			posicao = this.calculaPeçaComida(linha, coluna, linha2, coluna2);
		}
		if(posicao[0] != 0 & posicao[1] != 0){
			super.trocaParaCasabranca(linha, coluna);
		}
	}
}