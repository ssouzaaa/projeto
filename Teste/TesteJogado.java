package Teste;

import static org.junit.Assert.*;
import org.junit.*;

import Tabuleiro.*;

public class TesteJogado {

	private Jogador jogado;
	
	@Before
	public void setUp(){
		this.jogado = new Jogador("gilson");
	}
	@After
	public void tearDown(){
		
	}
	@Test
	public void nomeDoJogadoTest(){
		if(!this.jogado.getNome().equals("gilson")){
			fail("não deveria ter entrado");
		}
		this.jogado.setNome("italo");
		assertEquals("italo",this.jogado.getNome());
	}
	@Test
	public void pontosDoJogadoTest(){
		if(this.jogado.getPonto() != 12){
			fail("não deveria ter entrado");
		}
		this.jogado.setPonto();
		assertEquals(11,this.jogado.getPonto());
		this.jogado.novaPartida();
		assertEquals(12,this.jogado.getPonto());
	}
}
