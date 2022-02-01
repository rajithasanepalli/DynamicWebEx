package com.mouritech.departmentmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouritech.departmentmanagement.dao.DepartmentDao;
import com.mouritech.departmentmanagement.entity.Department;

/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DepartmentDao depDao;

	public void init() {
		depDao = new DepartmentDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		try {

			switch (action) {
			case "/new":
				showNewDepartmentForm(req, resp);
				break;
			case "/insert":
				insertDepartment(req, resp);
				break;
			case "/list":
				listDepartment(req, resp);
				break;
			case "/update":
				updateDepartment(req, resp);
				break;
			case "/edit":
				showEditDepartmentForm(req, resp);
				break;
			case "/delete":
				deleteDepartment(req, resp);
				break;
			default:
				break;
			}// close of switch

		} catch (Exception e) {
			e.printStackTrace();
		} // close catch

	}// close of doPost

	private void showEditDepartmentForm(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, SQLException {
		Integer depid = Integer.parseInt(req.getParameter("id"));

		Department existingDepartment = depDao.getDepartment(depid);
		RequestDispatcher rd = req.getRequestDispatcher("department-form.jsp");
		req.setAttribute("existingDepartment", existingDepartment);
		rd.forward(req, resp);
	}

	private void updateDepartment(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, SQLException {
		Integer depid = Integer.parseInt(req.getParameter("did"));
		String depname = req.getParameter("dname");
		String depemail = req.getParameter("demail");
		String depmobno = req.getParameter("dmobno");

		Department dep = new Department(depid, depname, depemail, depmobno);
		depDao.updateDepartment(dep);
		resp.sendRedirect("list");

	}

	private void deleteDepartment(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, SQLException {
		Integer depid = Integer.parseInt(req.getParameter("id"));
		depDao.deleteDepartment(depid);
		resp.sendRedirect("list");

	}

	private void insertDepartment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Long empid = (long) Integer.parseInt(req.getParameter("eid"));
		String depname = req.getParameter("dname");
		String depemail = req.getParameter("demail");
		String depmobno = req.getParameter("dmobno");

		Department dep = new Department(depname, depemail, depmobno);
		depDao.saveDepartment(dep);
		resp.sendRedirect("list");

	}

	private void showNewDepartmentForm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("department-form.jsp");
		rd.forward(req, resp);

	}

	private void listDepartment(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException, SQLException {

		List<Department> listOfDepartments = depDao.getAllDepartments();
		req.setAttribute("listDep",listOfDepartments);
		RequestDispatcher rd = req.getRequestDispatcher("department-list.jsp");
		rd.forward(req, res);
	}

}
