package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.UsuarioDAO;
import entidades.Usuario;

@ManagedBean
public class UsuarioBean {
	
	private Usuario user = new Usuario();
	private List<Usuario> list;
	
	public String salvar() {
			
			try {
				UsuarioDAO.salvar(user);
				user = new Usuario();
				System.out.println("Usuário Cadastrado");
				
			} catch (Exception e) {
				System.out.println("Erro no cadastro de usuário");
			}
			return null;
		}

	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public List<Usuario> getList() {
		return list;
	}
	public void setList(List<Usuario> list) {
		this.list = list;
	}

}
