package Tabuleiro;

import Grafico.EventoBotaoBranco;

public class GerenciadorDePonto {

	private static int CONT = 0;
	private Botao[][] botao;
	private int linha,linha2,coluna,coluna2;
	
	public GerenciadorDePonto(Botao[][] botao){
		this.botao = botao;
		this.posicaoZero();
	}
	public int[] getBotaoClicado(){
		int[] posicao = {0,0};
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.botao[i][j].getClicou()){
					this.botao[i][j].setClicou(false);
					posicao[0] = i;
					posicao[1] = j;
					return posicao;
				}
			}
		}
		return posicao;
	}
	/**
	 * método que procura o botão que foi clicado e adiciona nas primeiras posições
	 * e altera o contado para 1 na proxima vez adicione na segunda posição e altere
	 * o contado para 0.
	 */
	public void botaoClicado(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.botao[i][j].getClicou()){
					this.botao[i][j].setClicou(false);
					if(CONT == 0){
						this.linha = i;
						this.coluna = j;
						CONT = 1;
					}else{
						this.linha2 = i;
						this.coluna2 = j;
						CONT = 0;
					}
					break;
				}
			}
		}
	}
	public boolean pordiJoga(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.botao[i][j].getPordi()){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * método para altera as imagens dos botões clicados e dos botões que foram comidos
	 * nessa rodada.
	 * @param troca para altera as imagens dos botões
	 * @param jogado para dequementa a pontuação do jogado em questam.
	 */
	public void rodada(TrocaDePeçasAbstract troca,Jogado jogado,int linha,int coluna,int linha2,int coluna2){
		int[] comeu = troca.calculaPeçaComida(linha, coluna, linha2, coluna2);
		if(comeu[0] != -1){
			jogado.setPonto();
			troca.trocaParaCasabranca(comeu[0],comeu[1]);
		}
		if(this.botao[linha][coluna].getTipoBotao() != 2 & this.botao[linha2][coluna2].getTipoBotao() != 2){
			if(this.botao[linha][coluna].getEhDama()){
				troca.trocaDeDama(linha, coluna, linha2, coluna2);
			}else{
				troca.trocaDePeça(linha, coluna, linha2, coluna2);
			}
			if(this.botao[linha][coluna].getTipoBotao() == 3){
				troca.trocaDePeçaComida(linha, coluna, linha2, coluna2, true);
			}else{
				troca.trocaDePeçaComida(linha, coluna, linha2, coluna2, false);
			}
			EventoBotaoBranco.LINHA(linha2);
			EventoBotaoBranco.COLUNA(coluna2);
		}
	}
	public GerenciadorDePonto setLinha(int linha){
		this.linha = linha;
		return this;
	}
	public void setColuna(int coluna){
		this.coluna = coluna;
	}
	/**
	 * método para altera as posições dos botões para 0 um valor null para o jogo.
	 */
	private void posicaoZero(){
		this.linha = 0;
		this.linha2 = 0;
		this.coluna = 0;
		this.coluna2 = 0;
	}
	public void segundaRodada(){
		this.linha = this.linha2;
		this.coluna = this.coluna2;
		this.linha2 = 0;
		this.coluna2 = 0;
	}
	public int[] posicaoDoPrimeiroBotao(){
		int[] posicao = {this.linha,this.coluna};
		return posicao;
	}
	public int[] posicaoDoSegundoBotao(){
		int[] posicao = {this.linha2,this.coluna2};
		return posicao;
	}
}