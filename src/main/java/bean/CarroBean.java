package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.CarroDao;
import entidade.Carro;
import util.MessageUtil;

@ManagedBean
@ViewScoped
public class CarroBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private Carro Carro = new Carro();
	
	private List<Carro> list;
	
	private Date dataCadastro = new Date();
	
	private  String contarCarro;
					
	public String salvar() {
		
		try {	
			Carro.setDataCadastro(dataCadastro);
			CarroDao.salvar(Carro);
			MessageUtil.sucesso("Sucesso: ", "Carro salvo com sucesso!");
			Carro = new Carro();
			
		} catch(Exception e) {
			MessageUtil.erro("Erro: ", "Erro ao salvar o Carro!");
		}
		
		return null;
	}
	
	public String editar() {		
		CarroDao.editar(Carro);
		Carro = new Carro();
		return null;
	}

	public void deletar() {		
		CarroDao.deletar(Carro);
		list = CarroDao.listarTodos();
	}
	
	public String listarPorId() {		
		CarroDao.listarPorId(Carro.getId());
		return null;
	}	
	
	public String listarTodos() {		
		CarroDao.listarTodos();
		return null;
	}	
		
	public Carro getCarro() {
		return Carro;
	}


	public void setCarro(Carro Carro) {
		this.Carro = Carro;
	}


	public List<Carro> getList() {
		if (list == null) {
			list = CarroDao.listarTodos();
		}
		return list;
	}
		
	public void setList(List<Carro> list) {
		this.list = list;
	}
	
	public String getContarCarro() {
		if (list == null) {
			list = CarroDao.listarTodos();
		}
		return Integer.toString(list.size());
	}

	public void setContarCarro(String contarCarro) {
		this.contarCarro = contarCarro;
	}
	
	public String contarCarro() {
		return contarCarro;	
	}
}
