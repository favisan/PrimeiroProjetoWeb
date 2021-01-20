package com.rd.quartaturma;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.rd.quartaturma.dao.UsuarioDAO;
import com.rd.quartaturma.vo.Usuario;

public class UsuarioTeste {

	public static void main(String args[]) {
		ConexaoMySql conexao = new ConexaoMySql();
		
		Connection conn = conexao.obterConexao();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
		
		try {
//			List<Usuario> usuarios = usuarioDAO.getUsuarios();
//			System.out.println(usuarios);
			Usuario usuario = usuarioDAO.getUsuarioById(1);
			
			System.out.println(usuario.getNome());
			System.out.println(usuario.getCpf());
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar usuários" + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
