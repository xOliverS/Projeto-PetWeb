package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidades.Servico;
import util.JPAUTIL;



public class ServicoDAO {

	public static void salvar(Servico serv) {
		EntityManager em = JPAUTIL.criarEntity();
		em.getTransaction().begin();
		em.persist(serv);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Servico> listarTodos(){
		EntityManager em = JPAUTIL.criarEntity();
		Query q = em.createQuery("select s from Funcionario s");
		List<Servico> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	public static Servico getId(Integer id) {
		EntityManager em = JPAUTIL.criarEntity();
		Servico serv = em.find(Servico.class, id);
		em.close();
		return serv;
	}
	

}
