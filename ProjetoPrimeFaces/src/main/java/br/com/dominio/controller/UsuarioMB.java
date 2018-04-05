package br.com.dominio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.dominio.model.Usuario;
import br.com.dominio.servico.SugestaoUsuario;;

@Named("usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuario usuario;
	private List<Usuario> usuarioAD = new ArrayList<Usuario>();
	private List<Usuario> usuarioPortal = new ArrayList<Usuario>();
	private List<Usuario> usuarioMicrosiga = new ArrayList<Usuario>();
	private SugestaoUsuario sugestaoUsuario = new SugestaoUsuario();

	public void adicionar() {
		if (sugestaoUsuario.existCadatrado(usuario)) {
			addMessageError("CPF Existente" + usuario.getNumCpf());
		} else {
			sugestaoUsuario.adicionaUsuarioBaseInformacao(usuario);
			addMessageSucesso("Cadastrado: " + usuario.getNome() + "!!");
			limpar();
		}
		
		usuarioAD = sugestaoUsuario.getList_Usuario_AD();
		usuarioPortal = sugestaoUsuario.getList_Usuario_Portal();
		usuarioMicrosiga = sugestaoUsuario.getList_Usuario_Microsiga();
	}

	public void sugestao() {
		if (sugestaoUsuario.existCadatrado(usuario)) {
			addMessageError("CPF EXISTENTE");
		} else {
			usuario.setCodigoUsuario(sugestaoUsuario.retornaUsuarioSugestao(usuario));
		}

	}

	public void atualizaPaginaAtual() {
		limpar();
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}

	private void limpar() {
		usuario = new Usuario();
	}

	public void addMessageSucesso(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addMessageError(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarioAD() {
		return usuarioAD;
	}

	public void setUsuarioAD(List<Usuario> usuarioAD) {
		this.usuarioAD = usuarioAD;
	}

	public List<Usuario> getUsuarioPortal() {
		return usuarioPortal;
	}

	public void setUsuarioPortal(List<Usuario> usuarioPortal) {
		this.usuarioPortal = usuarioPortal;
	}

	public List<Usuario> getUsuarioMicrosiga() {
		return usuarioMicrosiga;
	}

	public void setUsuarioMicrosiga(List<Usuario> usuarioMicrosiga) {
		this.usuarioMicrosiga = usuarioMicrosiga;
	}

	
	



}
