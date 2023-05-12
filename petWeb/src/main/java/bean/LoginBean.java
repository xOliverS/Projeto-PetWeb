package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.LoginDAO;
import entidades.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private String login;
	private String senha;
	private Usuario usr;
	
	@ManagedProperty(value = "#{autenticadorBean}")
	private AutenticadorBean autenticadorBean;
	
	public String autenticar() {
		usr = LoginDAO.buscarLoginSenha(login, senha);
		
		if(usr != null) {	
			autenticadorBean.setUsrLogado(usr);
			if(usr.getNivel().equals("admin")) {
				autenticadorBean.setNivelAcesso("admin");
				System.out.println("LOGANDO COMO ADMINISTRADOR..");
				//return "index.xhtml?faces-redirect=true";
			}else {
				System.out.println("LOGANDO COMO USUÁRIO..");
				autenticadorBean.setNivelAcesso("cliente");
				//return "cadUsuario.xhtml?faces-redirect=true";
			}
			return "index.xhtml";
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não cadastrado!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
	}
	
	public String sair() {
		usr = null;
		autenticadorBean.setUsrLogado(null);
		System.out.println("SAINDO..");
		return "login.xhtml?faces-redirect=true";
	}
	
	public void setAutenticadorBean(AutenticadorBean autenticadorBean) {
		this.autenticadorBean = autenticadorBean;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
