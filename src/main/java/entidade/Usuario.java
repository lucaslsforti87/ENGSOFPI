package entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {

      @Id
      @GeneratedValue      
      private int id;

      @Column(name="nome", nullable=false, unique=true)
      private String nomeUsuario;
      
      @Column(name="login", nullable=false, unique=true)
      private String login;
      
      @Column(name="senha", nullable=false, unique=false)
      private String senha;
      
      @Column(name="data_cadastro")
      @Temporal(TemporalType.DATE)
      private Date dataCadastro;
     
      @Column(name="data_nascimento")
      private Date dataNascimento;
      
      @Column(name="email", nullable=false, unique=true)
      private String emailUsuario;
      
      
      public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
      }
	
      public void setId(int id) {
			this.id = id;
      }
	
      public String getNomeUsuario() {
	       return nomeUsuario;
      }

      public void setNomeUsuario(String nomeUsuario) {
            this.nomeUsuario = nomeUsuario;
      }

      public String getLogin() {
		return login;
      }

      public void setLogin(String login) {
		this.login = login;
      }

      public String getSenha() {
            return senha;
      }

      public void setSenha(String senha) {
            this.senha = senha;
      }
            
      public Date getDataCadastro() {
    	  return dataCadastro;
      }

      public void setDataCadastro(Date dataCadastro) {
    	  this.dataCadastro = dataCadastro;
      }      
 }