package com.rd.quartaturma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		String sqlConsulta = "select ID_USUARIO,\n"
				+ "		ID_GENERO,\n"
				+ "		ID_ESP_MED,\n"
				+ "		ID_UF_CRM,\n"
				+ "		ID_TIPO_USUARIO,\n"
				+ "		NM_NOME,\n"
				+ "		DT_NASCIMENTO,\n"
				+ "		NR_CPF,\n"
				+ "		NR_CRM,\n"
				+ "		DS_END_IMG"
				+ " FROM TB_USUARIO where ID_USUARIO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sqlConsulta);
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
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
		pstmt.close();
		conn.close();
		
		return usuario;
	}
	
	public List<Usuario> getListaUsuarios() throws SQLException {
		List<Usuario> usuarios = new ArrayList<>();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT U.ID_USUARIO, \n"
				+ "	   U.NM_NOME, \n"
				+ "	   U.DT_NASCIMENTO,\n"
				+ "	   U.NR_CPF,\n"
				+ "	   G.DS_GENERO,\n"
				+ "	   TP.DS_TIPO_USUARIO\n"
				+ "	   FROM TB_USUARIO U,\n"
				+ "			  TB_GENERO G,\n"
				+ "			  TB_TIPO_USUARIO TP\n"
				+ " WHERE U.ID_GENERO = G.ID_GENERO\n"
				+ " AND U.ID_TIPO_USUARIO = TP.ID_TIPO_USUARIO");
		
		Usuario usuario = new Usuario();
		if(rs.next()) {
			usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
			usuario.setNome(rs.getString("NM_NOME"));
			usuario.setDtNascimento(rs.getDate("DT_NASCIMENTO"));
			usuario.setCpf(rs.getString("NR_CPF"));
			
			usuario.setDsGenero(rs.getString("DS_GENERO"));
			usuario.setDsTipoUsuario(rs.getString("DS_TIPO_USUARIO"));
			
			usuarios.add(usuario);
		}

		rs.close();
		stmt.close();
		conn.close();
		
		return usuarios;
	}
	
	public boolean inserirUsuario(Usuario usuario) {
		String sqlInsert = "INSERT INTO TB_USUARIO (ID_USUARIO, "
				+ "						ID_GENERO, "
				+ "						ID_ESP_MED, "
				+ "						ID_UF_CRM, "
				+ "						ID_TIPO_USUARIO, "
				+ "						NM_NOME, "
				+ "						DT_NASCIMENTO, " 
				+ "						NR_CPF, "
				+ "						NR_CRM, "
				+ "						DS_END_IMG) "
				+ " VALUES(NULL, ?, 2, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setInt(1, usuario.getIdGenero());

			if(usuario.getIdEspMed() == null)
				pstmt.setNull(2, java.sql.Types.INTEGER);
			else
				pstmt.setInt(2, usuario.getIdEspMed());
			
			if(usuario.getIdUfCrm() == null)
				pstmt.setNull(3, java.sql.Types.INTEGER);
			else
				pstmt.setInt(3, usuario.getIdUfCrm());
			
			pstmt.setInt(4, usuario.getIdTipoUsuario());
			pstmt.setString(5, usuario.getNome());
			if(usuario.getDtNascimento() == null)
				pstmt.setNull(6, java.sql.Types.DATE);
			else {
				long dataTimesTamp = usuario.getDtNascimento().getTime();
				pstmt.setDate(6, new java.sql.Date(dataTimesTamp));
			}
			pstmt.setString(7, usuario.getCpf());
			pstmt.setString(8, usuario.getCrm());
			pstmt.setString(9, usuario.getEndImagem());
			
			int qtd = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			if(qtd > 0)
				return true;
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário");
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean inserirUsuarios(List<Usuario> usuarios) {
		String sqlInsert = "INSERT INTO TB_USUARIO (ID_USUARIO, "
				+ "						ID_GENERO, "
				+ "						ID_ESP_MED, "
				+ "						ID_UF_CRM, "
				+ "						ID_TIPO_USUARIO, "
				+ "						NM_NOME, "
				+ "						DT_NASCIMENTO, " 
				+ "						NR_CPF, "
				+ "						NR_CRM, "
				+ "						DS_END_IMG) "
				+ " VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			for(Usuario usuario : usuarios) {
				pstmt.clearParameters();
				pstmt.setInt(1, usuario.getIdGenero());
				pstmt.setInt(2, usuario.getIdEspMed());
				pstmt.setInt(3, usuario.getIdUfCrm());
				pstmt.setInt(4, usuario.getIdTipoUsuario());
				pstmt.setString(5, usuario.getNome());
				long dataTimesTamp = usuario.getDtNascimento().getTime();
				pstmt.setDate(6, new java.sql.Date(dataTimesTamp));
				pstmt.setString(7, usuario.getCpf());
				pstmt.setString(8, usuario.getCrm());
				pstmt.setString(9, usuario.getEndImagem());
				
				pstmt.executeUpdate();
			}
			
			pstmt.close();
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário");
			e.printStackTrace();
		}
		
		return false;
	}
	
	private void fecharConexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
