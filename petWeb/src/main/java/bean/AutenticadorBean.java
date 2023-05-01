package bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Usuario;

@ManagedBean
@ApplicationScoped
public class AutenticadorBean {

	private Usuario usrLogado;

	public Usuario getUsrLogado() {
		return usrLogado;
	}

	public void setUsrLogado(Usuario usrLogado) {
		this.usrLogado = usrLogado;
	}
}
