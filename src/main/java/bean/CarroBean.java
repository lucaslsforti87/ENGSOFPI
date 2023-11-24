package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import dao.CarrosDao;
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
	            CarrosDao.salvar(carros);
	            MessageUtil.sucesso("Sucesso: ", "Usuário criado com sucesso!");
	            carros = new Carros();
	        } catch (Exception e) {
	            MessageUtil.erro("Erro: ", "Erro ao criar usuário!");
	        }
	        return null;
	    }

	    public String editar() {
	        CarrosDao.editar(carros);
	        carros = new Carros();
	        return null;
	    }

	    public void deletar() {
	    	CarrosDao.deletar(carros);
	        list = CarrosDao.listarComFiltro(carros);
	    }

	    public String listarTodos() {
	        list = CarrosDao.listarComFiltro(carros);
	        return null;
	    }

	    public String getContarCarros() {
	        if (list == null) {
	            list = CarrosDao.listarComFiltro(carros);
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
