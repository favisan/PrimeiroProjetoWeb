package com.rd.quartaturma.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rd.quartaturma.vo.Usuario;

public class UsuarioDAO {

	private Connection conn;
	
	public UsuarioDAO(Connection conexao) {
		this.conn = conexao;
	}
	
	public List<Usuario> getUsuarios() throws SQLException {
		List<Usuario> usuarios = new ArrayList<>();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select ID_USUARIO,\n"
				+ "		ID_GENERO,\n"
				+ "		ID_ESP_MED,\n"
				+ "		ID_UF_CRM,\n"
				+ "		ID_TIPO_USUARIO,\n"
				+ "		NM_NOME,\n"
				+ "		DT_NASCIMENTO,\n"
				+ "		NR_CPF,\n"
				+ "		NR_CRM,\n"
				+ "		DS_END_IMG"
				+ " FROM TB_USUARIO");
		
//		ResultSet rs = stmt.executeQuery("select * FROM TB_USUARIO");

		while(rs.next()) {
//			Integer idUsuario = rs.getInt("ID_USUARIO");
//			Integer genero = rs.getInt("ID_GENERO");
//			Integer espMed = rs.getInt("ID_ESP_MED");
//			Integer uf = rs.getInt("ID_UF_CRM");
//			Integer tipoUsuario = rs.getInt("ID_TIPO_USUARIO");
//			String nome = rs.getString("NM_NOME");
//			Date dtNascimento = rs.getDate("DT_NASCIMENTO");
//			String cpf = rs.getString("NR_CPF");
//			String crm = rs.getString("NR_CRM");
//			String endImg = rs.getString("DS_END_IMG");
//			
//			Usuario usuario = new Usuario();
//			usuario.setIdUsuario(idUsuario);
//			usuario.setIdGenero(genero);
//			usuario.setIdEspMed(espMed);
//			usuario.setIdUfCrm(uf);
//			usuario.setIdTipoUsuario(tipoUsuario);
//			usuario.setNome(nome);
//			usuario.setDtNascimento(dtNascimento);
//			usuario.setCpf(cpf);
//			usuario.setCrm(crm);
//			usuario.setEndImagem(endImg);
						
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
			usuario.setIdGenero(rs.getInt("ID_GENERO"));
			usuario.setIdEspMed(rs.getInt("ID_ESP_MED"));
			usuario.setIdUfCrm(rs.getInt("ID_UF_CRM"));
			usuario.setIdTipoUsuario(rs.getInt("ID_TIPO_USUARIO"));
			usuario.setNome(rs.getString("NM_NOME"));
			usuario.setDtNascimento(rs.getDate("DT_NASCIMENTO"));
			usuario.setCpf(rs.getString("NR_CPF"));
			usuario.setCrm(rs.getString("NR_CRM"));
			usuario.setEndImagem(rs.getString("DS_END_IMG"));
			
			usuarios.add(usuario);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return usuarios;
	}
	
	
	public Usuario getUsuarioById(Integer id) throws SQLException {
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select ID_USUARIO,\n"
				+ "		ID_GENERO,\n"
				+ "		ID_ESP_MED,\n"
				+ "		ID_UF_CRM,\n"
				+ "		ID_TIPO_USUARIO,\n"
				+ "		NM_NOME,\n"
				+ "		DT_NASCIMENTO,\n"
				+ "		NR_CPF,\n"
				+ "		NR_CRM,\n"
				+ "		DS_END_IMG"
				+ " FROM TB_USUARIO where ID_USUARIO = " + id);
		
		Usuario usuario = new Usuario();
		if(rs.next()) {
			usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
			usuario.setIdGenero(rs.getInt("ID_GENERO"));
			usuario.setIdEspMed(rs.getInt("ID_ESP_MED"));
			usuario.setIdUfCrm(rs.getInt("ID_UF_CRM"));
			usuario.setIdTipoUsuario(rs.getInt("ID_TIPO_USUARIO"));
			usuario.setNome(rs.getString("NM_NOME"));
			usuario.setDtNascimento(rs.getDate("DT_NASCIMENTO"));
			usuario.setCpf(rs.getString("NR_CPF"));
			usuario.setCrm(rs.getString("NR_CRM"));
			usuario.setEndImagem(rs.getString("DS_END_IMG"));
		}

		rs.close();
		stmt.close();
		conn.close();
		
		return usuario;
	}
	
}
