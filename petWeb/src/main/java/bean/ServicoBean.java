package bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import static util.MessageUTIL.*;

import dao.ServicoDAO;
import entidades.Servico;

@ManagedBean
public class ServicoBean {

	private Servico serv = new Servico();
	private List<Servico> list;
	

	
	public String salvar() {
		
		try {
			ServicoDAO.salvar(serv);
			sucesso("Sucesso", "Agendamento realizado com sucesso !");
			serv = new Servico();
		} catch (Exception e) {
			erro("Erro", "Erro ao agendar serviço" + e);
		}
		return null;
	}
	
	public String deletar() {
		ServicoDAO.deletar(serv);
		sucesso("Sucesso", "Agendamento removido !");
		list = ServicoDAO.listarTodos();
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
