package com.rd.quartaturma;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rd.quartaturma.dao.UsuarioDAO;
import com.rd.quartaturma.vo.Usuario;

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
		}
	}

	private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Connection conn = ConexaoMySql.obterConexao();
		UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
		
		RequestDispatcher rd = null;
		
		try {
			List<Usuario> usuarios = usuarioDAO.getUsuarios();
			request.setAttribute("users", usuarios);
			
			rd = request.getRequestDispatcher("/pages/exibe-usuarios.jsp");
			rd.forward(request, response);
			
			
		} catch (SQLException e) {
			request.setAttribute("erro", "Erro ao consultar lista de usuários");
			rd = request.getRequestDispatcher("/pages/erro-validacao.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}
	
	private void editarUsuario(HttpServletRequest request, HttpServletResponse response) {
		//TODO 
		
	}
	
	private void excluirUsuario(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Connection conn = ConexaoMySql.obterConexao();
		UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
		
		usuarioDAO.excluirUsuario(Integer.valueOf(id));
		
		//Listar novamente os usuários
		listarUsuarios(request, response);
	}
}
