package Teste;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.*;

import Tabuleiro.*;

public class TesteFachada {

	@Test
	public void iniciarPartidaTest(){
		Fachada fachada = new Fachada();
		fachada.iniciarPartida("gilson","italo");
		Tabuleiro tabuleiro = fachada.getTabuleiro();
		assertTrue(tabuleiro.getPe�aTabuleiro()[2][1].getPordiMover());
	}
	@Test
	public void salvaJogoTest(){
		Fachada fachada = new Fachada();
		try {
			fachada.salvaJogo();
		} catch (IOException e) {
			fail("" + e);
		}
	}
	@Test
	public void retomaJogo(){
		Fachada fachada = new Fachada();
		try {
			fachada.retomaJogo();
		} catch (IOException e) {
			fail("" + e);
		}
	}
	@Test
	public void novaPartida(){
		Fachada fachada = new Fachada();
		fachada.novaPartida();
		Tabuleiro tabuleiro = fachada.getTabuleiro();
		assertTrue(tabuleiro.getPe�aTabuleiro()[2][1].getPordiMover());
	}
	@Test
	public void movimentoDePe�as(){
		Fachada fachada = new Fachada();
		fachada.movimentosDaPe�a(2,1);
		Tabuleiro tabuleiro = fachada.getTabuleiro();
		assertTrue(tabuleiro.getPe�aTabuleiro()[3][0].getPordiMover());
		assertTrue(tabuleiro.getPe�aTabuleiro()[3][2].getPordiMover());
	}
	@Test
	public void trocaDePe�aTest(){
		Fachada fachada = new Fachada();
		fachada.trocaDePe�as(2,1,3,0);
		Tabuleiro tabuleiro = fachada.getTabuleiro();
		assertEquals(Pe�a.EHPE�AAZUL(),tabuleiro.getPe�aTabuleiro()[3][0].getTipoPe�a());
		assertEquals(Pe�a.EHPE�ABRANCA(),tabuleiro.getPe�aTabuleiro()[2][1].getTipoPe�a());
	}
	@Test
	public void ganhadorTest(){
		Fachada fachada = new Fachada();
		if(fachada.ganhador() != null){
			fail("n�o retorna null");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test
	public void testPe�aClicada(){
		Fachada fachada = new Fachada();
		fachada.getTabuleiro().getPe�aTabuleiro()[1][1].setClicou(true);
		fachada.pe�aClicada();
		int[] p = fachada.getPosicao();
		if(p[0] != 1 & p[1] != 1){
			fail("n�o deveria ter entrado");
		}
		assertFalse(fachada.getTabuleiro().getPe�aTabuleiro()[1][1].getClicou());
		assertEquals(1,Fachada.GETRODADA());
	}
	@Test
	public void testNovaNovaPartida(){
		Fachada fachada = new Fachada();
		fachada.novaPartida();
		assertTrue(fachada.getTabuleiro().getPe�aTabuleiro()[0][1].getPordi());
	}*/
}
