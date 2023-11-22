package bean;

import java.io.Serializable;
import java.util.Date;

import dao.LoginDao;
import entidade.Usuario;
	
	public class RecuperarBean  implements Serializable{
		private static final long serialVersionUID = 1L;

		
		private LoginDao LoginDAO = new LoginDao();
		
		private Usuario usuario = new Usuario();
			
		private Date UltimoAcesso = new Date();

}
