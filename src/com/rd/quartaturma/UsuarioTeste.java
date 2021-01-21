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
			testeConsulta(usuarioDAO);
//			testeInsert(usuarioDAO);

		} catch (Exception e) {
			System.out.println("Erro ao consultar usuários" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private static void testeConsulta(UsuarioDAO usuarioDAO) throws SQLException {
		List<Usuario> usuarios = usuarioDAO.getUsuarios();
//		List<Usuario> usuarios = usuarioDAO.getListaUsuarios();
		System.out.println(usuarios);
		
//		Usuario usuario = usuarioDAO.getUsuarioById(1);
//		System.out.println(usuario.getNome());
//		System.out.println(usuario.getCpf());
	}
	
	private static void testeInsert(UsuarioDAO usuarioDAO) {
		Usuario usuario = new Usuario();
		usuario.setNome("Ivo");
		usuario.setCpf("4308430803");
		usuario.setIdGenero(2);
		usuario.setIdTipoUsuario(1);
//		usuario.setIdEspMed(1);
		
		usuarioDAO.inserirUsuario(usuario);
	}
}
