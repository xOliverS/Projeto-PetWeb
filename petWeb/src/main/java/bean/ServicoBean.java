package bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ServicoDAO;
import entidades.Servico;

@ManagedBean
public class ServicoBean {

	private Servico serv = new Servico();
	private List<Servico> list;
	

	
	public String salvar() {
		
		try {
			ServicoDAO.salvar(serv);
			serv = new Servico();
			System.out.println("DEU CERTO");
			
		} catch (Exception e) {
			System.out.println("PIFOU");
		}
		return null;
	}
	
	public List<Servico> getLista() {
		if (list == null) {
			list = ServicoDAO.listarTodos();
		}
		return list;
	}
	
	public Servico getServ() {
		return serv;
	}
	public void setServ(Servico serv) {
		this.serv = serv;
	}
	public List<Servico> getList() {
		if (list == null) {
			list = ServicoDAO.listarTodos();
		}
		return list;
	}
	public void setList(List<Servico> list) {
		this.list = list;
	}
	

}
