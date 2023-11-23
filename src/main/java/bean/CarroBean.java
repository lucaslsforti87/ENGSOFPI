package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import dao.CarroDao;
import dao.UsuarioDao;
import entidade.Carros;
import entidade.Usuario;
import util.MessageUtil;

	public class CarroBean implements Serializable {
	    private static final long serialVersionUID = 1L;

	    private static Carros carros = new Carros();
	    private Date dataCadastro = new Date();
	    private List<Carros> list;
	    private String contarUsuario;
	    

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

	    public String getContarUsuario() {
	        if (list == null) {
	            list = CarroDao.listarTodos();
	        }
	        return Integer.toString(list.size());
	    }

	}


