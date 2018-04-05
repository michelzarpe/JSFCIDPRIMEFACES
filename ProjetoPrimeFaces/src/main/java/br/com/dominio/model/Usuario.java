package br.com.dominio.model;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	private int ddi;
	private int ddd;
	private long celular;
	private String numCpf;
	private Date dataNascimento;
	private long idAuthy;
	private String email;
	private String codigoUsuario;

	public Usuario() {

	}

	public Usuario(String nome, String sobrenome, int ddi, int ddd, long celular, String numCpf, Date dataNascimento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.ddi = ddi;
		this.ddd = ddd;
		this.celular = celular;
		this.numCpf = numCpf;
		this.dataNascimento = dataNascimento;
	}

	public Usuario(String nome, String sobrenome, String email, int ddi, int ddd, long celular, String numCpf,
			String codigoUsuario, Date dataNascimento) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.ddi = ddi;
		this.ddd = ddd;
		this.celular = celular;
		this.numCpf = numCpf;
		this.codigoUsuario = codigoUsuario;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getDdi() {
		return ddi;
	}

	public void setDdi(int ddi) {
		this.ddi = ddi;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public long getCelular() {
		return celular;
	}

	public void setCelular(long celular) {
		this.celular = celular;
	}

	public String getNumCpf() {
		return numCpf;
	}

	public void setNumCpf(String numCpf) {
		this.numCpf = numCpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public long getIdAuthy() {
		return idAuthy;
	}

	public void setIdAuthy(long idAuthy) {
		this.idAuthy = idAuthy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String emailFormatado(){
		return codigoUsuario+"@gpssa.com.br";
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (celular ^ (celular >>> 32));
		result = prime * result + ((codigoUsuario == null) ? 0 : codigoUsuario.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ddd;
		result = prime * result + ddi;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (idAuthy ^ (idAuthy >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numCpf == null) ? 0 : numCpf.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (celular != other.celular)
			return false;
		if (codigoUsuario == null) {
			if (other.codigoUsuario != null)
				return false;
		} else if (!codigoUsuario.equals(other.codigoUsuario))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (ddd != other.ddd)
			return false;
		if (ddi != other.ddi)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idAuthy != other.idAuthy)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numCpf == null) {
			if (other.numCpf != null)
				return false;
		} else if (!numCpf.equals(other.numCpf))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	

}
