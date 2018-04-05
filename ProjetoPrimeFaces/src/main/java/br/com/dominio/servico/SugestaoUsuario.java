package br.com.dominio.servico;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import br.com.dominio.model.Usuario;

public class SugestaoUsuario {
	
	private ArrayList< Usuario> List_Usuario_AD = new ArrayList< Usuario>();
	private ArrayList< Usuario> list_Usuario_Portal = new ArrayList< Usuario>();
	private ArrayList< Usuario> list_Usuario_Microsiga = new ArrayList< Usuario>();
	

	public void adicionaUsuarioBaseInformacao(Usuario usuario){
		usuario.setEmail(usuario.emailFormatado());
		List_Usuario_AD.add(usuario);
		list_Usuario_Portal.add(usuario);
		list_Usuario_Microsiga.add(usuario);
	}

	public boolean existCadatrado(Usuario usuario){
        return ((usuarioCadatradoSistemas(usuario,List_Usuario_AD))||(usuarioCadatradoSistemas(usuario,list_Usuario_Portal))||(usuarioCadatradoSistemas(usuario,list_Usuario_Microsiga)));
	}
	
	private boolean usuarioCadatradoSistemas(Usuario usuarioParametro, ArrayList<Usuario> lista_Usuario_Sistema){
		boolean existUsuario = false;
		  for (int i = 0; i < lista_Usuario_Sistema.size(); i++) {
		        if (lista_Usuario_Sistema.get(i).getNumCpf().equals(usuarioParametro.getNumCpf())) {
		        	existUsuario = true;
		        }
		    }
		return existUsuario;
	}
	
	private Usuario formatuandoCodigoUsuario (Usuario usuario, String codigousuarioCorrente){
    	usuario.setCodigoUsuario(codigousuarioCorrente);
		return usuario;
	}
	
	private int retornaNumeroAleatorio(){
		Random rand = new Random();
	    return rand.nextInt((999999 - 111111) + 1) + 111111;
	}
	
	private boolean existCodUsuAd(String codigoUsuario){
		boolean existUsuario = false;
	    for (int i = 0; i < List_Usuario_AD.size(); i++) {
	        if (List_Usuario_AD.get(i).getCodigoUsuario().equals(codigoUsuario)) {
	        	existUsuario = true;
	        }

	    }
		return existUsuario;
	}
	
	private boolean existCodUsuPortal(String codigoUsuario){
		boolean existUsuario = false;
	    for (int i = 0; i < list_Usuario_Portal.size(); i++) {
	        if (list_Usuario_Portal.get(i).getCodigoUsuario().equals(codigoUsuario)) {
	        	existUsuario = true;
	        }

	    }
		return existUsuario;
	}
	
	private boolean existCodUsuMicrosiga(String codigoUsuario){
		boolean existUsuario = false;
	    for (int i = 0; i < list_Usuario_Microsiga.size(); i++) {
	        if (list_Usuario_Microsiga.get(i).getCodigoUsuario().equals(codigoUsuario)) {
	        	existUsuario = true;
	        }

	    }
		return existUsuario;
	}
	
	private boolean existUsuarioEmAlgumDosSistemas(String codigoUsuario){
		return ((existCodUsuAd(codigoUsuario)) || (existCodUsuPortal(codigoUsuario))  || (existCodUsuMicrosiga(codigoUsuario)));
	}
	
	public String retornaUsuarioSugestao(Usuario usuarioCorrente){
		   String codigousuarioCorrenteData ="";
		   String descricaoSistemas ="";
		   String retornoMetodo="";
		   Calendar cal = Calendar.getInstance();
		   cal.setTime(usuarioCorrente.getDataNascimento());
			if (existUsuarioEmAlgumDosSistemas(usuarioCorrente.getNome().toLowerCase()+"."+usuarioCorrente.getSobrenome().toLowerCase())) {
			    codigousuarioCorrenteData = usuarioCorrente.getNome().toLowerCase()+ "."+ usuarioCorrente.getSobrenome().toLowerCase()+ cal.get(Calendar.YEAR)+ (cal.get(Calendar.MONTH)+1) + cal.get(Calendar.DAY_OF_MONTH); 	
			    if (!existUsuarioEmAlgumDosSistemas(codigousuarioCorrenteData)) {
			  		        usuarioCorrente.setCodigoUsuario(codigousuarioCorrenteData);
					        usuarioCorrente = formatuandoCodigoUsuario(usuarioCorrente,codigousuarioCorrenteData);
			            	retornoMetodo = usuarioCorrente.getCodigoUsuario();
			  	}else{
			  		while (existUsuarioEmAlgumDosSistemas(codigousuarioCorrenteData))			  			
			  			codigousuarioCorrenteData = usuarioCorrente.getNome().toLowerCase() + "."+ usuarioCorrente.getSobrenome().toLowerCase() + retornaNumeroAleatorio();

	  		        usuarioCorrente.setCodigoUsuario(codigousuarioCorrenteData);
			        usuarioCorrente = formatuandoCodigoUsuario(usuarioCorrente,codigousuarioCorrenteData);
	            	retornoMetodo = usuarioCorrente.getCodigoUsuario();
			  	}
			  	
	        } else {
	            if ((!existCodUsuAd(usuarioCorrente.getNome().toLowerCase()+"."+usuarioCorrente.getSobrenome().toLowerCase())) 
	            		&& (!existCodUsuPortal(usuarioCorrente.getNome().toLowerCase()+"."+usuarioCorrente.getSobrenome().toLowerCase())) 
	            		&& (!existCodUsuMicrosiga(usuarioCorrente.getNome().toLowerCase()+"."+usuarioCorrente.getSobrenome().toLowerCase()))) {
	            	usuarioCorrente = formatuandoCodigoUsuario(usuarioCorrente,usuarioCorrente.getNome().toLowerCase()+"."+usuarioCorrente.getSobrenome().toLowerCase());
	            	retornoMetodo = usuarioCorrente.getCodigoUsuario();
	            }
	        }
			
		return retornoMetodo;
	}

	public ArrayList<Usuario> getList_Usuario_AD() {
		return List_Usuario_AD;
	}

	public void setList_Usuario_AD(ArrayList<Usuario> list_Usuario_AD) {
		List_Usuario_AD = list_Usuario_AD;
	}

	public ArrayList<Usuario> getList_Usuario_Portal() {
		return list_Usuario_Portal;
	}

	public void setList_Usuario_Portal(ArrayList<Usuario> list_Usuario_Portal) {
		this.list_Usuario_Portal = list_Usuario_Portal;
	}

	public ArrayList<Usuario> getList_Usuario_Microsiga() {
		return list_Usuario_Microsiga;
	}

	public void setList_Usuario_Microsiga(ArrayList<Usuario> list_Usuario_Microsiga) {
		this.list_Usuario_Microsiga = list_Usuario_Microsiga;
	}

	
	
	
}
