package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.LoginDAO;

@ManagedBean
@RequestScoped
public class LoginBean {
	
	private String username;
	private String password;
	
	
	public String doLogin() {
		if (LoginDAO.verificarCredencial(username, password) != null) {
			String resultado = password;
			return resultado;
		}else {
			return null;
		}
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
