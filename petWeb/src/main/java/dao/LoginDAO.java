package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entidades.Usuario;
import util.JPAUTIL;

public class LoginDAO {
	
	public static Usuario verificarCredencial(String username, String password) {
		EntityManager em = JPAUTIL.criarEntity();
		
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class);
			query.setParameter("login", username);
			Usuario usuario = query.getSingleResult();
			
			if(usuario != null && usuario.getSenha().equals(password)) {
				return usuario;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

}
