package Tabuleiro;

import java.io.Serializable;

public class MovimentoDasPe�as implements Serializable{

	private static boolean SEGUNDOMOVIMENTO = false;
	private Pe�a[][] pe�as;
	
	public MovimentoDasPe�as(Pe�a[][] pe�as){
		this.pe�as = pe�as;
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
		if(this.pe�as[x][y].getTipoPe�a() == Pe�a.EHPE�AAZUL()){
			jogado = Pe�a.EHPE�AAZUL();
		}else{
			jogado = Pe�a.EHPE�AVERMELHA();
		}
		for(int i = 0; i < 4; i++){
			int linha = x + verto[i][0],coluna = y + verto[i][1];
			if(linha >= 0 & coluna <= 7){
				if(x + verto2[i][0] >= 0 & x + verto2[i][0] <= 7 & y + verto2[i][1] >= 0 & y + verto2[i][1] <= 7){
					if((this.pe�as[x + verto2[i][0]][y + verto2[i][1]].getTipoPe�a() == jogado) & (this.pe�as[linha][coluna].getTipoPe�a() == Pe�a.EHPE�ABRANCA())){
						this.pe�as[linha][coluna].setPordiMover(true);
					}
				}
			}
		}
	}
	public void movimentoNormalAzul(int linha,int coluna){
		if(linha + 1 <= 7 & coluna - 1 >= 0){
			if(this.pe�as[linha + 1][coluna - 1].getTipoPe�a() == Pe�a.EHPE�ABRANCA()){
				this.pe�as[linha + 1][coluna - 1].setPordiMover(true);
			}
		}if(linha + 1 <= 7 & coluna + 1 <= 7){
			if(this.pe�as[linha + 1][coluna + 1].getTipoPe�a() == Pe�a.EHPE�ABRANCA()){
				this.pe�as[linha + 1][coluna + 1].setPordiMover(true);
			}
		}
	}
	public void movimentoNormalVermelho(int linha,int coluna) {
		if(linha - 1 >= 0 & coluna - 1 >= 0){
			if(this.pe�as[linha - 1][coluna - 1].getTipoPe�a() == Pe�a.EHPE�ABRANCA()){
				this.pe�as[linha - 1][coluna - 1].setPordiMover(true);
			}
		}
		if(linha - 1 >= 0 & coluna + 1 <= 7){
			if(this.pe�as[linha - 1][coluna + 1].getTipoPe�a() == Pe�a.EHPE�ABRANCA()){
				this.pe�as[linha - 1][coluna + 1].setPordiMover(true);
			}
		}
	}
	public void movimentoDama(int linha,int coluna){
		int[][] verto = {{-1,1},{1,1},{1,-1},{-1,-1}};
		for(int i = 0; i < 4; i++){
			int x = linha + verto[i][0],y = coluna + verto[i][1];
			while((x >= 0 & x <= 7) & (y >= 0 & y <= 7)){
				if(this.pe�as[x][y].getTipoPe�a() == Pe�a.EHPE�ABRANCA()){
					this.pe�as[x][y].setPordiMover(true);
				}
				if(this.pe�as[x][y].getTipoPe�a() == Pe�a.EHPE�AVERMELHA() & this.pe�as[x + verto[i][0]][y + verto[i][1]].getTipoPe�a() == Pe�a.EHPE�AVERMELHA()){
					break;
				}if(this.pe�as[x][y].getTipoPe�a() == Pe�a.EHPE�AAZUL() & this.pe�as[x + verto[i][0]][y + verto[i][1]].getTipoPe�a() == Pe�a.EHPE�AAZUL()){
					break;
				}
				if(this.pe�as[linha][coluna].getTipoPe�a() == Pe�a.EHPE�AVERMELHA()){
					if(this.pe�as[x][y].getTipoPe�a() == Pe�a.EHPE�AVERMELHA()){
						break;
					}
				}else{
					if(this.pe�as[x][y].getTipoPe�a() == Pe�a.EHPE�AAZUL()){
						break;
					}
				}
				x += verto[i][0];
				y += verto[i][1];
			}
		}
	}
}