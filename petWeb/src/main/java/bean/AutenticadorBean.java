package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Usuario;

@ManagedBean
@SessionScoped
public class AutenticadorBean {

	private Usuario usrLogado;
	private String nivelAcesso;

	public Usuario getUsrLogado() {
		return usrLogado;
	}

	public void setUsrLogado(Usuario usrLogado) {
		this.usrLogado = usrLogado;
	}
	

	public String getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
}
