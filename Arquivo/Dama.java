package Arquivo;

import Grafico.GerenteInterfaceGrafica;

public class Dama {

	public static void main(String[] args){
		
		GerenteInterfaceGrafica gerente = new GerenteInterfaceGrafica();
		
		do{
			
			gerente.trocaDePešas();
			
		}while(true);
	}
}