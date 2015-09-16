package br.unibh.pessoas;

import java.util.List;

import org.junit.Assert;

import br.unibh.pessoas.entidades.PessoaFisica;
import br.unibh.pessoas.persistencia.PessoaFisicaDAO;

public class teste {

	public void testePessoaFisicaFindAll(){
		
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		List<PessoaFisica> l = dao.findAll();
		Assert.assertEquals(l.size(), 100);
	}
	
	public void testePessoaFisicaFind(){
		
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica p = dao.find(6L);
		Assert.assertEquals(p.getNome(), "Oprah D. Keith");
	}
	
}
