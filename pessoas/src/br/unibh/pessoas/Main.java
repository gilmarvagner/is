package br.unibh.pessoas;

import java.util.Date;

import br.unibh.pessoas.entidades.Pessoa;
import br.unibh.pessoas.entidades.PessoaFisica;


public class Main {

	public static void main(String[] args) {
		
		PessoaFisica pf1 = new PessoaFisica(1l, "Joao", "Rua A", "3333-33333", "111222333444", "joao@gmail.com", new Date(),"M");
		System.out.println(pf1);
	}

}
