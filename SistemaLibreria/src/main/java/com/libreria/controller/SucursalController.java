package com.libreria.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libreria.dao.SucursalDao;
import com.libreria.model.Sucursal;


@WebServlet("/sucursal")
public class SucursalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SucursalDao objSucursalDao = new SucursalDao();

	public SucursalController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { //
		String opcion = request.getParameter("opcion");
		switch (opcion) {

		case "buscarPorNombre": {
			buscarporNombre(request, response);
			break;
		}
		case "nuevo": {
			nuevaSucursal(request, response);
			break;
		}

		case "editar": {
			editarSucursal(request, response);
			break;
			}
		}

	}

	private void editarSucursal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
		Sucursal objSucursalEditar = null;
		//objParqueEditar = objParqueDAO.buscarParquexId(idParque);
		objSucursalEditar = objSucursalDao.buscarParquexId_SP(idSucursal);	
		request.setAttribute("sucursal",objSucursalEditar);
		String paginaJSP = "/EditarSucursal.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);
		
	}

	private void nuevaSucursal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paginaJSP = "/NuevaSucursal.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);

	}

	private void buscarporNombre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Sucursal> listaSucursal;
		String nombreSucursal = request.getParameter("nombreSucursal");
		if (nombreSucursal == null) {

			listaSucursal = objSucursalDao.buscarSucursalAll_SP();
		} else {

			listaSucursal = objSucursalDao.buscarSucursalxNombre_SP(nombreSucursal);
		}

		request.setAttribute("listaSucursal", listaSucursal); /*
																 * Esto lo hago para dejarle a la página un atributo que
																 * la página pueda recuperar
																 */
		String paginaJSP = "/GestionSucursal.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "guardar": {
			try {
				grabarSucursal(request, response);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		case "eliminar": {
			// System.out.println("al cargar nuevamente se genera una excepcion");
			try {
				eliminarSucursal(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		case "actualizar" :{						
			try {
				actualizarSucursal(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
	}

	private void actualizarSucursal(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String estado = request.getParameter("estado");
		
		
		Sucursal objSucursal = new Sucursal(idSucursal,nombre,descripcion,estado);
		/*Utilizo el objeto DAO para agregarlo en la base de datos*/
		//objParqueDAO.editarParque(objParque);		
		objSucursalDao.editarSucursal_SP(objSucursal);
		String paginaJSP = "/GestionSucursal.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);
		System.out.println("Registro actualizado");
		
	}

	private void eliminarSucursal(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
		objSucursalDao.eliminarSucursal_SP(idSucursal);
		String paginaJSP = "/GestionSucursal.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);
		System.out.println("registro eliminado");

	}

	private void grabarSucursal(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String estado = "Activo";
		Sucursal objSucursal = new Sucursal(nombre, descripcion, estado);
		objSucursalDao.agregarSucursal_SP(objSucursal);
		String paginaJSP = "/GestionSucursal.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);

	}

}
