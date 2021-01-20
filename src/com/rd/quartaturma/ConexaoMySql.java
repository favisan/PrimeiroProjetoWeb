package com.rd.quartaturma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySql {

	public Connection obterConexao() {
		String url = "jdbc:mysql://dev.crurmnllvgn6.us-east-2.rds.amazonaws.com/BD_PI_QUARTA_TURMA";
		String usuario = "java";
		String senha = "1234";

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, usuario, senha);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
}


