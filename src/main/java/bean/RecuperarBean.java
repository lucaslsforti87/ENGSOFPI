package bean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.RecuperarDao;
import entidade.Usuario;

@ManagedBean
public class RecuperarBean {
    
    private Usuario Usuario = new Usuario();
    
   
    private RecuperarDao recuperarDao;

    // Getters e setters para 'usuario' e 'recuperarDao' 

    public String redefinirSenha() {
        if (recuperarDao != null) {
        	
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Senha enviada por email!", "Confira sua Caixa de Mensagem!"));
            // Lógica para redefinir a senha do usuário
            // Exemplo: recuperarDao.redefinirSenha(usuario);
            
            return "/Locacao.xhtml?faces-redirect=true"; // Redirecionamento após redefinir a senha
        } else {
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Senha enviada por email!", "Confira sua Caixa de Mensagem!"));
            return null;
        }
    }

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
}