package dao;

import javax.persistence.EntityManager;


import entidades.Usuario;
import util.JPAUTIL;

public class UsuarioDAO {
	public static void salvar(Usuario user) {
		EntityManager em = JPAUTIL.criarEntity();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

}
