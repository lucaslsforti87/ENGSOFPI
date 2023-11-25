package dao;

import java.util.List;

import javax.persistence.EntityManager;

import util.JPAUtil;

import entidade.Usuario;

public class RecuperarDao {

    public boolean verificarSenha(String login, String senha) {

        EntityManager em = JPAUtil.criarEntityManager();

        try {
            List<Usuario> usuarios = em
                .createQuery("SELECT u from Usuario u where u.login = :login", Usuario.class)
                .setParameter("login", login)
                .getResultList();

            // Verifica se existe algum usuário com o login fornecido
            if (!usuarios.isEmpty()) {
                Usuario usuario = usuarios.get(0);

                // Verifica se a senha fornecida corresponde à senha armazenada (não é uma prática segura!)
                return usuario.getSenha().equals(senha);
            }

            // Caso não exista usuário com o login fornecido ou a senha esteja incorreta
            return false;

        } finally {
            em.close();
        }
    }

	public Usuario getUsuario(String login, int dataNascimento) {
		// TODO Auto-generated method stub
		return null;
	}
}