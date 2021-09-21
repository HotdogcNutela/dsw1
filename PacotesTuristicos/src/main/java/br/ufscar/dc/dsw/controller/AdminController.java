package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;

	@Override
	public void init() {
		dao = new UsuarioDAO();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		Erro erros = new Erro();

		if (usuario == null) {
			response.sendRedirect(request.getContextPath());
			return;
		} else if (!usuario.getPapel().equals("ADMIN")) {
			erros.add("Acesso não autorizado!");
			erros.add("Apenas Papel [ADMIN] tem acesso a essa página");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
			return;
		}
		
		String action = request.getPathInfo();
		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
				case "/cadastroCliente":
					apresentaFormularioCadastroCliente(request, response);
					break;
				case "/cadastroAgencia":
					apresentaFormularioCadastroAgencia(request, response);
					break;
				case "/listaClientes":
					listaClientes(request, response);
					break;
				case "/listaAgencias":
					listaAgencias(request, response);
					break;
				default:
					paginaInicial(request, response);
					break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	private void paginaInicial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/index.jsp");
		dispatcher.forward(request, response);
	}

	private void apresentaFormularioCadastroCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formulario.jsp");
		request.setAttribute("usuario", "cliente");
		dispatcher.forward(request, response);
	}

	private void apresentaFormularioCadastroAgencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formulario.jsp");
		request.setAttribute("usuario", "agencia");
		dispatcher.forward(request, response);
	}

	private void listaClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> listaClientes = dao.getAllClientes();
		request.setAttribute("listaClientes", listaClientes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/listaClientes.jsp");
		dispatcher.forward(request, response);
	}

	private void listaAgencias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> listaAgencias = dao.getAllAgencias();
		request.setAttribute("listaAgencias", listaAgencias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/listaAgencias.jsp");
		dispatcher.forward(request, response);
	}
}
