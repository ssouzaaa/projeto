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
		assertTrue(tabuleiro.getPeçaTabuleiro()[2][1].getPordiMover());
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
		assertTrue(tabuleiro.getPeçaTabuleiro()[2][1].getPordiMover());
	}
	@Test
	public void movimentoDePeças(){
		Fachada fachada = new Fachada();
		fachada.movimentosDaPeça(2,1);
		Tabuleiro tabuleiro = fachada.getTabuleiro();
		assertTrue(tabuleiro.getPeçaTabuleiro()[3][0].getPordiMover());
		assertTrue(tabuleiro.getPeçaTabuleiro()[3][2].getPordiMover());
	}
	@Test
	public void trocaDePeçaTest(){
		Fachada fachada = new Fachada();
		fachada.trocaDePeças(2,1,3,0);
		Tabuleiro tabuleiro = fachada.getTabuleiro();
		assertEquals(Peça.EHPEÇAAZUL(),tabuleiro.getPeçaTabuleiro()[3][0].getTipoPeça());
		assertEquals(Peça.EHPEÇABRANCA(),tabuleiro.getPeçaTabuleiro()[2][1].getTipoPeça());
	}
	@Test
	public void ganhadorTest(){
		Fachada fachada = new Fachada();
		if(fachada.ganhador() != null){
			fail("não retorna null");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test
	public void testPeçaClicada(){
		Fachada fachada = new Fachada();
		fachada.getTabuleiro().getPeçaTabuleiro()[1][1].setClicou(true);
		fachada.peçaClicada();
		int[] p = fachada.getPosicao();
		if(p[0] != 1 & p[1] != 1){
			fail("não deveria ter entrado");
		}
		assertFalse(fachada.getTabuleiro().getPeçaTabuleiro()[1][1].getClicou());
		assertEquals(1,Fachada.GETRODADA());
	}
	@Test
	public void testNovaNovaPartida(){
		Fachada fachada = new Fachada();
		fachada.novaPartida();
		assertTrue(fachada.getTabuleiro().getPeçaTabuleiro()[0][1].getPordi());
	}*/
}
