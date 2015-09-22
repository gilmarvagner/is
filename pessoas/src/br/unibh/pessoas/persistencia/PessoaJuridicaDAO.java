package br.unibh.pessoas.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import br.unibh.pessoas.entidades.PessoaJuridica;

public class PessoaJuridicaDAO {

private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public PessoaJuridica find(Long id) {
		PessoaJuridica pessoajuridica = null;
		try {
			String sql = "select * from tb_pessoa_juridica where id = ?";
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(sql); 
			p.setLong(1, id);
			
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
		// TODO Auto-generated method stub
		
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
	
