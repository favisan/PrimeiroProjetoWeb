package com.rd.quartaturma;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChamadaJspServlet
 */
@WebServlet("/bem-vindo")
public class ChamadaJspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChamadaJspServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Executar regra de negócio
		RequestDispatcher rd = null;
		try {
			String nome = request.getParameter("nome");
			String idade = request.getParameter("idade");
			
			request.setAttribute("nome", nome);
			request.setAttribute("idade", idade);
			
//			String pIdade = request.getParameter("idade");
//			if(pIdade != null) {
//				int idade = Integer.valueOf(pIdade);
//				request.setAttribute("idade", idade);
//			}
			
			List<Modulo> lista = new ArrayList<Modulo>();
			lista.add(new Modulo("Nivelamento", 40));
			lista.add(new Modulo("Frontend", 60));
			lista.add(new Modulo("Banco de Dados", 40));
			lista.add(new Modulo("Java", 40));
			
			request.setAttribute("modulos", lista);
			
			// Chamar JSP
			rd = request.getRequestDispatcher("/pages/exibe-nome.jsp");
			rd.forward(request, response);
			
		} catch(NumberFormatException e) {
			
			request.setAttribute("erro", "Parametro idade é obrigatório");
			rd = request.getRequestDispatcher("/pages/erro-validacao.jsp");
			rd.forward(request, response);
			e.printStackTrace();
			
		} catch (ServletException | IOException e) {
			request.setAttribute("erro", "Erro de servidor.");
			rd = request.getRequestDispatcher("/pages/erro-validacao.jsp");
			rd.forward(request, response);
			
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("erro", "Erro desconhecido");
			rd = request.getRequestDispatcher("/pages/erro-validacao.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

