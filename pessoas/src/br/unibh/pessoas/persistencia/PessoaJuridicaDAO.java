package br.unibh.pessoas.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.pessoas.entidades.PessoaJuridica;

public class PessoaJuridicaDAO {

private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public PessoaJuridica find(Long id) {
		PessoaJuridica pessoajuridica = null;
		try {
			String sql = "select * from tb_pessoa_juridica where id = ?";
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(sql); //trata problemas com sql inject
			p.setLong(1, id);
			
			ResultSet res = p.executeQuery();//ResultSet Guarda os dados vindo do SQL
			if (res.next()){
				pessoajuridica = new PessoaJuridica(
							res.getLong("id"),
							res.getString("nome"), 
							res.getString("endereco"), 
							res.getString("telefone"), 
							res.getString("cnpj"), 
							res.getDate("data_constituicao"), 
							res.getString("site")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return pessoajuridica;
	}

	public void insert(PessoaJuridica t) {
		try {
			String sql = "INSERT INTO tb_pessoa_juridica (nome, endereco,telefone,cnpj,data_constituicao,site)"+
				"VALUES (?,?,?,?,?,?)";
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(sql); 
			
			p.setString(1, t.getNome());
			p.setString(2, t.getEndereco());
			p.setString(3, t.getTelefone());
			p.setString(4, t.getCnpj());
			p.setString(5, df.format(t.getDataConstituicao()));
			p.setString(6, t.getSite());
			
			p.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		
	}
//
	public void update(PessoaJuridica t) {
		try {
			String sql = "update pessoa_juridica set nome = ?, endereco = ?,"
					+ "telefone = ?,cnpj = ?,data_constituicao = ?, site  = ? where id = ?";
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(sql); 
			
			p.setString(1, t.getNome());
			p.setString(2, t.getEndereco());
			p.setString(3, t.getTelefone());
			p.setString(4, t.getCnpj());
			p.setString(5, df.format(t.getDataConstituicao()));
			p.setString(6, t.getSite());
			p.setLong(7, t.getId());
			
			p.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		
	}

	public void delete(PessoaJuridica t) {
		try {
			String sql = "DELETE FROM tb_pessoa_juridica WHERE ID = ?";
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(sql); 
			
			p.setLong(1, t.getId());
			p.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		
	}
	
	@Test
	public void testaPessoaJuridicaAtualizar(){
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica pf = new PessoaJuridica(null, "Empresa Ciclano", "Rua A", 
				"3188885555", "11111112222345", new Date(), "empresaciclano.com");
		
		dao.insert(pf);
		
		PessoaJuridica pf2 = dao.find("Empresa Ciclano");
		pf2.setNome("Empresa Beltrano");
		pf2.setSite("empresabeltrano.com");
		dao.update(pf2);
		
		PessoaJuridica pf3 = dao.find("Empresa Beltrano");
		Assert.assertEquals("empresabeltrano.com", pf3.getSite());

		Assert.assertNotNull(pf2);
		dao.delete(pf3);
		
		PessoaJuridica pf4 = dao.find("Empresa Beltrano");
		Assert.assertNull(pf4);
		
	}
	

	public List<PessoaJuridica> findAll() {
		List<PessoaJuridica> listaPesoaFisica = new ArrayList<PessoaJuridica>();
		try {
			
			String sql = "select * from tb_pessoa_juridica";
			ResultSet res = JDBCUtil.getConnection().
					prepareStatement(sql).executeQuery();
			
			while (res.next()) {
				listaPesoaFisica.add(
						new PessoaJuridica(
							res.getLong("id"),
							res.getString("nome"), 
							res.getString("endereco"), 
							res.getString("telefone"), 
							res.getString("cnpj"), 
							res.getDate("data_constituicao"), 
							res.getString("site")
						)
					);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return listaPesoaFisica;
	}

	public PessoaJuridica find(String nome) {
		PessoaJuridica pessoajuridica = null;
		try {
			String sql = "select * from tb_pessoa_juridica where nome like ?";
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(sql); 
			p.setString(1, nome+"%");
			
			ResultSet res = p.executeQuery();
			if (res.next()){
				pessoajuridica = new PessoaJuridica(
							res.getLong("id"),
							res.getString("nome"), 
							res.getString("endereco"), 
							res.getString("telefone"), 
							res.getString("cnpj"), 
							res.getDate("data_constituicao"), 
							res.getString("site")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return pessoajuridica;
	}

	public PessoaJuridica find() {
		// TODO Auto-generated method stub
		return null;
	}
}
	
