package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.UsuarioDao;

import entidade.Usuario;
import util.MessageUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Usuario usuario = new Usuario();
	
	private Date dataCadastro = new Date();
	
	private List<Usuario> list;
	
	private  String contarUsuario;
		
		
	public String salvar() {
			
		try {			
			usuario.setDataCadastro(dataCadastro);
			UsuarioDao.salvar(usuario);
			MessageUtil.sucesso("Sucesso: ", "Usuário criado com sucesso!");
			usuario = new Usuario();
				
		} catch(Exception e) {
			MessageUtil.erro("Erro: ", "Erro ao criar usuário!");
		}
			
		return null;
		}
	
	public String editar() {		
		UsuarioDao.editar(usuario);
		usuario = new Usuario();
		return null;
	}

	public void deletar() {		
		UsuarioDao.deletar(usuario);
		list = UsuarioDao.listarTodos();
	}
	
	public String listarTodos() {		
		UsuarioDao.listarTodos();
		return null;
	}		

	public List<Usuario> getList() {
		if (list == null) {
			list = UsuarioDao.listarTodos();
		}
		return list;
	}
	
	public void setList(List<Usuario> list) {
		this.list = list;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getContarUsuario() {
		
		if (list == null) {
			list = UsuarioDao.listarTodos();
		}
		return Integer.toString(list.size());
	}

	public void setContarUsuario(String contarUsuario) {
		this.contarUsuario = contarUsuario;
	}	
	
	public String contarEmail() {
		return contarUsuario;	
	}	
}
