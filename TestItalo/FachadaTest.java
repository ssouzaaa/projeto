package TestItalo;

import static org.junit.Assert.*;


import org.junit.*;

import Tabuleiro.Fachada;

public class FachadaTest {

	
	@Test
	public void rodadaTest(){
		Fachada fachada = new Fachada();
		fachada.rodada(2, 7, 3, 6);
		assertEquals(4,fachada.getTabuleiro().getBotao()[3][6].getTipoBotao());
		assertEquals(1,fachada.getTabuleiro().getBotao()[2][7].getTipoBotao());
		fachada.rodada(5, 0, 4, 1);
		assertEquals(3,fachada.getTabuleiro().getBotao()[4][1].getTipoBotao());
		assertEquals(1,fachada.getTabuleiro().getBotao()[5][0].getTipoBotao());
	}
	@Test
	public void iniciarPartidaTest(){
		Fachada fachada = new Fachada();
		fachada.iniciarPartida();
		assertEquals("Italo",fachada.getJogado1().getNome());
		assertEquals("Gilson", fachada.getJogado2().getNome());
	}
	@Test
	public void testPeçaClicada(){
		Fachada fachada = new Fachada();
		fachada.getTabuleiro().getBotao()[1][1].setClicou(true);
		fachada.peçaClicada();
		int[] p = fachada.getPosicao();
		if(p[0] != 1 & p[1] != 1){
			fail("não deveria ter entrado");
		}
		assertFalse(fachada.getTabuleiro().getBotao()[1][1].getClicou());
		assertEquals(1,Fachada.GETRODADA());
	}
	@Test
	public void testNovaNovaPartida(){
		Fachada fachada = new Fachada();
		fachada.novaPartida();
		assertTrue(fachada.getTabuleiro().getBotao()[0][1].getPordi());
	}
	
}
