package bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.LoginDao;
import entidade.Usuario;


@ManagedBean
public class LoginBean implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private LoginDao LoginDAO = new LoginDao();
	
	private Usuario usuario = new Usuario();
		
	private Date UltimoAcesso = new Date();
	
	
	public String envia() {

		usuario = LoginDAO.getUsuario(usuario.getLogin(), usuario.getSenha());
		
		if (usuario != null) {
			
			return "/listagem_usuario";
			
		} else {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha inválido!", "Erro no Login!"));
			return null;
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LoginDao getLoginDAO() {
		return LoginDAO;
	}

	public void setLoginDAO(LoginDao loginDAO) {
		LoginDAO = loginDAO;
	}

	public Date getUltimoAcesso() {
		return UltimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		UltimoAcesso = ultimoAcesso;
	}
}