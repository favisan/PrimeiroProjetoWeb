package com.rd.quartaturma;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rd.quartaturma.dao.UsuarioDAO;
import com.rd.quartaturma.entity.UsuarioEntity;
import com.rd.quartaturma.vo.Usuario;

//import br.com.rd.dao.CrudEntityManager;


@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao == null) {
			this.listarUsuarios(request, response);
		}else if(acao.equals("editar")) {
			this.editarUsuario(request, response);
		}else if(acao.equals("remover")){
			this.excluirUsuario(request, response);
		}else if(acao.equals("novo")) {
			RequestDispatcher rd = request.getRequestDispatcher("/pages/novo-usuario.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ConexaoMySql.obterConexao();
		UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
		
		String acao = request.getParameter("acao");
		
		if(acao.equals("alterar"))
			this.atualizaUsuario(usuarioDAO, request);
		else if(acao.equals("novo"))
			this.insereUsuario(usuarioDAO, request);
		
		listarUsuarios(request, response);
	}
	
	private void insereUsuario(UsuarioDAO usuarioDAO, HttpServletRequest request) {
		String nome  =  request.getParameter("nome");
		String cpf  = request.getParameter("cpf");
		
		//COM JDBC
//		Usuario usuario = new Usuario();
//		usuario.setNome(nome);
//		usuario.setCpf(cpf);
//		usuarioDAO.inserirUsuario(usuario);
		
		//COM JPA
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setNome(nome);
		usuarioEntity.setCpf(cpf);
		usuarioEntity.setIdTipoUsuario(BigInteger.valueOf(1));
		
		EntityManager em = CrudEntityManager.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(usuarioEntity);
		
		UsuarioEntity usuario = em.find(UsuarioEntity.class, 10);
		
		em.getTransaction().commit();
	}
	
	private void atualizaUsuario(UsuarioDAO usuarioDAO, HttpServletRequest request) {
		String nome  =  request.getParameter("nome");
		String cpf  = request.getParameter("cpf");
		String id  = request.getParameter("id");
		
//		Usuario usuario = new Usuario();
//		usuario.setIdUsuario(Integer.valueOf(id));
//		usuario.setNome(nome);
//		usuario.setCpf(cpf);
//		
//		usuarioDAO.atualizarUsuario(usuario);
		
		EntityManager em = CrudEntityManager.getEntityManager();
		UsuarioEntity usuarioEntity = em.find(UsuarioEntity.class, new BigInteger(id));
		usuarioEntity.setNome(nome);
		usuarioEntity.setCpf(cpf);
		
		em.getTransaction().begin();
		em.merge(usuarioEntity);
		em.getTransaction().commit();
	}
	
	
	private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//COM JDBC
//		Connection conn = ConexaoMySql.obterConexao();
//		UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
		
		RequestDispatcher rd = null;
		
//		try {
			//COM JDBC
//			List<Usuario> usuarios = usuarioDAO.getUsuarios();
			
			//COM JPA
			EntityManager em = CrudEntityManager.getEntityManager();
			Query query = em.createNamedQuery("Usuario.findAll", UsuarioEntity.class);
			
	        List<UsuarioEntity> usuariosEntity =  query.getResultList();
	        
//	        List<Usuario> usuarios = new ArrayList<Usuario>();
	        
//	        for(UsuarioEntity entity : usuariosEntity) {
//	        	Usuario usuario = new Usuario();
//	        	usuario.setIdUsuario(entity.getIdUsuario().intValue());
//	        	usuario.setNome(entity.getNome());
//	        	usuario.setCpf(entity.getCpf());
//	        	usuario.setDtNascimento(entity.getDtNascimento());
//	        	
//	        	usuarios.add(usuario);
//	        }
	        
	        request.setAttribute("users", usuariosEntity);
			
			rd = request.getRequestDispatcher("/pages/exibe-usuarios.jsp");
			rd.forward(request, response);
			
//		} catch (SQLException e) {
//			request.setAttribute("erro", "Erro ao consultar lista de usuários");
//			rd = request.getRequestDispatcher("/pages/erro-validacao.jsp");
//			rd.forward(request, response);
//			e.printStackTrace();
//		}
	}
	
	private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		String id = request.getParameter("id");
		
		Connection conn = ConexaoMySql.obterConexao();
		UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
		
		try {
			Usuario usuario = usuarioDAO.getUsuarioById(Integer.valueOf(id));
			request.setAttribute("usuario", usuario);
			
			rd = request.getRequestDispatcher("/pages/altera-usuario.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("erro", "Erro ao editar usuário");
			rd = request.getRequestDispatcher("/pages/erro-validacao.jsp");
			rd.forward(request, response);
			e.printStackTrace();
			e.printStackTrace();
		}
		
	}
	
	private void excluirUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		//JDBC
//		Connection conn = ConexaoMySql.obterConexao();
//		UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
//		
//		boolean retorno = usuarioDAO.excluirUsuario(Integer.valueOf(id));
//		if(retorno)
//			this.listarUsuarios(request, response);
//		else
//			//TODO
		
		//JPA
		EntityManager em = CrudEntityManager.getEntityManager();
		UsuarioEntity usuarioEntity = em.find(UsuarioEntity.class, new BigInteger(id));
		em.getTransaction().begin();
		em.remove(usuarioEntity);
		em.getTransaction().commit();
		
		this.listarUsuarios(request, response);
	}
}
