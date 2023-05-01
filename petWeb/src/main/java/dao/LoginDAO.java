package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Usuario;
import util.JPAUTIL;


public class LoginDAO {
	
	public static Usuario buscarLoginSenha(String login, String senha) {
		try {
			EntityManager em = JPAUTIL.criarEntity();
			Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha");
			q.setParameter("login", login);
			q.setParameter("senha", senha);
			return (Usuario) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
