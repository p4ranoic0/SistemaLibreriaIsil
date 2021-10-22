package com.libreria.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libreria.dao.UsuarioDao;
import com.libreria.model.Usuario;


/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	UsuarioDao objUsuarioDao = new UsuarioDao();
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		switch (opcion) {
			case "validarUsuario" : {
				/*Aquí implemento toda la lógica a utilizar para validar usuario en login*/
				try {
					validarUsuario(request,response);
					break;
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			case "nuevoUsuario":{
				try {
					ingresarUsuario(request,response);
					break;
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			case "recuperarContra":{
				try {
					buscarContra(request,response);
					break;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		doGet(request, response);
	}

	private void buscarContra(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		String correo = request.getParameter("correo");		
		String password = objUsuarioDao.buscarContra_SP(correo);
		System.out.println(password);
		request.setAttribute("password", password); 
		request.setAttribute("correo", correo);
		/*Esto lo hago para dejarle a la pï¿½gina un atributo que la pï¿½gina pueda recuperar*/
		String paginaJSP = "/RecuperarContrasena.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);
		
	}

	private void ingresarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String correo = request.getParameter("correo");
		String nombre = request.getParameter("nombre");
		String apePaterno = request.getParameter("apePaterno");
		String apeMaterno = request.getParameter("apeMaterno");
		String direccion = request.getParameter("direccion");
		String password= request.getParameter("password");
		
		Usuario objUsuario = new Usuario(correo,nombre,apePaterno,apeMaterno,direccion,password);
		/*Utilizo el objeto DAO para agregarlo en la base de datos*/
		//objParqueDAO.agregarParque(objParque);
		objUsuarioDao.agregarUsuario_SP(objUsuario);
		String paginaJSP = "/Principal.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);
		
	}

	private void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String pagina;
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		int existe = objUsuarioDao.validarUsuarioSP(correo, password);
		if (existe==1) {
			/*Aqui significa que el usuario si existe en la BD*/
			pagina = "/Principal.jsp";
			System.out.println("Logeo exitoso");
		}
		else {
			pagina = "/Login.jsp";
			System.out.println("error en datos");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}

}
