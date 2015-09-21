package br.unibh.pessoas;

import java.util.Date;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

import br.unibh.pessoas.entidades.PessoaFisica;
import br.unibh.pessoas.persistencia.PessoaFisicaDAO;

public class Testes {

	
	@Test
	public void testePessoaFisicaFindAll(){
		
		List<PessoaFisica> lista = new PessoaFisicaDAO().findAll();
		Assert.assertEquals(lista.size(), 100);
		
	}
	
	@Test
	public void testePessoaFisicaFind(){
		
		PessoaFisica pessoa = new PessoaFisicaDAO().find(3L);
		Assert.assertEquals("Harrison R. Brooks", pessoa.getNome());
		
	}
	
	@Test
	public void testaPessoaFisicaInserirExcluir(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica pf = new PessoaFisica(null, "Fulano da Silva", "Rua A", 
				"3188885555", "111111122", "fulano@fulano.com", new Date(), "M");
		
		dao.insert(pf);
		
		PessoaFisica pf2 = dao.find("Fulano da Silva");
		
		Assert.assertNotNull(pf2);
		
		dao.delete(pf2);
		PessoaFisica pf3 = dao.find("Fulano da Silva");
		
		Assert.assertNull(pf3);
		
		
	}
}