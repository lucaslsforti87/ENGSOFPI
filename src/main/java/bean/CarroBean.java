package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.CarroDao;
import entidade.Carros;
import util.MessageUtil;


@ManagedBean
@ViewScoped
public class CarroBean implements Serializable {
	    private static final long serialVersionUID = 1L;

	    private Carros carros = new Carros();	    
		private Date dataCadastro = new Date();
	    private List<Carros> list;
	 
	    

	    public CarroBean() {
	        System.out.println("Construiu o Bean");
	    }

	    public String salvar() {
	        try {
	            carros.setDataCadastro(dataCadastro);
	            CarroDao.salvar(carros);
	            MessageUtil.sucesso("Sucesso: ", "Usuário criado com sucesso!");
	            carros = new Carros();
	        } catch (Exception e) {
	            MessageUtil.erro("Erro: ", "Erro ao criar usuário!");
	        }
	        return null;
	    }

	    public String editar() {
	        CarroDao.editar(carros);
	        carros = new Carros();
	        return null;
	    }

	    public void deletar() {
	    	CarroDao.deletar(carros);
	        list = CarroDao.listarTodos();
	    }

	    public String listarTodos() {
	        list = CarroDao.listarTodos();
	        return null;
	    }

	    public String getContarCarros() {
	        if (list == null) {
	            list = CarroDao.listarTodos();
	        }
	        return Integer.toString(list.size());
	    }
	    
	    //isso aqui
	    public Carros getCarros() {
	        return carros;
	    }
	    
	    //isso aqui
	    public void setCarros(Carros carros) {
	        this.carros = carros;
	    }

	    


	}
