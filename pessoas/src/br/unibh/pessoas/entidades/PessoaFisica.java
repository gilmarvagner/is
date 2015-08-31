package br.unibh.pessoas.entidades;
import java.util.Date;

public class PessoaFisica extends Pessoa {

	
	//Construtores
	public PessoaFisica(Long id, String nome, String endereco, String telefone,
			String cpf, String email, Date dataNascimento, String sexo) {
		super(id, nome, endereco, telefone);
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}
	
	
	
	@Override
	public String toString() {
		return "PessoaFisica [cpf=" + cpf + ", email=" + email
				+ ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
				+ ", toString()=" + super.toString() + "]";
	}



	//Variáveis de instância
	private String cpf;
	private String email;
	private Date dataNascimento;
	private String sexo;
	public String getCpf() {
		return cpf;
	}
	
	//Get's e Set's
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
	
	
	
}
