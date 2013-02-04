package TestItalo;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.*;

import Tabuleiro.PeçaTabuleiro;
import Tabuleiro.Tabuleiro;

public class BotaoTest {

	
	@Test
	public void novaPartidaTest(){
		PeçaTabuleiro b = new PeçaTabuleiro(0,0, new Tabuleiro());
		assertFalse(b.getPordi());
		assertFalse(b.getEhDama());
		b.setPordi(true);
		b.setEhDama(true);
		assertTrue(b.getPordi());
		assertTrue(b.getEhDama());
		b.novaPartida(new ImageIcon(), 1);
		assertFalse(b.getPordi());
		assertFalse(b.getEhDama());
		assertEquals(1,b.getTipoBotao());
		b.setTipoBotao(2);
		assertEquals(2,b.getTipoBotao());
	}
	@Test
	public void testPosicao(){
		PeçaTabuleiro b = new PeçaTabuleiro(0,0, new Tabuleiro());
		int[] p = b.posicao();
		if(!(p[0]==0 & p[1]==0)){
			fail("Não deveria ter entrado");
		}
	}

}

