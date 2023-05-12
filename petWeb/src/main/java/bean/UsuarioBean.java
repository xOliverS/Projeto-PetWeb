package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.UsuarioDAO;
import entidades.Usuario;
import static util.MessageUTIL.*;

@ManagedBean
public class UsuarioBean {
	
	private Usuario user = new Usuario();
	private List<Usuario> list;
	
	public String salvar() {
			
			try {
				UsuarioDAO.salvar(user);
				sucesso("Sucesso", "Usuário cadastrado com sucesso !");
				user = new Usuario();
			} catch (Exception e) {
				erro("Erro", "Erro no cadastro de usuário" + e);
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
