package Tabuleiro;

import java.io.Serializable;

public class MovimentoDasPeças implements Serializable{

	private static boolean SEGUNDOMOVIMENTO = false;
	private Peça[][] peças;
	
	public MovimentoDasPeças(Peça[][] peças){
		this.peças = peças;
	}
	public static void SETSEGUNDOMOVIMENTO(boolean segundo){
		SEGUNDOMOVIMENTO = segundo;
	}
	public static boolean GETSEGUNDOMOVIMENTO(){
		return SEGUNDOMOVIMENTO;
	}
	public void movimentoCapturaPeca(int x,int y){
		int[][] verto = {{-2,2},{2,2},{2,-2},{-2,-2}};
		int[][] verto2 = {{-1,1},{1,1},{1,-1},{-1,-1}};
		int jogado = 0;
		if(this.peças[x][y].getTipoPeça() == Peça.EHPEÇAAZUL()){
			jogado = Peça.EHPEÇAAZUL();
		}else{
			jogado = Peça.EHPEÇAVERMELHA();
		}
		for(int i = 0; i < 4; i++){
			int linha = x + verto[i][0],coluna = y + verto[i][1];
			if(linha >= 0 & coluna <= 7){
				if(x + verto2[i][0] >= 0 & x + verto2[i][0] <= 7 & y + verto2[i][1] >= 0 & y + verto2[i][1] <= 7){
					if((this.peças[x + verto2[i][0]][y + verto2[i][1]].getTipoPeça() == jogado) & (this.peças[linha][coluna].getTipoPeça() == Peça.EHPEÇABRANCA())){
						this.peças[linha][coluna].setPordiMover(true);
					}
				}
			}
		}
	}
	public void movimentoNormalAzul(int linha,int coluna){
		if(linha + 1 <= 7 & coluna - 1 >= 0){
			if(this.peças[linha + 1][coluna - 1].getTipoPeça() == Peça.EHPEÇABRANCA()){
				this.peças[linha + 1][coluna - 1].setPordiMover(true);
			}
		}if(linha + 1 <= 7 & coluna + 1 <= 7){
			if(this.peças[linha + 1][coluna + 1].getTipoPeça() == Peça.EHPEÇABRANCA()){
				this.peças[linha + 1][coluna + 1].setPordiMover(true);
			}
		}
	}
	public void movimentoNormalVermelho(int linha,int coluna) {
		if(linha - 1 >= 0 & coluna - 1 >= 0){
			if(this.peças[linha - 1][coluna - 1].getTipoPeça() == Peça.EHPEÇABRANCA()){
				this.peças[linha - 1][coluna - 1].setPordiMover(true);
			}
		}
		if(linha - 1 >= 0 & coluna + 1 <= 7){
			if(this.peças[linha - 1][coluna + 1].getTipoPeça() == Peça.EHPEÇABRANCA()){
				this.peças[linha - 1][coluna + 1].setPordiMover(true);
			}
		}
	}
	public void movimentoDama(int linha,int coluna){
		int[][] verto = {{-1,1},{1,1},{1,-1},{-1,-1}};
		for(int i = 0; i < 4; i++){
			int x = linha + verto[i][0],y = coluna + verto[i][1];
			while((x >= 0 & x <= 7) & (y >= 0 & y <= 7)){
				if(this.peças[x][y].getTipoPeça() == Peça.EHPEÇABRANCA()){
					this.peças[x][y].setPordiMover(true);
				}
				if(this.peças[x][y].getTipoPeça() == Peça.EHPEÇAVERMELHA() & this.peças[x + verto[i][0]][y + verto[i][1]].getTipoPeça() == Peça.EHPEÇAVERMELHA()){
					break;
				}if(this.peças[x][y].getTipoPeça() == Peça.EHPEÇAAZUL() & this.peças[x + verto[i][0]][y + verto[i][1]].getTipoPeça() == Peça.EHPEÇAAZUL()){
					break;
				}
				if(this.peças[linha][coluna].getTipoPeça() == Peça.EHPEÇAVERMELHA()){
					if(this.peças[x][y].getTipoPeça() == Peça.EHPEÇAVERMELHA()){
						break;
					}
				}else{
					if(this.peças[x][y].getTipoPeça() == Peça.EHPEÇAAZUL()){
						break;
					}
				}
				x += verto[i][0];
				y += verto[i][1];
			}
		}
	}
}