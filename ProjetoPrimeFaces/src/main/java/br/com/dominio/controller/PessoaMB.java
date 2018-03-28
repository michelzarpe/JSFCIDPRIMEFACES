package br.com.dominio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.dominio.model.Pessoa;

@Named("bean")
@SessionScoped
public class PessoaMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pessoa pessoa;
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public String adicionar() {
		pessoas.add(pessoa);
		addMessage("ADD: "+pessoa.getNome()+"!!");
		limpar();
		return null;
	}

	private void limpar() {
		pessoa = new Pessoa();
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
