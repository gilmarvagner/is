package br.unibh.pessoas;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.pessoas.entidades.PessoaJuridica;
import br.unibh.pessoas.persistencia.PessoaJuridicaDAO;

public class TesteJ {

	@Test
	public void testePessoaFisicaFindAll(){
		
		List<PessoaJuridica> lista = new PessoaJuridicaDAO().findAll();
		Assert.assertEquals(lista.size(), 100);
		
	}
	//
	@Test
	public void testePessoaJuridicaFind(){
		
		PessoaJuridica pessoa = new PessoaJuridicaDAO().find(3L);
		Assert.assertEquals("Dominic X. Erickson", pessoa.getNome());
		
	}
	
	@Test
	public void testaPessoaJuridicaInserirExcluir(){
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica pf = new PessoaJuridica(null, "Fulano da Silva", "Rua A", 
				"3188885555", "72737483937481", new Date(), "site.com.br");
		
		dao.insert(pf);
		
		PessoaJuridica pf2 = dao.find("Fulano da Silva");
		
		Assert.assertNotNull(pf2);
		
		dao.delete(pf2);
		PessoaJuridica pf3 = dao.find("Fulano da Silva");
		
		Assert.assertNull(pf3);
		
		
	}
}
	