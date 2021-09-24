package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.PacoteDAO;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/pacote/*")
public class PacoteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PacoteDAO dao;

	@Override
	public void init() {
		dao = new PacoteDAO();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		
		String action = request.getPathInfo();
		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
				case "/cadastroPacote":
					apresentaFormularioCadastroPacote(request, response, usuario);
					break;
				case "/inserirPacote":
					inserePacote(request, response, usuario);
					break;
				case "/listaPacotesAgencia":
					listaPacotesAgencia(request, response, usuario);
					break;
				case "/listaPacotesCliente":
					listaPacotesCliente(request, response, usuario);
					break;
				case "/atualizaPacote":
					apresentaFormularioEdicaoPacote(request, response, usuario);
					break;
				case "/atualizarPacote":
					atualizaPacote(request, response, usuario);
					break;
				case "/removePacote":
					removePacote(request, response, usuario);
					break;
				default:
					listaDePacotes(request, response);
					break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	private void listaDePacotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pacote> listaPacotes = dao.getAllPacotes();
		request.setAttribute("listaPacotes", listaPacotes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pacote/listaPacotes.jsp");
		dispatcher.forward(request, response);
	}

	private void listaPacotesAgencia(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		System.out.println("Ta no controller e na funcao certa");
		if (usuario.getPapel().equals("AGENCIA")) {
			System.out.println("Verificou o papel e é AGENCIA");
			List<Pacote> listaPacotes = dao.getAllPacotesAgencia(usuario);
			System.out.println("Chamou o DAO e listou os pacotes");
			request.setAttribute("lista", listaPacotes);
			System.out.println("adicionou o atributo de sessão");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pacote/listaPacotes.jsp");
			System.out.println("setou a url do forward");
			System.out.println("enviando para: " + dispatcher);
			dispatcher.forward(request, response);
		} else {
			acessoNegadoAgencia(request, response);
		}
	}

	private void listaPacotesCliente(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		if (usuario.getPapel().equals("CLIENTE")) {
			List<Pacote> listaPacotes = dao.getAllPacotesCliente(usuario);
			request.setAttribute("listaPacotes", listaPacotes);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pacote/listaPacotes.jsp");
			dispatcher.forward(request, response);
		} else {
			acessoNegadoCliente(request, response);
		}
	}

	private void apresentaFormularioCadastroPacote(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		if (usuario.getPapel().equals("AGENCIA")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pacote/formulario.jsp");
			request.setAttribute("usuario", "cliente");
			dispatcher.forward(request, response);
		} else {
			acessoNegadoAgencia(request, response);
		}
	}

	private void apresentaFormularioEdicaoPacote(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		if (usuario.getPapel().equals("AGENCIA")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Pacote pacote = dao.get(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pacote/formulario.jsp");
			dispatcher.forward(request, response);
		} else {
			acessoNegadoAgencia(request, response);
		}
	}

	private void inserePacote(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		if (usuario.getPapel().equals("AGENCIA")) {
			request.setCharacterEncoding("UTF-8");
			Long id = Long.parseLong(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String cnpj = request.getParameter("cnpj");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String pais = request.getParameter("pais");
			Date partida = null;
			try {
				partida = new java.sql.Date((new SimpleDateFormat("dd.mm.yyyy").parse(request.getParameter("partida"))).getTime());
			} catch (Exception e) {
				System.out.println("Erro ao inserir a data.");
			}
			Integer duracao = Integer.parseInt(request.getParameter("duracao"));
			Float valor = Float.parseFloat(request.getParameter("valor"));

			UsuarioDAO uDao = new UsuarioDAO();

			Usuario agencia = uDao.getAgenciaByCnpj(cnpj);
			
			Pacote pacote = new Pacote(id, nome, agencia, cidade, estado, pais, partida, duracao, valor);

			dao.update(pacote);
			response.sendRedirect("listaPacotesAgencia");
		} else {
			acessoNegadoAgencia(request, response);
		}
	}

	private void atualizaPacote(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		if (usuario.getPapel().equals("AGENCIA")) {
			request.setCharacterEncoding("UTF-8");
			Long id = Long.parseLong(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String cnpj = request.getParameter("cnpj");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String pais = request.getParameter("pais");
			Date partida = null;
			try {
				partida = new java.sql.Date((new SimpleDateFormat("dd.mm.yyyy").parse(request.getParameter("partida"))).getTime());
			} catch (Exception e) {
				System.out.println("Erro ao inserir a data.");
			}
			Integer duracao = Integer.parseInt(request.getParameter("duracao"));
			Float valor = Float.parseFloat(request.getParameter("valor"));

			UsuarioDAO uDao = new UsuarioDAO();

			Usuario agencia = uDao.getAgenciaByCnpj(cnpj);
			
			Pacote pacote = new Pacote(id, nome, agencia, cidade, estado, pais, partida, duracao, valor);

			dao.update(pacote);
			response.sendRedirect("listaPacotesAgencia");
		} else {
			acessoNegadoAgencia(request, response);
		}
	}

	private void removePacote(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		if (usuario.getPapel().equals("AGENCIA")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Pacote pacote = new Pacote(id);                                                                           
			dao.delete(pacote);
			response.sendRedirect("listaPacotesAgencia");
		} else {
			acessoNegadoAgencia(request, response);
		}
	}

	private void acessoNegadoAgencia (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro();
		erros.add("Acesso não autorizado!");
		erros.add("Apenas usuários com papel [AGENCIA] têm acesso a essa página");
		request.setAttribute("mensagens", erros);
		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
		rd.forward(request, response);
	}

	private void acessoNegadoCliente (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro();
		erros.add("Acesso não autorizado!");
		erros.add("Apenas usuários com papel [CLIENTE] têm acesso a essa página");
		request.setAttribute("mensagens", erros);
		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
		rd.forward(request, response);
	}
}
